package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	@Override
	public Film findFilmById(int filmId) {
     Film film = null;
		try {
			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql;
			sql = "SELECT * FROM film WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int filmID = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int releaseYear = rs.getInt("releaseYear");
				int langID = rs.getInt("languageID");
				int rentDuration = rs.getInt("rentalDuration");
				double rentRate = rs.getDouble("rent");
				int length = rs.getInt("length");
				double replaceCost = rs.getDouble("replaceCost");
				String rating = rs.getString("rating");
				String specFeatures = rs.getString("specialFeatures");
				

				film = new Film(filmID, title, description, releaseYear, langID, rentDuration, rentRate, length,
						replaceCost, rating, specFeatures, findActorsByFilmId(filmId));
				
			}

			rs.close();
			stmt.close();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {
			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql;
			sql = "SELECT * FROM actor WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int actorID = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				

				actor = new Actor(actorID, firstName, lastName);
				
			}

			rs.close();
			stmt.close();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}



	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		
		try {
			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql;
			sql = "SELECT * FROM actor a JOIN film_actor fa ON a.id = fa.actor_id Join film f ON fa.film_id = f.id WHERE f.id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int actorID = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				

				Actor actor = new Actor(actorID, firstName, lastName);
				actors.add(actor);
				
			}

			rs.close();
			stmt.close();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

}
