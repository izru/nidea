<%@page import="com.ipartek.formacion.nidea.pojo.Alert"%>
<%
	Alert alert= (Alert)request.getAttribute("alert");

	if (alert !=null){
		//out.print("alert");
	
%>
		<div class="alert alert-warning alert-dismissible fade show" role="alert">
 			<%=alert.getMensaje() %>
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    			<span aria-hidden="true">&times;</span>
  			</button>
		</div>
<%
	}//end if
%>

