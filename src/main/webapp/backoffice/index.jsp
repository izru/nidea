<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>
<jsp:include page="/templates/alert.jsp"></jsp:include>

<%
	//recoger atributo del controlador, si es que existe
	
	
	ArrayList<Material> materiales = (ArrayList<Material>)request.getAttribute("materiales");
%>

<h1>Backoffice</h1>

<label  for="patas">Numero de patas:</label>
		
			<input type="number" name="patas" value="<%=materiales.size()%>"  required>

<table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Precio</th>                
            </tr>
        </thead>
        <tbody>
            
<!--  https://datatables.net/manual/styling/bootstrap-simple.html-->
 				
 				<% 
					Material m = null;
					for ( int i=0; i < materiales.size(); i++ ) {
						m = materiales.get(i);
				%>
				<tr>
					<td><%=m.getNombre()%></td>
					<td><%=m.getPrecio()%>&euro;</td>
					</tr>
 				<% } %>
              
        </tbody>
        <tfoot>
            <tr>
                <th>Nombre</th>
                <th>Precio</th>
                
            </tr>
        </tfoot>
    </table> 				


<jsp:include page="/templates/footer.jsp"></jsp:include>