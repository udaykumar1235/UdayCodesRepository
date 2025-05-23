package com.uday.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uday.springcloud.Entities.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class BookService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Book saveBook(Book book) {
		
		em.persist(book);
		
		return book;
	}
	
	public List<Book> getBookByGenre(String genre){
		
		return em.createQuery("SELECT b FROM Book b WHERE b.genre=:genre", Book.class)
				.setParameter("genre", genre)
				.getResultList();
	}
	
	
	public List<Book> getBookPaginated(int page, int size){
		
		return em.createQuery("SELECT b FROM Book b", Book.class)
				.setFirstResult(page * size)
				.setMaxResults(size)
				.getResultList();
	}
	
	public double getAveragePrice() {
		
		return em.createQuery("SELECT AVG(b.price) FROM Book b", Double.class).getSingleResult();
		
	}
	
	@Transactional
	public int updateGenre(Long id, String genre) {
		
		return em.createQuery("UPDATE Book b SET b.genre =:genre WHERE b.id=:id")
				.setParameter("genre", genre)
				.setParameter("id", id)
				.executeUpdate();
	}
	
	@Transactional
	public int deleteByGenre(String genre) {
		
		return em.createQuery("DELETE FROM Book b WHERE b.genre=:genre")
				.setParameter("genre", genre)
				.executeUpdate();
	}
	
	public List<Book> nativeQueryAllBooks(){
		
		return em.createNativeQuery("SELECT * FROM Book", Book.class).getResultList();
	}
}
