import java.util.*;

public class User {
    private static Map<String, String> users = new HashMap<>();
    
    static {
        users.put("admin", "password");
        users.put("AUC", "AUC123");
        users.put("Ravi", "Dodo123");
        users.put("Prashanth", "Freshu123");
    }
    
    public static boolean validateLogin(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
    
    public static void updatePassword(String username, String newPassword) {
        users.put(username, newPassword);
    }
}
