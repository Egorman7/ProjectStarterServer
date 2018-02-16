package main.server.database.model;

import java.util.Date;

public class CommentModel {
    private int id, project_id, user_id;
    private Date date;
    private String content;

    public CommentModel(int id, int project, int user, Date date, String content) {
        this.id = id;
        this.project_id = project;
        this.user_id = user;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getProjectId() {
        return project_id;
    }

    public int getUserId() {
        return user_id;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}
