package com.exam.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.bean.Article;
import com.exam.service.ArticleService;
import com.exam.service.impl.ArticleServiceImpl;

public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleService articleService =new ArticleServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String me = request.getParameter("me");
		if ("list".equals(me)) {
			list(request, response);
		}
		if ("addUI".equals(me)) {
			addUI(request, response);
		}
		if ("add".equals(me)) {
			add(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles =articleService.getAll();
		request.setAttribute("articles", articles);
		System.out.println(articles.toString());
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("addUI.jsp");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tile = request.getParameter("title");
		String contents = request.getParameter("contents");
		String pubname = request.getParameter("pubname");
		if(tile==null || contents==null || pubname==null) {
			response.sendRedirect("article?method=list");
			return;
		}
		Article article = new Article();
		article.setTitle(formatStr(tile,"iso8859-1"));
		article.setContents(formatStr(contents,"iso8859-1"));
		article.setPubName(formatStr(pubname,"iso8859-1"));
		article.setPubDate(new Date());
		System.out.println(article);
		articleService.save(article);
		response.sendRedirect("article?me=list");
	}

	private String formatStr(String source, String fmt) throws UnsupportedEncodingException {
		byte[] bytes = source.getBytes(fmt);
		return new String(bytes,"UTF-8");
	}

}
