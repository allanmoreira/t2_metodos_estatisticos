<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value="/static/docs/favicon.ico"/>">

    <%@ attribute name="titulo_aba" required="true" %><!--  -->
    <title>${titulo_aba } - T2 Allan Moreira</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/static/dist/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Bootstrap theme -->
    <link href="<c:url value="/static/dist/css/bootstrap-theme.min.css"/>" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="<c:url value="/static/docs/assets/css/ie10-viewport-bug-workaround.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/static/docs/examples/theme/theme.css"/>" rel="stylesheet">

    <link rel="stylesheet" href="<c:url value="/static/ajax/aguardar_ajax.css" />">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>



<body>

<div id="div_aguardar_ajax" class="modal_aguardar_ajax">
    <div style="top: 30%; left: 45%; position: fixed";
         class="navbar navbar-fixed-top" role="navigation">
        <img class="img_vertical_aguardar_ajax" src="<c:url value="/static/ajax/please_wait.gif" />" alt="carregando">
    </div>
</div>

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed active"
                    data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" id="menu_inicio" href="/T2MetodosEstatisticos/home">Início</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li id="item_lista_dados_populacionais"><a href="#" id="link_dados_populacionais">Dados Populacionais</a></li>
                <li id="item_lista_param_populacionais"><a href="#" id="link_param_populacionais">Parâmetros Populacionais</a></li>
                <li id="item_lista_comport_estim"><a href="#" id="link_comport_estim">Comportamento Estimadores</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
