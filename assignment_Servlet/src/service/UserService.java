package service;

import entity.User;

import java.util.List;

public interface UserService {
    boolean login(String user,String pw);
    String reg(String user,String pw);
    List<User>  getAll();

    void del(int id);
}
