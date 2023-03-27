package service;

import entity.Book;
import entity.Rent;
import repository.BookReposiatary;
import repository.RentRepositary;
import utill.Utill;

import java.util.List;

public class AdminService {
    BookReposiatary bookReposiatary = BookReposiatary.getInstance();
    RentRepositary rentRepositary = RentRepositary.getInstance();
    UserService userService = new UserService();

    public void addBook() {
        System.out.print("Kitob nomini kiritng: ");
        String title = Utill.strScan.nextLine();
        System.out.print("Kitob yozgan shaxs ismini kiritng: ");
        String auther = Utill.strScan.nextLine();
        System.out.print("Kitob ISBN kiritng (13): ");
        String ISBN = Utill.strScan.nextLine();
        System.out.print("Kitob chiqan yil kiritng: ");
        String year = Utill.strScan.nextLine();
        Book book = new Book(title, auther, ISBN, year);
        bookReposiatary.addBook(book);
        System.out.println("\n Kitob qo'shildi\n");
    }

    public void getBooks() {
        userService.findBook();
    }

    public void editBook() {
        Book book;
        System.out.print(" O'xgartirmoqci bo'lgan Kitob nomini: ");
        String title = Utill.strScan.nextLine();
        if (bookReposiatary.isExist(title)) {
            book = bookReposiatary.getBook(title);
            bookReposiatary.removeBook(title);
            while (true) {
                System.out.println("""
                        0 -> EXIT
                        1 -> Title ni ozgartiriw
                        2 -> Autherni o'gartirish
                        3 -> ISBN o'zgartirish
                        4 -> Yilini o'zgartirish
                        """);
                switch (Utill.intScan.nextInt()) {
                    case 0 -> {
                        bookReposiatary.addBook(book);
                        return;
                    }
                    case 1 -> {
                        System.out.print("Kitobning yangi nomini kiritng: ");
                        book.setTitle(Utill.strScan.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Kitobni avtorini kiritng: ");
                        book.setAuthor(Utill.strScan.nextLine());
                    }
                    case 3 -> {
                        System.out.println("Kitobni yangi ISBN kiriting (13): ");
                        book.setISBN(Utill.strScan.nextLine());
                    }
                    case 4 -> {
                        System.out.print("Kitob chiqan yil kiritng: ");
                        book.setYear(Utill.strScan.nextLine());
                    }
                }
            }
        } else {
            System.out.println("Bunday Kitob mavjud emas!");
        }

    }

    public void deleteBook() {
        System.out.print(" O'chirmoqci bo'lgan Kitob nomini: ");
        String title = Utill.strScan.nextLine();
        if (bookReposiatary.isExist(title)) {
            bookReposiatary.removeBook(title);
            System.out.println("Kitob ochirildi");
        } else {
            System.out.println("Bunday kitob mavjud emas");
        }
    }


    public void getallBooks() {
        List<Book> books = bookReposiatary.getAllBooks();
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

    public void getAllBrons() {
        List<Rent> rents = rentRepositary.getAllRent();
        for (int i = 0; i < rents.size(); i++) {
            System.out.println(rents.get(i));
        }
    }
}
