<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
<link rel="stylesheet" type="text/css" href="css/inquire.css">
</head>
<body>
<div id="content">
	<h3>글 목록</h3>
	<div align="right">전체<s:property value="total"/> 페이지 중에 현재 <s:property value="page"/> 페이지</div>
	<table>
		<tr>
			<th width="60">글 번호</th>
			<th>제목</th>
			<th width="60">작성자</th>
			<th width="60">조회수</th>
			<th width="80">작성일</th>
		</tr>
		<s:iterator value="articles" status="article">
		<tr>
			<td align="center"><s:property value="no"/></td>
			<td>
				<s:url var="view" action="freeview">
					<s:param name="no" value="no" />
					<s:param name="page" value="page" />
				</s:url>
				<s:a href="%{view}">
					<s:property value="title" escape="false"/>
				</s:a>&nbsp;
				<span class="small">(<s:property value="reply_cnt" />)</span>
			</td>
			<td align="center"><s:property value="writer"/></td>
			<td align="center"><s:property value="read_cnt"/></td>
			<td align="center"><s:date name="wdate" format="yyyy-MM-dd"/></td>
		</tr>
		</s:iterator>
		<tr>
			<td colspan="5" align="center">
				<a href="freeindex.action?page=1">&lt;&lt;첫 페이지</a>&nbsp;&nbsp;
				<s:if test="page > 1">
					<s:url var="previous" action="freeindex">
						<s:param name="page" value="page-1" />
					</s:url>
					<s:a href="%{previous}">&lt;이전 페이지</s:a>&nbsp;&nbsp;
				</s:if>
				<s:if test="page < total">
					<s:url var="next" action="freeindex">
						<s:param name="page" value="page+1" />
					</s:url>
					<s:a href="%{next}">다음 페이지&gt;</s:a>&nbsp;&nbsp;
				</s:if>
				<s:url var="last" action="freeindex">
					<s:param name="page" value="total" />
				</s:url>
				<s:a href="%{last}">마지막 페이지&gt;&gt;</s:a>
			</td>
		</tr>
	</table><br />
	<div align="center">
		<span class="button">
			<s:url var="write" action="freewrite">
				<s:param name="page" value="page" />
			</s:url>
			<s:a href="%{write}">새 글 쓰기</s:a>
		</span>
	</div>
</div>
</body>
</html>