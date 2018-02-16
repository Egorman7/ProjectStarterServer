package main.server.database;

import main.server.database.connection.ConnectionHelper;
import main.server.database.model.CommentModel;
import main.server.database.model.ProjectModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Connector implements IConnector {
    // table names
    private static final String PROJ_TABLE = "projects";


    private static String PROJ_ID = "id", PROJ_TITLE = "title", PROJ_DESC = "description", PROJ_IMG = "img", PROJ_ACC = "id_account", PROJ_DATE_S = "date_start",
            PROJ_DATE_E = "date_end", PROJ_DONE = "isdone";
    public static final int PROJ_NEW = 1, PROJ_TOP = 2, PROJ_SUCCESS = 3, PROJ_FAILED = 4;

    private ConnectionHelper connectionHelper;

    public Connector(ConnectionHelper connectionHelper) {
        this.connectionHelper = connectionHelper;
    }

    @Override
    public List<ProjectModel> getProjects(int type) {
        String query = "select * from " + PROJ_TABLE;
        switch (type){
            case PROJ_NEW:
                query += " where " + PROJ_DONE + " = false order by " + PROJ_DATE_S + " desc;";
                break;
            case PROJ_TOP:

                break;
            case PROJ_SUCCESS:
                query += " where " + PROJ_DONE + " = true order by " + PROJ_DATE_E + " desc;";
                break;
            case PROJ_FAILED:
                String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                query += " where " + PROJ_DONE + " = false and " + PROJ_DATE_E + " = '" + currentDate + "' order by " + PROJ_DATE_E + " desc;";
                break;
        }
        return connectionHelper.selectQuery(query, res -> {
            List<ProjectModel> projects = new ArrayList<>();
            while (res.next()){
                projects.add(new ProjectModel(res.getInt(PROJ_ID),
                        res.getString(PROJ_TITLE),
                        res.getString(PROJ_DESC),
                        "image",
                        res.getInt(PROJ_ACC),
                        res.getDate(PROJ_DATE_S).toString(),
                        res.getDate(PROJ_DATE_E).toString(),
                        res.getBoolean(PROJ_DONE)));
            }
            return projects;
        });
    }

    @Override
    public List<CommentModel> getComments(int project_id) {
        return null;
    }
}
