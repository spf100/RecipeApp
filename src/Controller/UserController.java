package Controller;
import Model.testUserList;
import Model.User;
import View.LoginForm;

import javax.swing.*;

public class UserController {
    private LoginForm loginForm;

    public UserController(LoginForm loginForm){

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
            boolean check = this.checkCredentials(username, password);
            if(!check){
                JOptionPane.showMessageDialog(this.loginForm, "Username, Password Combination is not valid", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //allow user to move to next page


        });

    }
    public boolean checkCredentials(String username, String password){

        boolean check = false;
        //if username is in database, check for matching password
        //if found set check to true
        if(/*found*/){
            check = true;
        }

        return check;
    }
}
