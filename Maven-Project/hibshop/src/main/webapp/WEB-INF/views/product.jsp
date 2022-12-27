<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.spring.hibshop.constant.*"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Add icon library -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="<%=Constants.URL%>resources/stylesheet.css"
	type="text/css">
<title>SEARCH TSHIRTS</title>
</head>
<body>
	<header class="header">
		<div class="row">
			<div class="col-md-9 text-center pt-md-3">
				<h2>TSHIRTS SHOP</h2>
			</div>
			<div class="col-md-3 text-end ">
				<form action="logout" method="get">
					Hi
					<%=request.getParameter("username")%>
					<input type="submit" value="Logout"
						class="btn btn-outline-secondary">
				</form>
			</div>
		</div>
	</header>
	<section>
		<div class="row p-md-5 form">
			<div class="col-12 form-header">
				<h4>ENTER YOUR CHOICE</h4>
			</div>
			<div class="col-12  p-3 form-body">
				<form action="search" method="post">
					<%
						//request.setAttribute("sessionUser", sessionUser);
					%>
					<input type="hidden" name="username" id="username"
						value=<%=request.getParameter("username")%> >
					<div class="row mb-md-2">
						<div class="col">
							<label for="color" class="form-label">Color</label>
						</div>
						<div class="col">
							<input type="text" id="color" name="color" class="form-control"
								required> 
						</div>
					</div>


					<div class="row mb-md-2">
						<div class="col">
							<label for="size" class="form-label">Size</label>
						</div>
						<div class="col">
							<!--<input type="text" id="size" name="size"
								class="form-control" required> <span id="quantity-error"></span>-->
							<select name="size" id="size" class="form-select" required>
							     <option value="S" selected="selected">Small</option>
							     <option value="M">Medium</option>
							     <option value="L">Large</option>
							     <option value="XL">Extra Large</option>
							     <option value="XXL">Double XL</option>
							</select>
						</div>
					</div>


					<div class="row mb-md-2">
						<div class="col">
							<label for="gender" class="form-label">Gender</label>
						</div>
						<div class="col">
							<!-- <input type="text" id="gender" name="gender" class="form-control"
								required> <span id="size-error"></span>-->
							<select name="gender" id="gender" class="form-select" required>
							     <option value="M" selected="selected">Male</option>
							     <option value="F">Female</option>
							     <option value="U">Unisex</option>
							</select>
						</div>
					</div>

					<div class="row mb-md-3">
						<div class="col">
							<label for="preference" class="form-label">Output Preference</label>
						</div>
						<div class="col">
							<!-- <input type="number" name="preference" id="preference" class="form-control"
								accept="image/*" required> <span id="image-error"></span>-->
							<select name="preference" id="preference" class="form-select" required>
							     <option value="1" selected="selected">Price</option>
							     <option value="2">Rating</option>
							     <option value="3">Price & Rating</option>
							</select>
						</div>
					</div>

					<div class="row">
						<div class="col-12 form-header py-2">
							<input type="submit" value="Submit>>"
								class="btn btn-outline-secondary"> <input type="reset"
								value="Reset>>" class="btn btn-outline-secondary">
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>
