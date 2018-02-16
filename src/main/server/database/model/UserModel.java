package main.server.database.model;

public class UserModel {
    private int id, account;
    private String name, sname, fname, login, pass;

    public UserModel(int id, int account, String name, String sname, String fname, String login, String pass) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.sname = sname;
        this.fname = fname;
        this.login = login;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public int getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getSname() {
        return sname;
    }

    public String getFname() {
        return fname;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
}
