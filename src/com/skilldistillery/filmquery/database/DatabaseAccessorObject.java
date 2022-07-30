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
				int releaseYear = rs.getInt("release_year");
				int langID = rs.getInt("language_id");
				// int rentDuration = rs.getInt("rental_duration");
				// double rentRate = rs.getDouble("rent");
				// int length = rs.getInt("length");
				// double replaceCost = rs.getDouble("replace_cost");
				String rating = rs.getString("rating");
				/// String specFeatures = rs.getString("special_features");

				film = new Film(filmID, description, releaseYear, langID, title, rating, findActorsByFilmId(filmId));

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
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

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
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

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

	public List<Film> findFilmByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		try {
			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql;
			sql = "SELECT * FROM film WHERE title like ? OR description like ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, keyword);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int filmID = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int releaseYear = rs.getInt("release_year");
				int langID = rs.getInt("language_id");
				// int rentDuration = rs.getInt("rental_duration");
				// double rentRate = rs.getDouble("rent");
				// int length = rs.getInt("length");
				// double replaceCost = rs.getDouble("replace_cost");
				String rating = rs.getString("rating");
				// String specFeatures = rs.getString("special_features");

				Film film = new Film(filmID, description, releaseYear, langID, title, rating,
						findActorsByFilmId(filmID));
				System.out.println(film);
				System.out.println(findFilmLanguage(filmID));
				films.add(film);

			}

			rs.close();
			stmt.close();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	public String findFilmLanguage(int filmId) {
		String language = "";
		try {
			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql;
			sql = "SELECT name FROM language l JOIN film f ON l.id = f.language_id WHERE f.id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				language = rs.getString("name");
			}

			rs.close();
			stmt.close();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return language;

	}

}
