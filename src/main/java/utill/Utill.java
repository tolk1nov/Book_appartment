package utill;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public interface Utill {
    Scanner strScan = new Scanner(System.in);
    Scanner intScan = new Scanner(System.in);

    Gson gson=new GsonBuilder().setPrettyPrinting().create();
    String userJsonUrl="src\\main\\resources\\users.json";
    String bookJsonUrl="src\\main\\resources\\books.json";
    String rentJson="src\\main\\resources\\rent.json";
    String adminLogin = "admin";
    String adminPassword = "0000";


}
