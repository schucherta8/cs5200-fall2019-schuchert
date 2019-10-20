package edu.northeastern.cs5200.model;

public enum Role {
	OWNER(1), ADMIN(2), WRITER(3), EDITOR(4), REVIEWER(5);
	
	private int id;
	private Role(int id) {
		this.id = id;
	}
	public int getId(){
		return id;
	}
}
