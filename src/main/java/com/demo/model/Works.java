package com.demo.model;

import java.net.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Works {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private URL url;
	private String work;

	public Integer getId() {
		return id;
	}

	public URL getUrl() {
		return url;
	}

	public String getWork() {
		return work;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public void setWork(String work) {
		this.work = work;
	}

}
