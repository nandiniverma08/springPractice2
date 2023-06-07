package com.learningsecurity.myproject.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Post")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Message")
	private String message;
	
	@Column(name="Description")
	private String description;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
	@Temporal(TemporalType.DATE)
    @Column(name = "Created Date and Time", nullable = false,insertable = false, updatable=false, columnDefinition = "datetime DEFAULT now()")
    private Date created;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private Set<Comment> comments=new HashSet<>();

	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getCreated() {
		return created;
	}



	public void setCreated(Date created) {
		this.created = created;
	}



	public Set<Comment> getComments() {
		return comments;
	}



	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}



	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", message=" + message + ", description=" + description
				+ ", created=" + created + ", comments=" + comments + "]";
	}
	
	
}
