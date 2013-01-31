<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인 결과</title>
<link rel="stylesheet" type="text/css" href="css/notice.css">
</head>
<body>
	<div id="content">
		<h3>암호 확인 결과</h3>
		<table>
			<tr>
				<th>결과</th>
			</tr>
			<tr>
				<td>암호가 일치하지 않습니다.</td>
			</tr>
		</table>
		<br />
		<div align="center">
			<s:url var="view" value="NoticeView.action">
				<s:param name="no" value="no" />
				<s:param name="page" value="page" />
				<s:param name="r" value="%{'n'}" />
			</s:url>
			<input type="button" onclick="location.href='<s:property value="view"/>'" value="확 인" />
		</div>
	</div>
</body>
</html>