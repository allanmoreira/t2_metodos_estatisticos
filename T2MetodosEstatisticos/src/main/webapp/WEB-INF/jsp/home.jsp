<%--
  Created by IntelliJ IDEA.
  User: allanmoreira
  Date: 15/10/16
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h"%>

<h:header titulo_aba="Home"/>

<div class="container theme-showcase" role="main">

    <h:home/>
    <h:dados_populacionais/>
    <h:param_populacionais/>

</div> <!-- /container -->

<h:footer/>