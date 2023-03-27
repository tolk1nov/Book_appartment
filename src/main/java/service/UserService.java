package service;


import entity.Book;
import entity.Rent;
import repository.BookReposiatary;
import repository.RentRepositary;
import utill.Utill;
import java.util.Objects;

public class UserService {
    BookReposiatary bookReposiatary = BookReposiatary.getInstance();
    RentRepositary rentRepositary = RentRepositary.getInstance();
    public void findBook() {
        Book book;
        while (true){
            System.out.println("""
                    0 -> EXIT
                    1 -> Kitob nomi bo'yicha qidirish
                    2 -> Kitob avtori bo'yicha qidirish
                    3 -> Kitob ISBN bo'yicha qidirish
                    """);
            switch (Utill.intScan.nextInt()){
                case 0 ->{
                    return;
                }case 1 ->{
                    System.out.print("Kitob nomini kiritng: ");
                    String title = Utill.strScan.nextLine();
                    if (bookReposiatary.isExist(title)) {
                        System.out.println(bookReposiatary.getBook(title));
                    } else {
                        System.out.println("Bunday Kitob mavjud emas!");
                    }
                }case 2 ->{
                    System.out.print("Kitob avtorini ismini kiritng: ");
                    String auther = Utill.strScan.nextLine();
                    if (bookReposiatary.isExist(auther)) {
                        System.out.println(bookReposiatary.getBook(auther));
                    } else {
                        System.out.println("Bunday Kitob mavjud emas!");
                    }
                }case 3 ->{
                    System.out.println("Kitob ISBN kiriting: ");
                    String ISBN = Utill.strScan.nextLine();
                    if (bookReposiatary.isExist(ISBN)) {
                        System.out.println(bookReposiatary.getBook(ISBN));
                    } else {
                        System.out.println("Bunday Kitob mavjud emas!");
                    }
                }
            }
        }
    }
    public void rentBook() {
        System.out.print(" Bron qlmoqci bolgan Kitob nomini kiriting: ");
        String title = Utill.strScan.nextLine();
        if (bookReposiatary.isExist(title)) {
            if (rentRepositary.isExist(title)) {
                System.out.println("Bu kitob bron qlingan");
            } else {
                System.out.println("Login kiriring:");
                String login = Utill.strScan.nextLine();
                Rent rent = new Rent(login, title);
                rentRepositary.addRent(rent);
                System.out.println("Kitob bron qilindi");
            }
        }else{
            System.out.println("Bunday kitob mavjud emas!");
        }
    }
    public void lendBook() {
        Rent rent;
        System.out.println("Login kiriting: ");
        String login  = Utill.strScan.nextLine();
        System.out.println("Kitob nomini kiritng: ");
        String title = Utill.strScan.nextLine();
        if(rentRepositary.isExist(title)){
            rent = rentRepositary.getRent(login,title);
            if(Objects.equals(rent.getUserlogin(),login)&&
            Objects.equals(rent.getBookTitle(),title)){
                rentRepositary.removeRent(login,title);
                System.out.println("Muvofiqiyatli amalga oshirildi");
            }
            else{
                System.out.println("Bu kitobni biz sizga ijaraga bermagnmza");
            }
        }else{
            System.out.println("Bu kitobni biz ijaraga bermaganmza");
        }
    }
}
