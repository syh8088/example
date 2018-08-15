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
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<table width="1000" cellpadding="0" cellspacing="0" border="1">
    <form action="/appnotice/create/" method="post">

        <tr>
            <td>공지 타입 설정</td>
            <td>
                <input type="checkbox" id="MOBILE_WEB" name="MOBILE_WEB" value="Y" checked> MOBILE_WEB

                | MOBILE_WEB 공지 허용 여부
                <label>
                    <input type='radio' name='mobile_web_notice_top_allowed' value='Y' checked>제공
                </label>
                <label>
                    <input type='radio' name='mobile_web_notice_top_allowed' value='N'>비제공
                </label>

                | MOBILE_WEB 팝업 허용 여부
                <label>
                    <input type='radio' name='mobile_web_popup_allowed' value='Y' checked>제공
                </label>
                <label>
                    <input type='radio' name='mobile_web_popup_allowed' value='N'>비제공
                </label>
                <br>

                <input type="checkbox" id="SPORT_ANDROID" name="SPORT_ANDROID" value="Y"> SPORT_ANDROID
                | SPORT_ANDROID 공지 허용 여부
                <label>
                    <input type='radio' name='sport_android_notice_top_allowed' value='Y' checked>제공
                </label>
                <label>
                    <input type='radio' name='sport_android_notice_top_allowed' value='N'>비제공
                </label>

                | SPORT_ANDROID 팝업 허용 여부
                <label>
                    <input type='radio' name='sport_android_popup_allowed' value='Y' checked>제공
                </label>
                <label>
                    <input type='radio' name='sport_android_popup_allowed' value='N'>비제공
                </label>
                <br>

                <input type="checkbox" id="SPORT_IOS" name="SPORT_IOS" value="Y"> SPORT_IOS
                | SPORT_IOS 공지 허용 여부
                <label>
                    <input type='radio' name='sport_ios_notice_top_allowed' value='Y' checked>제공
                </label>
                <label>
                    <input type='radio' name='sport_ios_notice_top_allowed' value='N'>비제공
                </label>

                | SPORT_IOS 팝업 허용 여부
                <label>
                    <input type='radio' name='sport_ios_popup_allowed' value='Y' checked>제공
                </label>
                <label>
                    <input type='radio' name='sport_ios_popup_allowed' value='N'>비제공
                </label>
                <br>

                <input type="checkbox" id="GAME_ANDROID" name="GAME_ANDROID" value="Y"> GAME_ANDROID
                | GAME_ANDROID 공지 허용 여부
                <label>
                    <input type='radio' name='game_android_notice_top_allowed' value='Y' checked>제공
                </label>
                <label>
                    <input type='radio' name='game_android_notice_top_allowed' value='N'>비제공
                </label>

                | GAME_ANDROID 팝업 허용 여부
                <label>
                    <input type='radio' name='game_android_popup_allowed' value='Y' checked>제공
                </label>
                <label>
                    <input type='radio' name='game_android_popup_allowed' value='N'>비제공
                </label>
                <br>

                <input type="checkbox" id="GAME_IOS" name="GAME_IOS" value="Y"> GAME_IOS
                | GAME_IOS 공지 허용 여부
                <label>
                    <input type='radio' name='game_ios_notice_top_allowed' value='Y' checked>제공
                </label>
                <label>
                    <input type='radio' name='game_ios_notice_top_allowed' value='N'>비제공
                </label>

                | GAME_IOS 팝업 허용 여부
                <label>
                    <input type='radio' name='game_ios_popup_allowed' value='Y' checked>제공
                </label>
                <label>
                    <input type='radio' name='game_ios_popup_allowed' value='N'>비제공
                </label>
                <br>



            </td>
        </tr>
        <tr>
            <td> 카테고리 </td>
            <td>
                <select id="category" name="category">
                    <option value="notice">공지</option>
                    <option value="event">이벤트</option>
                    <option value="update">업데이트</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>예약시간</td>
            <td>
                <input type="text" class="datepick" name="reserve_at" id="reserve_at" placeholder="날짜을 입력해주세요" value="">
            </td>
        </tr>

        <tr>
            <td> 제목 </td>
            <td> <input type="text" id="title" name="title" size = "50"> </td>
        </tr>
        <tr>
            <td> 내용 </td>
            <td> <textarea id="content" name="content" rows="10" ></textarea> </td>
        </tr>
        <tr >
            <td colspan="2"><input type="button" id="json" value="json"> &nbsp;&nbsp;</td>
        </tr>
    </form>
</table>

<script>
    $( function() {
        $('.datepick').each(function(){
            $(this).datepicker({
                dateFormat: 'yy-mm-dd',
                prevText: '이전 달',
                nextText: '다음 달',
                monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                dayNames: ['일','월','화','수','목','금','토'],
                dayNamesShort: ['일','월','화','수','목','금','토'],
                dayNamesMin: ['일','월','화','수','목','금','토'],
                showMonthAfterYear: true,
                changeMonth: true,
                changeYear: true,
                yearSuffix: '년',
                minDate: 0,
                onSelect: function(s_date) {


                }

            });
        });





        $("#json").click(function(){
            var sendData = JSON.stringify(
                {
                    mobile_web_notice_top_allowed:document.querySelector('input[name="mobile_web_notice_top_allowed"]:checked').value,
                    mobile_web_popup_allowed:document.querySelector('input[name="mobile_web_popup_allowed"]:checked').value,
                    sport_android_notice_top_allowed:document.querySelector('input[name="sport_android_notice_top_allowed"]:checked').value,
                    sport_android_popup_allowed:document.querySelector('input[name="sport_android_popup_allowed"]:checked').value,
                    sport_ios_notice_top_allowed:document.querySelector('input[name="sport_ios_notice_top_allowed"]:checked').value,
                    sport_ios_popup_allowed:document.querySelector('input[name="sport_ios_popup_allowed"]:checked').value,
                    game_android_notice_top_allowed:document.querySelector('input[name="game_android_notice_top_allowed"]:checked').value,
                    game_android_popup_allowed:document.querySelector('input[name="game_android_popup_allowed"]:checked').value,
                    game_ios_notice_top_allowed:document.querySelector('input[name="game_ios_notice_top_allowed"]:checked').value,
                    game_ios_popup_allowed:document.querySelector('input[name="game_ios_popup_allowed"]:checked').value,
                    MOBILE_WEB:document.getElementsByName('MOBILE_WEB')[0].checked,
                    SPORT_ANDROID:document.getElementsByName('SPORT_ANDROID')[0].checked,
                    SPORT_IOS:document.getElementsByName('SPORT_IOS')[0].checked,
                    GAME_ANDROID:document.getElementsByName('GAME_ANDROID')[0].checked,
                    GAME_IOS:document.getElementsByName('GAME_IOS')[0].checked,
                    category:$('#category').val(),
                    reserve_at:$('#reserve_at').val(),
                    title:$('#title').val(),
                    content:$('#content').val()
                }
            );
            console.log(sendData);
            $.ajax({
                type: "POST",
                url : "<c:url value='/appnotice/create' />",
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



    });

</script>

</body>
</html>