<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><jsp:include page="../menu/menu.jsp" /></div>
		<div><h1>로그인</h1></div>
		<form id="frm" action="memberLogin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th>아이디</th>
						<td><input type="text" id="memberId" name="memberId" required="required"></td>				
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="text" id="memberPassword" name="memberPassword" required="required"></td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
			</div>
		</form>
	</div>
</body>
</html>