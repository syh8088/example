<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<table width="500" cellpadding="0" cellspacing="0" border="1">
    <form action="members/create/community/posts" method="post">
    <%--    <tr>
            <td> 이름 </td>
            <td> <input type="text" name="bName" size = "50"> </td>
        </tr>--%>
        <tr>
            <td> 제목 </td>
            <td> <input type="text" id="subject" name="subject" size = "50"> </td>
        </tr>
        <tr>
            <td> 내용 </td>
            <td> <textarea id="content" name="content" rows="10" ></textarea> </td>
        </tr>
        <tr >
            <td colspan="2"> <input type="button" onclick="send();" value="입력"><input type="button" id="json" value="json"> &nbsp;&nbsp; <a href="list.do">목록보기</a></td>
        </tr>
    </form>
</table>

</body>
</html>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script>


        $("#json").click(function(){

            var sendData = JSON.stringify(
                    {
                        subject:$('#subject').val(),
                        content:$('#content').val()
                    }
                );
            console.log(sendData);
            $.ajax({
                type: "POST",
                url : "<c:url value='/members/create/community' />",
                data: sendData,
                dataType: "json",
                contentType:"application/json;charset=UTF-8",
                async: true,
                success : function(data, status, xhr) {
                    console.log(data);
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });



        });
/*
    $.fn.serializeObject = function(){
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            var name = $.trim(this.name),
                value = $.trim(this.value);

            if (o[name]) {
                if (!o[name].push) {
                    o[name] = [o[name]];
                }
                o[name].push(value || '');
            } else {
                o[name] = value || '';
            }
        });
        return o;
    };*/

    function send() {

        var ajax_url = "localhost:8081/members/create/community/posts";
        var xhr = new XMLHttpRequest();
        xhr.open('POST', ajax_url, true);

        var data = new FormData();
        data.append('subject', "dsdd");
        data.append('content', "ssdsdds");

        xhr.send(data);
        xhr.onload = function() {

        };

    }


</script>