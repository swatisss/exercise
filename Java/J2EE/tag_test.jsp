<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="sample.tld" prefix="s"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>カスタムタグのテストです</title>
</head>
<body>
      <h1><s:hello6 min="${param.min}" max="${param.max}">${pageContext.request.requestURI}</s:hello6></h1>
   <p>ページの残り</p>
</body>
</html>
