package dao;

import models.DepartmentNews;
import models.News;

import java.util.List;

public interface NewsDAO{
    List<News> getAllNews();
    List<News> getGeneralNews();
    List<DepartmentNews> getDepartmentNews();
}


