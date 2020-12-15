package dao;

import models.DepartmentNews;
import models.News;

import java.util.List;

public interface NewsDAO{
    static List<News> getAllNews() {
        return null;
    }

    static News getNewsById(int generalNewsId) {
        return null;
    }

    static void add(News generalNews) {
    }

//    List<News> getAllNews();

    List<News> getGeneralNews();
    List<DepartmentNews> getDepartmentNews();
//
//static void addGeneralNews(News news);

    static void addGeneralNews(News news) {

    }


    void addDepartmentNews(DepartmentNews departmentNews);
//    void add();
    News findGeneralNewsById(int id);
    DepartmentNews findDepartmentNewsById(int id);



    void updateGeneralNews(News news, int userId, String content);
    void updateDepartmentNews(DepartmentNews dptNews, int userId, String content, int departmentId);


    void clearAllNews();
    void clearGeneralNews();
    void clearDepartmentNews();
}


