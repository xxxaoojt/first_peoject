package com.exam.bean;

import java.util.Date;

public class Article {
	private Integer id;
	private String title;
	private String contents;
	private Date pubDate;
	private String pubName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getPubName() {
		return pubName;
	}
	public void setPubName(String pubName) {
		this.pubName = pubName;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", contents=" + contents + ", pubDate=" + pubDate
				+ ", pubName=" + pubName + "]";
	}
}
