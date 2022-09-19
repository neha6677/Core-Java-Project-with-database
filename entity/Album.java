package com.yash.app.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album {
	
		@Id
	    private String name;
	    private String artist;
		public Album(String name, String artist) {
			super();
			this.name = name;
			this.artist = artist;
		}
		public Album() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getArtist() {
			return artist;
		}
		public void setArtist(String artist) {
			this.artist = artist;
		}
		@Override
		public String toString() {
			return "Album [name=" + name + ", artist=" + artist + "]";
		}
	   
	    
}
