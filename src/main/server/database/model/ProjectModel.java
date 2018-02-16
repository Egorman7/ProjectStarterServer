package main.server.database.model;

public class ProjectModel {
    private int id;
    private String title,
        description,
        imgpath;
    private int id_account;
    private String date_start;
    private String date_end;
    private boolean isdone;

    public ProjectModel(int id, String title, String description, String imgpath, int id_account, String date_start, String date_end, boolean isdone) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgpath = imgpath;
        this.id_account = id_account;
        this.date_start = date_start;
        this.date_end = date_end;
        this.isdone = isdone;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImgpath() {
        return imgpath;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return id_account;
    }

    public String getDateStart() {
        return date_start;
    }

    public String getDateEnd() {
        return date_end;
    }

    public boolean isIsdone() {
        return isdone;
    }
}
