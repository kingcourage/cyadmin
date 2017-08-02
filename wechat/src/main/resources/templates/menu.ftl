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
    <div class="col-sm-4">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>功能菜单</h5>
                <div class="ibox-tools">
                    <a class="collapse-link" href="#" onclick="add()">
                        <i class="fa fa-plus"></i>
                    </a>

                    <a class="close-link">
                        <i class="fa fa-remove" onclick="del()"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <input type="hidden"  id="id" value="0"/>
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


</script>
<!-- Bootstrap table -->
<script src="${base}/static/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${base}/static/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${base}/static/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

<!-- Peity -->
<script src="${base}/static/js/demo/bootstrap-table-demo.js"></script>
<script>

    function add() {
        var parentid = $("#id").val();
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
            content: ['${base}/menu/add?parentid='+parentid, 'no'], //iframe的url，no代表不显示滚动条
            end: function(){ //此处用于演示
                parent.layer.open({
                    type: 2,
                    title: '添加菜单',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['1150px', '650px'],
                    content: '${base}/menu/add?parentid='+parentid,
                    end:function(){
                        window.location.reload();
                    }
                });
            }
        });
    }
    
    function del() {
        var id = $("#id").val();
        layer.confirm('确定删除该节点吗？', {icon: 3, title:'提示'}, function(index){
            //do something
            $.ajax({
                url:'${base}/menu/delete',
                type: 'post',
                dataType:'post',
                data:{"id":id},
                success:function(result){
                    if(result.code == 1){
                       parent.layer.msg("删除成功",{icon:3})
                    }else{
                       parent.layer.msg("删除失败",{icon:4})
                    }
                }
            })
            layer.close(index);
            window.location.reload();
        });
    }

    function getTree() {
        var data ;
        $.ajax({
            type:'post',
            url:'${base}/menu/list',
            dataType:'json',
            success:function (result) {
               // data = JSON.stringify(result.data);
                    data = result.data;
               $("#tree").treeview({data:data});
            }
        })

        return data;
    }
    $(function () {
         $('#tree').on('nodeSelected', function (event, node) {
             $("#id").val(node.id);
             $("#table").bootstrapTable('refresh',{
                 url: '${base}/menu/chrild?parentid='+node.id
             })
         });
        getTree();
        $('#table').bootstrapTable({
            url: '${base}/menu/chrild',
            columns: [{
                field: 'id',
                title: 'Item ID',
                visible:false
            }, {
                field: 'text',
                title: '名称'
            }, {
                field: 'color',
                title: '颜色'
            }, {
                field:'icon',
                title:'图标',
            },{
                field:'href',
                title:'菜单链接',
            }
            ]
        });
    })


</script>

</html>