<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customers</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1>Customers</h1>
    </div>
    <div id="container">
        <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;">
        <form:form action="searchForCustomer" method="get">
            <label>Search for a Customer: </label>
            <input type="text" name="userName"/>
            <input type="submit" value="Search"/>
        </form:form>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Birth Day</th>
                <th>Sex</th>
                <th>Action</th>
            </tr>

            <c:forEach var="user" items="${users}">
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/customer/deleteUser">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>

                <td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td>${customer.birthDay}</td>
                <td>${customer.sex}</td>
                <td><a href="${updateLink}">Update</a>
                    |
                    <a href="${deleteLink}"
                       onclick="if(!(confirm('Are you sure to delete this customer?'))) return false">Delete</a>
                </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>