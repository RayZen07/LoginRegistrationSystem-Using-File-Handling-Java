package LoginRegisterController;

import LoginRegisterService.LogIn;
import LoginRegisterService.Register;
import LoginRegisterUtility.LoginRegistrationUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void menu() {
        while (true) {
            System.out.println("Press 1 to Register");
            System.out.println("Press 2 to LogIn");
            System.out.println("Press 3 to Show All Users");
            System.out.println("Press 0 to Exit");
            System.out.println("Enter Your Choice");


            int choice = 0;
            try {
                choice = Integer.parseInt(bf.readLine());
            } catch (NumberFormatException ip) {
                System.out.println("Invalid Input Please Input a Number");
                menu();
            } catch (IOException e) {
                throw new RuntimeException(e);

            }
            if (choice == 1) {
                Register.register();

            } else if (choice == 2) {
                LogIn.login();

            } else if (choice == 3) {
                LoginRegistrationUtility.showUsers();

            } else if (choice == 0) {
                break;
            }

        }
    }
}
