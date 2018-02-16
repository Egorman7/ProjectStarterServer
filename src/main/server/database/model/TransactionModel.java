package main.server.database.model;

public class TransactionModel {
    private int id, project_id, user_id;
    private double value;

    public TransactionModel(int id, int project_id, int user_id, double value) {
        this.id = id;
        this.project_id = project_id;
        this.user_id = user_id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getProject_id() {
        return project_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public double getValue() {
        return value;
    }
}
