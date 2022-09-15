<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th {
background-color: #ccc;
padding: 5px;
width: 120px;
}
td {
padding: 5px;
width: 120px;
}

button {
margin-top: 15px;
}

</style>
</head>
<body>
   <div align="center">
      <div>
         <h1>멤버 전체 목록</h1>
      </div>
      <div>
         <table border="1">
            <tr>
               <th>아이디</th>
               <th>이름</th>
               <th>전화번호</th>
               <th>권한</th>
            </tr>
            
            <c:forEach items="${members }" var="m">
            <tr onMouseover="this.style.backgroundColor='yellow'"
               onMouseout="this.style.backgroundColor='white'"
               onclick="selectmember('${m.memberId}')">
               <td>${m.memberId }</td> 
               <td>${m.memberName }</td> 
               <td>${m.memberTel }</td> 
               <td>${m.memberAuthor }</td>
            </tr> <br />
            </c:forEach>
         </table>
         <button type="button" onclick="location.href='memberJoinForm.do'">멤버 추가</button> &nbsp;&nbsp;
         <button type="button" onclick="location.href='main.do'">홈</button>
      </div>
      <div>
         <form id="frm" action="MemberSelect" method="post">
            <input type="hidden" id="id" name="id">
         </form>
      </div>
   </div>
   <script type="text/javascript">
      function selectmember(id) {
         frm.id.value = id;
         frm.action = "memberSelect.do";
         frm.submit();
      }
   </script>
</body>
</html>