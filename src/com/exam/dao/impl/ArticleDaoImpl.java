package com.exam.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.bean.Article;
import com.exam.dao.ArticleDao;
import com.exam.util.DBUtil;

public class ArticleDaoImpl implements ArticleDao {
	private DBUtil dbUtil;

	public List<Article> getAll() {
		List<Article> list = new ArrayList<Article>();
		Article article = null;
		dbUtil = new DBUtil();
		ResultSet rs = dbUtil.commonQuery("select * from articles");
		if (rs != null) {
			try {
				while (rs.next()) {
					article = new Article();
					article.setId(rs.getInt("articleid"));
					article.setTitle(rs.getString("title"));
					article.setContents(rs.getString("contents"));
					article.setPubDate(rs.getDate("pubdate"));
					article.setPubName(rs.getString("pubname"));
					list.add(article);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtil.closeAll(dbUtil.getConn(), dbUtil.getPstmt(), rs);
			}
		}
		return null;
	}

	public void save(Article article) {
		dbUtil = new DBUtil();
		dbUtil.commonUpdate("insert into articles(title,contents,pubdate,pubname) values (?,?,?,?)", article.getTitle(),article.getContents(),article.getPubDate(),article.getPubName());
		dbUtil.closeAll(dbUtil.getConn(), dbUtil.getPstmt(), null);
	}

}
