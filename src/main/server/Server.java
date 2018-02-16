package main.server;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Server {
    private static int PORT = 1488;
    private static String ACCEPT_TYPE="application/json";
    public Server() {

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
        get("/kek", ACCEPT_TYPE, (req, res) -> {
            Map<String, String> map = new HashMap<String,String>();
            map.put("Kek", "Lol");
            Log.d("KEK", req.ip() + " connected!");
            return map;
        }, new JsonTransformer());
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
