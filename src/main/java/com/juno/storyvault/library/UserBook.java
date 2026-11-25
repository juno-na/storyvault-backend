package com.juno.storyvault.library;

import com.juno.storyvault.book.Book;
import com.juno.storyvault.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "user_books",
uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "book_id"})})
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReadingStatus readingStatus;

    protected UserBook(){}

    public UserBook(User user, Book book, ReadingStatus readingStatus) {
        this.user = user;
        this.book = book;
        this.readingStatus = readingStatus;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public ReadingStatus getReadingStatus() {
        return readingStatus;
    }
}
