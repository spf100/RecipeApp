package Controller;

import View.LoginForm;
import View.RegisterForm;
import _Services.CSV;

import javax.swing.*;
import java.io.IOException;

public class RegisterController {
    private LoginForm loginForm;
    private RegisterForm registerForm;

    public RegisterController(RegisterForm registerForm){

        this.registerForm = registerForm;

        this.registerForm.submitUserData(e -> {
            String username = this.registerForm.getUsername().trim();
            String password = this.registerForm.getPassword();
            String firstname = this.registerForm.getFirstName();
            String lastname = this.registerForm.getLastName();
            String confirmPassword = this.registerForm.getConfirmPassword();
            //check if fields were empty when submitted
            if(username.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(this.registerForm, "Required Information not entered", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(!confirmPassword.equals(password)){
                JOptionPane.showMessageDialog(this.registerForm, "Password's do not match", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //check if user is in database
            boolean check = false;
            try {
                check = this.checkCredentials(username);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            if(check){
                JOptionPane.showMessageDialog(this.registerForm, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean isAdded = false;
            try {
                 isAdded = this.AddUser(username, password, firstname, lastname);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            if(!isAdded){
                JOptionPane.showMessageDialog(this.registerForm, "User not added", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        });



    }
    public boolean checkCredentials(String username) throws IOException {
        return CSV.findUser(username);
    }
    public boolean AddUser(String username, String password, String firstname, String lastname) throws IOException {
        return CSV.AddUser(username, password, firstname, lastname);
    }

}
