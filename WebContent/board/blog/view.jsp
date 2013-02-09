<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내용보기</title>
<link rel="stylesheet" type="text/css" href="css/blog.css">
<script type="text/javascript" src="js/memo.js"></script>
<script type="text/javascript">
function checkForm() {
	var result = true;
	if(checkNull(document.fm.writer, document.getElementById("error_writer"), "작성자를 입력하세요")) result = false;
	if(checkNull(document.fm.password, document.getElementById("error_password"), "암호를 입력하세요")) result = false;
	if(!isEqual(document.fm.password, document.fm.password2, document.getElementById("error_password2"),
			"암호가 일치하지 않습니다")) result = false;
	if(checkNull(document.fm.memo, document.getElementById("error_memo"), "덧글을 입력하세요")) result = false;
	return result;
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
				<td><s:property value="article.title" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td height="200" valign="top">
					<s:property value="article.content" escape="false" />
				</td>
			</tr>						
		</table>
		<br />
		<div align="center">
			<input type="button" onclick="location.href='BlogIndex.action?page=<s:property value="page"/>'" value="목 록" />&nbsp;&nbsp;
			<input type="button" onclick="location.href='BlogCheck.action?no=<s:property value="no"/>&page=<s:property value="page"/>&job=edit&rno=-1'" value="수 정" />&nbsp;&nbsp;
			<input type="button" onclick="location.href='BlogCheck.action?no=<s:property value="no"/>&page=<s:property value="page"/>&job=remove&rno=-1'" value="삭 제" />
		</div>
		<br />
		<s:if test="replies!=null">
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
						<span class="small">
							<a href="BlogCheck.action?no=<s:property value='article.no'/>&page=<s:property value='page'/>&job=repl&rno=<s:property value='no'/>">삭제</a>
						</span>
					</td>
					<td align="center"><s:date name="wdate" format="yyyy-MM-dd"/></td>
				</tr>
			</s:iterator>
		</table>
		</s:if>
		<h3>덧글 달기</h3>
		<form name="fm" method="post" action="BlogWriteReply.action">
			<input type="hidden" name="parent_no" value="<s:property value='no'/>" />
			<input type="hidden" name="page" value="<s:property value='page'/>" />
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
						<textarea name="memo" id="memo" cols="80" rows="3"></textarea><br />
						<span class="error-text" id="error_memo"></span>
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