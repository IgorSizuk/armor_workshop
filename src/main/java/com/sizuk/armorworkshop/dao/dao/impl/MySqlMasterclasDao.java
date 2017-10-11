package com.sizuk.armorworkshop.dao.dao.impl;



import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dao.MasterclasDao;
import com.sizuk.armorworkshop.dao.dto.Masterclas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MySqlMasterclasDao implements MasterclasDao {


    private final Connection connection;

    private final String sqlMasterclassCreate = "INSERT INTO `master_class` (`master_class_name`, `master_class_text`) VALUES (?,?);";
    private final String sqlMasterclassRead = "SELECT `id`, `master_class_name`, `master_class_text` FROM `master_class` WHERE id = ?;";
    private final String sqlMasterclassUpdate = "UPDATE `master_class` SET `master_class_name` = ?, `master_class_text` =? WHERE id = ?;";
    private final String sqlMasterclassDelete = "DELETE from `master_class` where `id` = ?;";
    private final String sqlMasterclassReadAll = "SELECT `id`, `master_class_name`, `master_class_text` FROM `master_class`;";

    private PreparedStatement masterclassCreate = null;
    private PreparedStatement masterclassRead = null;
    private PreparedStatement masterclassUpdate = null;
    private PreparedStatement masterclassDelete = null;
    private PreparedStatement masterclassReadAll = null;

    public MySqlMasterclasDao(Connection connection) throws SQLException, DAOException {
        this.connection = connection;
    }

    @Override
    public void create(Masterclas masterclas) throws DAOException {
        try {
            if(masterclassCreate == null){
                masterclassCreate = connection.prepareStatement(sqlMasterclassCreate);
            }
            masterclassCreate.setString(1, masterclas.getMasterclassName());
            masterclassCreate.setString(2, masterclas.getMasterclassText());
            masterclassCreate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public Masterclas read(int key) throws DAOException {
        ResultSet rs = null;
        Masterclas mc = new Masterclas();
        try {
            if(masterclassRead == null){
                masterclassRead = connection.prepareStatement(sqlMasterclassRead);
            }
            masterclassRead.setInt(1, key);
            rs = masterclassRead.executeQuery();
            rs.next();
            mc.setId(rs.getInt("id"));
            mc.setMasterclassName(rs.getString("master_class_name"));
            mc.setMasterclassText(rs.getString("master_class_text"));
        }catch (SQLException e){
            throw new DAOException(e);
        } finally {
            try {
                rs.close();
            }catch (SQLException e) {
                throw new DAOException(e);
            }
        }
        return mc;
    }

    @Override
    public void update(Masterclas masterclas) throws DAOException {
        try {
            if(masterclassUpdate == null){
                masterclassUpdate = connection.prepareStatement(sqlMasterclassUpdate);
            }
            masterclassUpdate.setString(1, masterclas.getMasterclassName());
            masterclassUpdate.setString(2, masterclas.getMasterclassText());
            masterclassUpdate.setInt(3, masterclas.getId());
            masterclassUpdate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(Masterclas masterclas) throws DAOException {
        try {
            if(masterclassDelete == null){
                masterclassDelete = connection.prepareStatement(sqlMasterclassDelete);
            }
            masterclassDelete.setInt(1, masterclas.getId());
            masterclassDelete.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public List<Masterclas> getAll() throws DAOException {
        ResultSet rs = null;
        List<Masterclas> list = new ArrayList<Masterclas>();
        try {
            if(masterclassReadAll == null){
                masterclassReadAll = connection.prepareStatement(sqlMasterclassReadAll);
            }
            rs = masterclassReadAll.executeQuery();
            while (rs.next()) {
                Masterclas mc = new Masterclas();
                mc.setId(rs.getInt("id"));
                mc.setMasterclassName(rs.getString("master_class_name"));
                mc.setMasterclassText(rs.getString("master_class_text"));
                list.add(mc);
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

            if (masterclassCreate != null) {
                masterclassCreate.close();
            }

            if (masterclassRead != null) {
                masterclassRead.close();
            }

            if (masterclassUpdate != null) {
                masterclassUpdate.close();
            }

            if (masterclassDelete != null) {
                masterclassDelete.close();
            }

            if (masterclassReadAll != null) {
                masterclassReadAll.close();
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
