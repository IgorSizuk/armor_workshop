package com.sizuk.armorworkshop.dao.dao.impl;


import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dao.AdminDao;
import com.sizuk.armorworkshop.dao.dto.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MySqlAdminDao implements AdminDao {


    private final Connection connection;

    private final String sqlAdminCreate = "INSERT INTO `admin` (`password`, `login`) VALUES (?,?);";
    private final String sqlAdminRead = "SELECT `id`, `password`, `login` FROM `admin` WHERE id = ?;";
    private final String sqlAdminUpdate = "UPDATE `admin` SET `password` = ?, `login` =? WHERE id = ?;";
    private final String sqlAdminDelete = "DELETE from `admin` where `id` = ?;";
    private final String sqlAdminReadAll = "SELECT `id`, `password`, `login` FROM `admin`;";
    private final String sqlAdminCheck = "SELECT `password` FROM `admin` WHERE login = ?;";

    private PreparedStatement adminCreate = null;
    private PreparedStatement adminRead = null;
    private PreparedStatement adminUpdate = null;
    private PreparedStatement adminDelete = null;
    private PreparedStatement adminReadAll = null;
    private PreparedStatement adminCheck = null;

    public MySqlAdminDao(Connection connection) throws SQLException, DAOException {
        this.connection = connection;
    }

    @Override
    public void create(Admin admin) throws DAOException {
        try {
            if(adminCreate == null){
                adminCreate = connection.prepareStatement(sqlAdminCreate);
            }
            adminCreate.setString(1, admin.getPassword());
            adminCreate.setString(2, admin.getLogin());
            adminCreate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public Admin read(int key) throws DAOException {
        ResultSet rs = null;
        Admin ad = new Admin();

        try {
            if(adminRead == null){
            adminRead = connection.prepareStatement(sqlAdminRead);
            }
            adminRead.setInt(1, key);
            rs = adminRead.executeQuery();
            rs.next();
            ad.setId(rs.getInt("id"));
            ad.setPassword(rs.getString("password"));
            ad.setLogin(rs.getString("login"));
        }catch (SQLException e){
            throw new DAOException(e);
        } finally {
            try {
                rs.close();
            }catch (SQLException e) {
                throw new DAOException(e);
            }
        }
        return ad;
    }

    @Override
    public void update(Admin admin) throws DAOException {
        try {
            if(adminUpdate == null){
            adminUpdate = connection.prepareStatement(sqlAdminUpdate);
            }
            adminUpdate.setString(1, admin.getPassword());
            adminUpdate.setString(2, admin.getLogin());
            adminUpdate.setInt(3, admin.getId());
            adminUpdate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(Admin admin) throws DAOException {
        try {
            if(adminDelete == null){
            adminDelete = connection.prepareStatement(sqlAdminDelete);
            }
            adminDelete.setInt(1,admin.getId());
            adminDelete.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public List<Admin> getAll() throws DAOException {
        ResultSet rs = null;
        List<Admin> list = new ArrayList<Admin>();

        try {
            if(adminReadAll == null){
            adminReadAll = connection.prepareStatement(sqlAdminReadAll);
            }
            rs = adminReadAll.executeQuery();
            while (rs.next()) {
                Admin ad = new Admin();
                ad.setId(rs.getInt("id"));
                ad.setPassword(rs.getString("password"));
                ad.setLogin(rs.getString("login"));
                list.add(ad);
            }
        }catch (SQLException e){
            throw new DAOException(e);
        }
        finally {
            try {
                rs.close();
            }catch (SQLException e) {
                throw new DAOException(e);
            }
        }
        return list;
    }

    @Override
    public Admin check(String login) throws DAOException {
        ResultSet rs = null;
        Admin ad = new Admin();
        try {
            if(adminCheck == null){
                adminCheck = connection.prepareStatement(sqlAdminCheck);
            }
            adminCheck.setString(1, login);
            rs = adminCheck.executeQuery();
            rs.next();

            ad.setPassword(rs.getString("password"));

        }catch (SQLException e){
            throw new DAOException(e);
        } finally {
            try {
                rs.close();
            }catch (SQLException e) {
                throw new DAOException(e);
            }
        }
        return ad;
    }

    @Override
    public void close() throws DAOException {
        try {

            if (adminCreate != null) {
                adminCreate.close();
            }

            if (adminRead != null) {
                adminRead.close();
            }

            if (adminUpdate != null) {
                adminUpdate.close();
            }

            if (adminDelete != null) {
                adminDelete.close();
            }

            if (adminReadAll != null) {
                adminReadAll.close();
            }
        }catch (SQLException e) {
            throw new DAOException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }
}
