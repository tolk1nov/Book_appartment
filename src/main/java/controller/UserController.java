package controller;


import service.UserService;
import utill.Utill;

public class UserController {
    UserService userService = new UserService();
    public void userController(){
        String menu = """
                0 -> EXIT
                1 -> Kitobni qidirish
                2 -> Kitobni ijaraga olish
                3 -> Kitobni qaytarish
                """;
        while(true){
            System.out.println(menu);
            switch (Utill.intScan.nextInt()){
                case 0 -> {
                    return;
                }case 1 ->{
                    userService.findBook();

                }case 2 ->{
                    userService.rentBook();
                }case 3 ->{
                    userService.lendBook();
                }
            }
        }
    }
}
