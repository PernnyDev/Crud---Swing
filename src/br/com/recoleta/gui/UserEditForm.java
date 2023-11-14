package br.com.recoleta.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Stream;

import br.com.recoleta.enums.UserType;
import br.com.recoleta.model.User;

public class UserEditForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JTextField emailField;
    private JComboBox<String> userTypeComboBox;
    private JButton saveButton;
    public UserEditForm(List<User> mockUserDatabase, int selectedRow, String name, String email, UserType userType)
    	   {
        setTitle("Editar Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nome:"));
        nameField = new JTextField(name);
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField(email);
        add(emailField);

        add(new JLabel("Tipo de Usuário:"));
        String[] userTypes = getUserTypeValues();
        userTypeComboBox = new JComboBox<>(userTypes);
        userTypeComboBox.setSelectedItem(userType.toString());
        add(userTypeComboBox);

        saveButton = new JButton("Salvar");
        add(saveButton);

        // Adiciona um ouvinte de ação para o botão de salvar
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Atualiza os dados do usuário no banco de dados simulado
                User user = mockUserDatabase.get(selectedRow);
                user.setName(nameField.getText());
                user.setEmail(emailField.getText());
                user.setType(UserType.valueOf(userTypeComboBox.getSelectedItem().toString()));

                // Fecha a janela de edição
                dispose();

                // Atualiza a tabela na tela principal
                TelaExibicao telaExibicao = new TelaExibicao(mockUserDatabase);
                telaExibicao.setVisible(true);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String[] getUserTypeValues() {
        return Stream.of(UserType.values())
                .map(Enum::name)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Este seria um exemplo de como chamar a tela de edição
                // Substitua mockUserDatabase pelo seu banco de dados de usuários
                List<User> mockUserDatabase = UserLoginForm.mockUserDatabase;
                int selectedRow = 0; // Substitua pelo índice da linha que deseja editar
                User user = mockUserDatabase.get(selectedRow);
                new UserEditForm(mockUserDatabase, selectedRow, user.getName(), user.getEmail(), user.getType());
            }
        });
    }
}