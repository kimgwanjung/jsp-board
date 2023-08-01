<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modify Page</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        .form-button {
            margin-top: 20px;
        }
        .button-container {
            margin-top: 20px;
        }
        .button-container button {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <h2>Modify Page</h2>

    번호 : <td>${param.boardNum}</td>
    
    <form action="update.do" method="actionDo">
        <input type="hidden" name="boardNum" value="${param.boardNum}">
        <label for="boardName">이름 :</label>
        <input type="text" id="boardName" name="boardName" value="${param.boardName}"><br>
        <label for="boardSubject">제목 :</label>
        <input type="text" id="boardSubject" name="boardSubject" value="${param.boardSubject}"><br>
        <label for="boardContent">내용 :</label>
        <textarea id="boardContent" name="boardContent" cols="67" rows="15">${param.boardContent}</textarea><br>
        <input type="submit" value="Update">
    </form>
    <div class="button-container">
        <a href = "write_view.do">목록 보기</a>
        <form action= "delete.do" method= "actionDo">
        	<input type="hidden" name="boardNum" value="${param.boardNum}">
        	<input type="submit" value="삭제">
        </form>
        <form action = "reply.jsp" method= "post">
        	<input type="hidden" name="boardNum" value="${param.boardNum}">
        	<input type="hidden" name="boardName" value="${param.boardName}">
            <input type="hidden" name="boardSubject" value="${param.boardSubject}">
            <input type="hidden" name="boardContent" value="${param.boardContent}"> 
            <input type="hidden" name="boardLev" value="${param.boardLev}"> 
        	<input type="submit" value="답변">
        </form>
      
        <button onclick="location.href='write.jsp'">Write Post</button>
    </div>
</body>
</html>
