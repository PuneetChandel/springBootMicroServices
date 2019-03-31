package com.pc.blogger.bloggerservice.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;




@Entity
public class Blogger {

	@Id // for primary key
	@GeneratedValue
	private Integer id;
	
	@Size(min=4,max=25)
	private String name;
	
	@OneToMany(mappedBy="blogger")
	private List<Post> posts;
	
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Blogger(Integer id, @Size(min = 4, max = 25) String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public Blogger()
	{
		
	}
	
}
