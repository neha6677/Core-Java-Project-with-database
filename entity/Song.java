package com.yash.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

public class Song {
	
	@Id
	@Column(name="title")
	private String title;
	
	@Column(name="songduration")
    private double duration;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "album")
	private Album album;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(String title, double duration, Album album) {
		super();
		this.title = title;
		this.duration = duration;
		this.album = album;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", duration=" + duration + ", album=" + album + "]";
	}
	
	   

}
