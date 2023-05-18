package LoginRegisterService;

import LoginRegisterEntity.Users;
import LoginRegisterUtility.LoginRegistrationUtility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LogIn {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void login() {
        while (true) {

            try {

                System.out.println("Enter UserName:");
                String uname = bf.readLine();
                if (!LoginRegistrationUtility.isExist(uname)) {

                    System.out.println("User Not Found");
                    System.out.println("Press 1 to Retry");
                    System.out.println("Press 2 to Register");
                    System.out.println("Press 0 to Main Menu");
                    int ch = Integer.parseInt(bf.readLine());
                    if (ch == 1) {
                        login();
                        break;
                    } else if (ch == 2) {
                        Register.register();
                        break;
                    } else if (ch == 0) {
                        break;
                    }

                    break;
                }

                System.out.println("Enter Password:");
                String pass = bf.readLine();
                Users users = new Users(uname, pass);
                if (LoginRegistrationUtility.authenticateUser(users)) {
                    System.out.println("LogIn Successful");
                    System.out.println("WELCOME " + uname.toUpperCase());
                    System.out.println("Press 1 to LOGOUT");
                    int ch = Integer.parseInt(bf.readLine());
                    if (ch == 1) {
                        System.out.println("Logged Out Successfully");
                    }
                    break;

                } else {
                    System.out.println("Invalid UserName Or Password");
                    System.out.println("Press 1 to Retry");
                    System.out.println("Press 0 to Main Menu");
                    int ch = Integer.parseInt(bf.readLine());
                    if (ch == 1) {
                        login();
                        break;
                    } else if (ch == 0) {
                        break;
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
    }
}

