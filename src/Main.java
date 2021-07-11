import View.LoginForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // runs in AWT thread
        SwingUtilities.invokeLater(LoginForm::new);
    }
}
