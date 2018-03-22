<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>
<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>

<%
	//recoger atributo del controlador, si es que existe
	
	Mesa mesa = (Mesa)request.getAttribute("mesa");

%>

<form action="generar-mesa" method="post">
	<div class="form-group row">
		<label class="col-sm-2 col-form-label" for="patas">Numero de patas:</label>
		<div class="col-sm-10">
			<input type="number" name="patas" value="4" required>
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label" for="dimension">Dimension:</label>
		<div class="col-sm-10">
			<input type="number" name="dimension" value="1" required>
		</div>
	</div>
	<div class="form-group row">
    	<label class="col-sm-2 col-form-label" for="materiales"  >Materiales</label>
    	<div class="col-sm-10">
    		<select class="form-control" id="materiales" name="material" >
      			<option value="1">Madera</option>
      			<option value="2">Acero</option>
      			<option value="3">Aluminio</option>
      			<option value="4">Plastico</option>     
    		</select>
    	</div>
  	</div>
  	
	
	<fieldset class="form-group">
    <div class="row">
      <legend class="col-form-label col-sm-2 pt-0">Color</legend>
      <div class="col-sm-10">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="color" id="gridRadios1" value="blanco" checked>
          <label class="form-check-label" for="gridRadios1">
            Color blanco
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="color" id="gridRadios2" value="custom">
          <label class="form-check-label" for="gridRadios2">
            Custom
          </label>
        </div>        
      </div>
    </div>
  </fieldset>
	
	<div class="row">
	<div class="col-sm-2" ></div>
	<div class="col-sm-10">
		<input type="submit" value="Calcular Precio">
		</div>
	</div>
</form>
<section >
<div class="row">
	<p class="col-sm-2">Numero Patas: <%=mesa.getNumPatas()%> </p>
</div>
<div class="row">
	<p class="col-sm-2">Dimension: <%=mesa.getDimension() %> </p>
</div>
<div class="row">
	<p class="col-sm-2">Color: <%=mesa.getColor()%> </p>
</div>

<div class="row">
	<p class="col-sm-2">Material: <%=mesa.getMaterial()%> </p>
</div>
<div class="row">
	<p class="col-sm-2">Precio: <%=mesa.getPrecio()%> </p>
</div>
</section>
<jsp:include page="templates/footer.jsp"></jsp:include>