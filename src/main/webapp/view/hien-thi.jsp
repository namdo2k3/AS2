<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/5/2026
  Time: 2:02 PM
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
    <label>Ho ten</label>
    <input type="text" name="hoTen" required>
    <br>
    <label>Gioi tinh</label>
    <input type="radio" name="gioiTinh" value="false" required>Nu
    <input type="radio" name="gioiTinh" value="true" required>Nam
    <br>
    <label>Dia chi</label>
    <input type="text" name="diaChi" required>
    <br>
    <label>Ten lop</label>
    <select name="idLopHoc">
        <c:forEach items="${listLopHoc}" var="lh">
            <option value="${lh.id}" label="${lh.tenLop}"></option>
        </c:forEach>
    </select>
    <br>
    <button>Save</button>
</form>
    <table border="1" style="border-collapse: collapse">
        <thead>
            <tr>
                <th>Id</th>
                <th>Ho ten</th>
                <th>Gioi tinh</th>
                <th>Dia chi</th>
                <th>Ten lop</th>
                <th>Khoi</th>
                <th>Si so</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listHocSinh}" var="hs">
                <tr>
                    <td>${hs.id}</td>
                    <td>${hs.hoTen}</td>
                    <td>${hs.gioiTinh == false ? "Nu" : "Nam"}</td>
                    <td>${hs.diaChi}</td>
                    <td>${hs.lopHoc.tenLop}</td>
                    <td>${hs.lopHoc.khoi}</td>
                    <td>${hs.lopHoc.siSo}</td>
                    <td>
                        <a href="/hoc-sinh/view-update?id=${hs.id}"><button>Sua</button></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
