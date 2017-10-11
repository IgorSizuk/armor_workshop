<%@ page import="com.sizuk.armorworkshop.dao.dto.Production" %>
<%@ page import="com.sizuk.armorworkshop.dao.dto.AlbomDescription" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.sizuk.armorworkshop.dao.dto.AlbomPhoto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Armor Workshop</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
    <!-- подключение CSS файла Fancybox -->
    <link rel="stylesheet" href="fancybox/jquery.fancybox.css" type="text/css" media="screen" />

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- production -->
<div class="production">
    <!-- header -->
    <header class="site-header">
        <div class="header-top"></div>
        <div class="navbar navbar-default  header-content">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle = "collapse" data-target = "#responsive-menu">
                        <span class="sr-only">Открыть навигацию</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="MainServlet?action=main" class="navbar-brand" id = "brand-top">Armor Workshop</a>
                </div>
                <div class="collapse navbar-collapse" id = "responsive-menu">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="MainServlet?action=main">Главная</a></li>
                        <li><a href="MainServlet?action=ourWorkshop">Мастерская</a></li>
                        <li><a href="MainServlet?action=production">Продукция</a></li>
                        <li><a href="MainServlet?action=masterclas">Блог</a></li>
                        <li><a href="MainServlet?action=contacts">Контакты</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </header>
    <!-- #header -->
    <!-- content -->
    <div class="production-content">
        <!-- breadcrumb -->
        <div class="container">

            <ol class="breadcrumb">
                <li><a href="MainServlet?action=production">Продукция</a></li>
                <%--rootAlbom--%>
                <li><a href="MainServlet?action=showProduction&productionId=<%= ((Production)(request.getAttribute("pdReadRoot"))).getId()%>"><%= ((Production)(request.getAttribute("pdReadRoot"))).getAlbumName()%></a></li>
                <%--Albom name--%>
                <li class="active"><%= ((Production)(request.getAttribute("pdRead"))).getAlbumName()%></li>
            </ol>
        </div>
        <!-- #breadcrumb -->
        <div class= "container">
            <div class="production-deskriotion">
                <%--Deskription--%>
                <p><%=((AlbomDescription)(request.getAttribute("adGetAll"))).getDescription()%></p>
            </div>
            <div class="production-content-works">
                <%--Грузим фотки--%>
                <%--Из всех фоток выбираем только те что в альбоме--%>
                <div class="row">
                    <%
                        Iterator albomPhotositerator = ((List)(request.getAttribute("afList"))).iterator();
                        while (albomPhotositerator.hasNext()) {
                            AlbomPhoto afGetAll = (AlbomPhoto) albomPhotositerator.next();
                            if(afGetAll.getAlbumId() == Integer.parseInt(request.getParameter("productionAlbomId"))){
                    %>
                    <div class="col-md-4 col-sm-4 col-xs-6 thumb-1">
                        <a class="fancyimage" data-fancybox-group="group" href="<%=afGetAll.getPhotoUrl()%>">
                            <img class="img-responsive" src="<%=afGetAll.getPhotoUrl()%>" />
                        </a>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
    <!-- #content -->
    <!-- footer -->
    <footer class="site-footer" id="footer">
        <div class= "container">
            <div class="site-footer-content">
                <div class="site-footer-top">
                    <p>Armor Workshop</p>
                </div>
                <div class="btn-group" role="group" aria-label="...">
                    <div class="btn-group">
                        <a class="btn btn-default" href="MainServlet?action=main">Главная</a>
                        <a class="btn btn-default" href="MainServlet?action=ourWorkshop">Мастерская</a>
                        <a class="btn btn-default" href="MainServlet?action=production">Продукция</a>
                        <a class="btn btn-default" href="MainServlet?action=masterclas">Блог</a>
                        <a class="btn btn-default" href="MainServlet?action=contacts">Контакты</a>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- #footer -->
</div>
<!-- #production -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<!-- Подключение JS файла Fancybox -->
<script type="text/javascript" src="fancybox/jquery.fancybox.pack.js"></script>
<script type="text/javascript"> $(document).ready(function() { $("a.fancyimage").fancybox(); }); </script>
</body>
</html>

