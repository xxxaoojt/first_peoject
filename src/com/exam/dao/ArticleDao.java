package com.exam.dao;

import java.util.List;

import com.exam.bean.Article;

public interface ArticleDao {

	List<Article> getAll();

	void save(Article article);

}
