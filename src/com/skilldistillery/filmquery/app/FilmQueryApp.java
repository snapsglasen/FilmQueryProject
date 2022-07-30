package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	boolean loop = true;
	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

	// private void test() {
	// Film film = db.findFilmById(1);
	// System.out.println(film);
	// }

	private void launch() {
		Scanner input = new Scanner(System.in);
		while (loop) {
			startUserInterface(input);
		}
		input.close();
	}

	private void startUserInterface(Scanner input) {
		DatabaseAccessorObject dao = new DatabaseAccessorObject();

		System.out.println("Please choose an option:");
		System.out.println("Type 1 to search for a film by it's Film ID.");
		System.out.println("Type 2 to search for a film by keyword");
		System.out.println("Type 3 to exit this application");
		int menuChoice = input.nextInt();

		if (menuChoice == 1) {
			System.out.println("Please enter film's Film ID: ");
			int filmID = input.nextInt();
			if (dao.findFilmById(filmID) == null) {
				System.out.println("No film was found matching that Film ID");
			} else {
				System.out.println(dao.findFilmById(filmID));
				System.out.println("Language: " + dao.findFilmLanguage(filmID));

			}

		}

		if (menuChoice == 2) {
			System.out.println("Please enter a keyword for a film: ");
			String kw = input.next();
			kw = "%" + kw + "%";

			if (dao.findFilmByKeyword(kw) == null) {
				System.out.println("No films where found containing that keyword.");
			} else {
				List<Film> films = dao.findFilmByKeyword(kw);
				for (Film f : films) {
					System.out.println(f);
					System.out.println("Language: " + dao.findFilmLanguage(f.getFilmID()));
				}

			}

		}
		if (menuChoice == 3) {
			System.out.println("Goodbye");
			loop = false;

		}
	}
}
