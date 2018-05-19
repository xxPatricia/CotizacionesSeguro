	
	
	<!-- Jquery Core Js -->
    <script src="css/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="css/bootstrap/js/bootstrap.js"></script>

    <!-- Select Plugin Js -->

    <!-- Slimscroll Plugin Js -->
    <script src="css/jquery-slimscroll/jquery.slimscroll.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="css/node-waves/waves.js"></script>

    <!-- Jquery CountTo Plugin Js -->
    <script src="css/jquery-countto/jquery.countTo.js"></script>

    <!-- Morris Plugin Js -->
    <script src="css/raphael/raphael.min.js"></script>
    <script src="css/morrisjs/morris.js"></script>
    
    <!-- ChartJs -->
    <script src="css/chartjs/Chart.bundle.js"></script>

    <!-- Flot Charts Plugin Js -->
    <script src="css/flot-charts/jquery.flot.js"></script>
    <script src="css/flot-charts/jquery.flot.resize.js"></script>
    <script src="css/flot-charts/jquery.flot.pie.js"></script>
    <script src="css/flot-charts/jquery.flot.categories.js"></script>
    <script src="css/flot-charts/jquery.flot.time.js"></script>

    <!-- Sparkline Chart Plugin Js -->
    <script src="css/jquery-sparkline/jquery.sparkline.js"></script>

    <!-- Custom Js -->
    <script src="js/admin.js"></script>
    <script src="js/pages/index.js"></script>
    <script src="js/pages/forms/basic-form-elements.js"></script>

    <!-- Demo Js -->
    <script src="../js/demo.js"></script>
    
	<script src="assets/js/jquery-2.1.4.min.js"></script>


	
	<script type="text/javascript">
	$(document).ready(function () {
        $('#idMar').change(function (event) {
            var IdMar2 = document.getElementById('idMar').value;
            // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
            $.post('ComboboxAjaxAction', {
            	IdMar: IdMar2
            }, function (responseText) {
                $('#idMod').html(responseText);
                //document.getElementById('txtPrecio').value = "10000";
               // document.getElementById('txtPrecio').max = "11000";
                //document.getElementById('txtPrecio').min = "9000";
            });
        });
        $("#txtPrecio").keypress(function (evt) {
            evt.preventDefault();
        });
        
        $('#idMod').change(function (event) {
            var idMod2 = document.getElementById('idMod').value;
             //Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
            $.post('ComboboxAjaxAction2', {
            	IdMod: idMod2
            }, function (responseText) {
            	document.getElementById('txtPrecio').value = responseText-1+1;
            	document.getElementById('txtPrecio').max = responseText - 1 + 1001;
            	document.getElementById('txtPrecio').min = responseText - 1000;
            });
        });
        
        $('#idMar').change(function (event) {
            var idMod2 = document.getElementById('idMod').value;
             //Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
            $.post('ComboboxAjaxAction2', {
            	IdMod: idMod2
            }, function (responseText) {
            	document.getElementById('txtPrecio').value = responseText-1+1;
            	document.getElementById('txtPrecio').max = responseText - 1 + 1001;
            	document.getElementById('txtPrecio').min = responseText - 1000;
            });
        });
        
        $('#idCot').change(function (event) {
            var idCot2 = document.getElementById('idCot').value;
             //Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
            $.post('ComboboxAjaxCotizacionAction', {
            	IdCot: idCot2
            }, function (responseText) {
            	document.getElementById('txtPrecio').value = responseText-1+1;
            });
        });
        
        $('#idCot').change(function (event) {
            var idCot2 = document.getElementById('idCot').value;
            //Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
            $.post('ComboboxAjaxFormaPagoAction', {
            	IdCot: idCot2, accion:'obtenerPrecio'
            }, function (responseText) {
            	$("#formaPago").html(responseText);
            });
        });
        $('#formaPago').change(function (event) {
            var index = $('#formaPago').prop('selectedIndex');
            //Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
            if(index == 0){
            	document.getElementById('cuotaPago').value = '1';
            } else if(index == 1){
            	document.getElementById('cuotaPago').value = '3';
            } else if(index == 2){
            	document.getElementById('cuotaPago').value = '6';
            } else if(index == 3){
            	document.getElementById('cuotaPago').value = '12';
            }
            
        });
        
        
    });
	</script>
</body>

</html>>