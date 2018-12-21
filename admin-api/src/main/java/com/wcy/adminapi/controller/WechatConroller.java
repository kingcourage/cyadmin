package com.wcy.adminapi.controller;

import com.wcy.adminapi.common.ServerResponse;
import com.wcy.adminapi.model.WeChatUser;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceHttpClientImpl;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/wechat/")
@Slf4j
public class WechatConroller {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage;

    @Autowired
    private WxMpMessageRouter wxMpMessageRouter;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "/check_sign")
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        String signature = request.getParameter("signature");
        String nonce = request.getParameter("nonce");
        String timestamp = request.getParameter("timestamp");

        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
            // 消息签名不正确，说明不是公众平台发过来的消息
            response.getWriter().println("非法请求");
            return;
        }

        String echostr = request.getParameter("echostr");
        if (StringUtils.isNotBlank(echostr)) {
            // 说明是一个仅仅用来验证的请求，回显echostr
            response.getWriter().println(echostr);
            return;
        }

        String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type")) ?
                "raw" :
                request.getParameter("encrypt_type");

        if ("raw".equals(encryptType)) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
            WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
            if (outMessage != null) {
                response.getWriter().write(outMessage.toXml());
            }
            return;
        }

        if ("aes".equals(encryptType)) {
            // 是aes加密的消息
            String msgSignature = request.getParameter("msg_signature");
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(request.getInputStream(), wxMpInMemoryConfigStorage, timestamp, nonce, msgSignature);
            WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
            response.getWriter().write(outMessage.toEncryptedXml(wxMpInMemoryConfigStorage));
            return;
        }

        response.getWriter().println("不可识别的加密类型");
        return;
    }

    @RequestMapping("index")
    public String index(){
        return "wechat/wechatIndex";
    }

    @RequestMapping("page_data")
    @ResponseBody
    public List<WeChatUser> pageData(){
        List<WeChatUser> weChatUserList = new ArrayList<>();
        try {
            WxMpUserList wxUserList = wxMpService.getUserService().userList(null);
            wxUserList.getOpenids();
            if(wxUserList.getOpenids() != null && wxUserList.getOpenids().size()>0){
                log.info(wxUserList.getOpenids().toString());
                wxUserList.getOpenids().stream().forEach(item->{
                    WeChatUser weChatUser = new WeChatUser();
                    weChatUser.setOpenId(item);
                    try {
                        String nickName = wxMpService.getUserService().userInfo(item).getNickname();
                        weChatUser.setNickName(nickName);
                        weChatUserList.add(weChatUser);
                    } catch (WxErrorException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return weChatUserList;
    }

    @RequestMapping("send_message_page")
    public String sendMessagePage(String openId, ModelMap modelMap){
        modelMap.addAttribute("openId",openId);
        return "wechat/sendMessagePage";
    }

    @RequestMapping("send_message")
    @ResponseBody
    public ServerResponse sendMessage(String openId,String content){
        WxMpKefuMessage wxMpKefuMessage = WxMpKefuMessage.TEXT().toUser(openId).content(content).build();

        try {
            wxMpService.getKefuService().sendKefuMessage(wxMpKefuMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess();
    }
}
