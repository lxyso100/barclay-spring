<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx = request.getContextPath()/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h2>hello.ftl =========== </h2>

    <form id="form1" runat="server">
        <div id="v">
        </div>
        <input type="button" value="测试" id="test"/>
    </form>

    <script type="text/javascript" src="${ctx}/static/jquery/jquery-3.3.1.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#test").click(function () {
                $.ajax({
                    type: "GET",
                    url: "${ctx}/app/user/login.json?password=123",
                    success: function (result) {
                        alert(JSON.stringify(result));
                    }
                });
            });
        });
    </script>
</body>
</html>