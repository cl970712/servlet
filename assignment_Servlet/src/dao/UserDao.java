package dao;

import entity.User;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    User getUser(String user,String pw);
    void insertInfo(String user, String pw);
    void update(String user,String pw,int id);
    void delete(int id);
    boolean login(String user,String pw);
    String reg(String user, String pw);
    List<User> getAll();

    void del(int id);
}
