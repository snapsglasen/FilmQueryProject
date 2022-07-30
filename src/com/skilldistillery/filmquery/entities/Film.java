package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int filmID;
	private String description;
	private int releaseYear;
	private int langID;
	private int rentDuration;
	private double rentRate;
	private int length;
	private double replaceCost;
	private String title;
	private String rating;
	private String specFeatures;
	private List<Actor> actors;
	
	
	

	public List<Actor> getActors() {
		return actors;
	}


	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}


	public Film (int filmID, String title, String description, 
			int releaseYear, int langID, 
			int rentDuration, double rentRate, int length,
			double replaceCost, String rating, String specFeatures, List<Actor> actors) {

		this.filmID = filmID;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.langID = langID;
		this.rentDuration = rentDuration;
		this.rentRate = rentRate;
		this.length = length;
		this.replaceCost = replaceCost;
		this.rating = rating;
		this.specFeatures = specFeatures;
		this.actors = actors;
		
	}
	
	
	public Film(int filmID, String description, int releaseYear, int langID, String title, String rating,
			List<Actor> actors) {
		super();
		this.filmID = filmID;
		this.description = description;
		this.releaseYear = releaseYear;
		this.langID = langID;
		this.title = title;
		this.rating = rating;
		this.actors = actors;
	}


	public String getRating() {
		return rating;
	}
	
	
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	
	public String getSpecFeatures() {
		return specFeatures;
	}
	
	
	
	public void setSpecFeatures(String specFeatures) {
		this.specFeatures = specFeatures;
	}
	
	public int getFilmID() {
		return filmID;
	}

	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLangID() {
		return langID;
	}

	public void setLangID(int langID) {
		this.langID = langID;
	}

	public int getRentDuration() {
		return rentDuration;
	}

	public void setRentDuration(int rentDuration) {
		this.rentDuration = rentDuration;
	}

	public double getRentRate() {
		return rentRate;
	}

	public void setRentRate(double rentRate) {
		this.rentRate = rentRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplaceCost() {
		return replaceCost;
	}

	public void setReplaceCost(double replaceCost) {
		this.replaceCost = replaceCost;
	}


	@Override
	public int hashCode() {
		return Objects.hash(description, filmID, langID, length, rating, releaseYear, rentDuration, rentRate,
				replaceCost, specFeatures, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && filmID == other.filmID && langID == other.langID
				&& length == other.length && Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentDuration == other.rentDuration
				&& Double.doubleToLongBits(rentRate) == Double.doubleToLongBits(other.rentRate)
				&& Double.doubleToLongBits(replaceCost) == Double.doubleToLongBits(other.replaceCost)
				&& Objects.equals(specFeatures, other.specFeatures) && Objects.equals(title, other.title);
	}


	@Override
	public String toString() {
		return "Film [Film ID: " + filmID + ", \nDescription: " + description + ", \nRelease Year: " + releaseYear + ", \nTitle: "
				+ title + ", \nRating: " + rating + ", \nActors: " + actors + "]";
	}


	
	
	
			
}

