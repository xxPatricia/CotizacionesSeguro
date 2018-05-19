<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Administrador"%>
<%@page import="entidad.Modelo"%>
<%@page import="entidad.Marca"%>
<%@page import="entidad.Seguradora"%>
<%@page import="entidad.TipoVehiculo"%>
<%@page import="entidad.Cotizacion"%>

<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	List<Cotizacion> listaCotizacion = (List<Cotizacion>) request.getAttribute("listaCotizacion");
%>
<%
	List<Modelo> listaModelo = (List<Modelo>) request.getAttribute("listaModelo");
%>
<%
	List<Seguradora> listaSeguradora = (List<Seguradora>) request.getAttribute("listaSeguradora");
%>
<%
	List<TipoVehiculo> listaTipoVehiculo = (List<TipoVehiculo>) request.getAttribute("listaTipoVehiculo");
%>
<%
	Cotizacion cotizacionEditable = (Cotizacion) request.getAttribute("cotizacionEditable");
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
			<form action="CotizacionController">
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
							<label>Modelo y Marca:</label> 
							<select class="form-control" name="idMod" id="idMod">
								<%
									if(cotizacionEditable.getModelo() != null) {
								%>
									<option value="<%=cotizacionEditable.getModelo().getId()%>"><%=cotizacionEditable.getModelo().getNombre()%> - <%=cotizacionEditable.getModelo().getMarca().getNombre()%></option>
								<%
									}
								%>
							
								<%
									for (Modelo modelo : listaModelo) {
								%>
									<option value="<%=modelo.getId()%>"><%= modelo.getNombre()%> - <%= modelo.getMarca().getNombre() %></option>
								<%
									}
								%>
							</select>
						</div>
						
						<div class="col-sm-6">
							<label>Tipo de Vehiculo:</label> 
							<select class="form-control" name="idTip" id="idTip">
								<%
									if(cotizacionEditable.getTipoVehiculo() != null) {
								%>
									<option value="<%=cotizacionEditable.getTipoVehiculo().getId()%>"><%=cotizacionEditable.getTipoVehiculo().getNombre()%></option>
								<%
									}
								%>
							
								<%
									for (TipoVehiculo tipoVehiculo : listaTipoVehiculo) {
								%>
									<option value="<%=tipoVehiculo.getId()%>"><%=tipoVehiculo.getNombre()%></option>
								<%
									}
								%>
							</select>
						</div>
						
						<div class="col-sm-6">
							<label>Seguradora:</label> 
							<select class="form-control" name="idSeg" id="idSeg">
								<%
									if(cotizacionEditable.getSeguradora() != null) {
								%>
									<option value="<%=cotizacionEditable.getSeguradora().getId()%>"><%=cotizacionEditable.getSeguradora().getNombre()%></option>
								<%
									}
								%>
							
								<%
									for (Seguradora seguradora : listaSeguradora) {
								%>
									<option value="<%=seguradora.getId()%>"><%=seguradora.getNombre()%></option>
								<%
									}
								%>
							</select>
						</div>
						
						<div class="col-sm-6">
							<label>Precio de Cotización:</label> 
							<input type="text" class="form-control" name="txtPrecio" id="txtPrecio" value="<%=cotizacionEditable.getPrecio()%>">
						</div>
						<div class="col-sm-6"></br>
							<button class="btn bg-red btn-block btn-lg" type="submit">Grabar</button>
							<input type="hidden" value="<%= cotizacionEditable.getId() %>" name="idCot" />
							<input type="hidden" value="grabarCotizacion" name="accion" />
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
							<h2>Lista de Cotizacion</h2>
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
									<th>Tipo de Vehiculo</th>
									<th>Seguradora</th>
									<th>Precio</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Cotizacion cotizacion : listaCotizacion) {
								%>
								<tr>
									<td><%= cotizacion.getModelo().getNombre()%></td>
									<td><%= cotizacion.getModelo().getMarca().getNombre() %></td><!--  error  -->
									<td><%= cotizacion.getTipoVehiculo().getNombre() %></td>
									<td><%= cotizacion.getSeguradora().getNombre() %></td>
									<td><%= cotizacion.getPrecio() %></td>
									<td><a href="CotizacionController?accion=editarCotizacion&idCot=<%= cotizacion.getId() %>"><i class="fas fa-edit"></i></a></td>
									<td><a href="CotizacionController?accion=eliminarCotizacion&idCot=<%= cotizacion.getId() %>"><i class="fas fa-trash-alt"></i></a></td>
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