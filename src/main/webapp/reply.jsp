<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String boardNum = request.getParameter("boardNum");
    String boardSubject = request.getParameter("boardSubject");
    String boardContent = request.getParameter("boardContent");
    String boardName = request.getParameter("boardName");
    String boardLev = request.getParameter("boardLev");
	System.out.println(boardNum);
	System.out.println(boardSubject);
	System.out.println(boardName);
	
	System.out.println("boardLev" + boardLev);
%>

<h2></h2>
번호 : <%= boardNum %></td>
<form action="reply.do" method="actionDo">
    <input type="hidden" name="boardNum" value="<%= boardNum %>">
    <input type="hidden" name="boardLev" value="<%= boardLev %>">
    <label for="boardName">답변자 : </label>
    <input type="text" id="boardName" name="boardName" value="<%= boardName %>" ><br>
    <label for="boardSubject">제목 : </label>
    <input type="text" id="boardSubject" name="boardSubject" value="<%= boardSubject %>"><br>
    <label for="boardContent">답변 내용 :</label>
    <textarea id="boardContent" name="boardContent" cols="67" rows="15"><%= boardContent %></textarea><br>
    <input type="submit" value="답변">
</form>

