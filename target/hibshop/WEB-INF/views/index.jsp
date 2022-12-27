<%@page import="com.nagarro.spring.hibshop.constant.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="<%=Constants.URL %>resources/stylesheet.css"
	type="text/css">
<title>Login</title>
</head>
<body>
	<div class="background">
		<div class="border">
			<form action="authentication" method="post">
				<div class="row form-header-footer text-lg-start form-header-text">
					<h2>Login</h2>
				</div>
				<div class="row form-body p-md-4">
					<div class="row mb-3 mt-3">
						<div class="col">
							<label for="username" class="form-label">User Name:</label>
						</div>
						<div class="col">
							<!-- <span>*</span> -->
							<input id="username" class="form-control" type="text"
								name="username" placeholder="User Name" required>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col">
							<label for="password" class="form-label">Password:</label>
						</div>
						<div class="col">
							<!-- <span>*</span> -->
							<input type="password" class="form-control" name="password"
								id="password" placeholder="Password" required>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col"></div>
						<div class="col">
							<a href="reset.jsp">Forgotten your password?</a>
						</div>
					</div>
				</div>
				<div class="row form-header-footer p-2">
					<div class="col text-end">
						<input type="submit" class="button" name="login" id="login"
							value="Login >>">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
