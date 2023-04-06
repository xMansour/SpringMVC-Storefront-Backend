<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Products</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1>Products</h1>
    </div>
    <div id="container">
        <input type="button" value="Add Product" onclick="window.location.href='showFormForAdd'; return false;">
        <form:form action="${pageContext.request.contextPath}/product/searchForProduct" method="get">
            <label>Search for a Product</label>
            <input type="text" name="productName">
            <input type="submit" value="Search">
        </form:form>

        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Action</th>
            </tr>

            <c:forEach var="product" items="${products}">
                <c:url var="updateLink" value="${pageContext.request.contextPath}/product/showFormForUpdate">
                    <c:param name="productId" value="${product.id}"/>
                </c:url>
                <c:url var="deleteLink" value="${pageContext.request.contextPath}/product/deleteProduct">
                    <c:param name="productId" value="${product.id}"/>
                </c:url>


                <tr>

                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td><a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure to delete this product?'))) return false">Delete</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>