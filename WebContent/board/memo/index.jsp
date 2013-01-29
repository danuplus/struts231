<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>한줄 메모장</title>
<link rel="stylesheet" type="text/css" href="css/memo.css">
<script type="text/javascript" src="js/memo.js"></script>
<script type="text/javascript">
function checkForm() {
	var result = true;
	
	if(checkNull(document.fm.writer, document.getElementById("error_writer"), "작성자를 입력해주세요")) result = false;
	if(checkNull(document.fm.password, document.getElementById("error_password"), "암호를 입력해주세요")) result = false;
	if(!isEqual(document.fm.password, document.fm.password2, document.getElementById("error_password2"),
			"암호가 일치하지 않습니다")) result = false;
	if(checkNull(document.fm.memo, document.getElementById("error_memo"), "메모를 입력해주세요")) result = false;
	
	return result;
}
</script>
</head>
<body>
<div id="content">
	<h3>한줄 메모장</h3>
	<div align="right">전체 <s:property value="total"/> 페이지 중에 현재 <s:property value="page"/> 페이지</div>
	<table>
		<tr>
			<th width="60">글번호</th>
			<th>메모</th>
			<th width="60">작성자</th>
			<th width="80">작성일</th>
		</tr>
		<s:iterator value="memos" status="memo">
		<tr>
			<td align="center"><s:property value="no"/></td>
			<td>
				<s:property value="memo"/>
				<s:url id="url" action="MemoCheck">
					<s:param name="no" value="no"></s:param>
					<s:param name="page" value="page"></s:param>
				</s:url>
				<s:a href="%{url}" cssClass="small">삭제</s:a>
			</td>
			<td align="center"><s:property value="writer"/></td>
			<td align="center"><s:date name="date" format="yyyy-MM-dd"/></td>
		</tr>
		</s:iterator>
		<tr>
			<td colspan="4" align="center">
				<s:a href="MemoIndex.action?page=1">&lt;&lt;첫 페이지</s:a>&nbsp;&nbsp;
				<s:if test="page > 1">
					<s:url id="utl" action="MemoIndex">
						<s:param name="page" value="page-1"></s:param>
					</s:url>
					<s:a href="%{url}">&lt;이전 페이지</s:a>&nbsp;&nbsp;
				</s:if>
				<s:if test="page < total">
					<s:url id="url" action="MemoIndex">
						<s:param name="page" value="page+1"></s:param>
					</s:url>
					<s:a href="%{url}">다음 페이지&gt;</s:a>&nbsp;&nbsp;
				</s:if>
				<s:url id="url" action="MemoIndex">
					<s:param name="page" value="total"></s:param>
				</s:url>
				<s:a href="%{url}">마지막 페이지&gt;&gt;</s:a>
			</td>
		</tr>
	</table>
	<h3>메모 쓰기</h3>
	<s:form name="fm" action="MemoWrite" method="post">
		<table>
			<tr>
				<th width="60">작성자</th>
				<td>
					<input type="text" name="writer" />
					<span class="error-text" id="error_writer"></span>
				</td>
			</tr>
			<tr>
				<th>암호</th>
				<td>
					<input type="password" name="password" />
					<span class="error-text" id="error_password"></span>
				</td>
			</tr>
			<tr>
				<th>암호확인</th>
				<td>
					<input type="password" name="password2" />
					<span class="error-text" id="error_password2"></span>
				</td>
			</tr>
			<tr>
				<th>메모</th>
				<td>
					<textarea rows="3" cols="85" name="memo"></textarea><br /><br />
					<span class="error-text" id="error_memo"></span>
				</td>
			</tr>
		</table><br />
		<div align="center">
			<input type="submit" onclick="return checkForm()" value="확 인" />
		</div>
	</s:form>
</div>
</body>
</html>