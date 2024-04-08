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
<script src="${path}/resources/js/SpringBoardJavascript.js"></script>

<script src="${path}/resources/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>

</head>
<body>
<%
// 세션값 가져오기
UserVo userInfo = (UserVo) session.getAttribute("loginUser");
%>
<div align="center">
<a href="/select.do"><h1>Secondhand Markets</h1></a>
<form action="/updateOk.do">
<input id = 'bgsno' size=1 type=hidden name=sno value="${m.sno}" readonly>
<table border=1>
<tr><td>${m.title}</td></tr> 
<tr><td>${m.sname} <fmt:formatDate value="${m.modifyDate}" pattern="yyyy-MM-dd"/></td></tr>
<tr><td colspan=2> ${m.contents}</table>
</form>
</div>
<form name="comForm" id="comForm">
<table border=1>
<tr><td colspan=3>전체 댓글 ${cnt}개</td>
<c:forEach var="com" items="${comList}">
<tr><td>${com.writer}</td><td>${com.comments}</td><td id="commentDate"><fmt:formatDate value="${com.modifyDate}" pattern="yyyy-MM-dd"/>
<input type=button value="x" onClick="delCom(${m.sno})"></td></tr>
</c:forEach>
</table>
</form>
<form action="/insertComments.do">
<table border=1>
<tr><td><input type=text id="writer" name="writer" value="<%=userInfo.getId()%>"></td><td><textarea rows="5" cols="100" name="comments" id="comments" placeholder="Leave a comments"></textarea></td></tr>
<tr><td colspan=2><input type="submit" value="등록"></td>
</table>
</form>
<div id="btnEdit"><input type="button" value="수정" onClick="mvEdit(${m.sno})"></div>
</body>

</html>