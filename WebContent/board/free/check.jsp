<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인</title>
<link rel="stylesheet" type="text/css" href="css/inquire.css" />
<script type="text/javascript" src="js/memo.js"></script>
<script type="text/javascript">
function checkForm() {
	if(!checkNull(document.fm.password, document.getElementById("error_password"), "암호를 입력하세요")) 
		document.fm.submit();
}
</script>
</head>
<body>
<div id="content">
	<h3>암호 확인</h3>
	<s:form name="fm" action="freecheck_pass">
		<s:hidden name="no" value="%{no}" />
		<s:hidden name="page" value="%{page}" />
		<s:hidden name="job" value="%{job}" />
		<s:hidden name="rno" value="%{rno}" />
		<table>
			<tr>
				<th width="60">암호</th>
				<td>
					<input type="password" name="password" />
					<span class="error-text" id="error_password"></span>
				</td>
			</tr>
		</table>
		<br />
		<div align="center">
			<span class="button"><a href="javaScript:checkForm()">확 인</a></span>&nbsp;
			<s:url var="cancel" action="freeview">
				<s:param name="no" value="no"></s:param>
				<s:param name="page" value="page"></s:param>
				<s:param name="r" value="%{'n'}"></s:param>
			</s:url>
			<span class="button"><s:a href="%{cancel}">취 소</s:a></span>
		</div>
	</s:form>
</div>
</body>
</html>