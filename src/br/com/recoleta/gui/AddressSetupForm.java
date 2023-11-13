package br.com.recoleta.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import	 javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AddressSetupForm extends JFrame {
    private JTextField streetField;
    private JTextField numberField;
    private JTextField neighborhoodField;
    private JTextField complementField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField countryField;

    public AddressSetupForm() {
        setTitle("Address Setup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Street:"));
        streetField = new JTextField();
        add(streetField);

        add(new JLabel("Number:"));
        numberField = new JTextField();
        add(numberField);

        add(new JLabel("Neighborhood:"));
        neighborhoodField = new JTextField();
        add(neighborhoodField);

        add(new JLabel("Complement:"));
        complementField = new JTextField();
        add(complementField);

        add(new JLabel("City:"));
        cityField = new JTextField();
        add(cityField);

        add(new JLabel("State:"));
        stateField = new JTextField();
        add(stateField);

        add(new JLabel("Country:"));
        countryField = new JTextField();
        add(countryField);

        JButton setupAddressButton = new JButton("Setup Address");
        add(setupAddressButton);

        setupAddressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle address setup here
                String street = streetField.getText();
                String number = numberField.getText();
                String neighborhood = neighborhoodField.getText();
                String complement = complementField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                String country = countryField.getText();

                // You can process the address details as needed
                System.out.println("Address set up with the following details:");
                System.out.println("Street: " + street);
                System.out.println("Number: " + number);
                System.out.println("Neighborhood: " + neighborhood);
                System.out.println("Complement: " + complement);
                System.out.println("City: " + city);
                System.out.println("State: " + state);
                System.out.println("Country: " + country);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
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
