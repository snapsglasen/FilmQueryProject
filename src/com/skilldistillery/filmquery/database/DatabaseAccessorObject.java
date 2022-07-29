package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.skilldistillery.filmquery.entities.Film;

private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

public class DatabaseAccessorObject implements DatabaseAccessor {

  @Override
  public Film findFilmById(int filmId) {
	  String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		
		String sql;
		sql = "SELECT id, first_name, last_name FROM staff WHERE store_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
		      System.out.println(rs.getString(1) + " " +
		                         rs.getString(2) + " " +
		                         rs.getString(3));
		    }
		    rs.close();
		    stmt.close();

		conn.close();
	  
    return null;
  }

  
  
  
}
