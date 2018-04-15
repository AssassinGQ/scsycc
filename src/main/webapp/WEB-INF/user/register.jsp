<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form action="" method="post">
    <table>
        <tr>
            <td><spring:message code="username"/></td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td><spring:message code="password"/></td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><h5>${registe_info}</h5></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value=<spring:message code="submit"/>></td>
        </tr>
    </table>
</form>