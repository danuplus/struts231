<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 보기</title>
<link rel="stylesheet" type="text/css" href="css/inquire.css">
<script type="text/javascript" src="js/memo.js"></script>
<script type="text/javascript">
function checkForm() {
	var result = true;
	
	if(checkNull(document.fm.writer, document.getElementById("error_writer"), "작성자를 입력하세요")) result = false;
	if(checkNull(document.fm.password, document.getElementById("error_password"), "암호를 입력하세요")) result = false;
	if(!isEqual(document.fm.password, document.fm.password2,
			document.getElementById("error_password2"), "암호가 일치하지 않습니다")) result = false;
	if(checkNull(document.fm.memo, document.getElementById("error_memo"), "덧글을 입력하세요")) result = false;
	
	if(result)
		document.fm.submit();
}
</script>
</head>
<body>
<div id="content">
	<h3>글 보기</h3>
	<table>
		<tr>
			<th width="60">작성자</th>
			<td><s:property value="article.writer" /></td>
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
		<s:url var="answer" action="freeanswer">
			<s:param name="no" value="article.no" />
			<s:param name="page" value="page" />
		</s:url>
		<span class="button"><s:a href="%{answer}">답 글</s:a></span>&nbsp;
		<s:url var="edit" action="freecheck">
			<s:param name="no" value="article.no" />
			<s:param name="page" value="page" />
			<s:param name="job" value="%{'edit'}" />
			<s:param name="rno" value="%{'-1'}" />
		</s:url>
		<span class="button"><s:a href="%{edit}">수 정</s:a></span>&nbsp;
		<s:url var="remove" action="freecheck">
			<s:param name="no" value="article.no" />
			<s:param name="page" value="page" />
			<s:param name="job" value="%{'remove'}" />
			<s:param name="rno" value="%{'-1'}" />
		</s:url>
		<span class="button"><s:a href="%{remove}">삭 제</s:a></span>&nbsp;
		<s:url var="index" action="freeindex">
			<s:param name="page" value="page" />
		</s:url>
		<span class="button"><s:a href="%{index}">목 록</s:a></span>
	</div><br />
	
	<s:if test="replies != null">
		<h3>덧글</h3>
		<table>
			<tr>
				<th width="60">작성자</th>
				<th>덧글</th>
				<th width="80">작성일</th>
			</tr>
			<s:iterator value="replies" status="reply">
			<tr>
				<td align="center"><s:property value="writer"/></td>
				<td>
					<s:property value="memo"/>&nbsp;
					<s:url var="remove_repl" action="freecheck">
						<s:param name="no" value="article.no" />
						<s:param name="page" value="page" />
						<s:param name="job" value="%{'repl'}" />
						<s:param name="rno" value="no" />
					</s:url>
					<span class="small">
						<s:a href="%{remove_repl}">삭제</s:a>
					</span>
				</td>
				<td align="center"><s:date name="wdate" format="yyyy-MM-dd" /></td>
			</tr>
			</s:iterator>
		</table>
	</s:if>
	
	<h3>덧글 쓰기</h3>
	<s:form name="fm" action="freewrite_reply">
		<s:hidden name="pno" value="%{article.no}"></s:hidden>
		<s:hidden name="page" value="%{page}"></s:hidden>
		<table>
			<tr>
				<th width="60">작성자</th>
				<td><input type="text" name="writer" />
					<span class="error-text" id="error_writer"></span>
				</td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="password" />
					<span class="error-text" id="error_password"></span>
				</td>
			</tr>
			<tr>
				<th>암호 확인</th>
				<td><input type="password" name="password2" />
					<span class="error-text" id="error_password2"></span>
				</td>
			</tr>
			<tr>
				<th>덧글</th>
				<td>
					<textarea rows="3" cols="85" name="memo"></textarea><br /><br />
					<span class="error-text" id="error_memo"></span>
				</td>
			</tr>
		</table>
		<br />
		<div align="center">
			<span class="button">
				<a href="javaScript:checkForm()">확 인 </a>
			</span>
		</div>
	</s:form>
</div>
</body>
</html>