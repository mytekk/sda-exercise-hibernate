package pl.sda.exercise.hibernate.service;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.sda.exercise.hibernate.model.Book;

public class BookService {
    //klasa pomocnicza
    //nasze DAO do pobierania danych

    private SessionFactory sessionFactory;

    public BookService() {
        //zainicjalizowanie fabryki polaczen
        //metoda Configuration ma pusty argument, poniewaz nasz plik konfiguracyjny
        //hibernate jest madokladnie taka nazwa jak wymaga od nas hibernate
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public List<Book> getBooks() {
        //TODO
        //otwieramy sesje
        Session session = sessionFactory.openSession();

        //pobieramy dane, bedzieich kilka, wiec dodajemy "list()", oraz drugi argument "Book.class"
        //tak zeby zwrocona lista byla zawierala obiekty Book
        //gdyby nie ten drugiargument, to by trzeba bylo rzutowac: (Book) session.createQuery("from Book", Book.class).list()
        List<Book> list = session.createQuery("from Book", Book.class).list();

        session.close();

        return list;
    }

    public long countBooks() {

        Session session = sessionFactory.openSession();

        //uniqueResult() - w przeciwienstwie do .list() zwroci jeden wiersz
        Long bookCount = session.createQuery("select count(*) from Book", Long.class).uniqueResult();
        session.close();

        return bookCount;
    }

    public Book getBookById(int bookId) {

        Session session = sessionFactory.openSession();

        Query<Book> query = session.createQuery("from Book b where b.id = :id", Book.class);
        query.setParameter("id", bookId);

        Book bookToReturn = query.uniqueResult();

        session.close();

        return bookToReturn;
    }

    public List<Book> getBooksByTitle(String titleToSearch) {

        Session session = sessionFactory.openSession();

        Query<Book> query = session.createQuery("from Book b where b.title like :title", Book.class);
        query.setParameter("title", "%"+titleToSearch+"%"); //tutaj dodajemy procenty, bo hibernate
                                        //nie łyknie ich w samym zapytaniu

        List<Book> list = query.list();

        return list;
    }

    public void createBook(Book book) {

        Session session = sessionFactory.openSession();

        session.save(book); //zapisanie nowego book do bazy danych

        session.close();
    }

    public void updateBook(Book book) {
        //TODO
    }

    public void deleteBook(Book book) {
        //TODO
    }

}
