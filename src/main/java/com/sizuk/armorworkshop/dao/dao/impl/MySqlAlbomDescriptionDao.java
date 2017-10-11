package com.sizuk.armorworkshop.dao.dao.impl;



import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dao.AlbomDescriptionDao;
import com.sizuk.armorworkshop.dao.dto.AlbomDescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MySqlAlbomDescriptionDao implements AlbomDescriptionDao {

    private final Connection connection;

    private final String sqlAlbomDescriptionCreate = "INSERT INTO `albom_description` (`album_id`, `description`) VALUES (?,?);";
    private final String sqlAlbomDescriptionRead = "SELECT `id`, `album_id`, `description` FROM `albom_description` WHERE id = ?;";
    private final String sqlAlbomDescriptionUpdate = "UPDATE `albom_description` SET `album_id` = ?, `description` =? WHERE id = ?;";
    private final String sqlAlbomDescriptionDelete = "DELETE from `albom_description` where `id` = ?;";
    private final String sqlAlbomDescriptionReadAll = "SELECT `id`, `album_id`, `description` FROM `albom_description`;";

    private PreparedStatement albomDescriptionCreate = null;
    private PreparedStatement albomDescriptionRead = null;
    private PreparedStatement albomDescriptionUpdate = null;
    private PreparedStatement albomDescriptionDelete = null;
    private PreparedStatement albomDescriptionReadAll = null;

    public MySqlAlbomDescriptionDao(Connection connection) throws SQLException, DAOException {
        this.connection = connection;
    }

    @Override
    public void create(AlbomDescription albomDescription) throws DAOException {
        try {
            if(albomDescriptionCreate == null){
                albomDescriptionCreate = connection.prepareStatement(sqlAlbomDescriptionCreate);
            }
            albomDescriptionCreate.setInt(1, albomDescription.getAlbumId());
            albomDescriptionCreate.setString(2, albomDescription.getDescription());
            albomDescriptionCreate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public AlbomDescription read(int key) throws DAOException {
        ResultSet rs = null;
        AlbomDescription ad = new AlbomDescription();
        try {
            if(albomDescriptionRead == null){
                albomDescriptionRead = connection.prepareStatement(sqlAlbomDescriptionRead);
            }
            albomDescriptionRead.setInt(1, key);
            rs = albomDescriptionRead.executeQuery();
            rs.next();
            ad.setId(rs.getInt("id"));
            ad.setAlbumId(rs.getInt("album_id"));
            ad.setDescription(rs.getString("description"));
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
    public void update(AlbomDescription albomDescription) throws DAOException {
        try {
            if(albomDescriptionUpdate == null){
                albomDescriptionUpdate = connection.prepareStatement(sqlAlbomDescriptionUpdate);
            }
            albomDescriptionUpdate.setInt(1, albomDescription.getAlbumId());
            albomDescriptionUpdate.setString(2, albomDescription.getDescription());
            albomDescriptionUpdate.setInt(3, albomDescription.getId());
            albomDescriptionUpdate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(AlbomDescription albomDescription) throws DAOException {
        try {
            if(albomDescriptionDelete == null){
                albomDescriptionDelete = connection.prepareStatement(sqlAlbomDescriptionDelete);
            }
            albomDescriptionDelete.setInt(1, albomDescription.getId());
            albomDescriptionDelete.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public List<AlbomDescription> getAll() throws DAOException {
        ResultSet rs = null;
        List<AlbomDescription> list = new ArrayList<AlbomDescription>();
        try {
            if(albomDescriptionReadAll == null){
                albomDescriptionReadAll = connection.prepareStatement(sqlAlbomDescriptionReadAll);
            }
            rs = albomDescriptionReadAll.executeQuery();
            while (rs.next()) {
                AlbomDescription ad = new AlbomDescription();
                ad.setId(rs.getInt("id"));
                ad.setAlbumId(rs.getInt("album_id"));
                ad.setDescription(rs.getString("description"));
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
    public void close() throws DAOException {
        try {

            if (albomDescriptionCreate != null) {
                albomDescriptionCreate.close();
            }

            if (albomDescriptionRead != null) {
                albomDescriptionRead.close();
            }

            if (albomDescriptionUpdate != null) {
                albomDescriptionUpdate.close();
            }

            if (albomDescriptionDelete != null) {
                albomDescriptionDelete.close();
            }

            if (albomDescriptionReadAll != null) {
                albomDescriptionReadAll.close();
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
