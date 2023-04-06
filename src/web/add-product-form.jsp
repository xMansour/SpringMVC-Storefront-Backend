<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Product</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1>Add New Product</h1>
    </div>
    <div id="container">
        <form:form method="post" action="${pageContext.request.contextPath}/product/saveNewProduct" modelAttribute="product">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                    <td><label>Name: </label></td>
                    <td><form:input path="name"/></td>

                    <td><label>Price</label></td>
                    <td><form:input path="price"/></td>


                    <td></td>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <br>
        <p>
            <a href="${pageContext.request.contextPath}/product/list">Back to List</a>
        </p>
    </div>
</div>
</body>
</html>