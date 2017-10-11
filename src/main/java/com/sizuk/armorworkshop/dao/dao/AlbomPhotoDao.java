package com.sizuk.armorworkshop.dao.dao;



import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dto.AlbomPhoto;

import java.util.List;



/** Объект для управления персистентным состоянием объекта AlbomPhoto */
public interface AlbomPhotoDao {

    /** Создает новую запись */
    void create(AlbomPhoto albomPhoto) throws DAOException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    AlbomPhoto read(int key) throws DAOException;

    /** Сохраняет состояние объекта albomPhoto в базе данных */
    void update(AlbomPhoto albomPhoto) throws DAOException;

    /** Удаляет запись об объекте из базы данных */
    void delete(AlbomPhoto albomPhoto) throws DAOException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    List<AlbomPhoto> getAll() throws DAOException;

    /** Закрывает все PreparedStatementы */
    void close() throws DAOException;
}
