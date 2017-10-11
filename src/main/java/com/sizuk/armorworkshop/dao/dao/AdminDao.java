package com.sizuk.armorworkshop.dao.dao;



import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dto.Admin;
import java.util.List;



/** ������ ��� ���������� ������������� ���������� ������� Admin */
public interface AdminDao {
    /** ������� ����� ������ */
    void create(Admin admin) throws DAOException;

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
    Admin read(int key) throws DAOException;

    /** ��������� ��������� ������� admin � ���� ������ */
    void update(Admin admin) throws DAOException;

    /** ������� ������ �� ������� �� ���� ������ */
    void delete(Admin admin) throws DAOException;

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
    List<Admin> getAll() throws DAOException;

    Admin check(String login) throws DAOException;

    /** ��������� ��� PreparedStatement� */
    void close() throws DAOException;
}

