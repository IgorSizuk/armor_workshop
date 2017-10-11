<%@ page import="com.sizuk.armorworkshop.dao.dto.Masterclas" %>
<%@ page import="com.sizuk.armorworkshop.dao.dto.MasterclasPhoto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang = "ru-Ru">
<head>
  <meta charset="UTF-8">
  <title></title>
  <link rel = "stylesheet" href = "style.css">
  <style>
    .header {
      font-family: Arial, sans-serif;
      font-size: 150%;
    }
  </style>
</head>
<body bgcolor = "FFffe0">

<jsp:include page="/menu.jsp" />

<%--грузим мастеркласс--%>

<%--грузим название мастеркласса--%>
<div class="header"><%= ((Masterclas)(request.getAttribute("mcRead"))).getMasterclassName() %></1>
<div>
  <div>
<%
  //Грузим фотки

  Iterator masterclassPhotoDaoIterator = ((List<MasterclasPhoto>)(request.getAttribute("masterclasPhotoList"))).iterator();
  while (masterclassPhotoDaoIterator.hasNext()) {

    MasterclasPhoto mcpGetAll = (MasterclasPhoto) masterclassPhotoDaoIterator.next();

    if(((Masterclas)(request.getAttribute("mcRead"))).getId() == mcpGetAll.getMasterclassId()){
    %>
        <img id = "myAva" src = "<%= mcpGetAll.getPhotoUrl() %>" alt = "Мастеркласс N" border = "2">
    <%
    }
  }
      %>
    <br>
    <%--Грузим текст--%>
    <p><%= ((Masterclas)(request.getAttribute("mcRead"))).getMasterclassText() %></p>
  </div>
</div>

</body>
</html>
