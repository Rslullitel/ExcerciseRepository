package com.prokarma.ejercitacion.dto;

import java.util.ArrayList;

public class Artist {

	private String artisticName;
	private ArrayList<Disc> discs;
	
	public Artist(String artisticName) {
		this.artisticName = artisticName;
		this.discs = new ArrayList<Disc>();
	}
	
	public String getArtisticName() {
		return artisticName;
	}
	public void setArtisticName(String artisticName) {
		this.artisticName = artisticName;
	}
	public ArrayList<Disc> getDiscs() {
		return discs;
	}
	public void setDiscs(ArrayList<Disc> discs) {
		this.discs = discs;
	}
	
	
	public String toString() {
		return "Artistic name: " + this.artisticName + 
			   "Discs: " + this.discs.toString();
	}
	
}
