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
	List<Modelo> listaModelo = (List<Modelo>) request.getAttribute("listaModelo");
%>
<%
	List<Marca> listaMarca = (List<Marca>) request.getAttribute("listaMarca");
%>
<%
	Modelo modeloEditable = (Modelo) request.getAttribute("modeloEditable");
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
			<form action="ModeloController">
			<div class="card">
				<div class="header">
					<div class="row clearfix">
						<div class="col-xs-12 col-sm-6">
							<h2>Mantenimiento de Modelos de Vehiculos</h2>
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
							<input type="text" class="form-control" name="txtNombre" id="txtNombre" value="<%=modeloEditable.getNombre()%>">
						</div>
						<div class="col-sm-6">
							<label>Marca:</label> 
							<select class="form-control" name="idMar" id="idMar">
								<%
									if(modeloEditable.getMarca() != null) {
								%>
									<option value="<%=modeloEditable.getMarca().getId()%>"><%=modeloEditable.getMarca().getNombre()%></option>
								<%
									}
								%>
							
								<%
									for (Marca marca : listaMarca) {
								%>
								<option value="<%=marca.getId()%>"><%=marca.getNombre()%></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="col-sm-6">
							<label>Precio:</label> 
							<input type="text" class="form-control" name="txtPrecio" id="txtPrecio" value="<%=modeloEditable.getPrecio()%>">
						</div>
						<div class="col-sm-6"></br>
							<button class="btn bg-red btn-block btn-lg" type="submit">Grabar</button>
							<input type="hidden" value="<%= modeloEditable.getId() %>" name="idMod" />
							<input type="hidden" value="grabarModelo" name="accion" />
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
							<h2>Lista de Modelos de Vehiculo</h2>
						</div>
					</div>
				</div>
				<div class="body">
					<div class="table-responsive">
						<table class="table table-hover dashboard-task-infos">
							<thead>
								<tr>
									<th>Modelo</th>
									<th>Marca</th>
									<th>Precio Referencial</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Modelo modelo : listaModelo) {
								%>
								<tr>
									<td><%= modelo.getNombre() %></td>
									<td><%= modelo.getMarca().getNombre() %></td>
									<td><%= modelo.getPrecio() %></td>
									<td><a href="ModeloController?accion=editarModelo&idMod=<%= modelo.getId() %>"><i class="fas fa-edit"></i></a></td>
									<td><a href="ModeloController?accion=eliminarModelo&idMod=<%= modelo.getId() %>"><i class="fas fa-trash-alt"></i></a></td>
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