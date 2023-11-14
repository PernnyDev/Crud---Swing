package br.com.recoleta.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import br.com.recoleta.model.User;

public class FullMockApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                List<User> mockUserDatabase = new ArrayList<>();

                
                UserLoginForm loginForm = new UserLoginForm(mockUserDatabase);

                loginForm.setVisible(true);

            }
        });
    }
}

