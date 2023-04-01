<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Customer</title>
</head>
<body>

<div class="wrapper">
    <div class="header">
        <h1>Add New Customer</h1>
    </div>
    <div class="container">
        <form:form method="post" action="saveNewCustomer" modelAttribute="customer">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                    <td><label>First Name: </label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><label>First Name: </label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><label>Email: </label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><label>Birth Day: </label></td>
                    <td><form:input path="birthDay"/></td>
                </tr>
                <tr>
                    <td><label>Sex: </label></td>
                    <td><form:input path="sex"/></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <br>
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>
    </div>

</div>
</body>
</html>