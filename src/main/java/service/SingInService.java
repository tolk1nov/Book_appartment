package service;

import controller.AdminController;
import controller.UserController;
import entity.User;
import repository.UserRepositary;
import utill.Utill;

public class SingInService {
    AdminController adminController = new AdminController();
    UserRepositary userRepositary =UserRepositary.getInstance();
    UserController userController = new UserController();
    public void chekAdmin() {
        System.out.print("Login kiriting: ");
        String login = Utill.strScan.nextLine();
        System.out.print("Passwordni kiriting: ");
        String password = Utill.strScan.nextLine();
        if(login.equals(Utill.adminLogin)&&password.equals(Utill.adminPassword)){
            adminController.adminController();
        }else {
            System.out.println("Login yoki Parol xato\n");

        }
    }
    public void singUp() {
        System.out.println("Ismingizni kiriring: ");
        String name = Utill.strScan.nextLine();
        System.out.println("Familyangizni  kiriring:");
        String surname = Utill.strScan.nextLine();
        System.out.println("Yoshingizni kiriintg");
        int age = Utill.intScan.nextInt();
        System.out.println("Login kiriring:");
        String login = Utill.strScan.nextLine();
        System.out.println("Password kiriring:");
        String password = Utill.strScan.nextLine();

        User user = new User(name, surname, age, login, password);
        userRepositary.addUser(user);
        userController.userController();

    }
    public void singIn() {
        System.out.println("Login kiriring:");
        String login = Utill.strScan.nextLine();
        System.out.println("Password kiriring:");
        String password = Utill.strScan.nextLine();
        User user = userRepositary.getUser(login, password);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        userController.userController();
    }
}
