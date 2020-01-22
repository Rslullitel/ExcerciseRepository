package com.prokarma.ejercitacion.dto;

import java.util.ArrayList;

public abstract class SongContainer {

	private String name;
	private ArrayList<Song> songs;
	
	public SongContainer(String name) {
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
