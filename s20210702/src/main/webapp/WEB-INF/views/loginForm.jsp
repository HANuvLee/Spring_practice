<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/metisMenu.min.css" rel="stylesheet">
<link href="/resources/css/sb-admin-2.css" rel="stylesheet">
<link href="/resources/css/font-awesome.min.css" rel="stylesheet">

<script src="/resources/js/jquery-2.2.3.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">다모웨어</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="login" method="post" id="form1"
							name="form1">
							<fieldset>

								<div class="form-group">
									<input type="text" id="mem_id" name="mem_id"
										required="required" placeholder="아이디" autofocus="autofocus" />
								</div>
								<div class="form-group">
									<input type="password" id="mem_pw" name="mem_pw"
										placeholder="비밀번호" required="required" />
								</div>
								<input type="submit" value="로그인">
							</fieldset>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>