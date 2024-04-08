<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/signupOk.do">
	<table>
	<tr><td>아이디</td><td><input type=text id=id name=id></td></tr>
	<tr><td>비밀번호</td><td><input type="password" id=password1 name=password1></td></tr>
	<tr><td>비밀번호 확인</td><td><input type="password" id=password2 name=password2></td></tr>
	<tr><td>이메일</td><td><input type="text" id=email name=email></td>
	<tr><td colspan=2><input type="checkbox"/> 이용약관 개인정보 수집 및 이용, 마케팅 활용
          선택에 모두 동의합니다.</td></tr>
	<tr><td colspan=2><input type=submit value="회원가입"></td></tr>
	</table>
	</form>
</body>
</html>