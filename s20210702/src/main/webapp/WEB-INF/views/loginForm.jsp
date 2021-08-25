<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
</head>
<body>
   <form action="login" method="post" class="loginForm">
      <h2>Login</h2>
      <div class="idForm">
         <input type="text" id="mem_id" class="id" name="mem_id" required="required" placeholder="ID" autofocus="autofocus">
      </div>
      <div class="passForm">
         <input type="password" id="mem_pw" class="pw" name="mem_pw" required="required" placeholder="PW">
      </div>
      <input type="submit" class="btn" value="로그인" onclick="button()">
   </form>
</body>
</html>