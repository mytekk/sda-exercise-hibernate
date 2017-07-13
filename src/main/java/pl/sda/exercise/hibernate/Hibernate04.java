package pl.sda.exercise.hibernate;

import pl.sda.exercise.hibernate.service.BookService;

/**
 * Exercise 04: get books by name
 */
public class Hibernate04 {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		String title = "arl";
		System.out.println("Books by name:");
		bookService.getBooksByTitle(title).forEach(System.out::println);
	}

}
