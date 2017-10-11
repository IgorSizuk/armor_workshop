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
<!-- site -->
<div class="site">
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
    <div class="site-content">
        <main id = "content-mine-page">
            <!-- slider -->
            <section class="block-1-wrap">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                    </ol>
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="Pictures\Mainpage\Slider\slider_0.jpg" alt="">
                            <div class="carousel-caption">
                                <!-- Picture description -->
                            </div>
                        </div>
                        <div class="item">
                            <img src="Pictures\Mainpage\Slider\slider_1.jpg" alt="">
                            <div class="carousel-caption">
                                <!-- Picture description -->
                            </div>
                        </div>
                        <div class="item">
                            <img src="Pictures\Mainpage\Slider\slider_2.jpg" alt="">
                            <div class="carousel-caption">
                                <!-- Picture description -->
                            </div>
                        </div>
                        <div class="item">
                            <img src="Pictures\Mainpage\Slider\slider_3.jpg" alt="">
                            <div class="carousel-caption">
                                <!-- Picture description -->
                            </div>
                        </div>
                    </div>
                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </section>
            <!-- #slider -->
            <!-- main text -->
            <section class="block-2-wrap">
                <div class="container">
                    <div class="main-deskription-header">
                        <h2>Добро пожаловать в мир средневековых доспехов</h2>
                        <h1>Armor Workshop</h1>
                    </div>
                    <div class="main-deskription-text">
                        <p>Мы занимаемся изготовлением моделей средневекового защитного и наступательного снаряжения.
                            Предпочтения отдаются реконструкции раннего средневековья 9-11вв, высокого средневековья и ренессанса 15-16вв.</p>
                        <p>Наша кузница стилизована в духе 16 века - времени наибольшего расцвета доспешного мастерства.</p>
                        <p>На ее базе мы проводим мастер классы по работе с листовым металлом, ковке предметов быта и вооружения разных эпох.
                        </p>
                    </div>
                    <div class="main-deskription-button">
                        <p><a class="btn btn-primary btn-lg" href="MainServlet?action=ourWorkshop" role="button">Узнайте о нас больше</a></p>
                    </div>
                </div>
            </section>
            <!-- #main text -->
            <!-- you can -->
            <section class="block-3-wrap">
                <div class="container">
                    <div class="main-youcan">
                        <div class="main-youcan-header">
                            <h1>У нас вы можете</h1>
                        </div>
                        <div class="main-youcan-content">
                            <div class="row">
                                <div class="col-sm-6">
                                    <h2>Заказать</h2>
                                    <img src="Pictures\Mainpage\Youcan\1.jpg" alt="..." class="img-responsive img-thumbnail center-block">
                                    <p>Новые доспехи и вооружение для фестивалей исторической реконструкции и ролевых игр</p>
                                </div>
                                <div class="col-sm-6">
                                    <h2>Отремонтировать</h2>
                                    <img src="Pictures\Mainpage\Youcan\2.jpg" alt="..." class="img-responsive img-thumbnail center-block">
                                    <p>Имеющиеся у вас доспехи в случае необходимости можно отрихтовать, почистить от ржавчины, а так же заменить старые пряжки и лямки креплений  </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- #you can -->
            <!-- main works -->
            <section class="block-4-wrap">
                <div class="container">
                    <div class="main-works">
                        <div class="main-works-header">
                            <h1>Наши работы</h1>
                        </div>
                        <div class="main-works-imajes">
                            <div class="row">
                                <div class="col-sm-3 thumb-2">
                                    <a href="Pictures\Mainpage\Works\1.jpg" class="fancyimage" data-fancybox-group="group">
                                        <img src="Pictures\Mainpage\Works\1.jpg" alt="..." class="img-responsive img-circle center-block">
                                    </a>
                                    <p>Латные рукавицы 14в.</p>
                                </div>
                                <div class="col-sm-3 thumb-2">
                                    <a href="Pictures\Mainpage\Works\2.jpg" class="fancyimage" data-fancybox-group="group">
                                        <img src="Pictures\Mainpage\Works\2.jpg" alt="..." class="img-responsive img-circle center-block">
                                    </a>
                                    <p>Норманский шлем 11в.</p>
                                </div>
                                <div class="col-sm-3 thumb-2">
                                    <a href="Pictures\Mainpage\Works\3.jpg" class="fancyimage" data-fancybox-group="group">
                                        <img src="Pictures\Mainpage\Works\3.jpg" alt="..." class="img-responsive img-circle center-block">
                                    </a>
                                    <p>Европейские наколенники 14в.</p>
                                </div>
                                <div class="col-sm-3 thumb-2">
                                    <a href="Pictures\Mainpage\Works\4.jpg" class="fancyimage" data-fancybox-group="group">
                                        <img src="Pictures\Mainpage\Works\4.jpg" alt="..." class="img-responsive img-circle center-block">
                                    </a>
                                    <p>Щит баклер 13в.</p>
                                </div>
                            </div>
                        </div>
                        <div class="main-works-button">
                            <p><a class="btn btn-primary btn-lg" href="MainServlet?action=production" role="button">Посмотреть все работы</a></p>
                        </div>
                    </div>
                </div>
            </section>
            <!-- #main works -->
            <!-- main stage -->
            <section class="block-5-wrap">
                <div class="container">
                    <div class="main-stage">
                        <div class="row">
                            <div class="main-stage-header">
                                <h1>Этапы производства</h1>
                                <p>Выполнение нашими мастерами каждого заказа происходит в несколько этапов, на каждом из которых мы делаем всё для того, чтобы готовое изделие стало настоящим шедевром</p>
                            </div>
                            <div class="main-stage-text">
                                <div class="col-sm-4">
                                    <h2>1.Эскиз</h2>
                                    <p>В удобное для клиента время наши специалисты сделают необходимые замеры, тщательно проработают эскиз и согласуют с заказчиком все нюансы работы</p>
                                </div>
                                <div class="col-sm-4">
                                    <h2>2.Производство</h2>
                                    <p>Наши мастера, основываясь на согласованном с заказчиком эскизе, создают изящные качественные изделия, приобретающие художественную ценность</p>
                                </div>
                                <div class="col-sm-4">
                                    <h2>3.Примерка</h2>
                                    <p>В конце основного этапа изготовления делается контрольная примерка изделия, чтобы сделать его максимально удобным для заказчика</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- #main stage -->
            <!-- blog -->
            <section class="block-6-wrap">
                <div class="container">
                    <div class="main-blog">
                        <div class="row">
                            <div class="main-blog-text">
                                <p>Следите за последними новостями и интересными событиями из жизни нашей мастерской в разделе:</p>
                            </div>
                        </div>
                        <div class="main-blog-button">
                            <p><a class="btn btn-primary btn-lg" href="MainServlet?action=masterclas" role="button">Блог</a></p>
                        </div>
                        <div class="main-blog-img">
                            <img src="Pictures\Mainpage\Blog\1.jpg" alt="..." class="img-responsive img-rounded center-block">
                        </div>
                    </div>
                </div>
            </section>
            <!-- #blog -->
        </main>
    </div>
    <!-- #content -->
    <!-- footer -->
    <footer class="site-footer">
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
<!-- #site -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<!-- Подключение JS файла Fancybox -->
<script type="text/javascript" src="fancybox/jquery.fancybox.pack.js"></script>
<script type="text/javascript"> $(document).ready(function() { $("a.fancyimage").fancybox(); }); </script>
</body>
</html>
