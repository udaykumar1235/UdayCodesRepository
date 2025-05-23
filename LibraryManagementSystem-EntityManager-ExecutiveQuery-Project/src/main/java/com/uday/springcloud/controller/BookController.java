package com.uday.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uday.springcloud.Entities.Book;
import com.uday.springcloud.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		
		return bookService.saveBook(book);
	}
	
	@GetMapping("/by-genre")
	public List<Book> getByGenre(@RequestParam String genre){
		
		return bookService.getBookByGenre(genre);
	}
	
	@GetMapping("/paginated")
	public List<Book> paginated(@RequestParam int page, @RequestParam int size){
		
		return bookService.getBookPaginated(page, size);
	}
	
	@GetMapping("/average-price")
	public double averagePrice() {
		
		return bookService.getAveragePrice();
	}
	
	@PutMapping("/update-genre")
	public String updateGenre(@RequestParam Long id, @RequestParam String genre) {
		return bookService.updateGenre(id, genre) > 0 ? "Genre updated":"Update Failed!";
	}
	
	@DeleteMapping("/delete-by-genre")
	public String deleteByGenre(@RequestParam String genre) {
		
		return bookService.deleteByGenre(genre) > 0 ? "Deleted!" : "No Records Found!";
	}
	
	@GetMapping("/native")
	public List<Book> getAllNative(){
		
		return bookService.nativeQueryAllBooks();
	}
}
