<%@ page pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
   <meta charset="UTF-8">
   <title>セッション情報の表示</title>
</head>
<body>
   <h1>カート情報</h1>
   <table border="1">
      <tr><th>タイトル</th><th>価格</th></tr>
      <c:forEach var="book" items="${sessionScope.cart.books}">
         <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.price}</td>
         </tr>
      </c:forEach>
   </table>
</body>
</html>
