package com.demo.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Problems  {

	
	@Id 
	private String name;
	
	private String  url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
