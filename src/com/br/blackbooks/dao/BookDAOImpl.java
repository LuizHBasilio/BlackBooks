package com.br.blackbooks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.br.blackbooks.dto.BookDTO;

public class BookDAOImpl implements BookDAO {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public BookDAOImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mnysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	@Override
	public List<BookDTO> getAllBooks() throws SQLException {
		List<BookDTO> listBook = new ArrayList<BookDTO>();

		String sql = "SELECT * FROM book";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("book_id");
			String title = resultSet.getString("title");
			String des = resultSet.getString("description");
			float price = resultSet.getFloat("price");
			BookDTO book = new BookDTO(id, title, des, price);
			listBook.add(book);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listBook;
	}

	@Override
	public boolean addNewBook(BookDTO newBook) throws SQLException {
		String sqlInsert = "INSERT INTO book (title, description, price) VALUES (?, ?, ?)";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
		statement.setString(1, newBook.getTitle());
		statement.setString(2, newBook.getDescription());
		statement.setFloat(3, newBook.getPrice());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}

	@Override
	public boolean updateBook(BookDTO book) throws SQLException {
		String sql = "UPDATE book SET title = ?, description = ?, price = ? WHERE book_id = ?";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, book.getTitle());
		statement.setString(2, book.getDescription());
		statement.setFloat(3, book.getPrice());
		statement.setFloat(4, book.getId());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;
	}

	@Override
	public boolean deleteBook(BookDTO book) throws SQLException {
		String sql = "DELETE FROM book WHERE book_id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, book.getId());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;
	}

	@Override
	public BookDTO getBookById(int id) throws SQLException {
		BookDTO book = null;
		String sql = "SELECT * FROM book where book_id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String title = resultSet.getString("title");
			String des = resultSet.getString("description");
			float price = resultSet.getFloat("price");

			book = new BookDTO(id, title, des, price);
		}

		resultSet.close();
		statement.close();

		return book;
	}

}
