<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인</title>
<link rel="stylesheet" type="text/css" href="../../css/notice.css">
<script type="text/javascript" src="../../js/memo.js"></script>
<script type="text/javascript">
function checkForm() {
	if(checkNull(document.fm.password, document.getElementById("error_password"), "비밀번호를 입력하세요"))
		return false;
	else 
		return true;
}
</script>
</head>
<body>
	<div id="content">
		<h3>비밀번호 확인</h3>
		<form name="fm" action="/struts231/NoticeCheckPassword.action" method="post">
			<input type="hidden" name="no" value="<s:property value='#parameters.no'/>" />
			<input type="hidden" name="page" value="<s:property value='#parameters.page'/>" />
			<input type="hidden" name="job" value="<s:property value='#parameters.job'/>" />
			<table>
				<tr>
					<th width="60">비밀번호</th>
					<td><input type="password" name="password" />
						<span class="error-text" id="error_password"></span>
					</td>
				</tr>
			</table>
			<br />
			<div align="center">
				<input type="submit" onclick="return checkForm()" value="확 인" />
			</div>
		</form>
	</div>
</body>
</html>