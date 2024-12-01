import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Online_Exam onlineExam = new Online_Exam();
    
    public static void main(String[] args) {
        onlineExam.initializeUsers();
        
        while (true) {
            if (!Online_Exam.isLoggedIn()) {
                login();
            } else {
                showMenu();
            }
        }
    }

    private static void login() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        if (Online_Exam.login(username, password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
    
    private static void showMenu() {
        System.out.println("\nWelcome, " + Online_Exam.getLoggedInUser());
        System.out.println("1. Update Profile");
        System.out.println("2. Take Exam");
        System.out.println("3. Logout");
        System.out.println("4. Close Session");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // to consume newline
        
        switch (choice) {
            case 1:
                updateProfile();
                break;
            case 2:
                Online_Exam.takeExam();
                break;
            case 3:
                Online_Exam.logout();
                break;
            case 4:
                Online_Exam.closeSession();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static void updateProfile() {
        System.out.println("Updating Profile...");
        System.out.println("Enter new password: ");
        String newPassword = scanner.nextLine();
        Online_Exam.updateProfile(newPassword);
    }
}
