<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="container">
                <div class="mt-4">
            <table class="table table-hover m-auto" >
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td><a href="delete?id=${product.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
           <button class="btn btn-success"> <a type="submit"  href="add"  style="text-decoration: none;color: white">Add Product</a></button>

        </div>
            </div>
        </div>
    </div>
</body>
</html>