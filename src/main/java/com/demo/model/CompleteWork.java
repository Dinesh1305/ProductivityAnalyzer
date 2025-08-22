package com.demo.model;

import java.net.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CompleteWork {
	@Id
	private Integer id;

	private String work;

	private URL url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

}
