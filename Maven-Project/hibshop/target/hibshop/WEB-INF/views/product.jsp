<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.spring.hibshop.constant.*"%>

<%@page import="com.nagarro.spring.hibshop.dao.*"%>
<%
	//ProductDBOperationsImp dbOperation = new ProductDBOperationsImp();
%>

<%@page import="java.util.List"%>
<%
	//Object sessionUser=request.getAttribute("username");
%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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
<title>Page 1</title>
</head>
<body>
	<header class="header">
		<div class="row">
			<div class="col-md-9 text-center pt-md-3">
				<h2>TSHIRTS SHOP</h2>
			</div>
			<div class="col-md-3 text-end ">
				<form action="logout" method="get" onsubmit="store()">
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
				<form action="product" method="post" enctype="multipart/form-data">
					<%
						//request.setAttribute("sessionUser", sessionUser);
					%>
					<input type="hidden" name="username" id="username"
						value=<%=request.getParameter("username")%>>
					<div class="row mb-md-2">
						<div class="col">
							<label for="color" class="form-label">Color</label>
						</div>
						<div class="col">
							<input type="text" id="color" name="color" class="form-control"
								required> <span id="title-error"></span>
						</div>
					</div>


					<div class="row mb-md-2">
						<div class="col">
							<label for="size" class="form-label">Size</label>
						</div>
						<div class="col">
							<input type="number" id="size" name="size"
								class="form-control" required> <span id="quantity-error"></span>
						</div>
					</div>


					<div class="row mb-md-2">
						<div class="col">
							<label for="gender" class="form-label">Gender</label>
						</div>
						<div class="col">
							<input type="text" id="gender" name="gender" class="form-control"
								required> <span id="size-error"></span>
						</div>
					</div>

					<div class="row mb-md-3">
						<div class="col">
							<label for="preference" class="form-label">Output Preference</label>
						</div>
						<div class="col">
							<input type="text" name="preference" id="preference" class="form-control"
								accept="image/*" required> <span id="image-error"></span>
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
