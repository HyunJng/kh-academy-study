<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<title><spring:message code="message.board.list.mainTitle" /></title>
</head>
<body>
<center>
<h1><spring:message code="message.board.list.mainTitle" /></h1>
<h3>${userName }<spring:message code="message.board.list.welcomeMsg" />...
	<a href="logout.do">Log-out</a></h3>

<!-- 검색 시작 -->
<form action="getBoardList.do" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="75%">
	<tr>
		<td align="right">
			<select name="searchCondition">
				<c:forEach items="${conditionMap }" var="option">
					<option value="${option.value }">${option.key }
				</c:forEach>
			</select>
			<input name="searchKeyword" type="text" />
			<input  type="submit" 
				value="<spring:message code="message.board.list.search.condition.btn" />" />
		</td>
	</tr>
</table>
</form>

<!-- 검색 종료 -->
<table class="table table-bordered w-75">
<thead class="table-primary w-100">
<tr>
	<th class="col-sm-1">
		<spring:message code="message.board.list.table.head.seq" /></th>
	<th class="col-sm-4">
		<spring:message code="message.board.list.table.head.title" /></th>
	<th class="col-sm-3">
		<spring:message code="message.board.list.table.head.writer" /></th>
	<th class="col-sm-3">
		<spring:message code="message.board.list.table.head.regDate" /></th>
	<th class="col-sm-1">
		<spring:message code="message.board.list.table.head.cnt" /></th>
</tr>
</thead>
<c:forEach items="${boardList }" var="board">
<tr>
	<td>${ board.seq }</td>
	<td align="left">
		<a href="getBoard.do?seq=${ board.seq }&pageNum=${pageMaker.cri.pageNum}&
			amount=${pageMaker.cri.amount}&searchCondition=${ pageMaker.cri.searchCondition }&
			searchKeyword=${ pageMaker.cri.searchKeyword }">${ board.title }</a>
	</td>
	<td>${ board.writer }</td>
	<td><fmt:formatDate value="${ board.regDate }" pattern="yyyy-MM-dd" /></td>
	<td>${ board.cnt }</td>
</tr>
</c:forEach>
</table>

<br>
<div class="text-center">
	<ul class="pagination justify-content-center">
		<c:if test="${pageMaker.prev}">
			<li class="page-item paginate_button previous">
				<a class="page-link" href="${pageMaker.startPage -1}">Previous</a>
			</li>
		</c:if>
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num" >
			<li class="page-item paginate_button  ${pageMaker.cri.pageNum == num ? "active":""} ">
				<a class="page-link" href="${num}">${num}</a>
			</li>
		</c:forEach>
		<c:if test="${pageMaker.next}">
			<li class="page-item paginate_button next">
				<a class="page-link" href="${pageMaker.endPage +1 }">Next</a>
			</li>
		</c:if>
	</ul>
</div>
<form id='pageForm' action="getBoardList.do" method='get'>
	<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
	<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>

	<input type='hidden' name='searchCondition' value='<c:out value="${ pageMaker.cri.searchCondition }"/>'> 
	<input type='hidden' name='searchKeyword'	value='<c:out value="${ pageMaker.cri.searchKeyword }"/>'>
</form>

<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard" /></a>
<script>
	$(function(){
		$(".paginate_button a").on("click",
			function(e) {
				e.preventDefault();
//				console.log('click');
				$("#pageForm").find("input[name='pageNum']").val($(this).attr("href"));
				$("#pageForm").submit();
			}
		);
	});
</script>
</center>
</body>
</html>