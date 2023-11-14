package br.com.recoleta.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.recoleta.model.User;

public class UserLoginForm extends JFrame {
    private static final long serialVersionUID = 1L;
    static List<User> mockUserDatabase;
    private JLabel lblLogin, lblSenha, lblError;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnEntrar, btnRegistrar;
    private JFrame janela;

    public JLabel getLblLogin() {
        lblLogin = new JLabel("Email: ");
        lblLogin.setBounds(12, 20, 200, 33);
        return lblLogin;
    }

    public JLabel getLblSenha() {
        lblSenha = new JLabel("Senha: ");
        lblSenha.setBounds(12, 60, 200, 33);
        return lblSenha;
    }

    public JLabel getLblError() {
        lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        lblError.setBounds(50, 90, 250, 30);
        return lblError;
    }

    public JTextField getTxtLogin() {
        txtLogin = new JTextField();
        txtLogin.setBounds(162, 20, 100, 33);
        return txtLogin;
    }

    public JPasswordField getTxtSenha() {
        txtSenha = new JPasswordField();
        txtSenha.setEchoChar('?');
        txtSenha.setBounds(162, 60, 100, 33);
        return txtSenha;
    }

    public JButton getBtnEntrar() {
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(45, 120, 100, 33);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = txtLogin.getText();
                String password = new String(txtSenha.getPassword());

                // Verificar se os campos estão em branco
                if (email.isBlank() || password.isBlank()) {
                    lblError.setText("Todos os campos são obrigatórios.");
                } else if (isLoginSuccessful(email, password)) {
                    // Log in the user and perform any necessary actions
                    JOptionPane.showMessageDialog(UserLoginForm.this, "Login successful.");

                    // Close the login window
                    setVisible(false);
                    UserLoginForm.this.dispose();

                    // Open the AddressSetupForm window
                    AddressSetupForm addressSetupForm = new AddressSetupForm();
                    addressSetupForm.setVisible(true);

                    // Limpar os campos de texto
                    txtLogin.setText("");
                    txtSenha.setText("");
                } else {
                    // Display an error message
                    lblError.setText("Credenciais incorretas. Por favor, verifique e tente novamente.");
                }
            }
        };

        btnEntrar.addActionListener(listener);
        return btnEntrar;
    }

    public JButton getBtnRegistrar() {
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(155, 120, 100, 33);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Oculte a janela de login
                setVisible(false);

                UserRegistrationForm userRegistrationForm = new UserRegistrationForm(mockUserDatabase);
                // Exiba a janela de registro
                userRegistrationForm.setVisible(true);

                // Limpar os campos de texto
                txtLogin.setText("");
                txtSenha.setText("");
            }
        };

        btnRegistrar.addActionListener(listener);
        return btnRegistrar;
    }

    public UserLoginForm(List<User> mockUserDatabase) {
        List<User> mockUserDatabase1 = new ArrayList<>();
        UserLoginForm.mockUserDatabase = mockUserDatabase1;
        janela = new JFrame();
        janela.setTitle("Sejam Bem Vindo");
        janela.setBounds(0, 0, 350, 200);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.getContentPane().setBackground(new Color(150, 150, 150));
        janela.setLayout(null);
        janela.getContentPane().add(getLblLogin());
        janela.getContentPane().add(getTxtLogin());
        janela.getContentPane().add(getLblSenha());
        janela.getContentPane().add(getTxtSenha());
        janela.getContentPane().add(getBtnEntrar());
        janela.getContentPane().add(getBtnRegistrar());
        janela.getContentPane().add(getLblError());
        janela.setVisible(true);
    }

    private boolean isLoginSuccessful(String email, String password) {
        for (User user : mockUserDatabase) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new UserLoginForm(new ArrayList<>());
    }
}
