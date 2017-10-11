
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    if((request.getAttribute("action")).equals("enterLoginPassword")){
          %><h1>Здравствуйте! Введите ваш логин и пароль.</h1><%
    }
    if((request.getAttribute("action")).equals("emptyField")) {
          %><h1>Что-то не ввел!</h1><%
    }
    if((request.getAttribute("action")).equals("loginNotFound")){
           %><h1>Пользователя с таким именем не существует.</h1><%
    }
    if((request.getAttribute("action")).equals("passwordNotFound")){
           %><h1>Пароль не верный.</h1><%
    }
%>
<div>
  <form action ="  <%=request.getContextPath()%>  /MainServlet" method = "get">
    <input type ="text" name ="login"  value="<%=(request.getParameter("login")!=null)?request.getParameter("login"):""%>"   placeholder = "Введите логин">
    <input type ="password" name ="pswrd" placeholder = "Введите пароль">
    <input type ="submit"  value = "enter" name = "action" >
    <input type = "reset" value = "сброс">
  </form>
</div>
</body>
</html>
