package com.prokarma.ejercitacion.dto;

import java.util.ArrayList;

public class User {

	private String name;
	private ArrayList<PlayList> playlists;
	
	public User(String name) {
		this.name = name;
		this.playlists = new ArrayList<PlayList>();
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<PlayList> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(ArrayList<PlayList> playlists) {
		this.playlists = playlists;
	}
	
	
	public String toString() {
		return "Name: " + this.name + 
			   "PlayLists: " + this.playlists.toString();
	}
	
}
