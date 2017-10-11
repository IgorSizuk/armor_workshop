package com.sizuk.armorworkshop.dao.dao;



import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dto.MasterclasPhoto;

import java.util.List;



/** Объект для управления персистентным состоянием объекта MasterclasPhoto */
public interface MasterclasPhotoDao {

    /** Создает новую запись */
    void create(MasterclasPhoto masterclasPhoto) throws DAOException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    MasterclasPhoto read(int key) throws  DAOException;

    /** Сохраняет состояние объекта masterclasPhoto в базе данных */
    void update(MasterclasPhoto masterclasPhoto) throws DAOException;

    /** Удаляет запись об объекте из базы данных */
    void delete(MasterclasPhoto masterclasPhoto) throws DAOException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    List<MasterclasPhoto> getAll() throws  DAOException;

    /** Закрывает все PreparedStatementы */
    void close() throws  DAOException;
}
