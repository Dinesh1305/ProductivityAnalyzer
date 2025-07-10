package com.demo.model;

import java.net.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Problems  {

	
	@Id 
	private String name;
	
	private URL  url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
}
