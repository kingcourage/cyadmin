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
    <link href="${base}/static/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">

</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>支付订单</h5>
                <div class="ibox-tools">
                    <a class="collapse-link" href="#">
                        <i class="fa fa-plus"></i>
                    </a>

                    <a class="close-link">
                        <i class="fa fa-remove"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <form method="post" action= "${base}/alipay/payOrder" class="form-horizontal" id="theForm" target="_blank">
                <div class="form-group">
                    <label class="col-sm-2 control-label">订单号</label>

                    <div class="col-sm-10">
                        <input type="text" name="orderNo" class="form-control">
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">价格</label>

                    <div class="col-sm-10">
                        <input type="text" name="orderPrice" class="form-control">
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">订单描述</label>

                    <div class="col-sm-10">
                        <input type="text" name="orderDescription" class="form-control">
                    </div>
                </div>
                <div class="hr-line-dashed"></div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">商品描述</label>

                    <div class="col-sm-10">
                        <input type="text" name="goodsDescription" class="form-control">
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="form-group">
                    <div class="col-sm-3 col-sm-offset-3">
                        <button class="btn btn-primary" type="submit" >提交</button>
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
</body>

<script>


</script>
<!-- Bootstrap table -->
<script src="${base}/static/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${base}/static/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${base}/static/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

<!-- Peity -->
<script src="${base}/static/js/demo/bootstrap-table-demo.js"></script>
<script>


</script>

</html>