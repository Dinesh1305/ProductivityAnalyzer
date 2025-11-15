package com.demo.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LeetCodeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String lang;

	private String status;

	@CreationTimestamp
	private Timestamp time;

	private String title;

	private String titleSlug;

	public Integer getId() {
		return id;
	}

	public String getLang() {
		return lang;
	}

	public String getStatus() {
		return status;
	}

	public Timestamp getTime() {
		return time;
	}

	public String getTitle() {
		return title;
	}

	public String getTitleSlug() {
		return titleSlug;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitleSlug(String titleSlug) {
		this.titleSlug = titleSlug;
	}

}
