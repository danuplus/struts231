<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내용 보기</title>
<link rel="stylesheet" type="text/css" href="css/inquire.css">
</head>
<body>
<div id="content">
	<h3>글보기</h3>
	<table>
		<tr>
			<th width="60">작성자</th>
			<td><s:property value="article.writer"/></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><s:date name="article.wdate" format="yyyy-MM-dd" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><s:property value="article.title"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td height="200" valign="top"><s:property value="article.content" escape="false"/></td>
		</tr>
	</table><br />
	<div align="center">
		<input type="button" onclick="location.href='InquireAnswer.action?no=<s:property value="no" />&page=<s:property value="page" /> ' " value="답 글" />&nbsp;&nbsp;
		<input type="button" onclick="location.href='InquireCheck.action?no=<s:property value="no" />&page=<s:property value="page" />&job=edit' " value="수 정" />&nbsp;&nbsp;
		<input type="button" onclick="location.href='InquireCheck.action?no=<s:property value="no" />&page=<s:property value="page" />&job=remove' " value="삭 제" />&nbsp;&nbsp;
		<input type="button" onclick="location.href='InquireIndex.action?page=<s:property value="page" />' " value="목 록" />
	</div>
</div>
</body>
</html>