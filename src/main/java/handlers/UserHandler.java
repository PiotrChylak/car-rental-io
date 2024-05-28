package handlers;

import java.util.List;

import com.example.app.model.User;

public interface UserHandler {
    public static void saveUsers(List<User> users,String path){};
    public static void saveUser(User user,String path){};
    public static List<User> getUsers(String path){return null;};
}   
