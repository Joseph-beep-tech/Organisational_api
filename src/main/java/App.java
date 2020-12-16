import com.google.gson.Gson;


import dao.*;
import exceptions.ApiException;
import models.DepartmentNews;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Sql2o;

import static spark.Spark.*;
import org.sql2o.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class App {
    public static void main (String[] args) {
        Sql2oDepartmentDAO DepartmentDAO;

        Sql2oUserDAO UserDAO;
        Connection conn;
        Gson gson = new Gson();
//        String connectionString = "jdbc:h2:~/NewsAPI.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        String connectionString =  ("jdbc:postgresql://localhost:5432/news");
        Sql2o sql2o = new Sql2o(connectionString, "moring", "Brook1234");
        DepartmentDAO = new Sql2oDepartmentDAO ( sql2o ) {
            @Override
            public List<Department> getDepartments() {
                return null;
            }

            @Override
            public List<Department> getAllDepartment() {
                return null;
            }



        };

        get("/", "application/json", (req, res) ->
                "{\"message\":\"Welcome to the main page of Organisation news api.\"}");
        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            NewsDAO.addGeneralNews(news);
            res.status(201);
            return gson.toJson(news);
        });

        UserDAO = new Sql2oUserDAO(sql2o);
        conn = sql2o.open();
//        CREATE
        post("/department/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            dao.DepartmentDAO.addDepartment(department);
            res.status(201);
            return gson.toJson(department);
        });
//        post("/departmentNews/new", "application/json", (req, res) -> {
//            DepartmentNews departmentNews = gson.fromJson(req.body(), DepartmentNews.class);
//            DepartmentNewsDao.add(departmentNews);
//            res.status(201);
//            return gson.toJson(departmentNews);
//        });
        post("/News/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            NewsDAO.addGeneralNews (news);
            res.status(201);
            return gson.toJson(news);
        });
        post("/user/new", "application/json", (req, res) -> {
            User users = gson.fromJson(req.body(), User.class);
            UserDAO.addUser(users);
            res.status(201);
            res.type("application/json");
            return gson.toJson(users);
        });

        get("/user", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson( UserDAO.getAllUser());//send it back to be displayed
        });
        get("/department", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(DepartmentDAO.getAllDepartment());//send it back to be displayed
        });

        get("/News", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(NewsDAO.getAllNews());//send it back to be displayed
        });

        get("/user/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            User usersToFind = dao.UserDAO.getUserById(departmentId);
            if(usersToFind == null) {
                throw new ApiException (404, String.format("No user with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(usersToFind);
        });
        get("/department/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentsToFind = dao.DepartmentDAO.getDepartmentById(departmentId );
            if (departmentsToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentsToFind );
        });

//        get("/departmentNews/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
//            int departmentNewsId = Integer.parseInt(req.params("id"));
//            DepartmentNews departmentsNewsToFind = DepartmentNewsDao.getDepartmentNewsById(departmentNewsId );
//            if (departmentsNewsToFind== null){
//                throw new ApiException(404, String.format("No department news with the id: \"%s\" exists", req.params("id")));
//            }
//            return gson.toJson(departmentsNewsToFind );
//        });
        get("/News/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int generalNewsId = Integer.parseInt(req.params("id"));
            News generalNewsToFind = NewsDAO.getNewsById(generalNewsId );
            if (generalNewsToFind== null){
                throw new ApiException(404, String.format("No news with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(generalNewsToFind );
        });
        //FILTERS
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });
        after((req, res) -> {
            res.type("application/json");
        });
    }
}