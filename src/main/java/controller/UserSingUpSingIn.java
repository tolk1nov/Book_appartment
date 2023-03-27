package controller;

import service.SingInService;
import utill.Utill;

public class UserSingUpSingIn {
    SingInService singInService = new SingInService();
    public void usersSingUpSingIn(){
        String menu = """
                0 -> EXIT
                1 -> Sing up
                2 -> Sing in
                """;
        while(true){
            System.out.println(menu);
            switch (Utill.intScan.nextInt()){
                case 0 -> {
                    return;
                }case 1 ->{
                    singInService.singUp();
                }case 2 ->{
                    singInService.singIn();
                }
            }
        }
    }
}
