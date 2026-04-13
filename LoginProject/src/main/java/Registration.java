import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login auth = new Login();

        System.out.println("--- REGISTRATION ---");
        System.out.print("First Name: "); String fn = sc.nextLine();
        System.out.print("Last Name: "); String ln = sc.nextLine();
        System.out.print("Username: "); String u = sc.nextLine();
        System.out.print("Password: "); String p = sc.nextLine();
        System.out.print("Cell: "); String c = sc.nextLine();

        String regStatus = auth.registerUser(u, p, c, fn, ln);
        System.out.println(regStatus);

        if (regStatus.contains("successfully captured")) {
            System.out.println("Cell number successfully captured.");
            
            System.out.println("\n--- LOGIN ---");
            System.out.print("Username: "); String lu = sc.nextLine();
            System.out.print("Password: "); String lp = sc.nextLine();

            System.out.println(auth.returnLoginStatus(auth.loginUser(lu, lp)));
        }
    }
}

