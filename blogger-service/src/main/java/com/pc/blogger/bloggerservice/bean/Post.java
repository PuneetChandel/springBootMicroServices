package com.pc.blogger.bloggerservice.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String content;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore // this is important otherwise we will be in infinite loop of fethcing Blogger->post and post->blogger
	private Blogger blogger;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Blogger getBlogger() {
		return blogger;
	}

	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}
	
	
}
