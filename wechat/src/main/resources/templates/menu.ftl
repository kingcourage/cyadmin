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


</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="col-sm-4">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>功能菜单</h5>
                <div class="ibox-tools">
                    <a class="collapse-link" href="#" onclick="add()">
                        <i class="fa fa-plus"></i>
                    </a>

                    <a class="close-link">
                        <i class="fa fa-remove"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <div id="tree"></div>
            </div>
        </div>
    </div>
    <div class="col-sm-8">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>节点详情</h5>
                <div class="ibox-tools">
                    <a class="collapse-link"  >
                        <i class="fa fa-plus"></i>
                    </a>

                    <a class="close-link">
                        <i class="fa fa-remove"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <div id="table"></div>
            </div>
        </div>
    </div>

</div>
</body>
<script>

    function add() {
        //iframe窗
        parent.layer.open({
            type: 2,
            title: false,
            closeBtn: false,
            shade: [0],
            area: ['340px', '215px'],
            offset: 'rb', //右下角弹出
            time: 1000, //2秒后自动关闭
            shift: 2,
            content: ['http://www.huangyaoxin.com', 'no'], //iframe的url，no代表不显示滚动条
            end: function(){ //此处用于演示
                parent.layer.open({
                    type: 2,
                    title: '添加菜单',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['1150px', '650px'],
                    content: 'http://www.huangyaoxin.com'
                });
            }
        });


    }

    function getTree() {
        // Some logic to retrieve, or generate tree structure
        var data = [
            {
                text: '父节点 1',
                href: '#parent1',
                tags: ['4'],
                nodes: [
                    {
                        text: '子节点 1',
                        href: '#child1',
                        tags: ['2'],
                        nodes: [
                            {
                                text: '孙子节点 1',
                                href: '#grandchild1',
                                tags: ['0']
                            },
                            {
                                text: '孙子节点 2',
                                href: '#grandchild2',
                                tags: ['0']
                            }
                        ]
                    },
                    {
                        text: '子节点 2',
                        href: '#child2',
                        tags: ['0']
                    }
                ]
            },
            {
                text: '父节点 2',
                href: '#parent2',
                tags: ['0']
            },
            {
                text: '父节点 3',
                href: '#parent3',
                tags: ['0']
            },
            {
                text: '父节点 4',
                href: '#parent4',
                tags: ['0']
            },
            {
                text: '父节点 5',
                href: '#parent5',
                tags: ['0']
            }
        ];
        return data;
    }
    $(function () {
        $('#tree').treeview({data: getTree()});
    })

</script>
</html>