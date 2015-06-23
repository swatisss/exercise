<%@ page pageEncoding="utf-8"
         contentType="text/html; charset=utf-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
   <meta charset="UTF-8">
   <title>結果</title>
</head>
<body>
   <table border="1">
      <c:forEach var="out" items="${list}" varStatus="status">
         <c:if test="${status.index == 0}">
            <c:forEach var="name" items="${out}">
               <th>${name}</th>
            </c:forEach>
         </c:if>
            <tr>
            <c:forEach var="name" items="${out}">
               <td>${name}</td>
            </c:forEach>
      </c:forEach>
   </table>
</body>
</html>
