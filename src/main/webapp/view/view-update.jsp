<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/5/2026
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/hoc-sinh/them" method="post">
    <input type="number" name="id" value="${hs.id}" hidden>
    <br>
    <label>Ho ten</label>
    <input type="text" name="hoTen" value="${hs.hoTen}" required>
    <br>
    <label>Gioi tinh</label>
    <input type="radio" name="gioiTinh" value="false" ${hs.gioiTinh == false ? "checked" : ""} required>Nu
    <input type="radio" name="gioiTinh" value="true" ${hs.gioiTinh == true ? "checked" : ""}>Nam
    <br>
    <label>Dia chi</label>
    <input type="text" name="diaChi" value="${hs.diaChi}" required>
    <br>
    <label>Ten lop</label>
    <select name="idLopHoc">
        <c:forEach items="${listLopHoc}" var="lh">
            <option value="${lh.id}" label="${lh.tenLop}" ${hs.lopHoc.id == lh.id ? "selected" : ""}></option>
        </c:forEach>
    </select>
    <br>
    <button>Save</button>
</body>
</html>
