package Controller;
import View.LoginForm;
import View.RegisterForm;
import _Services.CSV;

import javax.swing.*;
import java.io.IOException;

public class LoginController {
    private LoginForm loginForm;
    private RegisterForm registerForm;
    public LoginController(LoginForm loginForm){

        this.loginForm = loginForm;
        this.loginForm.submitUserData(e -> {
            String username = this.loginForm.getUsername().trim();
            String password = this.loginForm.getPassword();
            //check if fields were empty when submitted
            if(username.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(this.loginForm, "Required Information not entered", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //check if user is in database
            boolean check = false;
            try {
                check = this.checkCredentials(username, password);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            if(!check){
                JOptionPane.showMessageDialog(this.loginForm, "Username, Password Combination is not valid", "Error", JOptionPane.ERROR_MESSAGE);
            }
            //allow user to move to next page
            System.out.println(check);
            System.out.println(username);
        });



    }
    public boolean checkCredentials(String username, String password) throws IOException {
        return CSV.CheckPassword(username, password);
    }
}