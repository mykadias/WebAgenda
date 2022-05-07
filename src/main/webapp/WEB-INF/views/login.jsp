<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Google Agenda</title>


<!-- folhas de estilo CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<!-- estilos para o jquery validation -->
<style>
	label.error { color: red; }
	input.error { border: 2px solid red}
</style>

</head>
<body class="bg-secondary">

	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">

			<div class="card">
				<div class="card-body">

					<div class="text-center">
						<img
							src="https://www.gstatic.com/images/branding/product/1x/hh_calendar_64dp.png"
							class="img-fluid" />
						<h3>Google Agenda</h3>
						<p>Agenda online para desenvolvedores<p>
					</div>

					<hr />

					<form id="formLogin" action="login-user" method="post">

						<div class="mb-3">
							<label>Email de Acesso:</label> <form:input path="model.email" type="text"
								class="form-control" id="email" name="email" placeholder="Digite seu email" />
						</div>
						<div class="mb-3">
							<label>Senha de Acesso:</label> <form:input path="model.senha" type="password"
								class="form-control" id="senha" name="senha" placeholder="Digite sua senha" />
								<div class="text-end">
									<a href="/webagenda/password">
									Esqueci minha senha
									</a>
								
								</div>
						</div>

						<div class="mb-3">
							<div class="d-grid">
								<input type="submit" value="Acessar Agenda"
									class="btn btn-primary" />
							</div>
						</div>
						<div class="mb-3">
							<div class="d-grid">
								<a href="/webagenda/register" class="btn btn-light">
									Ainda não possui conta? <strong>Cadastre-se aqui!</strong>
								</a>
							</div>
						</div>
						
						<div class="mb-3">
							<div class="text-center">
							<strong class="text-danger">
								${mensagem_erro} 
							</strong>
							
							</div>
						</div>

					</form>

				</div>
			</div>

		</div>
	</div>

	<!-- arquivos de extensão javascript-->
	<script src="resources/js/bootstrap.min.js"></script>
	
		
	<!-- biblioteca do jquery -->
	<script src="resources/js/jquery-3.6.0.min.js"></script>
	
	<!-- biblioteca do jquery validation-->
	<script src="resources/js/jquery.validate.min.js"></script>	
	<script src="resources/js/additional-methods.min.js"></script>	
	<script src="resources/js/messages_pt_BR.min.js"></script>	
	
	<script>
	
	//função para inicializar ao código JavaScript (JQuery)
	$(document).ready(function(){
		
		$("#formLogin").validate({
			rules : {
				'email' : { required : true, email : true },
				'senha' : { required : true, minlength : 8, maxlength : 20, pwcheck: true }
			},
			messages : {
				senha : { pwcheck : 'Informe pelo menos 1 letra maiúscula, 1 letra minúscula e 1 digito numérico.' }
			}
		});
		
		//validação customizada para campo senha forte
		$.validator.addMethod('pwcheck', function(value, element){
			return /^[A-Za-z0-9]+$/.test(value)
		})
		
	});
	
	</script>


</body>
</html>