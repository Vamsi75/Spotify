package com.mycompany.springboot.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Songs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int songid;
	private String songName;
	private String dor;
	private String coverimage;
	public Songs() {}
	
	public Songs(int songid, String songName, String dor, String coverimage) {
		super();
		this.songid = songid;
		this.songName = songName;
		this.dor = dor;
		this.coverimage = coverimage;
	}

	public int getSongid() {
		return songid;
	}
	public void setSongid(int songid) {
		this.songid = songid;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String name) {
		songName = name;
	}
	public String getDor() {
		return dor;
	}
	public void setDor(String dor) {
		this.dor = dor;
	}
	public String getCoverimage() {
		return coverimage;
	}
	public void setCoverimage(String coverimage) {
		this.coverimage = coverimage;
	}
	
	
	
}
