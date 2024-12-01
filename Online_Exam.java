import java.util.*;

public class Online_Exam {
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, String> userPasswords = new HashMap<>();
    private static boolean loggedIn = false;
    private static String loggedInUser = "";
    private static Scanner scanner = new Scanner(System.in);
    
    public void initializeUsers() {
        users.put("admin", "password");
        users.put("AUC", "AUC123");
        users.put("Ravi", "Dodo123");
        users.put("Prashanth", "Freshu123");
        
        userPasswords.put("admin", "password");
        userPasswords.put("AUC", "AUC123");
        userPasswords.put("Ravi", "Dodo123");
        userPasswords.put("Prashanth", "Freshu123");
    }
    
    public static boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedIn = true;
            loggedInUser = username;
            return true;
        } else {
            return false;
        }
    }

    public static void updateProfile(String newPassword) {
        userPasswords.put(loggedInUser, newPassword);
        System.out.println("Password updated successfully.");
    }

    public static void takeExam() {
        System.out.println("\nStarting the exam...");
        String[] questions = {
            "Q1: What is 2 + 2? (a) 3 (b) 4 (c) 5",
            "Q2: What is the capital of France? (a) Berlin (b) Madrid (c) Paris",
            "Q3: Who wrote 'Hamlet'? (a) Shakespeare (b) Dickens (c) Orwell",
            "Q4: Who is the All Time Best Footballer? (a) Lionel Messi (b) Cristina Ronaldo (c) Kylain Mbappe (d) Harry Maguire"
        };
        
        String[] correctAnswers = {"b", "c", "a", "a"};
        String[] userAnswers = new String[questions.length];
        
        ExamTimer timer = new ExamTimer();
        timer.startTimer(30000); // 30 seconds timer
        
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            String answer = scanner.nextLine();
            userAnswers[i] = answer.toLowerCase();
        }
        
        timer.stopTimer();
        submitExam(userAnswers, correctAnswers);
    }
    
    private static void submitExam(String[] userAnswers, String[] correctAnswers) {
        int score = 0;
        for (int i = 0; i < userAnswers.length; i++) {
            if (userAnswers[i].equals(correctAnswers[i])) {
                score++;
            }
        }
        System.out.println("You scored: " + score + " out of " + correctAnswers.length);
    }

    public static void logout() {
        loggedIn = false;
        loggedInUser = "";
        System.out.println("Logged out successfully.");
    }

    public static void closeSession() {
        System.out.println("Closing session...");
        System.exit(0);
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static String getLoggedInUser() {
        return loggedInUser;
    }
}
