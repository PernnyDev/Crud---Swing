package br.com.recoleta.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import br.com.recoleta.enums.UserType;
import br.com.recoleta.model.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaExibicao extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable userTable;
	private JButton deleteButton;
	private JButton registerButton;
	private JButton returnToLoginButton;
	private JButton editButton;

	public TelaExibicao(List<User> userList) {
		if (userList == null) {
			// Caso a lista seja nula, inicialize-a vazia ou trate conforme necessário
			userList = new ArrayList<>();

		}

		setTitle("Lista de Usuários");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Cria o modelo da tabela
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Nome");
		tableModel.addColumn("Email");
		tableModel.addColumn("Tipo");

		// Preenche a tabela com dados dos usuários
		for (User user : userList) {
			Object[] rowData = { user.getName(), user.getEmail(), user.getType() };
			tableModel.addRow(rowData);
		}

		// Cria a tabela com o modelo
		userTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(userTable);
		add(scrollPane, BorderLayout.CENTER);

		// Cria o botão de deletar
		deleteButton = new JButton("Deletar Usuário Selecionado");
		// Adiciona um ouvinte de ação para o botão de deletar
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = userTable.getSelectedRow();

				if (selectedRow != -1) {
					// Remove o usuário da tabela e do banco de dados simulado
					tableModel.removeRow(selectedRow);
					UserLoginForm.mockUserDatabase.remove(selectedRow);

					// Atualiza a exibição da tabela
					userTable.repaint();
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um usuário para deletar.");
				}
			}
		});

		// Cria o botão de registrar novo usuário
		registerButton = new JButton("Registrar Novo Usuário");
		// Adiciona um ouvinte de ação para o botão de registrar novo usuário
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Fecha a janela atual
				dispose();

				// Abre a tela de registro de usuário
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new UserRegistrationForm(UserLoginForm.mockUserDatabase);
					}
				});
			}
		});

		// Cria o botão de retornar à tela de login
		returnToLoginButton = new JButton("Retornar à Tela de Login");
		// Adiciona um ouvinte de ação para o botão de retornar à tela de login
		returnToLoginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Fecha a janela atual
				dispose();

				// Abre a tela de login
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new FullMockApplication();
					}
				});
			}
		});

		editButton = new JButton("Editar Usuário Selecionado");
		add(editButton, BorderLayout.NORTH);
		// Adiciona um ouvinte de ação para o botão de editar usuário
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = userTable.getSelectedRow();

				if (selectedRow != -1) {
					// Obtém os dados do usuário selecionado
					String name = (String) tableModel.getValueAt(selectedRow, 0);
					String email = (String) tableModel.getValueAt(selectedRow, 1);
					UserType userType = (UserType) tableModel.getValueAt(selectedRow, 2);

					// Fecha a janela atual
					dispose();

					// Abre a tela de edição de usuário
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							// Altere a linha onde você chama UserEditForm
							new UserEditForm(UserLoginForm.mockUserDatabase, selectedRow, name, email,
									UserType.valueOf(userType.toString()));
						}
					});
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um usuário para editar.");
				}
			}
		});

		// Adiciona os botões abaixo da tabela
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(registerButton);	
		buttonPanel.add(editButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(returnToLoginButton);
		add(buttonPanel, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Substitua mockUserDatabase pelo seu banco de dados de usuários
				new TelaExibicao(UserLoginForm.mockUserDatabase);
			}
		});
	}
}
