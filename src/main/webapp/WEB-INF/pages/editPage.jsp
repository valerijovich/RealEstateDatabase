<%--
  Edit page for every real estate object.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty realEstate.rooms}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty realEstate.rooms}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty realEstate.rooms}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty realEstate.rooms}">
    <c:url value="/edit" var="var"/>
</c:if>
    <form action="${var}" method="POST">
        <c:if test="${!empty realEstate.rooms}">
            <input type="hidden" name="id" value="${realEstate.id}">
        </c:if>
        <label for="rooms">Rooms</label>
        <input type="text" name="rooms" id="rooms">
        <label for="floor">Floor</label>
        <input type="text" name="floor" id="floor">
        <label for="totalArea">Total Area</label>
        <input type="text" name="totalArea" id="totalArea">
        <label for="livingArea">Living Area</label>
        <input type="text" name="livingArea" id="livingArea">
        <label for="kitchenArea">Kitchen Area</label>
        <input type="text" name="kitchenArea" id="kitchenArea">
        <label for="district">District</label>
        <input type="text" name="district" id="district">

        <c:if test="${empty realEstate.rooms}">
            <input type="submit" value="Add new object">
        </c:if>
        <c:if test="${!empty realEstate.rooms}">
            <input type="submit" value="Edit object">
        </c:if>
    </form>
</body>
</html>