package com.yash.app.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.yash.app.dao.SongDao;
import com.yash.app.entity.Album;
import com.yash.app.entity.Song;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		SongDao sd = new SongDao();
		//Song song = new Song("song2", 5, new Album("album2", "artist2"));
		//sd.saveSong(song);
		 
		/*
		 * //get song by title Song songByTitle = sd.getSongByTitle("song2");
		 * System.out.println(songByTitle);
		 */ 
		
		 //add a song
		/* Album album1 = new Album("My Album", "Akon");
		 Song song = new Song("Beautiful", 4.0, album1);
		 sd.saveSong(song);
		 System.out.println(song);*/
		 
		
		 //update the song
		
		
			/*
			 * Song song1 = sd.getSongByTitle("song2"); song1.setDuration(2.0);
			 * song1.setAlbum(new Album("updated", "New Artist")); boolean updateSong =
			 * sd.updateSong(song1); System.out.println(updateSong);
			 * 
			 */
		
		 //retrive
			/*
			 * List<Song> allSong = sd.getAllSong();
			 * allSong.forEach(n->System.out.println(n)); System.out.println("done");
			 */
		
		//delete
		
		Song songtodelete = sd.getSongByTitle("song1");
		System.out.println(songtodelete);
		sd.delete(songtodelete);
		System.out.println("done");
	
	}

	
}
	
	
	