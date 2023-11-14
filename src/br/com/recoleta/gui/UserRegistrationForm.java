package br.com.recoleta.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import br.com.recoleta.enums.UserType;
import br.com.recoleta.model.User;

public class UserRegistrationForm extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JRadioButton producesWasteRadioButton, collectsWasteRadioButton;
    private JLabel passwordErrorLabel; // Adicione esta linha

    public UserRegistrationForm(List<User> mockUserDatabase) {
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Altere o número de linhas para 7

        add(new JLabel("Name:")).setBounds(5, 5,100,35);
        nameField = new JTextField();
        nameField.setBounds(105, 5,200,35);
        add(nameField);

        add(new JLabel("Email:")).setBounds(5, 40,100,35);
        emailField = new JTextField();
        emailField.setBounds(105, 40,200,35);
        add(emailField);

        add(new JLabel("Password:")).setBounds(5, 75,100,35);
        passwordField = new JPasswordField();
        passwordField.setBounds(105, 75,200,35);
        add(passwordField);

        passwordErrorLabel = new JLabel(""); // Inicialize o JLabel
        passwordErrorLabel.setForeground(Color.RED); // Defina a cor do texto para vermelho
        passwordErrorLabel.setBounds(5, 110,300,35);
        add(passwordErrorLabel); // Adicione o JLabel ao JFrame
        add(new JLabel("User Type:")).setBounds(5, 145,100,35);
        passwordField.setBounds(105, 75,200,35);
        producesWasteRadioButton = new JRadioButton("Produces Waste");
        collectsWasteRadioButton = new JRadioButton("Collects Waste");
        ButtonGroup userTypeGroup = new ButtonGroup();
        userTypeGroup.add(producesWasteRadioButton);
        userTypeGroup.add(collectsWasteRadioButton);
        producesWasteRadioButton.setBounds(105, 145,200,35);
        collectsWasteRadioButton.setBounds(105, 180,200,35);
        add(producesWasteRadioButton);
        add(collectsWasteRadioButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(5, 215,300,35);
        add(registerButton);
       
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                UserType userType = producesWasteRadioButton.isSelected() ? UserType.PRODUCES_WASTE : UserType.COLLECTS_WASTE;

                // Verifique se a senha tem menos de 4 dígitos
                if (password.length() < 4) {
                    passwordErrorLabel.setText("A senha deve ter pelo menos 4 dígitos."); // Mostre a mensagem de erro
                } 
                // Verifique se o e-mail é válido
                else if (!email.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)*(\\.[a-zA-Z]{2,})$")) {
                    passwordErrorLabel.setText("Por favor, insira um e-mail válido.");
                } 
                else {
                    // Proceed with user registration
                    User newUser = new User();
                    newUser.setName(name);
                    newUser.setEmail(email);
                    newUser.setPassword(password);
                    newUser.setType(userType);

                    // Log the user creation and data
                    System.out.println("User created:");
                    System.out.println("Name: " + newUser.getName());
                    System.out.println("Email: " + newUser.getEmail());
                    System.out.println("Password: " + newUser.getPassword());
                    System.out.println("User Type: " + newUser.getType());

                    UserLoginForm.mockUserDatabase.add(newUser);

                    // Print the contents of the mock user database
                    System.out.println("Current User Database:");
                    for (User user : mockUserDatabase) {
                        System.out.println("Name: " + user.getName());
                        System.out.println("Email: " + user.getEmail());
                        System.out.println("Password: " + user.getPassword());
                        System.out.println("User Type: " + user.getType());
                        System.out.println("------------------------");
                    }

                    

                    // Add a confirmation dialog
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Você tem certeza de que deseja se registrar?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
                    if(dialogResult == JOptionPane.OK_OPTION){
                    	// Clear the fields
                        nameField.setText("");
                        emailField.setText("");
                        passwordField.setText("");
                        userTypeGroup.clearSelection();

                        // Clear the error message
                        passwordErrorLabel.setText("");
                        // Close the registration window
                        dispose();
                    }
                }
            }
        });


        pack();
        setBounds(0, 0, 330, 290);
        setLocationRelativeTo(null);
        setVisible(true);
    }

		/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new UserRegistrationForm(null);

			}
		});
	}*/
}
