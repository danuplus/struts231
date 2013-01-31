<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 보기</title>
<link rel="stylesheet" type="text/css" href="css/notice.css">
</head>
<body>
<div id="content">
	<h3>글 보기</h3>
	<table>
		<tr>
			<th width="60">작성자</th>
			<td><s:property value="article.writer"/></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><s:date name="article.wdate" format="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><s:property value="article.title"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td height="200" valign="top"><s:property value="article.notice" escape="false"/></td>
		</tr>
	</table><br />
	<div align="center">
		<s:url var="index" action="NoticeIndex">
			<s:param name="page" value="page" />
		</s:url>
		<s:url var="edit" value="board/notice/check.jsp?job=edit">
			<s:param name="no" value="no" />
			<s:param name="page" value="page" />
			<s:param name="job" value="%{'edit'}" />
		</s:url>
		<s:url var="remove" value="board/notice/check.jsp?job=remove">
			<s:param name="r" value="n" />
			<s:param name="no" value="no" />
			<s:param name="page" value="page" />
			<%-- <s:param name="job" value="%{'remove'}" /> --%>
		</s:url>
		<input type="button" onclick="location.href='NoticeIndex?page=<s:property value="page" />'" value="목 록" />&nbsp;&nbsp;
		<input type="button" onclick="location.href='board/notice/check.jsp?job=edit&no=<s:property value="no" />&page=<s:property value="page" />'" value="수 정" />&nbsp;&nbsp;
		<input type="button" onclick="location.href='board/notice/check.jsp?job=remove&no=<s:property value="no" />&page=<s:property value="page" />'" value="삭 제" />&nbsp;&nbsp;
	</div>
</div>
</body>
</html>