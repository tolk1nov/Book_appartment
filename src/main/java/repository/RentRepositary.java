package repository;

import com.google.gson.reflect.TypeToken;
import entity.Rent;
import utill.Utill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RentRepositary {

    public void addRent(Rent rent) {
        List<Rent> rents = getAllRent();
        rents.add(rent);
        writeRent(rents);
    }

    public void removeRent(String login , String title){
        List<Rent> rents = getAllRent();
        for(Rent rent:rents){
            if(Objects.equals(rent.getUserlogin(),login)&&
                    Objects.equals(rent.getBookTitle(),title)){
                rents.remove(rent);
                writeRent(rents);
                return;
            }
        }
    }

    public void writeRent(List<Rent> rents){
        new Thread(() -> {
            try {
                BufferedWriter writer=new BufferedWriter(new FileWriter(Utill.rentJson));
                writer.write(Utill.gson.toJson(rents));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

    public Rent getRent(String userLogin, String bookTitle) {
        List<Rent> rents = getAllRent();
        for (Rent rent : rents) {
            if (Objects.equals(rent.getUserlogin(),userLogin)&&
                    Objects.equals(rent.getBookTitle(),bookTitle)){
                return rent;
            }
        }
        return null;
    }

    public boolean isExist(String incoming) {
        List<Rent> rents = getAllRent();
        for (Rent rent : rents) {
            if (Objects.equals(rent.getBookTitle(),incoming)){
                return true;
            }if (Objects.equals(rent.getUserlogin(),incoming)){
                return true;
            }
        }
        return false;
    }

    public List<Rent> getAllRent() {
        ArrayList<Rent> rents=new ArrayList<>();
        try {
            rents = Utill.gson.fromJson(new FileReader(Utill.rentJson), new TypeToken<ArrayList<Rent>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rents == null?new ArrayList<>(): rents;
    }

    static RentRepositary rentRepositary;
    public static RentRepositary getInstance(){
        if (rentRepositary==null){
            rentRepositary=new RentRepositary();
        }
        return rentRepositary;
    }
}
