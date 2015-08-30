<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/taglibs.jsp"%>
<html>
<body>
<h2>Hello World!</h2>

<c:forEach var="user" varStatus="userStatus" items="${users}">
    <h2>${user.id}_____${user.name}</h2>
</c:forEach>
<h1>${user.name}</h1>
</body>
</html>
