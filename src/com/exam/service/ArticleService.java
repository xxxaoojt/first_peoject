package com.exam.service;

import java.util.List;

import com.exam.bean.Article;

public interface ArticleService {

	List<Article> getAll();

	void save(Article article);

}
