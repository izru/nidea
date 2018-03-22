<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>
<%
	//scriplet < %... % >
	//permite escribir varias sentencias
	String nombre ="pepe";
	String hora ="10:18";
%>

<h2>Hello World! <%=nombre %></h2>
<p><%=hora%></p>
<a href="generar-mesa">Quieres comprar una mesa?</a>
<jsp:include page="templates/footer.jsp"></jsp:include>
