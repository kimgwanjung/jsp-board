<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }

        h2 {
            text-align: center;
            margin-top: 0;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        tr:hover {
            background-color: #f9f9f9;
        }

        .checkbox-header {
            padding: 0;
            text-align: center;
        }

        .write-button {
            margin-top: 20px;
            text-align: center;
        }

        .write-button a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .write-button a:hover {
            background-color: #45a049;
        }

        .write-button input[type="submit"] {
            display: inline-block;
            padding: 10px 20px;
            background-color: #f44336;
            color: #fff;
            text-decoration: none;
            border: none;
            border-radius: 4px;
            transition: background-color 0.3s;
            cursor: pointer;
            margin-left: 10px;
        }

        .write-button input[type="submit"]:hover {
            background-color: #d32f2f;
        }
    </style>
    <script>
        function toggle(source) {
            checkboxes = document.getElementsByName('boardNum[]');
            for(var i=0, n=checkboxes.length;i<n;i++) {
                checkboxes[i].checked = source.checked;
            }
        }
    </script>
</head>
<body>
    <h2>Board View Page</h2>
    <form id="deleteForm" action="delete2.do" method="post">
        <table>
            <tr>
                <th class="checkbox-header"><input type="checkbox" onClick="toggle(this)"></th>
                <th>Num</th>
                <th>Name</th>
                <th>Subject</th>
                <th>Date</th>
                <th>Read Count</th>
            </tr>
            <c:forEach var="mbdto" items="${board}">
                <tr>
                    <td>
                        <input type="checkbox" name="boardNum[]" value="${mbdto.getBOARD_NUM()}">
                    </td>
                    <td>${mbdto.getBOARD_NUM()}</td>
                    <td>
                        <c:set var="repeats" value="${mbdto.getBOARD_RE_LEV()}" />
                        <c:forEach begin="1" end="${repeats}">
                            -
                        </c:forEach>
                        ${mbdto.getBOARD_NAME()}
                    </td>
                     <td>
			            <a href="read.do?boardNum=${mbdto.getBOARD_NUM()}&amp;boardReadCount=${mbdto.getBOARD_READCOUNT()}&amp;boardName=${mbdto.getBOARD_NAME()}&amp;boardSubject=${mbdto.getBOARD_SUBJECT()}&amp;boardContent=${mbdto.getBOARD_CONTENT()}&amp;boardLev=${mbdto.getBOARD_RE_LEV()}">
			                ${mbdto.BOARD_SUBJECT}
			            </a>
			        </td>   
                    <td>${mbdto.getBOARD_DATE()}</td>
                    <td>${mbdto.getBOARD_READCOUNT()}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="write-button">
            <a href="write.jsp">글쓰기</a>
            <input type="submit" value="삭제">
        </div>
    </form>
</body>
</html>
