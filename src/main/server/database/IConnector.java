package main.server.database;

import main.server.database.model.CommentModel;
import main.server.database.model.ProjectModel;

import java.util.List;

interface IConnector {
    public List<ProjectModel> getProjects(int type);
    public List<CommentModel> getComments(int project_id);
}
