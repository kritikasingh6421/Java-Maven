<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.spring.hibshop.constant.*"%>
<%@page import="com.nagarro.spring.hibshop.pojo.*"%>
<%@page import="com.nagarro.spring.hibshop.service.*"%>
<%
	SpringShopHibOperationsImp shop = new SpringShopHibOperationsImp();
%>

<%@page import="java.util.List"%>
<%
	//Object sessionUser=request.getAttribute("username");
%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>TSHIRTS List</title>
</head>
<body>
<body>
	<header class="header">
		<div class="row">
			<div class="col-md-9 text-center pt-md-3">
				<h2>TSHIRTS OF YOUR CHOICE</h2>
			</div>
			<div class="col-md-3 text-end ">
				<form action="back" method="get">
				<input type="hidden" name="username" id="username"
						value=<%=request.getParameter("username")%> >
					Hi
					<%=request.getParameter("username")%>
					<input type="submit" value="Back To Search"
						class="btn btn-outline-secondary">
				</form>
			</div>
		</div>
	</header>
	<section>
		<div class="row">
			<div class="col table table-responsive-md">
				<table style="width: 100%;" id="product-details">
					<thead>
						<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>COLOR</th>
							<th>GENDER</th>
							<th>PRICE</th>
							<th>RATING</th>
							<th>AVAILABILITY</th>
						</tr>
					</thead>
					<%
						List<TShirts> tshirts = shop.getPreferedTShirts();
						for (TShirts t : tshirts) {
					%>
						<tr>
							<td><%=t.getId()%></td>
							<td><%=t.getName()%></td>
							<td><%=t.getColor() %></td>
							<td><%=t.getGender() %></td>
							<td><%=t.getPrice() %></td>
							<td><%=t.getRating() %></td>
							<td><%=t.getAvailability() %></td>
						</tr>
					<%
					}
					%>
				</table>
			</div>
		</div>
	</section>
</body>
</html>