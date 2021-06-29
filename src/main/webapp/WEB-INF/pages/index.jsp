<%--
  Main page of Real Estate Database web-application.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Real Estate Objects</title>
</head>
<body>

<h2>Real Estate Objects</h2>
<table>
    <tr>
        <th>id</th>
        <th>rooms</th>
        <th>floor</th>
        <th>totalArea</th>
        <th>livingArea</th>
        <th>kitchenArea</th>
        <th>district</th>
    </tr>
    <c:forEach var="realEstate" items="${realEstatesList}">
        <tr>
            <td>${realEstate.id}</td>
            <td>${realEstate.rooms}</td>
            <td>${realEstate.floor}</td>
            <td>${realEstate.totalArea}</td>
            <td>${realEstate.livingArea}</td>
            <td>${realEstate.kitchenArea}</td>
            <td>${realEstate.district}</td>
            <td>
                <a href="/edit/${realEstate.id}">edit</a>
                <a href="/delete/${realEstate.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new object</a>
</body>
</html>