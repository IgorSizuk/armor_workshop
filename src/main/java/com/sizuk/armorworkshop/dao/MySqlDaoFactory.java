package com.sizuk.armorworkshop.dao;

import com.sizuk.armorworkshop.dao.dao.*;
import com.sizuk.armorworkshop.dao.dao.impl.*;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlDaoFactory implements DaoFactory {

    private Connection connection = null;

    Properties props = new Properties();
    InputStream is = null;

    public MySqlDaoFactory() throws DAOException {
        try {
            is =  this.getClass().getClassLoader().getResourceAsStream("db.properties");
            props.load(is);
            Class.forName(props.getProperty("driver"));//Регистрируем драйвер
            connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
            throw new DAOException(e);
        }catch (Exception e) {
            throw new DAOException(e);
        }
    }

    @Override
    public AdminDao getAdminDao() throws DAOException {
        try {
            return new MySqlAdminDao(connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public ProductionDao getProductionDao() throws DAOException {
        try {
            return new MySqlProductionDao(connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public AlbomDescriptionDao getAlbomDescriptionDao() throws DAOException {
        try {
            return new MySqlAlbomDescriptionDao(connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public AlbomPhotoDao getAlbomPhotosDao() throws DAOException {
        try {
            return new MySqlAlbomPhotoDao(connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public MasterclasDao getMasterclassDao() throws DAOException {
        try {
            return new MySqlMasterclasDao(connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public MasterclasPhotoDao getMasterclassPhotoDao() throws DAOException {
        try {
            return new MySqlMasterclasPhotoDao(connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
