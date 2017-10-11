package com.sizuk.armorworkshop.dao.dao.impl;


import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dao.MasterclasPhotoDao;
import com.sizuk.armorworkshop.dao.dto.MasterclasPhoto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySqlMasterclasPhotoDao implements MasterclasPhotoDao {

    private final Connection connection;

    private final String sqlMasterclassPhotoCreate = "INSERT INTO `master_class_photo` (`master_class_id`, `photo_url`) VALUES (?,?);";
    private final String sqlMasterclassPhotoRead = "SELECT `id`, `master_class_id`, `photo_url` FROM `master_class_photo` WHERE id = ?;";
    private final String sqlMasterclassPhotoUpdate = "UPDATE `master_class_photo` SET `master_class_id` = ?, `photo_url` =? WHERE id = ?;";
    private final String sqlMasterclassPhotoDelete = "DELETE from `master_class_photo` where `id` = ?;";
    private final String sqlMasterclassPhotoReadAll = "SELECT `id`, `master_class_id`, `photo_url` FROM `master_class_photo`;";

    private PreparedStatement masterclassPhotoCreate = null;
    private PreparedStatement masterclassPhotoRead = null;
    private PreparedStatement masterclassPhotoUpdate = null;
    private PreparedStatement masterclassPhotoDelete = null;
    private PreparedStatement masterclassPhotoReadAll = null;

    public MySqlMasterclasPhotoDao(Connection connection) throws SQLException, DAOException {
        this.connection = connection;
    }

    @Override
    public void create(MasterclasPhoto masterclasPhoto) throws DAOException {
        try {
            if(masterclassPhotoCreate == null){
                masterclassPhotoCreate = connection.prepareStatement(sqlMasterclassPhotoCreate);
            }
            masterclassPhotoCreate.setInt(1, masterclasPhoto.getMasterclassId());
            masterclassPhotoCreate.setString(2, masterclasPhoto.getPhotoUrl());
            masterclassPhotoCreate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public MasterclasPhoto read(int key) throws DAOException {
        ResultSet rs = null;
        MasterclasPhoto mcp = new MasterclasPhoto();
        try {
            if(masterclassPhotoRead == null){
                masterclassPhotoRead = connection.prepareStatement(sqlMasterclassPhotoRead);
            }
            masterclassPhotoRead.setInt(1, key);
            rs = masterclassPhotoRead.executeQuery();
            rs.next();
            mcp.setId(rs.getInt("id"));
            mcp.setMasterclassId(rs.getInt("master_class_id"));
            mcp.setPhotoUrl(rs.getString("photo_url"));
        }catch (SQLException e){
            throw new DAOException(e);
        } finally {
            try {
                rs.close();
            }catch (SQLException e) {
                throw new DAOException(e);
            }
        }
        return mcp;
    }

    @Override
    public void update(MasterclasPhoto masterclasPhoto) throws DAOException {
        try {
            if(masterclassPhotoUpdate == null){
                masterclassPhotoUpdate = connection.prepareStatement(sqlMasterclassPhotoUpdate);
            }
            masterclassPhotoUpdate.setInt(1, masterclasPhoto.getMasterclassId());
            masterclassPhotoUpdate.setString(2, masterclasPhoto.getPhotoUrl());
            masterclassPhotoUpdate.setInt(3, masterclasPhoto.getId());
            masterclassPhotoUpdate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(MasterclasPhoto masterclasPhoto) throws DAOException {
        try {
            if(masterclassPhotoDelete == null){
                masterclassPhotoDelete = connection.prepareStatement(sqlMasterclassPhotoDelete);
            }
            masterclassPhotoDelete.setInt(1, masterclasPhoto.getId());
            masterclassPhotoDelete.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public List<MasterclasPhoto> getAll() throws DAOException {
        ResultSet rs = null;
        List<MasterclasPhoto> list = new ArrayList<MasterclasPhoto>();
        try {
            if(masterclassPhotoReadAll == null){
                masterclassPhotoReadAll = connection.prepareStatement(sqlMasterclassPhotoReadAll);
            }
            rs = masterclassPhotoReadAll.executeQuery();
            while (rs.next()) {
                MasterclasPhoto mcp = new MasterclasPhoto();
                mcp.setId(rs.getInt("id"));
                mcp.setMasterclassId(rs.getInt("master_class_id"));
                mcp.setPhotoUrl(rs.getString("photo_url"));
                list.add(mcp);
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

            if (masterclassPhotoCreate != null) {
                masterclassPhotoCreate.close();
            }

            if (masterclassPhotoRead != null) {
                masterclassPhotoRead.close();
            }

            if (masterclassPhotoUpdate != null) {
                masterclassPhotoUpdate.close();
            }

            if (masterclassPhotoDelete != null) {
                masterclassPhotoDelete.close();
            }

            if (masterclassPhotoReadAll != null) {
                masterclassPhotoReadAll.close();
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
