<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Administrador"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% String mensaje = (String) request.getAttribute("mensaje");%>

<%@include file="../template/cabeceraAdmin.jsp"%>

<section class="content">
	<div class="container-fluid">
		<!-- #END# Widgets -->
		<!-- CPU Usage -->
		<div class="row clearfix">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="card">
					<div class="header">
						<div class="row clearfix">
							<div class="col-xs-12 col-sm-6">
								<h2>Datos del Cliente</h2>
							</div>
						</div>
					</div>
					<div class="body">
						<div class="row clearfix">
							<% if (mensaje != null) { %>
							<div class="col-12">
								<div id="myAlert" class="alert bg-green alert-dismissible" role="alert">
									<button type="button" class="close" data-dismiss="alert"  aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<strong>Accion!</strong><%=mensaje%>
								</div>
							</div>
							<%}%>
							Bienvenido Administrador <%= adminLogeado.getApellidos() + " " + adminLogeado.getNombre() %> 
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- #END# CPU Usage -->
		<!-- #END# Task Info -->
		<!-- Browser Usage -->
		<!-- #END# Browser Usage -->
	</div>
	<script type="text/javascript">
	
	$(document).ready(function(){
	    $('input[rel="tooltip"]').tooltip();
	});
	</script>
		<script type="text/javascript">
	$(document).ready(function() {
	    // show the alert
	    setTimeout(function() {
	        $("#myAlert").alert('close');
	    }, 5000);
	});
	</script>
</section>

<%@include file="../template/pieAdmin.jsp"%>