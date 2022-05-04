<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda Web</title>


<!-- folhas de estilo CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

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

					<form>

						<div class="mb-3">
							<label>Email de Acesso:</label> <input type="text"
								class="form-control" placeholder="Digite seu email" />
						</div>
						<div class="mb-3">
							<label>Senha de Acesso:</label> <input type="password"
								class="form-control" placeholder="Digite sua senha" />
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

					</form>

				</div>
			</div>

		</div>
	</div>

	<!-- arquivos de extensão javascript-->
	<script src="resources/js/bootstrap.min.js"></script>


</body>
</html>