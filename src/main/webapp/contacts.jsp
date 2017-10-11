
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

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<!-- contacts -->
<div class="contacts">
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
  <div class="contacts-content">
    <!-- breadcrumb -->
    <div class="container">
      <ol class="breadcrumb">
        <li class="active">Контакты</li>
      </ol>
    </div>
    <!-- #breadcrumb -->
    <div class= "container">
      <div class="contacts-text">
        <p>Оформить заказ можно по адресу: <a href="mailto:sizuk.igor@gmail.com">sizuk.igor@gmail.com</a></p>
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
<!-- #contacts -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
