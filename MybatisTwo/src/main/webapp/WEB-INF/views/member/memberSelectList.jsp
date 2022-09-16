<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>멤버 전체 목록</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td width="150" align="center">아이디</td>
					<td width="150" align="center">이 름</td>
					<td width="150" align="center">전화번호</td>
					<td width="150" align="center">권 한</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members }" var="m"> 
					<tr onMouseover="this.style.backgroundColor='yellow';"
						onMouseout="this.style.backgroundColor='white';"
						onclick="selectMember('${m.memberId }')">
						<td>${m.memberId }</td>
						<td>${m.memberName }</td>
						<td>${m.memberTel }</td>
						<td>${m.memberAuthor }</td>
					</tr>		
				</c:forEach>
			</tbody>
		</table>		
	</div><br>
	<div>
		<button type="button" onclick="location.href='memberJoinForm.do'">멤버추가</button>&nbsp;&nbsp;
		<button type="button" onclick="location.href='main.do'">홈</button>
	</div>
	<div>
		<form id="frm" method="post">
			<input type="hidden" id="memberId" name="memberId">
		</form>
	</div>
</div>
<script type="text/javascript">
	function selectMember(id) {
		document.getElementById("memberId").value = id;
		frm.action = "memberSelect.do";
		frm.submit();
	}
</script>
</body>
</html>