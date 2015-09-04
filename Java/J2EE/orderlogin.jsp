<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>ログイン</title>
</head>
<body>
  <h1>ログイン</h1>
  <form action="/j2ee${requestScope.target}" method="post">
    <p>氏名：</p><input type="text" name="name"><br>
    <p>パスワード：</p><input type="text" name="pass"><br><br>
    <input type="submit" value="ログイン">
  </form>
</body>
</html>
