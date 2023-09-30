<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add new Product</title>
   <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form  method="post" id="add">
        <div class="mb-3">
            <label for="name" class="form-label">name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>

        <div class="mb-3">
            <label for="price" class="form-label">price</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>
        <button type="submit" class="btn btn-primary" formaction="products?action=save">save</button>


    </form>
<script src="js/bootstrap.js"></script>
</div>
</body>
</html>
