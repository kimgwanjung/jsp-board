<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script language ="javascript"> 
    function addboard(){ 
        boardform.submit(); 
    } 
</script>
</head>
<body>
<form action="write.do" method="actionDo" enctype="multipart/form-data" name="boardform"> 
<table cellpadding="0" cellspacing="0"> 
    <tr align="center" valign="middle"> 
        <td colspan="5">MVC게시판</td> 
    </tr> 
    <tr> 
        <td style="font-family:돋음; font-size:12" height="16"> 
            <div align="center">글쓴이</div> 
        </td>         
        <td> 
            <input name="BOARD_NAME" type="text" size="10" maxlength="10" value=""/> 
        </td>         
    </tr> 
    <tr> 
        <td style="font-family:돋움; font-size:12" height="16"> 
            <div align="center">제목</div> 
        </td>         
        <td> 
            <input name="BOARD_SUBJECT" type="text" size="50" maxlength="100" value=""/> 
        </td> 
    </tr>     
    <tr> 
        <td style="font-family:돋움; font-size:12" height="16"> 
            <div align="center">내용</div> 
        </td>         
        <td> 
            <textarea name="BOARD_CONTENT" cols="67" rows="15" value=""></textarea> 
        </td>         
    </tr>                 
    <tr bgcolor="cccccc" > 
        <td colspan="2" style="height:1px;"> 
        </td>         
    </tr> 
    <tr><td colspan="2">&nbsp;</td></tr> 
    <tr align="center" valign="middle"> 
        <td colspan="5"> 
            <a href="javascript:addboard()">[등록]</a> &nbsp;&nbsp; 
            <a href="javascript:history.go(-1)">[뒤로]</a>             
        </td> 
    </tr>     
</table> 
</form> 
</body>
</html>