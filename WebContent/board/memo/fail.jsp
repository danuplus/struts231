<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인 결과</title>
<link rel="stylesheet" type="text/css" href="css/memo.css" >
</head>
<body>
<div id="content">
	<table>
		<tr>
			<th>결과</th>
		</tr>
		<tr>
			<td>데이터베이스 인증에 실패하였습니다.</td>
		</tr>
	</table><br />
	<div align="center">
		<input type="button" onclick="location.href='MemoIndex.action?page=<s:property value="page" />'" value="확 인"/>
	</div>
</div>
</body>
</html>