package com.prokarma.ejercitacion.ej8;

import java.util.ArrayList;

public class PlayList {

	private String name;
	private ArrayList<Song> songs;
	
	public PlayList(String name) {
		this.name = name;
		this.songs = new ArrayList<Song>();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Song> getSongs() {
		return songs;
	}
	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}
	
	
	public String toString() {
		return "Name: " + this.name + 
			   "Songs: " + this.songs.toString();
	}
}
