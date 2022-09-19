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
		<div><jsp:include page="../menu/menu.jsp"/></div>
		<div><h1>공지사항 등록</h1></div>
		<form id="frm" action="noticeInsert.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="100">작성자</th>
						<td>
							<input type="text" id="noticeWriter" name="noticeWriter" value="${name }" readonly="readonly">
						</td>
						<th width="150">작성일자</th>
						<td>
							<input type="date" id="noticeDate" name="noticeDate" required="required">
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3">
							<input type="text" size="87" id="noticeTitle" name="noticeTitle" required="required">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textArea rows="10" cols="88" id="noticeSubject" name="noticeSubject"></textArea>
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3">
							<input type="file" id="noticeAttech" name="noticeAttech">
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="등록">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='noticeSelectList.do'">&nbsp;&nbsp;&nbsp;
			</div>
		</form>
	</div>
</body>
</html>