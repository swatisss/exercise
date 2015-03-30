<%@ page contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"
    %>

<!DOCTYPE html>
<html>
    <head>
        <title>登録確認</title>
    </head>
    <body>
        ユーザ名<p>${name}</p>
        パスワード<p>${pass}</p>
        <form action="register" method="post">
           <input type="hidden" name="name" value="${name}">
           <input type="hidden" name="pass" value="${pass}">
           <button>登録する<input type="submit" value=""></button>
           <button>キャンセル<input type="submit" value=""></button>
        </form>
    </body>
</html>
