package controller;

import service.SingInService;
import utill.Utill;

public class Controller {
    UserSingUpSingIn userSingUpSingIn = new UserSingUpSingIn();
    SingInService singInService = new SingInService();

    public void mainController() {
        String menu = """
                0 - EXIT
                1 - User
                2 - Admin
                """;
        while(true){
            System.out.println(menu);
            switch (Utill.intScan.nextInt()){
                case 0-> {
                    return;
                }
                case 1->{
                    userSingUpSingIn.usersSingUpSingIn();
                }
                case 2->{
                    singInService.chekAdmin();
                }
            }
        }
    }

}
