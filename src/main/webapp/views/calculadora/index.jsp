<%@page import="com.ipartek.formacion.nidea.controller.CalculadoraController"%>
<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>

<%
	String alert= (String)request.getAttribute("alert");
	if (alert !=null){
		//out.print(alert);
	
%>
<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <%=alert %>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<%
}
%>
formulario calcular
<form action="calculadora" method="post">
	<div class="form-group">
    	<label for="num1">1º Numero</label>
    	<input type="text" class="form-control" name="num1">
  	</div>
  	
  	<div class="form-group">
    	<label for="num2">2º Numero</label>
    	<input type="text" class="form-control" name="num2">
  	</div>
  	
  	<div class="form-group">
    <label for="operacion">Operacion</label>
    <select class="form-control" id="operacion" name="operacion">
      <option value="<%=CalculadoraController.OP_SUMAR%>">Sumar</option>
      <option value="<%=CalculadoraController.OP_RESTAR%>">Restar</option>
      <option value="<%=CalculadoraController.OP_DIVIDIR%>">Division</option>
      <option value="<%=CalculadoraController.OP_MULTIPLICAR%>">Multiplicar</option>     
    </select>
  </div>
  	
	<input type="submit" value="Calcular">
</form>
<jsp:include page="/templates/footer.jsp"></jsp:include>
