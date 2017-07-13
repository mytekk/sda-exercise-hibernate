package pl.sda.exercise.hibernate.service;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sda.exercise.hibernate.model.Book;

public class BookService {
	//klasa pomocnicza
	//nasze DAO do pobierania danych

	private SessionFactory sessionFactory;

	public BookService() {
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
		//zainicjalizowanie fabryki polaczen
	}

	public List<Book> getBooks() {
		//TODO
		//otwieramy sesje
		Session session = sessionFactory.openSession();

		//pobieramy dane, bedzieich kilka, wiec dodajemy "list()", oraz drugi argument "Book.class"
		//tak zeby zwrocona lista byla zawierala obiekty Book
		//gdyby nie ten drugiargument, to by trzeba bylo rzutowac: (Book) session.createQuery("from Book", Book.class).list()
		List<Book> list = session.createQuery("from Book", Book.class).list();

		return list;
	}

	public long countBooks() {
		//TODO
		return 0;
	}

	public List<Book> getBookById(int id) {
		//TODO
		return null;
	}

	public List<Book> getBooksByTitle(String title) {
		//TODO
		return new LinkedList<>();
	}

	public void createBook(Book book) {
		//TODO
	}

	public void updateBook(Book book) {
		//TODO
	}

	public void deleteBook(Book book) {
		//TODO
	}

}
