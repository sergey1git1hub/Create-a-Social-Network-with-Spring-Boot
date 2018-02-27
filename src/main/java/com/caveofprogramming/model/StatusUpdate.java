package com.caveofprogramming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="status_update")
public class StatusUpdate {
	
	//fields
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Override
	public String toString() {
		return "StatusUpdate [id=" + id + ", text=" + text + ", added=" + added + "]";
	}
	@Column(name="text")
	private String text;
	
	@Column(name="added")
	@Temporal(TemporalType.TIMESTAMP)
	private Date added;
	
	@PrePersist
	protected void onCreate(){
		if(added==null){
			added=new Date();
		}
	}
	
	
	public StatusUpdate() {
	
	}


	//constructors
	public StatusUpdate(String text) {
		this.text = text;
	}
	public StatusUpdate(String text, Date added) {
		this.text = text;
		this.added = added;
	}
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getAdded() {
		return added;
	}
	public void setAdded(Date added) {
		this.added = added;
	}


}
