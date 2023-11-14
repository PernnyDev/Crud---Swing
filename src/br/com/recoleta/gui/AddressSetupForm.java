package br.com.recoleta.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AddressSetupForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField streetField;
    private JTextField numberField;
    private JTextField neighborhoodField;
    private JTextField complementField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField countryField;
    private JLabel errorLabel;

    public AddressSetupForm() {
        setTitle("Address Setup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // Usar GridBagLayout

        // Adicionar JLabels e JTextFields com GridBagConstraints
        addLabelAndTextField("Street:", streetField = createSizedTextField());
        addLabelAndTextField("Number:", numberField = createSizedTextField());
        addLabelAndTextField("Neighborhood:", neighborhoodField = createSizedTextField());
        addLabelAndTextField("Complement:", complementField = createSizedTextField());
        addLabelAndTextField("City:", cityField = createSizedTextField());
        addLabelAndTextField("State:", stateField = createSizedTextField());
        addLabelAndTextField("Country:", countryField = createSizedTextField());

        JButton setupAddressButton = new JButton("Setup Address");
        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.gridx = 0;
        gbcButton.gridy = 8;
        gbcButton.gridwidth = 2;
        gbcButton.insets = new Insets(10, 0, 0, 0); // Adicionar espaço entre o botão e o errorLabel
        add(setupAddressButton, gbcButton);

        errorLabel = new JLabel();
        errorLabel.setForeground(java.awt.Color.RED);
        GridBagConstraints gbcErrorLabel = new GridBagConstraints();
        gbcErrorLabel.gridx = 0;
        gbcErrorLabel.gridy = 9;
        gbcErrorLabel.gridwidth = 2;
        add(errorLabel, gbcErrorLabel);

        setupAddressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpe mensagens de erro anteriores
                errorLabel.setText("");

                // Obtenha os valores dos campos
                String street = streetField.getText();
                String number = numberField.getText();
                String neighborhood = neighborhoodField.getText();
                String complement = complementField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                String country = countryField.getText();

                // Realize validações
                if (street.trim().isEmpty() || number.trim().isEmpty() || neighborhood.trim().isEmpty() || city.trim().isEmpty() || state.trim().isEmpty() || country.trim().isEmpty()) {
                     errorLabel.setText("Todos os campos são obrigatórios.");
                } else if (!number.matches("\\d+")) {
                    errorLabel.setText("O campo 'Number' deve conter apenas dígitos numéricos.");
                } else {
                    // Processar os detalhes do endereço conforme necessário
                    System.out.println("Address set up with the following details:");
                    System.out.println("Street: " + street);
                    System.out.println("Number: " + number);
                    System.out.println("Neighborhood: " + neighborhood);
                    System.out.println("Complement: " + complement);
                    System.out.println("City: " + city);
                    System.out.println("State: " + state);
                    System.out.println("Country: " + country);

                    // Feche a janela atual
                    dispose();

                    // Abra a nova janela
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new TelaExibicao(UserLoginForm.mockUserDatabase);
                        }
                    });
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addLabelAndTextField(String labelText, JTextField textField) {
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.gridx = 0;
        gbcLabel.gridy = GridBagConstraints.RELATIVE;
        gbcLabel.anchor = GridBagConstraints.WEST;
        gbcLabel.insets = new Insets(5, 5, 5, 5); // Adicionar margens
        add(new JLabel(labelText), gbcLabel);

        GridBagConstraints gbcTextField = new GridBagConstraints();
        gbcTextField.gridx = 1;
        gbcTextField.gridy = GridBagConstraints.RELATIVE;
        gbcTextField.anchor = GridBagConstraints.WEST;
        gbcTextField.fill = GridBagConstraints.HORIZONTAL;
        gbcTextField.weightx = 1.0;
        gbcTextField.insets = new Insets(5, 5, 5, 5);
        add(textField, gbcTextField);
    }

    private JTextField createSizedTextField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 25));
        return textField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddressSetupForm();
            }
        });
    }
}
