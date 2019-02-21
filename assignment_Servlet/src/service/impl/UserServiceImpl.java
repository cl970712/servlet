package service.impl;

import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public boolean login(String user, String pw) {

        return userDao.login(user,pw);
    }

    @Override
    public String reg(String user, String pw) {
        return userDao.reg(user,pw);
    }

    @Override
    public List<User>  getAll() {
       return userDao. getAll();
    }

    @Override
    public void del(int id) {
        userDao.del(id);
    }

}
