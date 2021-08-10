<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <h2>삭제 코딩용 임시 파일</h2> -->


<c:if test="${cdc eq 0 }">
			<script type="text/javascript">
				alert("삭제 신청이 불가능한 스케쥴 입니다.");
				location.href = "mycal?mem_no=${mem_no}";
			</script>
		</c:if> 

	<c:if test="${cdc eq 1 }">
			<script type="text/javascript">
				alert("스케쥴 삭제 신청 완료");
					location.href = "mycal?mem_no=${mem_no}";
				
			</script>
		</c:if>
		--%>
</body>
</html>