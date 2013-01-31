<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지 게시판</title>
<link rel="stylesheet" type="text/css" href="css/notice.css">
</head>
<body>
<div id="content">
	<h3>공지 게시판</h3>
	<div align="right">전체 <s:property value="total" /> 페이지 중에 현재 <s:property value="page"/> 페이지</div>
	<table>
		<tr>
			<th width="60">글번호</th>
			<th>제목</th>
			<th width="60">작성자</th>
			<th width="60">조회수</th>
			<th width="80">작성일</th>
		</tr>
		<s:iterator value="articles" status="article">
		<tr>
			<td align="center"><s:property value="no"/></td>
			<td>
				<a href="NoticeView.action?no=<s:property value='no'/>&page=<s:property value='page'/>">
					<s:property value="title"/>
				</a>
			</td>
			<td align="center"><s:property value="writer"/></td>
			<td align="center"><s:property value="ref"/></td>
			<td align="center"><s:date name="wdate" format="yyyy-MM-dd"/></td>
		</tr>
		</s:iterator>
		<tr>
			<td colspan="5" align="center">
				<a href="NoticeIndex.action?page=1">&lt;&lt;첫 페이지</a>&nbsp;&nbsp;
				<s:if test="page > 1">
					<a href="NoticeIndex.action?page=<s:property value='page-1'/>">&lt;이전 페이지</a>&nbsp;&nbsp;
				</s:if>
				<s:if test="page < total">
					<a href="NoticeIndex.action?page=<s:property value='page+1'/>">다음 페이지&gt;</a>&nbsp;&nbsp;
				</s:if>
				<a href="NoticeIndex.action?page=<s:property value='total'/>">마지막 페이지</a>
			</td>
		</tr>
	</table><br/>
	<div align="center">
		<input type="button" onclick="location.href='board/notice/write.jsp?page=<s:property value="page" />'" value="새글 쓰기" />
	</div>
</div>
</body>
</html>