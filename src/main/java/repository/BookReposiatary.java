package repository;


import com.google.gson.reflect.TypeToken;
import entity.Book;
import utill.Utill;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookReposiatary {
    public void addBook(Book book) {
        List<Book> books = getAllBooks();
        books.add(book);
        writeBook(books);
    }
    public void removeBook(String title ){
        List<Book> books = getAllBooks();
        for(Book book:books){
            if(Objects.equals(book.getTitle(),title)){
                books.remove(book);
                writeBook(books);
                return;
            }
        }
    }

    public void writeBook(List<Book> books) {
        new Thread(() -> {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(Utill.bookJsonUrl));
                writer.write(Utill.gson.toJson(books));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

    public boolean isExist(String incoming) {
        List<Book> books = getAllBooks();
        for (Book book : books) {
            if (Objects.equals(book.getTitle(), incoming)) {
                return true;
            }if(Objects.equals(book.getAuthor(),incoming)){
                return true;
            }if(Objects.equals(book.getISBN(),incoming)){
                return true;
            }
        }
        return false;
    }

    public List<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            books = Utill.gson.fromJson(new FileReader(Utill.bookJsonUrl), new TypeToken<ArrayList<Book>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return books == null ? new ArrayList<>() : books;
    }
    public Book getBook(String incoming){
        List<Book>books=getAllBooks();
        for(Book book : books){
            if(Objects.equals(book.getTitle(),incoming)){
                return book;
            }if(Objects.equals(book.getAuthor(),incoming)){
                return book;
            }if(Objects.equals(book.getISBN(),incoming)){
                return book;
            }
        }return null;
    }

    static BookReposiatary bookReposiatary;
    public static BookReposiatary getInstance(){
        if (bookReposiatary==null){
            bookReposiatary=new BookReposiatary();
        }
        return bookReposiatary;
    }
}




