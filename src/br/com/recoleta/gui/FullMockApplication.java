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

                
                UserLoginForm loginForm = new UserLoginForm(mockUserDatabase, null);
                /*UserRegistrationForm registrationForm = new UserRegistrationForm(mockUserDatabase);
                CollectionForm collectionForm = new CollectionForm(); // If applicable
                AddressSetupForm addressSetupForm = new AddressSetupForm(); // If applicable*/

                // You can manage the flow of your application, e.g., show login form initially
                loginForm.setVisible(true);
               /* registrationForm.setVisible(false);
                collectionForm.setVisible(false);
                addressSetupForm.setVisible(false);*/
            }
        });
    }
}

