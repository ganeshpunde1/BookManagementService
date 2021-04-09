package com.gp.book.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

@Entity
@Table(name = "books")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Book Name cannot be null")
	@Size(min = 2, message = "Book Name should have atleast 2 characters")
	@Column(name = "book_Name")
	private String bookName;

	@NotNull(message = "subject cannot be null")
	@Column(name = "subject")
	@Size(min = 2, message = "subject should have atleast 2 characters")
	private String subject;

	@NotNull
	@Column(name = "book_author")
	private String bookAuthor;

	@NotNull
	@Column(name = "book_code")
	private String bookCd;

	@NotNull
	@Column(name = "price")
	private long price;

	@Email(message = "Email should be valid")
	@Column(name = "email")
	private String email;

	public Book(String bookName, String subject, String bookAuthor, String bookCd, long price, String email) {
		super();
		this.bookName = bookName;
		this.subject = subject;
		this.bookAuthor = bookAuthor;
		this.bookCd = bookCd;
		this.price = price;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookCd() {
		return bookCd;
	}

	public void setBookCd(String bookCd) {
		this.bookCd = bookCd;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
