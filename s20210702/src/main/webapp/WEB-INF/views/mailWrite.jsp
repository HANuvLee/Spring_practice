<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>메일 쓰기</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">${mo.mem_no }
			</div>
			${mo.mem_id } ${member.mem_id} /<a href="main?mem_no=${sessionScope.mem_no }">Go Main</a>
			<div class="panel-body">
				<form action="mailSend" method="post" enctype="multipart/form-data">
					<input type="hidden" name="mem_id" value="${mo.mem_id }"> 
					<input type="hidden" name="mem_no"  value="${mo.mem_no }"> 
					<input type="text" id="mail_receiver"  placeholder="받는사람 :" name="mail_receiver"> @ damoware.com
					<p>
					 <input type="text" id="mail_title" placeholder="제목" name="mail_title">
					<p>
					<textarea rows="20" cols="20" id="mail_content" placeholder="내용" name="mail_content"></textarea>
					<p>
					<h5>첨부파일</h5>
					<input type="file" id="file" name="file1"> 
					<input type="hidden" name="path" value="${pageContext.request.contextPath}/resources/image/">
					<input type="submit" value="전송">
				</form>
			</div>
		</div>
	</div>
</body>
</html>