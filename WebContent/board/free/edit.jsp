<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
<link rel="stylesheet" type="text/css" href="css/inquire.css">
<script type="text/javascript" src="js/memo.js"></script>
<script type="text/javascript">
function checkForm(){
	var result = true;
	if(checkNull(document.fm.writer, document.getElementById("error_writer"), "작성자를 입력하세요")) result = false;
	if(checkNull(document.fm.password, document.getElementById("error_password"), "암호를 입력하세요")) result = false;
	if(!isEqual(document.fm.password, document.fm.password2, 
			document.getElementById("error_password2"), "암호가 일치하지 않습니다")) result = false;
	if(checkNull(document.fm.title, document.getElementById("error_title"), "제목을 입력하세요")) result = false;
	if(result) {
		document.fm.submit();
	} 
}
</script>
</head>
<body>
<div id="content">
	<h3>글 수정</h3>
	<s:form name="fm" action="freeedit">
		<s:hidden name="no" value="%{no}"></s:hidden>
		<s:hidden name="page" value="%{page}"></s:hidden>
		<table>
			<tr>
				<th width="60">작성자</th>
				<td><input type="text" name="writer" value="<s:property value='article.writer'/>"/>
					<span class="error-text" id="error_writer"></span>
				</td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="password" value="<s:property value='article.password'/>"/>
					<span class="error-text" id="error_password"></span>
				</td>
			</tr>
			<tr>
				<th>암호 확인</th>
				<td><input type="password" name="password2" value="<s:property value='article.password'/>"/>
					<span class="error-text" id="error_password2"></span>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" size="80" value="<s:property value='article.title'/>"/>
					<span class="error-text" id="error_title"></span>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="20" cols="80" name="content"><s:property value="article.content"/></textarea>
				</td>
			</tr>
		</table>
		<br />
		<div align="center">
			<span class="button"><a href="javaScript:checkForm()">확 인</a></span>&nbsp;
			<s:url var="cancel" action="freeview">
				<s:param name="no" value="no" />
				<s:param name="page" value="page" />
				<s:param name="r" value="%{'n'}" />
			</s:url>
			<span class="button"><s:a href="%{cancel}">취 소</s:a></span>
		</div>
	</s:form>
</div>
</body>
</html>