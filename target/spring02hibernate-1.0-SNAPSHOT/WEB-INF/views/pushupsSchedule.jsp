<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>pushupsSchedule</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>

<a href="/menu">back to menu</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">day</th>
        <th scope="col">series</th>
        <th scope="col">reps1</th>
        <th scope="col">reps2</th>
        <th scope="col">reps3</th>
        <th scope="col">reps4</th>
        <th scope="col">reps5</th>
        <th scope="col">reps6</th>
        <th scope="col">reps7</th>
        <th scope="col">reps8</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pushups}" var="pushups">
        <tr>
            <form method="POST" modelAttribute="userhistorypushup">
                <input type="hidden" name="pushups" value="${pushups.id}"/>
                <input type="hidden" name="users" value="${user.id}"/>
                <td>${pushups.day}</td>
                <td> ${pushups.series}</td>
                <td> ${pushups.reps1}</td>
                <td> ${pushups.reps2}</td>
                <td> ${pushups.reps3}</td>
                <td> ${pushups.reps4}</td>
                <td> ${pushups.reps5}</td>
                <td> ${pushups.reps6}</td>
                <td> ${pushups.reps7}</td>
                <td> ${pushups.reps8}</td>
                <td><input type="submit" value="Save"></td>
            </form>
        </tr>
    </c:forEach>

    </tbody>
</table>


</body>
</html>