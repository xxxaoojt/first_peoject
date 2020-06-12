package com.exam.service.impl;

import java.util.List;

import com.exam.bean.Article;
import com.exam.dao.ArticleDao;
import com.exam.dao.impl.ArticleDaoImpl;
import com.exam.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
	private ArticleDao articleDao = new ArticleDaoImpl();

	public List<Article> getAll() {
		return articleDao.getAll();
	}

	public void save(Article article) {
		articleDao.save(article);		
	}
}
