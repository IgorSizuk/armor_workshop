package com.sizuk.armorworkshop.dao.dao;



import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dto.Production;

import java.util.List;



/** Объект для управления персистентным состоянием объекта Production */
public interface ProductionDao {
    /** Создает новую запись */
    void create(Production production) throws DAOException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    Production read(int key) throws DAOException;

    /** Сохраняет состояние объекта production в базе данных */
    void update(Production production) throws DAOException;

    /** Удаляет запись об объекте из базы данных */
    void delete(Production production) throws DAOException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    List<Production> getAll() throws DAOException;

    /** Закрывает все PreparedStatementы */
    void close() throws DAOException;
}
