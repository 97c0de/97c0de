<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.review.cinema.vo.QnaVo" %>
<%@ page import = "com.review.cinema.vo.UserVo" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/qna_view.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinema Review |</title>
</head>
<body>
	<div class="container" style="margin-top: 50px;">
		<%
		request.setCharacterEncoding("utf-8");
			QnaVo qna = (QnaVo)request.getAttribute("qna");
			UserVo user = (UserVo)session.getAttribute("user");
			List<QnaVo> qna_comment = (List<QnaVo>)request.getAttribute("qna_comment");
		%>
		<h2>1:1문의게시판</h2>
		<table>
			<tr>
				<th>제목</th>
				<td><%=qna.getQna_title()%></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=qna.getId()%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><%=qna.getQna_content().replace("\r\n","<br>")%></td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="qna_updateForm.qna?qna_no=<%=qna.getQna_no()%>"><p>수정</p></a>
					<a href="qna_delete.qna?qna_no=<%=qna.getQna_no()%>" id="delete_button"><p>삭제</p></a>
					<script>
						document.getElementById("delete_button").onclick = function(){
							var con = confirm("문의글을 삭제하시겠습니까?");
							if(!con){
								return false;
							}
						}
					</script>
				</td>
			</tr>
			<%
			if(user.getId().equals("admin")){
			%>
			<tr class="reply">
				<td colspan="2">
					<form action="comment_write.qna?qna_no=<%=qna.getQna_no()%>" method="post" id="comment_write_form" onsubmit="return checkComment()">
						<p id="text">댓글쓰기</p>  <textarea cols="80" rows="6" name="comment_write" id="comment_write"></textarea>
						&nbsp;&nbsp;&nbsp;
						<p>
							<input type="submit" value="등록"/>
						</p>
						<script>
							function checkComment(){
								var value = document.getElementById("comment_write").value;
								
								if(!value){
									alert("댓글에 아무것도 입력하지 않았습니다.");
									return false;
								}
							}
						</script>
					</form>
				</td>
			</tr>
			<%
			} else {
			%>
			<tr>
				<td id="admin_reply" colspan="4">관리자만 댓글을 쓸 수 있습니다.</td>
			</tr>
			<%
			}
			%>
			
			<%
						if(qna_comment.size() > 0){
													for(int i=0; i<qna_comment.size(); i++){
														QnaVo comment = qna_comment.get(i);
						%>
			<tr class="reply_view">
				<td id="replyid"><%= comment.getId() %></td>
				<td>
					<form action="comment_update.qna?qna_comment_no=<%=comment.getQna_comment_no()%>&comment_update_name=<%=i%>&qna_no=<%=comment.getQna_no()%>" method="post" name="comment_update_form">
						<span id="comment_content_<%=i%>"><%= comment.getQna_comment_content().replace("\r\n","<br>") %></span>
		
					<%
						if(user != null){
							if(user.getId().equals("admin")){
					%>
					<p id="reply_option">
						<a href="#" id="button_<%=i%>">수정</a>
						<script>
							document.getElementById("button_<%=i%>").onclick = function(){
								var org_value = document.getElementById("comment_content_<%=i%>").innerHTML;
								
								document.getElementById("button_<%=i%>").style.display = "none";
								document.getElementById("update_commit_<%=i%>").style.display = "inline";
								document.getElementById("comment_content_<%=i%>").innerHTML = "<textarea cols='130' rows='4' name='<%=i%>' id='<%=i%>'></textarea>";
								document.getElementById("<%=i%>").value = org_value.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
							}
						</script>
						<a href="javascript:comment_update_form.submit()" id="update_commit_<%=i%>" style="display:none;"><button>완료</button></a>
						<a href="comment_delete.qna?qna_comment_no=<%=comment.getQna_comment_no()%>&qna_no=<%=comment.getQna_no()%>">삭제</a>
					</p>
					</form>
				<%
						}
					}
				%>
				</td>
			</tr>
			<%
					}
				} else {
			%>
			<tr>
				<td colspan="2">아직 댓글이 없습니다.</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>