<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>암호 확인</title>
<link rel="stylesheet" type="text/css" href="css/inquire.css">
<script type="text/javascript" src="js/board.js"></script>
<script type="text/javascript">
function CheckForm() {
	if(checkNull(document.fm.password, document.getElementById("error_password"), "암호를 입력하세요"))
		return false;
	else 
		return true;
}
</script>
</head>
<body>
	<div id="content">
		<h3>암호 확인</h3>
		<form name="fm" method="post" action="InquireCheckPassword.action">
			<input type="hidden" name="no" value="<s:property value='#parameters.no' />" />
			<input type="hidden" name="page" value="<s:property value='#parameters.page' />" />
			<input type="hidden" name="job" value="<s:property value='#parameters.job' />" />
			<table>
				<tr>
					<th width="60">암호</th>
					<td><input type="password" name="password" />
						<span class="error-text" id="error_password"></span>
					</td>
				</tr>
			</table>
			<br />
			<div align="center">
				<input type="submit" onclick="return CheckForm()" value="확 인" />&nbsp;&nbsp;
				<input type="button" onclick="location.href='InquireView.action?no=<s:property value="#parameters.no" />&page=<s:property value="#parameters.page" />&r=n'" value="취 소" />
			</div>
		</form>
	</div>
</body>
</body>
</html>