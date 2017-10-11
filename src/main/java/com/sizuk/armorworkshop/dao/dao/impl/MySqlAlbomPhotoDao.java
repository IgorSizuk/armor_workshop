package com.sizuk.armorworkshop.dao.dao.impl;



import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dao.AlbomPhotoDao;
import com.sizuk.armorworkshop.dao.dto.AlbomPhoto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MySqlAlbomPhotoDao implements AlbomPhotoDao {

    private final Connection connection;

    private final String sqlAlbomPhotosDaoCreate = "INSERT INTO `albom_photos` (`album_id`, `photo_url`) VALUES (?,?);";
    private final String sqlAlbomPhotosDaoRead = "SELECT `id`, `album_id`, `photo_url` FROM `albom_photos` WHERE id = ?;";
    private final String sqlAlbomPhotosDaoUpdate = "UPDATE `albom_photos` SET `album_id` = ?, `photo_url` =? WHERE id = ?;";
    private final String sqlAlbomPhotosDaoDelete = "DELETE from `albom_photos` where `id` = ?;";
    private final String sqlAlbomPhotosDaoReadAll = "SELECT `id`, `album_id`, `photo_url` FROM `albom_photos`;";

    private PreparedStatement albomPhotosDaoCreate = null;
    private PreparedStatement albomPhotosDaoRead = null;
    private PreparedStatement albomPhotosDaoUpdate = null;
    private PreparedStatement albomPhotosDaoDelete = null;
    private PreparedStatement albomPhotosDaoReadAll = null;

    public MySqlAlbomPhotoDao(Connection connection) throws SQLException, DAOException {
        this.connection = connection;
    }

    @Override
    public void create(AlbomPhoto albomPhoto) throws DAOException {
        try {
            if(albomPhotosDaoCreate == null){
                albomPhotosDaoCreate = connection.prepareStatement(sqlAlbomPhotosDaoCreate);
            }
            albomPhotosDaoCreate.setInt(1, albomPhoto.getAlbumId());
            albomPhotosDaoCreate.setString(2, albomPhoto.getPhotoUrl());
            albomPhotosDaoCreate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public AlbomPhoto read(int key) throws DAOException {
        ResultSet rs = null;
        AlbomPhoto ap = new AlbomPhoto();
        try {
            if(albomPhotosDaoRead == null){
                albomPhotosDaoRead = connection.prepareStatement(sqlAlbomPhotosDaoRead);
            }
            albomPhotosDaoRead.setInt(1, key);
            rs = albomPhotosDaoRead.executeQuery();
            rs.next();
            ap.setId(rs.getInt("id"));
            ap.setAlbumId(rs.getInt("album_id"));
            ap.setPhotoUrl(rs.getString("photo_url"));
        }catch (SQLException e){
            throw new DAOException(e);
        } finally {
            try {
                rs.close();
            }catch (SQLException e) {
                throw new DAOException(e);
            }
        }
        return ap;
    }

    @Override
    public void update(AlbomPhoto albomPhoto) throws DAOException {
        try {
            if(albomPhotosDaoUpdate == null){
                albomPhotosDaoUpdate = connection.prepareStatement(sqlAlbomPhotosDaoUpdate);
            }
            albomPhotosDaoUpdate.setInt(1, albomPhoto.getAlbumId());
            albomPhotosDaoUpdate.setString(2, albomPhoto.getPhotoUrl());
            albomPhotosDaoUpdate.setInt(3, albomPhoto.getId());
            albomPhotosDaoUpdate.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(AlbomPhoto albomPhoto) throws DAOException {
        try {
            if(albomPhotosDaoDelete == null){
                albomPhotosDaoDelete = connection.prepareStatement(sqlAlbomPhotosDaoDelete);
            }
            albomPhotosDaoDelete.setInt(1, albomPhoto.getId());
            albomPhotosDaoDelete.executeUpdate();
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public List<AlbomPhoto> getAll() throws DAOException {
        ResultSet rs = null;
        List<AlbomPhoto> list = new ArrayList<AlbomPhoto>();
        try {
            if(albomPhotosDaoReadAll == null){
                albomPhotosDaoReadAll = connection.prepareStatement(sqlAlbomPhotosDaoReadAll);
            }
            rs = albomPhotosDaoReadAll.executeQuery();
            while (rs.next()) {
                AlbomPhoto ap = new AlbomPhoto();
                ap.setId(rs.getInt("id"));
                ap.setAlbumId(rs.getInt("album_id"));
                ap.setPhotoUrl(rs.getString("photo_url"));
                list.add(ap);
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

            if (albomPhotosDaoCreate != null) {
                albomPhotosDaoCreate.close();
            }

            if (albomPhotosDaoRead != null) {
                albomPhotosDaoRead.close();
            }

            if (albomPhotosDaoUpdate != null) {
                albomPhotosDaoUpdate.close();
            }

            if (albomPhotosDaoDelete != null) {
                albomPhotosDaoDelete.close();
            }

            if (albomPhotosDaoReadAll != null) {
                albomPhotosDaoReadAll.close();
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
