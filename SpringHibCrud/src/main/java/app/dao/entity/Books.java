package app.dao.entity;


/**
 * Created by Андрей on 03.02.2018.
 */

public class Books {
    private int id;
    private String title;
    private String description;
    private String author;
    private String isbn;
    private int printYear;
    private Byte readAlready;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }


    public Byte getReadAlready() {
        return readAlready;
    }

    public void setReadAlready(Byte readAlready) {
        this.readAlready = readAlready;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (id != books.id) return false;
        if (printYear != books.printYear) return false;
        if (title != null ? !title.equals(books.title) : books.title != null) return false;
        if (description != null ? !description.equals(books.description) : books.description != null) return false;
        if (author != null ? !author.equals(books.author) : books.author != null) return false;
        if (isbn != null ? !isbn.equals(books.isbn) : books.isbn != null) return false;
        if (readAlready != null ? !readAlready.equals(books.readAlready) : books.readAlready != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + printYear;
        result = 31 * result + (readAlready != null ? readAlready.hashCode() : 0);
        return result;
    }
}
