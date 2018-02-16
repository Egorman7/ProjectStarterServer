package main.server;

import main.server.database.Connector;
import main.server.database.connection.ConnectionHelper;
import main.server.database.model.ProjectModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Server {
    private static int PORT = 1488;
    private static String ACCEPT_TYPE="application/json";
    private Connector connector;
    public Server() {
        connector = new Connector(new ConnectionHelper());
    }
    public void start(){
        try {
            port(PORT);
            Log.d("SERVER", "Server on port " + PORT + " started!");
            setUpRoutes();
        } catch (Exception ex){
            Log.e(ex.getMessage());
        }
    }

    private void setUpRoutes(){
        path("/projects", () -> {
            get("/new", ACCEPT_TYPE, (req, res) -> {
                List<ProjectModel> projects = connector.getProjects(Connector.PROJ_NEW);
                Log.d("[GET_PROJECTS_NEW]",req.ip() + " " + req.host() + " got new projects!");
                return projects;
            }, new JsonTransformer());
        });
    }

    public void stop(){
        try {
            //stop();
            Log.d("SERVER", "Server stopped! Shut down in 2 sec!");
        } catch (Exception ex){
            Log.e(ex.getMessage());
        }
    }
}
