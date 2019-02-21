package entity;

public class User {
    String user;
    String pw;
    int id;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", pw='" + pw + '\'' +
                ", id=" + id +
                '}';
    }
}
