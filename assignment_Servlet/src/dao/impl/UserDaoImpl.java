package dao.impl;

import dao.UserDao;
import entity.User;
import util.Base;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public User getUser(String user, String pw) {
        //获取数据库连接
        Connection conn = getConn();
        //sql语句
        String sql = "select * from login where user = ? and pw = ?";

        try {
            //创建一个ps,执行sql语句
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pw);

            //创建一个rs，保存查询的数据
            ResultSet rs = ps.executeQuery();
            //遍历循环输出数据

            User usr = new User();
            while(rs.next()){

                String username = rs.getString("user");
                String password = rs.getString("pw");

                System.out.println(user);
                System.out.println(pw);
                //将数据返回给User中，返回给servlet

                usr.setUser(username);
                usr.setPw(password);

            }
            return usr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean login(String user, String pw) {
        Connection conn = getConn();

       String sql = "select * from login where user=? and pw=?";

        try {
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pw);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                ps.close();
                rs.close();;
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public String reg(String user, String pw) {
        Connection conn = getConn();

        String sql1= "select * from login where user = ?";
        String sql = "insert into login(user,pw) values (?,?)";



        try {
            PreparedStatement pss = conn.prepareStatement(sql1);
            pss.setString(1,user);
            ResultSet rs = pss.executeQuery();
            if (!rs.next()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,user);
                ps.setString(2,pw);
                ps.executeUpdate();

                return Base.registerSuccess;
            }else{

            return Base.registerFalse;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Base.registerFalse;
    }

    @Override
    public List<User> getAll() {

        Connection conn = getConn();

        String sql = "select * from login";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<User> userList = new ArrayList<>();
            while(rs.next()) {
                User user1 = new User();
                user1.setId(rs.getInt("id"));
                user1.setUser(rs.getString("user"));
                user1.setPw(rs.getString("pw"));
                userList.add(user1);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection getConn() {
        ConnectionUtil connectionUtil = new ConnectionUtil();
        return connectionUtil.getConn();
    }

    @Override
    public void del(int id) {
        //获取连接
        Connection conn = getConn();
        //sql语句
        String sql = "delete from login where id = ?";
        //ps
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertInfo(String user, String pw){
        //获取数据库连接
        Connection conn = getConn();
        //sql语句
        String sql = "insert into login(user,pw) values (?,?)";
        //执行sql语句
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pw);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String user,String pw,int id){
        //获取连接
        Connection conn = getConn();
        //sql语句
        String sql = "update login set user = ?,pw = ? where id = ?";
        //ps
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //设置参数
            ps.setString(1,user);
            ps.setString(2,pw);
            ps.setInt(3,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        //获取连接
        Connection conn = getConn();
        //sql语句
        String sql = "delete from login where id = ?";
        //ps
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
      UserDaoImpl ud = new UserDaoImpl();
        List<User> list = ud.getAll();
        System.out.println(list);
    }
}
