1	
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entidad.Marca"%>
<%@page import="entidad.TipoVehiculo"%>
<%@page import="entidad.Modelo"%>
<%@page import="entidad.Cotizacion"%>
<%@page import="entidad.Vehiculo"%>
<head>

<style type="text/css"></style>
</head>
<% List<Marca> listaMarca = (List<Marca>) request.getAttribute("listaMarca"); %>
<% List<TipoVehiculo> listaTipoVehiculo = (List<TipoVehiculo>) request.getAttribute("listaTipoVehiculo"); %>
<% List<Modelo> listaModelo = (List<Modelo>) request.getAttribute("listaModelo"); %>
<% Vehiculo vehiculo = (Vehiculo) request.getAttribute("vehiculo"); %>
<% List<Cotizacion> listadoCotizacion = (List<Cotizacion>) request.getAttribute("listadoCotizacion"); %>
<% String precio = String.valueOf(request.getAttribute("precio")); %>
<% String mensaje = (String) request.getAttribute("mensaje");%>

<%@include file="../template/cabeceraCliente.jsp"%>

<section class="content">
	<div class="container-fluid">
		<div class="block-header">
			<h2>Seguro Simple</h2>
		</div>
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
						<form action="CotizacionController">
							<div class="row clearfix">
								<%
									if (mensaje != null) {
								%>
								<div class="row">
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
								</div>
								<%}%>
								<div class="col-sm-6">
									<center>
										<h5>DATOS DE VEHÍCULO</h5>
									</center>
									<label>Marca:</label> 
									<select class="form-control" name="idMar"id="idMar">
										
										<% for (Marca marca : listaMarca) { %>
										<option value="<%=marca.getId()%>"><%=marca.getNombre()%></option>
										<% } %>
									</select>
								</div>

								<center>
									<h5>DATOS DE CONDUCTOR</h5>
								</center>

								<div class="col-sm-6">
									<label>Nombre:</label> <input type="text" class="form-control"
										name="txtNombre" id="txtNombre"
										value="<%= clienteLogeado.getNombre()%>" readonly>
								</div>


								<div class="col-sm-6">
									<label>Modelo:</label> <select class="form-control"
										name="idMod" id="idMod">
										<% for (Modelo modelo : listaModelo) { %>
										<option value="<%=modelo.getId()%>"><%=modelo.getNombre()%></option>
										<% } %>
									</select>
								</div>

								<div class="col-sm-6">
									<label>Apellidos:</label> <input type="text"
										class="form-control" name="txtApellido" id="txtApellido"
										value="<%= clienteLogeado.getApellidos() %>" readonly>
								</div>

								<div class="col-sm-6">
									<label>Tipo de Vehiculo:</label> <select class="form-control"
										name="idTip" id="idTip">
										<% for (TipoVehiculo tipoVehiculo : listaTipoVehiculo) { %>
										<option value="<%=tipoVehiculo.getId()%>"><%=tipoVehiculo.getNombre()%></option>
										<% } %>
									</select>
								</div>
								<div class="col-sm-6">
									<label>Dni:</label> <input type="text" class="form-control"
										name="txtDni" value="<%= clienteLogeado.getDni() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Año de Fabricacion:</label> <select class="form-control"
										name="txtFecha" id="txtFecha">
										<option value="">[Seleccionar]</option>
										<option value="2018-Nuevo">2018-Nuevo</option>
										<option value="2018-Usado">2018-Usado</option>
										<option value="2017-Nuevo">2017-Nuevo</option>
										<option value="2017-Usado">2017-Usado</option>
										<option value="2016">2016</option>
										<option value="2015">2015</option>
										<option value="2014">2014</option>
										<option value="2013">2013</option>
										<option value="2012">2012</option>
										<option value="2011">2011</option>
										<option value="2010">2010</option>
										<option value="2009">2009</option>
										<option value="2008">2008</option>
										<option value="2007">2007</option>
										<option value="2006">2006</option>
										<option value="2005">2005</option>
										<option value="2004">2004</option>
										<option value="2003">2003</option>
										<option value="2002">2002</option>
										<option value="2001">2001</option>
										<option value="2000">2000</option>
									</select>
								</div>
								<div class="col-sm-6">
									<label>Email:</label> <input type="text" class="form-control"
										name="txtEmail" id="txtEmail"
										value="<%= clienteLogeado.getEmail() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Precio de Compra:</label> <input type="number"
										class="form-control" name="txtPrecio" id="txtPrecio"
										min="1000" max="5000" rel="tooltip"
										 required="required" value="5000" step="50"/>

								</div>
								<div class="col-sm-6">
									<label>Edad:</label> <input type="text" class="form-control"
										name="txtEdad" id="txtEdad"
										value="<%= clienteLogeado.getEdad() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Matricula:</label> <input type="text"
										class="form-control" name="txtMatricula"
										placeholder="Matricula" required="required"></input>
								</div>

								<div class="col-sm-6">
									<label>Telefono:</label> <input type="text"
										class="form-control" name="txtTelefona" id="txtTelefona"
										value="<%= clienteLogeado.getTelefono() %>" readonly>
								</div>
								<div class="col-sm-6">
									<label>Convertido a Gas:</label> <select class="form-control"
										name="txtConvertidor" id="txtConvertidor"
										onchange="habilitar(this.value);">
										<option value="">[Seleccionar]</option>
										<option value="Si">Si</option>
										<option value="No">No</option>
									</select>
								</div>

							</div>
							<div class="row clearfix">
							<div class="col-sm-6">
								<button class="btn bg-red btn-block btn-lg waves-effect" type="submit" value="Cotizar Seguros">Encuentra tu seguro vehicular</button>
								<input type="hidden" value="cotizar" name="accion" />
							</div>
								
							</div>
						</form>
						
						<% if (listadoCotizacion != null) { %>
						<div class="row clearfix">
							<% for (Cotizacion cotizacion : listadoCotizacion) {%>
							<div class="col-sm-6">
								<div class="info-box bg-orange" style="height: 160px;">
                        			<form action="AsegurarController"><!-- ////////////////////////////// -->
                        			<div class="icon">
                            			<i class="material-icons">person_add</i>
                        			</div>
                        			<div class="content">
                            			<div class="text">
                            				<h3><%= cotizacion.getSeguradora().getNombre() %></h3>
                            				<%= cotizacion.getTipoVehiculo().getNombre() %> 
                            				<%= cotizacion.getModelo().getMarca().getNombre() %> modelo
                            				<%= cotizacion.getModelo().getNombre() %> 
                            				<h4><%= cotizacion.getPrecio()%></h4>
                            				<input type="hidden" value="<%= cotizacion.getId() %>" name="txtIdCot" />
                            				<input type="hidden" value="<%= vehiculo.getId() %>" name="txtIdVeh" />
                            				<input type="hidden" value="prepararAsegurar" name="accion" />
                            				<button class="btn bg-red btn-block btn-sm waves-effect" type="submit" value="Cotizar Seguros">Asegurar</button>
                            			</div>
                            		</div>
                            		</form><!-- ////////////////////////////////////////////////////////// -->
                    			</div>
							</div>
							<!--</form>-->
							<% } %>
						</div>
						<% } %>
						
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
