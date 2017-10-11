package com.sizuk.armorworkshop.dao.dao;



import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dto.AlbomDescription;
import java.util.List;



/** ������ ��� ���������� ������������� ���������� ������� AlbomDescription */
public interface AlbomDescriptionDao {

    /** ������� ����� ������ */
    void create(AlbomDescription albomDescription) throws DAOException;

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
    AlbomDescription read(int key) throws DAOException;

    /** ��������� ��������� ������� albomDescription � ���� ������ */
    void update(AlbomDescription albomDescription) throws DAOException;

    /** ������� ������ �� ������� �� ���� ������ */
    void delete(AlbomDescription albomDescription) throws DAOException;

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
    List<AlbomDescription> getAll() throws DAOException;

    /** ��������� ��� PreparedStatement� */
    void close() throws DAOException;
}
