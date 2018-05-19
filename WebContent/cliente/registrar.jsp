1	
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entidad.Marca"%>
<%@page import="entidad.TipoVehiculo"%>
<%@page import="entidad.Modelo"%>
<%@page import="entidad.Cotizacion"%>
<head>

<style type="text/css"></style>
</head>
<% List<Marca> listaMarca = (List<Marca>) request.getAttribute("listaMarca"); %>
<% List<TipoVehiculo> listaTipoVehiculo = (List<TipoVehiculo>) request.getAttribute("listaTipoVehiculo"); %>
<% List<Modelo> listaModelo = (List<Modelo>) request.getAttribute("listaModelo"); %>
<% List<Cotizacion> listadoCotizacion = (List<Cotizacion>) request.getAttribute("listadoCotizacion"); %>
<% String precio = String.valueOf(request.getAttribute("precio")); %>
<% String mensaje = (String) request.getAttribute("mensaje");%>

<%@include file="../template/cabeceraCliente.jsp"%>

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
								<h2>Cotizaciòn de Seguro vehicular</h2>
							</div>
						</div>
					</div>
					<div class="body">
						
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

<%@include file="../template/pie.jsp"%>
