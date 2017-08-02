<#assign base = request.contextPath />
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->

    <title> - 主页示例</title>

    <link rel="shortcut icon" href="${base}/static/favicon.ico"> <link href="${base}/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${base}/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${base}/static/css/plugins/colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
    <!-- 全局js -->
    <script src="${base}/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${base}/static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${base}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="${base}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${base}/static/js/plugins/layer/layer.min.js"></script>

    <link href="${base}/static/css/animate.css" rel="stylesheet">
    <link href="${base}/static/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${base}/static/css/plugins/treeview/bootstrap-treeview.css" rel="stylesheet">
    <script src="${base}/static/js/plugins/treeview/bootstrap-treeview.js"></script>
    <script src="${base}/static/js/demo/treeview-demo.js"></script>
    <link href="${base}/static/css/plugins/clockpicker/clockpicker.css" rel="stylesheet">
    <!-- Clock picker -->
    <!-- Color picker -->
    <script src="${base}/static/js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
    <script src="${base}/static/js/plugins/clockpicker/clockpicker.js"></script>


</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>添加菜单项 <small></small></h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                    <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                        <i class="fa fa-wrench"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="form_basic.html#">选项1</a>
                        </li>
                        <li><a href="form_basic.html#">选项2</a>
                        </li>
                    </ul>
                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <form method="post" action= "${base}/menu/save" class="form-horizontal" id="theForm">
                    <div class="form-group">
                        <input type="hidden" name = "parentid" class="form-control" value="${parentid}">
                        <label class="col-sm-2 control-label">菜单名称</label>

                        <div class="col-sm-10">
                            <input type="text" name = "text"class="form-control">
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label ">菜单颜色</label>

                        <div class="col-sm-10">
                            <input type="text" name="color" class="form-control colorpicker-demo1">
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">菜单图标</label>

                        <div class="col-sm-10">
                            <input type="text" name="icon" class="form-control">
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">菜单链接</label>

                        <div class="col-sm-10">
                            <input type="text" name="href" class="form-control">
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">菜单状态</label>

                        <div class="col-sm-10">
                            <div class="radio">
                                <label>
                                    <input type="radio" checked="" value="1" id="optionsRadios1" name="optionsRadios">启用</label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" value="0" id="optionsRadios2" name="optionsRadios">停用</label>
                            </div>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <div class="col-sm-3 col-sm-offset-3">
                            <button class="btn btn-primary" type="button" onclick="save()">提交</button>
                        </div>
                        <div class="col-sm-6 ">
                            <button class="btn btn-primary" type="reset" ">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>
</div>
</body>
<script>
$(function(){
    $('.colorpicker-demo1').colorpicker();
})

function save() {
    $.ajax({
        url: '${base}/menu/save',
        type: 'post',
        data: $("#theForm").serialize(),
        dataType: 'json',
        success: function (result) {
            if (result.code == 1) {
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
            }
        }

    })
}
</script>
</html>