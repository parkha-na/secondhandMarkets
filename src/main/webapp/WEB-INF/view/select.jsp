<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@page import="com.example.secondhandMarkets.vo.UserVo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secondhand Markets</title>
<link rel="stylesheet" href="${path}/resources/css/SpringBoardStyle.css">

</head>
<body>
<%
// 세션값 가져오기
UserVo userInfo = (UserVo) session.getAttribute("loginUser");
%>
<script src="${path}/resources/js/jquery-3.7.1.min.js"></script>
<script src="${path}/resources/js/SpringBoardJavascript.js"></script>


<input type=button onClick="btnLogOut()" id="btnLogout" value="로그아웃"></div>
<div>
<h1>Secondhand Markets</h1>
<form name="loginForm" id="loginForm" onSubmit="return false;">
	<table>
	<tr><td>아이디</td><td><input type=text name="id" id="id" /></td>
	<td>비밀번호</td><td><input type="password" name="password1" id="password1" /></td>
	<td><input type="button" value="로그인" id="idBtn2" onClick="loginCheck()"></td><td><input type="button" onClick="btnGo()" value="회원가입"></td></tr>
	</table>
</form>

<table border=1>
<thead>
<tr><th>번호</th><th>작성자</th><th>제목</th><th>작성일</th></tr>
</thead>
<tbody>

<c:forEach var="m" items="${li}">
<tr>
 <td>
 <a id="link" href="/detail.do?sno=${m.sno}"><div name="sno">${m.sno}</div></a>
 </td>
 <td>${m.sname}</td>
 <td id="leftTitle">${m.title}</td>
 <td><fmt:formatDate value="${m.modifyDate}" pattern="yyyy-MM-dd"/></td>
</tr>
</c:forEach>
</tbody>
</table>
<form action="/select.do">
<select name=ch1>
  <option value=sno>번호</option>
  <option value=sname>닉네임</option>
  <option value=title>제목</option>
  <option value=contents>내용</option>
</select>
<input  type=text  name=ch2 size=10>
<input  type=submit value="검색하기">&nbsp;<input type=button id="posting" onclick="goPage()" value="글쓰기">
</form>
</body>
</html>