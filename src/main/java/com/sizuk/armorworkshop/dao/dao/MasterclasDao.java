package com.sizuk.armorworkshop.dao.dao;



import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dto.Masterclas;

import java.util.List;



/** Объект для управления персистентным состоянием объекта Masterclas */
public interface MasterclasDao {

    /** Создает новую запись */
    void create(Masterclas masterclas) throws DAOException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    Masterclas read(int key) throws  DAOException;

    /** Сохраняет состояние объекта masterclas в базе данных */
    void update(Masterclas masterclas) throws DAOException;

    /** Удаляет запись об объекте из базы данных */
    void delete(Masterclas masterclas) throws DAOException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    List<Masterclas> getAll() throws  DAOException;

    /** Закрывает все PreparedStatementы */
    void close() throws  DAOException;
}
