package com.sizuk.armorworkshop.dao.dao.impl;



import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dao.ProductionDao;
import com.sizuk.armorworkshop.dao.dto.Production;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MySqlProductionDao implements ProductionDao {

    private final Connection connection;

    private final String sqlProductionCreate = "INSERT INTO `production` (`album_name`, `album_photo_url`, `link`) VALUES (?,?,?);";
    private final String sqlProductionRead = "SELECT `id`, `album_name`, `album_photo_url`, `link` FROM `production` WHERE id = ?;";
    private final String sqlProductionUpdate = "UPDATE `production` SET `album_name` = ?, `album_photo_url` =?, `link` =? WHERE id = ?;";
    private final String sqlProductionDelete = "DELETE from `production` where `id` = ?;";
    private final String sqlProductionReadAll = "SELECT `id`, `album_name`, `album_photo_url`, `link` FROM `production`;";

    private PreparedStatement productionCreate = null;
    private PreparedStatement productionRead = null;
    private PreparedStatement productionUpdate = null;
    private PreparedStatement productionDelete = null;
    private PreparedStatement productionReadAll = null;

    public MySqlProductionDao(Connection connection) throws SQLException, DAOException {
        this.connection = connection;
    }

    @Override
    public void create(Production production) throws DAOException {
        try {
            if(productionCreate == null){
                productionCreate = connection.prepareStatement(sqlProductionCreate);
            }
            productionCreate.setString(1, production.getAlbumName());
            productionCreate.setString(2, production.getAlbumPhotoUrl());


            if(production.getLink() == 0) {
                productionCreate.setNull(3, production.getLink());
            }else {
                productionCreate.setInt(3, production.getLink());
            }


            productionCreate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public Production read(int key) throws DAOException {
        ResultSet rs = null;
        Production pd = new Production();
        try {
            if(productionRead == null){
                productionRead = connection.prepareStatement(sqlProductionRead);
            }
            productionRead.setInt(1, key);
            rs = productionRead.executeQuery();
            rs.next();
            pd.setId(rs.getInt("id"));
            pd.setAlbumName(rs.getString("album_name"));
            pd.setAlbumPhotoUrl(rs.getString("album_photo_url"));
            pd.setLink(rs.getInt("link"));
        }catch (SQLException e){
            throw new DAOException(e);
        } finally {
            try {
                rs.close();
            }catch (SQLException e) {
                throw new DAOException(e);
            }
        }
        return pd;
    }

    @Override
    public void update(Production production) throws DAOException {
        try {
            if(productionUpdate == null){
                productionUpdate = connection.prepareStatement(sqlProductionUpdate);
            }
            productionUpdate.setString(1, production.getAlbumName());
            productionUpdate.setString(2, production.getAlbumPhotoUrl());
            productionUpdate.setInt(3, production.getLink());
            productionUpdate.setInt(4, production.getId());
            productionUpdate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(Production production) throws DAOException {
        try {
            if(productionDelete == null){
                productionDelete = connection.prepareStatement(sqlProductionDelete);
            }
            productionDelete.setInt(1, production.getId());
            productionDelete.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public List<Production> getAll() throws DAOException {
        ResultSet rs = null;
        List<Production> list = new ArrayList<Production>();
        try {
            if(productionReadAll == null){
                productionReadAll = connection.prepareStatement(sqlProductionReadAll);
            }
            rs = productionReadAll.executeQuery();
            while (rs.next()) {
                Production pd = new Production();
                pd.setId(rs.getInt("id"));
                pd.setAlbumName(rs.getString("album_name"));
                pd.setAlbumPhotoUrl(rs.getString("album_photo_url"));
                pd.setLink(rs.getInt("link"));
                list.add(pd);
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
    public void close() throws DAOException {
        try {

            if (productionCreate != null) {
                productionCreate.close();
            }

            if (productionRead != null) {
                productionRead.close();
            }

            if (productionUpdate != null) {
                productionUpdate.close();
            }

            if (productionDelete != null) {
                productionDelete.close();
            }

            if (productionReadAll != null) {
                productionReadAll.close();
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
