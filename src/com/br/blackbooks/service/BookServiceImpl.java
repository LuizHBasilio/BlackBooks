package com.br.blackbooks.service;

import java.sql.SQLException;
import java.util.List;

import com.br.blackbooks.dao.BookDAO;
import com.br.blackbooks.dao.BookDAOImpl;
import com.br.blackbooks.dto.BookDTO;

public class BookServiceImpl implements BookService {
	private BookDAO bookDAO;
	
	public BookServiceImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.bookDAO = new BookDAOImpl(jdbcURL, jdbcUsername, jdbcPassword);
	}

	@Override
	public List<BookDTO> getAllBooks() throws SQLException {
		return this.bookDAO.getAllBooks();
	}

	@Override
	public boolean addNewBook(BookDTO newBook) throws SQLException {
		return this.bookDAO.addNewBook(newBook);
	}

	@Override
	public boolean updateBook(BookDTO book) throws SQLException {
		return this.bookDAO.updateBook(book);
	}

	@Override
	public boolean deleteBook(BookDTO book) throws SQLException {
		return this.bookDAO.deleteBook(book);
	}

	@Override
	public BookDTO getBookById(int id) throws SQLException {
		return this.bookDAO.getBookById(id);
	}

}
