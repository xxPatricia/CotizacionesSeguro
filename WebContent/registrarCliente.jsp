<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Sign In | Bootstrap Based Admin Template - Material
	Design</title>
<!-- Favicon-->
<link rel="icon" href="../../favicon.ico" type="image/x-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" type="text/css">

<!-- Bootstrap Core Css -->
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Waves Effect Css -->
<link href="css/node-waves/waves.css" rel="stylesheet" />

<!-- Animation Css -->
<link href="css/animate-css/animate.css" rel="stylesheet" />

<!-- Custom Css -->
<link href="css/style.css" rel="stylesheet">
</head>
<% String mensaje = (String) request.getAttribute("mensaje");%>
<body class="login-page">
	<div class="login-box">
		<div class="logo">
			<a href="javascript:void(0);">Seguro Simple</a> <small>Sistema
				de Cotizacion de Autos</small>
		</div>
		<div class="card">
			<div class="body">
				<%
					if (mensaje != null) {
				%>
				<div class="row">
					<div class="col-12">
						  <div id="myAlert"class="alert bg-green alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <strong>Accion!</strong>
							<%=mensaje%>
                           </div>
					</div>
				</div>
				<%
					}
				%>
				<form id="sign_in" method="POST" action="ClienteController">
					<div class="body">

						<div class="row clearfix">

							<div class="col-sm-6">
								<label>Nombre:</label> 
								<input type="text" class="form-control" name="txtNombre" id="txtNombre   required="required"/>
								<div class="help-info">Min:3 Car, Max: 10car</div>
							</div>
							<div class="col-sm-6">

								<label>Apellido:</label> 
								<input type="text" class="form-control" name="txtApellido" id="txtApellido"   required="required"  />
									<div class="help-info">Min:3 Car, Max: 10car</div>
							</div>
							<div class="col-sm-6">
								<label>Direccion:</label> 
								<input type="text" class="form-control" name="txtDireccion" id="txtDireccion"   required="required"  />
								<div class="help-info">Min:3Car,Max:50car</div>
							</div>
							<div class="col-sm-6">
								<label>Edad:</label> 
								<input type="number" class="form-control" name="txtEdad" id="txtEdad"required="required"  />
							    <div class="help-info">Min:18,Max:60</div>
							</div>
							<div class="col-sm-6">
								<label>Telefono:</label> <input type="text" class="form-control"
									name="txtTelefono" id="txtTelefono" required="required" />
									<div class="help-info">7 digitos</div>
									
							</div>
							<div class="col-sm-6">
								<label>Email:</label> <input type="email" class="form-control"
									name="txtEmail" id="txtEmail" required="required" />
									<div class="help-info">Ex:ab@hotmail.com</div>
									
							</div>
							<div class="col-sm-6">
								<label>Dni:</label>                                         
								<input type="text" class="form-control" name="txtDni" id="txtDni"  required/>
									<div class="help-info">9 digitos</div>
							</div>
							<div class="col-sm-6">
								<label>Usuario:</label> 
								<input type="text" class="form-control" name="txtNombreUsu" id="txtNombreUsu"  required="required"  />
								<div class="help-info">Min:3Car,Max:50car</div>
							</div>
							<div class="col-sm-6">
								<center></center>
								<label>Contrasena:</label> 
								<input type="text" class="form-control"name="txtClaveUsu" id="txtClaveUsu" required="required" />
								<div class="help-info">Min:3Car,Max:50car</div>
							</div>
							  
                                   
                            
						</div>
						<div class="row clearfix">
							<div class="col-sm-12">
								<input type="submit" class="btn bg-red btn-block btn-lg waves-effect" value="Registrar"/>
            					<input type="hidden" name="txtAccion" value="registrar">
								
							</div>
							<div class="col-sm-12">
								<input type="submit" class="btn bg-red btn-block btn-lg waves-effect" onclick="location.href='login.jsp';"value="Ir Login"/>
								
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Jquery Core Js -->
	<script src="css/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script src="css/bootstrap/js/bootstrap.js"></script>

	<!-- Waves Effect Plugin Js -->
	<script src="css/node-waves/waves.js"></script>

	<!-- Validation Plugin Js -->
	<script src="css/jquery-validation/jquery.validate.js"></script>

	<!-- Custom Js -->
	<script src="js/admin.js"></script>
	<script src="js/pages/examples/sign-in.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	    // show the alert
	    setTimeout(function() {
	        $("#myAlert").alert('close');
	    }, 5000);
	});
	</script>
	<script type="text/javascript">
	
	<script>
	function soloLetras(e) {
	    key = e.keyCode || e.which;
	    tecla = String.fromCharCode(key).toLowerCase();
	    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
	    especiales = [8, 37, 39, 46];

	    tecla_especial = false
	    for(var i in especiales) {
	        if(key == especiales[i]) {
	            tecla_especial = true;
	            break;
	        }
	    }

	    if(letras.indexOf(tecla) == -1 && !tecla_especial)
	        return false;
	}

	function limpia() {
	    var val = document.getElementById("miInput").value;
	    var tam = val.length;
	    for(i = 0; i < tam; i++) {
	        if(!isNaN(val[i]))
	            document.getElementById("miInput").value = '';
	    }
	}
	</script>
	</script>
</body>

</html>