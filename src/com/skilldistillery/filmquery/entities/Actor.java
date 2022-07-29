package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class Actor {

	private int actorID;
	private String fName;
	private String lName;
	
	public Actor(int actorID, String fName, String lName) {
		super();
		this.actorID = actorID;
		this.fName = fName;
		this.lName = lName;
	}
	
	
	
	

	@Override
	public String toString() {
		return "Actor [actorID=" + actorID + ", fName=" + fName + ", lName=" + lName + "]";
	}
	
	public int getActorID() {
		return actorID;
	}
	public void setActorID(int actorID) {
		this.actorID = actorID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(actorID, fName, lName);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return actorID == other.actorID && Objects.equals(fName, other.fName) && Objects.equals(lName, other.lName);
	}


}
