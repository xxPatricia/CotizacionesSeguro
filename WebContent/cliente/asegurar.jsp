1	
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entidad.Marca"%>
<%@page import="entidad.TipoVehiculo"%>
<%@page import="entidad.Modelo"%>
<%@page import="entidad.Cotizacion"%>
<%@page import="entidad.Vehiculo"%>
<%@page import="entidad.VehiculoCotizacion"%>
<head>

<style type="text/css"></style>
</head>
<% VehiculoCotizacion vehiculoCotizacion = (VehiculoCotizacion) request.getAttribute("vehiculoCotizacion"); %>
<% List<Cotizacion> listadoCotizacion = (List<Cotizacion>) request.getAttribute("listadoCotizacion"); %>
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
								<h2>Datos del Cliente</h2>
							</div>
						</div>
					</div>
					<div class="body">
							<div class="row clearfix">
								<% if (mensaje != null) { %>
									<div class="col-12">
										<div id="myAlert" class="alert bg-green alert-dismissible"
											role="alert">
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<strong>Accion!</strong>
											<%=mensaje%>
										</div>
									</div>
								<%}%>
								<div class="col-sm-6">
									<label>Nombre:</label> 
									<input type="text" class="form-control" name="txtNombre" id="txtNombre"
									value="<%= clienteLogeado.getNombre()%>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Apellidos:</label> 
									<input type="text" class="form-control" name="txtApellido" id="txtApellido"
									value="<%= clienteLogeado.getApellidos() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Dni:</label> 
									<input type="text" class="form-control" name="txtDni" 
									value="<%= clienteLogeado.getDni() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Email:</label> 
									<input type="text" class="form-control" name="txtEmail" id="txtEmail"
									value="<%= clienteLogeado.getEmail() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Edad:</label> 
									<input type="text" class="form-control" name="txtEdad" id="txtEdad"
									value="<%= clienteLogeado.getEdad() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Telefono:</label> 
									<input type="text" class="form-control" name="txtTelefona" id="txtTelefona"
									value="<%= clienteLogeado.getTelefono() %>" readonly>
								</div>
							</div>
					</div>
				</div>
			</div>
			
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="card">
					<div class="header">
						<div class="row clearfix">
							<div class="col-xs-12 col-sm-6">
								<h2>Datos del Vehiculo</h2>
							</div>
						</div>
					</div>
					<div class="body">
							<div class="row clearfix">
								<div class="col-sm-6">
									<label>Matricula:</label> 
									<input type="text" class="form-control" name="txtNombre" id="txtNombre"
									value="<%= vehiculoCotizacion.getVehiculo().getMatricula() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Marca:</label> 
									<input type="text" class="form-control" name="txtNombre" id="txtNombre"
									value="<%= vehiculoCotizacion.getVehiculo().getModelo().getMarca().getNombre() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Modelo:</label> 
									<input type="text" class="form-control" name="txtApellido" id="txtApellido"
									value="<%= vehiculoCotizacion.getVehiculo().getModelo().getNombre() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Tipo:</label> 
									<input type="text" class="form-control" name="txtDni" 
									value="<%= vehiculoCotizacion.getVehiculo().getTipoVehiculo().getNombre() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Precio:</label> 
									<input type="text" class="form-control" name="txtEmail" id="txtEmail"
									value="<%= vehiculoCotizacion.getVehiculo().getPrecio() %>" readonly>
								</div>
							</div>
					</div>
				</div>
			</div>
			
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="card">
					<div class="header">
						<div class="row clearfix">
							<div class="col-xs-12 col-sm-6">
								<h2>Confirmar Seguro</h2>
							</div>
						</div>
					</div>
					<div class="body">
							<div class="row clearfix">
							<form action="AsegurarController">
								<div class="col-sm-6">
									<label>Seguro:</label> 
									<select class="form-control" name="idCot" id="idCot">
										<option value="<%=vehiculoCotizacion.getCotizacion().getId()%>">
										<%= vehiculoCotizacion.getCotizacion().getSeguradora().getNombre() %> - <%= vehiculoCotizacion.getCotizacion().getPrecio() %>
										</option>
										<% for (Cotizacion cotizacion : listadoCotizacion) { %>
										<option value="<%=cotizacion.getId()%>">
										<%= cotizacion.getSeguradora().getNombre() %> - <%= cotizacion.getPrecio() %>
										</option>
										<% } %>
									</select>
								</div>
								<div class="col-sm-6">
									<label>Prima Total:</label> 
									<input type="text" class="form-control" name="txtPrecio" id="txtPrecio"
									value="<%= vehiculoCotizacion.getCotizacion().getPrecio() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Forma de Pago:</label> 
									<select class="form-control" name="formaPago" id="formaPago">
										<option value="Contado">Contado</option>
										<option value="3 Cuotas de <%= (vehiculoCotizacion.getCotizacion().getPrecio())/3 %>">3 Cuotas de <%= (vehiculoCotizacion.getCotizacion().getPrecio())/3 %></option>
										<option value="6 Cuotas de <%= (vehiculoCotizacion.getCotizacion().getPrecio())/6 %>">6 Cuotas de <%= (vehiculoCotizacion.getCotizacion().getPrecio())/6 %></option>
										<option value="12 Cuotas de <%= (vehiculoCotizacion.getCotizacion().getPrecio())/12 %>">12 Cuotas <%= (vehiculoCotizacion.getCotizacion().getPrecio())/12 %></option>
									</select>
								</div>
								<div class="col-sm-6">
									<label>Medio de Pago:</label> 
									<select class="form-control" name="medioPago" id="medioPago">
										<option value="Cuenta Corriente">Cuenta Corriente</option>
										<option value="Tarjeta Visa">Tarjeta Visa</option>
										<option value="Tarjeta Master Card">Tarjeta Master Card</option>
									</select>
								</div>
								<div class="col-sm-6">
									<label>Dia de Pago:</label> 
									<input type="number" class="form-control" name="diaPago" id="diaPago" value="1" max="28" min="1" readonly/>
								</div>
								<div class="col-sm-12">
									<button class="btn bg-red btn-block btn-lg waves-effect" type="submit" value="Contratar Seguro">Contratar Seguro</button>
									<input type="hidden" value="contratarSeguro" name="accion" />
									<input type="hidden" value="<%= vehiculoCotizacion.getVehiculo().getId() %>" name="txtIdVeh" />
									<input type="hidden" value="1" name="cuotaPago" id="cuotaPago" />
								</div>
							</form>
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

<%@include file="../template/pie.jsp"%>
