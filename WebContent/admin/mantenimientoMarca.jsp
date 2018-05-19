<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Administrador"%>
<%@page import="entidad.Modelo"%>
<%@page import="entidad.Marca"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	List<Marca> listaMarca = (List<Marca>) request.getAttribute("listaMarca");
%>
<%
	Marca marcaEditable = (Marca) request.getAttribute("marcaEditable");
%>
<%
	String mensaje = (String) request.getAttribute("mensaje");
%>

<%@include file="../template/cabeceraAdmin.jsp"%>

<section class="content">
<div class="container-fluid">
	<!-- #END# Widgets -->
	<!-- CPU Usage -->
	<div class="row clearfix">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<form action="MarcaController">
			<div class="card">
				<div class="header">
					<div class="row clearfix">
						<div class="col-xs-12 col-sm-6">
							<h2>Mantenimiento de Marca de Vehiculos</h2>
						</div>
					</div>
				</div>
				<div class="body">
					<div class="row clearfix">
						<%
							if (mensaje != null) {
						%>
						<div class="col-12">
							<div id="myAlert" class="alert bg-green alert-dismissible"
								role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>Accion!</strong><%=mensaje%>
							</div>
						</div>
						<%
							}
						%>
						<div class="col-sm-6">
							<label>Nombre:</label> 
							<input type="text" class="form-control" name="txtNombre" id="txtNombre" value="<%=marcaEditable.getNombre()%>">
						</div>
						<div class="col-sm-6"></br>
							<button class="btn bg-red btn-block btn-lg" type="submit">Grabar</button>
							<input type="hidden" value="<%= marcaEditable.getId() %>" name="idMar" />
							<input type="hidden" value="grabarMarca" name="accion" />
						</div>
					</div>
				</div>
			</div>
			</form>
		</div>

		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="card">
				<div class="header">
					<div class="row clearfix">
						<div class="col-xs-12 col-sm-6">
							<h2>Lista de Marcas de Vehiculo</h2>
						</div>
					</div>
				</div>
				<div class="body">
					<div class="table-responsive">
						<table class="table table-hover dashboard-task-infos">
							<thead>
								<tr>
									<th>Marca</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Marca marca : listaMarca) {
								%>
								<tr>
									<td><%= marca.getNombre() %></td>
									<td><a href="MarcaController?accion=editarMarca&idMar=<%= marca.getId() %>"><i class="fas fa-edit"></i></a></td>
									<td><a href="MarcaController?accion=eliminarMarca&idMar=<%= marca.getId() %>"><i class="fas fa-trash-alt"></i></a></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
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
	$(document).ready(function() {
		$('input[rel="tooltip"]').tooltip();
	});
</script> <script type="text/javascript">
		$(document).ready(function() {
			// show the alert
			setTimeout(function() {
				$("#myAlert").alert('close');
			}, 5000);
		});
	</script> </section>

<%@include file="../template/pieAdmin.jsp"%>