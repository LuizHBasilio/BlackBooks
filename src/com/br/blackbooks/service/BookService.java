package com.br.blackbooks.service;

import java.sql.SQLException;
import java.util.List;

import com.br.blackbooks.dto.BookDTO;

public interface BookService {
	List<BookDTO> getAllBooks() throws SQLException;
	boolean addNewBook(BookDTO newBook) throws SQLException;
	boolean updateBook(BookDTO book) throws SQLException;
	boolean deleteBook(BookDTO book) throws SQLException;
	BookDTO getBookById(int id) throws SQLException;
}
