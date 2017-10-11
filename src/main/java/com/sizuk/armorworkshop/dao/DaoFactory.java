package com.sizuk.armorworkshop.dao;

import com.sizuk.armorworkshop.dao.dao.*;

/** Фабрика объектов для работы с базой данных */
public interface DaoFactory {
    /** Возвращает объект для управления персистентным состоянием объекта Admin */
    AdminDao getAdminDao() throws DAOException;

    ProductionDao getProductionDao() throws DAOException;

    AlbomDescriptionDao getAlbomDescriptionDao() throws DAOException;

    AlbomPhotoDao getAlbomPhotosDao() throws DAOException;

    MasterclasDao getMasterclassDao() throws DAOException;

    MasterclasPhotoDao getMasterclassPhotoDao() throws DAOException;
}
