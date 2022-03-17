<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
      <head>
    <meta charset="utf-8">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet"
	     href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	     integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	     crossorigin="anonymous">
         </head>
         <body>
       	<div class="container">
		<h1 class="bg-info text-white" style="text-align: center">Customer
			Relationship Management</h1>
		<hr />

		<h2>
			<a href="/crmapp/customers/new"
				class="btn btn-primary btn-sm float-end">Add a customer</a>
		</h2>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers}" var="customer">
					<tr>
						<td><c:out value="${customer.firstname}" /></td>
						<td><c:out value="${customer.lastname}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td><a href="/crmapp/customers/edit?id=${customer.id}"
							class="btn btn-info btn-sm"> Update </a> <a
							href="/crmapp/customers/delete?id=${customer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete customer ${customer.firstname} ${customer.lastname} ?'))) return false">
							Delete </a></td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>