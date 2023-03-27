package controller;

import service.AdminService;
import utill.Utill;

public class AdminController {
    AdminService adminService = new AdminService();
    public void adminController(){
        String menu = """
                0 -> EXIT
                1 -> Kitob qo'shish
                2 -> Kitoblar ro'yxatini ko'rish
                3 -> Bron bolgan kitoblar ro'yxatini ko'rish
                4 -> Kitobni qidirish
                5 -> Kitob malumotlarini o'zgartirish
                6 -> Kitobni o'chirish
                """;
        while(true){
            System.out.println(menu);
            switch (Utill.intScan.nextInt()){
                case 0 -> {
                    return;
                }case 1 ->{
                    adminService.addBook();
                }case 2 ->{
                    adminService.getallBooks();
                }case 3 ->{
                    adminService.getAllBrons();
                }case 4 ->{
                    adminService.getBooks();
                }case 5 ->{
                    adminService.editBook();
                }case 6 ->{
                    adminService.deleteBook();
                }
            }
        }
    }

}
