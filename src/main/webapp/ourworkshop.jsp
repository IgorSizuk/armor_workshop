
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
<div class="workshop">
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
  <div class="workshop-content">
    <!-- breadcrumb -->
    <div class="container">
      <ol class="breadcrumb">
        <li class="active">Мастерская</li>
      </ol>
    </div>
    <!-- #breadcrumb -->
    <div class="workshop-text">
      <div class= "container">
        <div class="workshop-text-top">
          <p>Что же такое кузница? В двух словах, это помещение, оборудованное для выполнения кузнечных работ. А если подойти к этому вопросу творчески, то кузница для кузнеца, увлеченного своим делом, не просто помещение, — это его дом, его храм, в котором происходят всевозможные чудеса. В кузнице мастер проводит практически все свое время. Здесь он работает, отдыхает, творит, мыслит.</p>
        </div>
        <div class="row">
          <div class="col-lg-4">
            <img src="Pictures\Ourworkshop\1.jpg" alt="..." class="img-responsive img-thumbnail center-block">
          </div>
          <div class="col-lg-4">
            <p>Если кузница – организм, то сердце в нём – это кузнечный горн. Именно там грубая сталь превращается в пластичный материал.
              Принцип работы горна достаточно прост. На рабочей поверхности горит уголь, в который помещается стальная заготовка и разогревается до нужной температуры. Угли как тысячу лет назад, как и сейчас, раздуваются при помощи воздуха. Их можно раздуть почти до полутора тысячи градусов!
            </p>
          </div>
          <div class="col-lg-4">
            <img src="Pictures\Ourworkshop\2.jpg" alt="..." class="img-responsive img-thumbnail center-block">
          </div>
        </div>
        <div class="workshop-text-midle-one">
          <p>Наковальня, являясь основным помощником кузнеца, не может остаться без внимания. Она изготавлена методом литья из инструментальной углеродистой стали. Горизонтальную площадку сверху называют лицом, и на нём выполняется основная часть всех работ. Эта поверхность должна быть тщательно отшлифована и находиться в идеальном состоянии: не иметь выбоин, зарубок и вмятин. Нельзя стучать по поверхности голым молотком или пользоваться на ней зубилом. С правой стороны у наковальни находится конический рог, который предназначен для выгибания прутков и полос, сварки и раскатки колец.</p>
        </div>
        <img src="Pictures\Ourworkshop\3.jpg" alt="..." class="img-thumbnail center-block">
        <div class="workshop-text-midle-two">
          <p>Руки мастера способны превратить кусок обычного металла в ажурные изделия, красота которых делает их сравнимыми с произведениями искусства. И такие шедевры доступны любому желающему – достаточно лишь заказать их в нашей мастерской.</p>
        </div>

        <img src="Pictures\Ourworkshop\4.jpg" alt="..." class="img-thumbnail center-block">

        <div class="workshop-text-bottom">
          <p>Кузнечная мастерская Armor Workshop уже более 12 лет успешно работает на рынке средневековых доспехов и кованых изделий. Работы нашей ковки славятся не только качеством, прочностью и долговечностью, но и изысканностью, красотой и неповторимым дизайном. Качество наших изделий не подвергается сомнению даже самыми требовательными и искушенными заказчиками. В первую очередь это исторические реконструкторы а так же спортсмены по историческому средневековому бою сборных Беларуси и России.</p>
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
<!-- #contacts -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
