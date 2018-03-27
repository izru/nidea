<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>


<h1>Resultado de la operacion</h1>
<%
	float result = (Float)request.getAttribute("resultado");
%>
<%=result %>
<jsp:include page="/templates/footer.jsp"></jsp:include>