package com.prokarma.ejercitacion.dto;

import java.util.ArrayList;

public class PlayList extends SongContainer{

	private String name;
	private ArrayList<Song> songs;
	
	public PlayList(String name) {
		super(name);
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
	
	
	@Override
	public String toString() {
		return super.toString();
	}
}
