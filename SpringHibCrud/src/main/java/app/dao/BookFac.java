package app.dao;

import app.dao.entity.Books;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 03.02.2018.
 */
public class BookFac{
        private static  BookFac instance=null;
        //Jdbc connection fields...
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";//?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String SQL_SUBLIST = "SELECT * FROM"
            + " books ORDER BY id LIMIT %d OFFSET %d";
    private Connection connection;
    private Driver driver;
    private Statement statement;
    //private constructor... lasy initialization class...
        private BookFac() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
        }
        //access method to class instance...
        public static BookFac getInstance() throws SQLException, ClassNotFoundException {
            if(instance==null){
                instance = new BookFac();
            }
            return instance;
        }
    public Statement getStatement() {
        return statement;
    }

    public void addNewBook(String title, String description, String author, String isbn, int printyear, Byte readAlready) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO books(title, description, author, isbn, printYear, readAlready) " +
                        "VALUES (?,?,?,?,?,?)");
        ps.setString(1, title);
        ps.setString(2, description);
        ps.setString(3,author);
        ps.setString(4, isbn);
        ps.setInt(5, printyear);
        ps.setByte(6, readAlready);
        ps.addBatch();
        int[] ints = ps.executeBatch();
    }

    public List<Books> getAllBooks() throws SQLException {
            ResultSet rs = statement.executeQuery("SELECT * FROM books;");
        ArrayList<Books> ar = new ArrayList<Books>();
            while (rs.next()){
                Books book = new Books();
                book.setId(rs.getInt(1));
                book.setTitle(rs.getString(2));
                book.setDescription(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setIsbn(rs.getString(5));
                book.setPrintYear(rs.getInt(6));
                book.setReadAlready(rs.getByte(7));
                ar.add(book);
            }
        return ar;
    }

    public List<Books> pagination(int firstrow, int rowcount) throws SQLException {
        String sql = String.format(SQL_SUBLIST, firstrow, rowcount);
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<Books> ar = new ArrayList<Books>();
        while (rs.next()){
            Books book = new Books();
            book.setId(rs.getInt(1));
            book.setTitle(rs.getString(2));
            book.setDescription(rs.getString(3));
            book.setAuthor(rs.getString(4));
            book.setIsbn(rs.getString(5));
            book.setPrintYear(rs.getInt(6));
            book.setReadAlready(rs.getByte(7));
            ar.add(book);
        }
        return ar;
    }

    public void deleteBook(int id) {
        try {
            PreparedStatement pr = connection.prepareStatement(
                    "DELETE  FROM books WHERE id = ?");
            pr.setInt(1, id);
            pr.addBatch();
            int[] ints = pr.executeBatch();
        } catch (SQLException e) {
            System.err.println("Can't delete row");
            e.printStackTrace();
        }
    }

    public void updateBook(int id) throws SQLException {
        PreparedStatement pr =connection.prepareStatement("UPDATE books SET readAlready = 1 WHERE id=?");
        pr.setInt(1, id);
        pr.addBatch();
        int[] ints = pr.executeBatch();
    }

    public void changeBook(Integer id, String t, String d, String i, int y) throws SQLException {
        PreparedStatement pr = connection.prepareStatement(
                "UPDATE  books SET title=?, description=?," +
                        "isbn=?, printYear=? WHERE id=?");
        pr.setString(1, t);
        pr.setString(2, d);
        pr.setString(3, i);
        pr.setInt(4, y);
        pr.setInt(5, id);
        pr.addBatch();
        int[] ints = pr.executeBatch();

    }

    public List<Books> findByTitle(String s) throws SQLException {
        PreparedStatement pr = connection.prepareStatement("SELECT * FROM books WHERE title = ?;");
        pr.setString(1, s);
        ResultSet rs = pr.executeQuery();
        ArrayList<Books> ar = new ArrayList<Books>();
        while (rs.next()){
            Books book = new Books();
            book.setId(rs.getInt(1));
            book.setTitle(rs.getString(2));
            book.setDescription(rs.getString(3));
            book.setAuthor(rs.getString(4));
            book.setIsbn(rs.getString(5));
            book.setPrintYear(rs.getInt(6));
            book.setReadAlready(rs.getByte(7));
            ar.add(book);
        }
        return ar;
    }
}
