package com.sizuk.armorworkshop.web;

import com.sizuk.armorworkshop.dao.dao.impl.*;
import com.sizuk.armorworkshop.dao.dto.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


public class MainServlet extends HttpServlet {


    private void goToMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/mainpage.jsp");
        rd.forward(request, response);
    }

    private void goToOurWorkshop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/ourworkshop.jsp");
        rd.forward(request, response);
    }

    private void goToProduction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Передаем все альбомы
            List<Production> pdList = ((MySqlProductionDao) (request.getSession()).getAttribute("productionDao")).getAll();
            request.setAttribute("pdList", pdList);
            //-------------
            RequestDispatcher rd = request.getRequestDispatcher("/production.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void goToShowProduction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            //Передача параметром для закладки Albom name
            Production pdRead = ((MySqlProductionDao) (request.getSession()).getAttribute("productionDao")).read(Integer.parseInt(request.getParameter("productionId")));
            request.setAttribute("pdRead", pdRead);
            //-------------
            //Передаем все альбомы
            List<Production> pdList = ((MySqlProductionDao) (request.getSession()).getAttribute("productionDao")).getAll();
            request.setAttribute("pdList", pdList);
            //-------------
            RequestDispatcher rd = request.getRequestDispatcher("/showproduction.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void goToShowProductionAlbom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //Передача параметров для закладки Albom name
            Production pdRead = ((MySqlProductionDao) (request.getSession()).getAttribute("productionDao")).read(Integer.parseInt(request.getParameter("productionAlbomId")));
            request.setAttribute("pdRead", pdRead);
            //-------------
            //Передача параметров для закладки rootAlbom
            Production pdReadRoot = ((MySqlProductionDao) (request.getSession()).getAttribute("productionDao")).read(Integer.parseInt(request.getParameter("rootAlbomId")));
            request.setAttribute("pdReadRoot", pdReadRoot);
            //-------------
            //Передача параметров для Deskription
            List<AlbomDescription> adList = ((MySqlAlbomDescriptionDao) (request.getSession()).getAttribute("albomDescriptionDao")).getAll();

            Iterator albomDescriptioniterator = adList.iterator();
            while (albomDescriptioniterator.hasNext()) {
                AlbomDescription adGetAll = (AlbomDescription) albomDescriptioniterator.next();
                if (adGetAll.getAlbumId() == Integer.parseInt(request.getParameter("productionAlbomId"))) {
                    request.setAttribute("adGetAll", adGetAll);
                }
            }
            //Рередаем все фото
            List<AlbomPhoto> afList = ((MySqlAlbomPhotoDao) (request.getSession()).getAttribute("albomPhotosDao")).getAll();

            request.setAttribute("afList", afList);

            RequestDispatcher rd = request.getRequestDispatcher("/showproductionalbom.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void goToMasterclas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<Masterclas, MasterclasPhoto> map = new HashMap<Masterclas , MasterclasPhoto>();

        try {

            // Грузим наши мастерклассы

            List<Masterclas> mcList = ((MySqlMasterclasDao) (request.getSession()).getAttribute("masterclassDao")).getAll();

            Iterator masterclassDaoIterator = mcList.iterator();
            while (masterclassDaoIterator.hasNext()) {

                Masterclas mcGetAll = (Masterclas) masterclassDaoIterator.next();

                // Логотип мастеркласса(Первое фото в альбоме)

                List<MasterclasPhoto> masterclasPhotoList = ((MySqlMasterclasPhotoDao) (request.getSession()).getAttribute("masterclassPhotoDao")).getAll();
                Iterator masterclassPhotoDaoIterator = masterclasPhotoList.iterator();
                mcpLabel:
                while (masterclassPhotoDaoIterator.hasNext()) {

                    MasterclasPhoto mcpGetAll = (MasterclasPhoto) masterclassPhotoDaoIterator.next();

                    if (mcGetAll.getId() == mcpGetAll.getMasterclassId()) {

                        map.put(mcGetAll, mcpGetAll);

                        break mcpLabel;
                    }
                }
            }

            request.setAttribute("map", map);

            RequestDispatcher rd = request.getRequestDispatcher("/masterclas.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void goToShowMasterclas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            //грузим мастеркласс

            Masterclas mcRead = ((MySqlMasterclasDao) (request.getSession()).getAttribute("masterclassDao")).read(Integer.parseInt(request.getParameter("masterclassId")));

            request.setAttribute("mcRead", mcRead);

            //Грузим фотки

            List<MasterclasPhoto> masterclasPhotoList = ((MySqlMasterclasPhotoDao) (request.getSession()).getAttribute("masterclassPhotoDao")).getAll();

            request.setAttribute("masterclasPhotoList", masterclasPhotoList);

            RequestDispatcher rd = request.getRequestDispatcher("/showmasterclas.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void goToContacts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/contacts.jsp");
        rd.forward(request, response);
    }

    private void goToAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("action", "enterLoginPassword");
        RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
        rd.forward(request, response);
    }

    private void enter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("login") != null && request.getParameter("pswrd") != null){
            if ((request.getParameter("login")).equals("") || (request.getParameter("pswrd")).equals("")) {
                //Если что-то не ввел
                request.setAttribute("action", "emptyField");
                RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
                rd.forward(request, response);
            } else {
                //Сравниваем с базой
                List<Admin> adminList = new ArrayList<Admin>();
                try {
                    adminList = ((MySqlAdminDao) (request.getSession()).getAttribute("adminDao")).getAll();
                } catch (Exception e) {
                    throw new ServletException(e);
                }
                Iterator iterator = adminList.iterator();
                leble1:  while (iterator.hasNext()) {
                    Admin adGetAll = new Admin();
                    adGetAll = (Admin) iterator.next();

                    if((request.getParameter("login")).equals(adGetAll.getLogin())){
                        if((request.getParameter("pswrd")).equals(adGetAll.getPassword())){

                            RequestDispatcher rd = request.getRequestDispatcher("/editor.jsp");
                            rd.forward(request, response);
                            break leble1;
                        }else {
                            //Пароль не верный
                            request.setAttribute("action", "passwordNotFound");
                            RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
                            rd.forward(request, response);
                        }
                    }else {
                        //Такого логина нет
                        request.setAttribute("action", "loginNotFound");
                        RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
                        rd.forward(request, response);
                    }
                }
            }
        }
    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            (request.getSession()).invalidate();
            goToMain(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {

        //Если нажата на "Главная", либо ничего
        if(request.getParameter("action") == null || (request.getParameter("action")).equalsIgnoreCase("main")){
            goToMain(request, response);
        }

        //Если пользователь что-то нажал(кроме главной)
        if (request.getParameter("action") != null) {

            //Если нажато на "Наша мастерская"
            if ((request.getParameter("action")).equalsIgnoreCase("ourWorkshop")) {
                goToOurWorkshop(request, response);
            }

            //Если нажато на "Продукция"
            if ((request.getParameter("action")).equalsIgnoreCase("production")) {
                goToProduction(request, response);
            }

            //Если в продукции выбран какой-то альбом
            if ((request.getParameter("action")).equalsIgnoreCase("showProduction")) {
                goToShowProduction(request, response);
            }

            //Если в продукции выбран какой-то альбом и в нем выбран какой-то альбом
            if ((request.getParameter("action")).equalsIgnoreCase("showProductionAlbom")) {



                goToShowProductionAlbom(request, response);
            }

            //Если нажато на "Мастерклассы"
            if ((request.getParameter("action")).equalsIgnoreCase("masterclas")) {
                goToMasterclas(request, response);
            }

            //Если нажато на конкретный мастеркласс
            if ((request.getParameter("action")).equalsIgnoreCase("showMasterclas")) {
                goToShowMasterclas(request, response);
            }

            //Если нажато на "Контакты"
            if ((request.getParameter("action")).equalsIgnoreCase("contacts")) {
                goToContacts(request, response);
            }
//----------------------------------------------------------------------------------------------------------------------
            //Если зашел админ
            if ((request.getParameter("action")).equalsIgnoreCase("GoToAdminPage")) {
                //Идем на страницу логина
                goToAdmin(request, response);
            }

            if((request.getParameter("action").equals("enter"))){
                enter(request, response);
            }

            if((request.getParameter("action").equals("logOut"))){
                logOut(request, response);
            }
//----------------------------------------------------------------------------------------------------------------------
        }
    }
}
