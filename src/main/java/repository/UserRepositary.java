package repository;

import com.google.gson.reflect.TypeToken;
import entity.User;
import utill.Utill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositary {

    public void addUser(User user) {
        List<User> users = getAllUsers();
        users.add(user);
        writeUsers(users);
    }

    public void writeUsers(List<User> users){
        new Thread(() -> {
            try {
                BufferedWriter writer=new BufferedWriter(new FileWriter(Utill.userJsonUrl));
                writer.write(Utill.gson.toJson(users));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

    public User getUser(String login, String password) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (Objects.equals(user.getLogin(),login)&&
                    Objects.equals(user.getPassword(),password)){
                return user;
            }
        }
        return null;
    }

    public boolean isExist(String login) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (Objects.equals(user.getLogin(),login)){
                return true;
            }
        }
        return false;
    }

    public List<User> getAllUsers() {
        ArrayList<User> users=new ArrayList<>();
        try {
            users = Utill.gson.fromJson(new FileReader(Utill.userJsonUrl), new TypeToken<ArrayList<User>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users == null?new ArrayList<>(): users;
    }

    static UserRepositary userRepositary;
    public static UserRepositary getInstance(){
        if (userRepositary==null){
            userRepositary=new UserRepositary();
        }
        return userRepositary;
    }
}


