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
	<div><h1>멤버 가입</h1></div>
	<div>
		<form id="frm" action="memberInsert.do" onsubmit="return formCheck()" method="post">
		<div>
			<table border="1">
				<tr>
					<th width="100">아이디</th>
					<td width="150">
						<input type="text" id="memberId" name="memberId" required="required">
					</td>
					
				</tr>
				<tr>
					<th width="150">패스워드</th>
					<td>
					<input type="password" id="memberPassword" name="memberPassword" required="required">
					</td>
				</tr>
				<tr>
					<th width="150">패스워드 확인</th>
					<td>					
					<input type="password" id="pwc" name="pwc" required="required">
					</td>
				</tr>
				<tr>
				<th width="150">이름</th>
					<td>
						<input type="text" id="memberName" name="memberName" required="required">
					</td>
				</tr>
					<tr>
					<th width="150">전화번호</th>
					<td>
					<input type="text" id="memberTel" name="memberTel">
					</td>
					
				</tr>
			</table>
		</div> <br>
		<div>
			<input type="hidden" name="memberAuthor" value="USER">
			<input type="submit" value="등록">&nbsp;&nbsp;
			<input type="reset" value="취소">&nbsp;&nbsp;
			<input type="button" value="목록" onclick="location.href='memberSelectList.do'">
		</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	function formCheck() {
		let pass1 = document.getElementById("memberPassword").value;
		let pass2 = document.getElementById("pwc").value;
		
		if(pass1 != pass2) {
			alert("패스워드가 일치하지 않습니다.");
			document.getElementById("memberPassword").value = "";
		 	document.getElementById("pwc").value = "";
		 	document.getElementById("memberPassword").focus();
		 	return false;
		}
		
		return true;
	}
</script>
</body>
</html>