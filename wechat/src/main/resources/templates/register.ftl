<#assign base = request.contextPath />
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 注册</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="${base}/static/favicon.ico"> <link href="${base}/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${base}/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${base}/static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${base}/static/css/animate.css" rel="stylesheet">
    <link href="${base}/static/css/style.css?v=4.1.0" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">cy</h1>

            </div>
            <h3>欢迎注册 cy</h3>
            <p>创建一个cy新账户</p>
            <form class="form-horizontal m-t" id="signupForm" type="post" action="${base}/register/saveUser">
                <div class="form-group">
                    <label class="col-sm-3 control-label">姓氏：</label>
                    <div class="col-sm-8">
                        <input id="firstname" name="firstname" class="form-control" type="text" value="">
                        <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">名字：</label>
                    <div class="col-sm-8">
                        <input id="lastname" name="lastname" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">用户名：</label>
                    <div class="col-sm-8">
                        <input id="username" name="username" class="form-control" type="text" aria-required="true" aria-invalid="true" class="error">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">密码：</label>
                    <div class="col-sm-8">
                        <input id="password" name="password" class="form-control" type="password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">确认密码：</label>
                    <div class="col-sm-8">
                        <input id="confirm_password" name="confirm_password" class="form-control" type="password">
                        <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 请再次输入您的密码</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">E-mail：</label>
                    <div class="col-sm-8">
                        <input id="email" name="email" class="form-control" type="email">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">手机号码：</label>
                    <div class="col-sm-8">
                        <input id="mobile" name="mobile" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-3">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" class="checkbox" id="agree" name="agree"> 我已经认真阅读并同意《H+使用协议》
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-3">
                        <button class="btn btn-primary" type="button" onclick="register()">提交</button>
                    </div>
                </div>

                <p class="text-muted text-center"><small>已经有账户了？</small><a href="${base}/login">点此登录</a>
                </p>

            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${base}/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${base}/static/js/bootstrap.min.js?v=3.3.6"></script>
    <!-- iCheck -->
    <script src="${base}/static/js/plugins/iCheck/icheck.min.js"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="${base}/static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${base}/static/js/plugins/validate/messages_zh.min.js"></script>
    <script src="${base}/static/js/demo/form-validate-demo.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });

        function register(){
            $("#signupForm").submit();
        }

    </script>


    
    

</body>

</html>
