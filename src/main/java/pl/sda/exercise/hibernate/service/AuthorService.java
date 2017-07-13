package pl.sda.exercise.hibernate.service;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.sda.exercise.hibernate.model.Author;

public class AuthorService {

    //klasa pomocnicza
    //nasze DAO do pobierania danych

    SessionFactory sessionFactory;

    public AuthorService() {
        //zainicjalizowanie fabryki polaczen
        //metoda Configuration ma pusty argument, poniewaz nasz plik konfiguracyjny
        //hibernate jest madokladnie taka nazwa jak wymaga od nas hibernate
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    //metoda pomocnicza do pobierania wszystkich autorow
    public List<Author> getAuthors() {

        Session session = sessionFactory.openSession();

        List<Author> list = session.createQuery("from Author", Author.class).list();

        //wymuszenie zeby hibernate przed zamknieciem sesji dociagnal nam ksiazki tego autora
        list.forEach( author -> Hibernate.initialize(author.getBooks()) );

        session.close();

        return list;
	}

}
