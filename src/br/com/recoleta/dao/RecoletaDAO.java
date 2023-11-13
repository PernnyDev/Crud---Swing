package br.com.recoleta.dao;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.recoleta.enums.UserType;
import br.com.recoleta.model.User;

public class RecoletaDAO {

	User user[] = new User[10];

	private int total = 0;
	
	private int typeChoice = 0;
	private int updateChoice = 0;

	Scanner scanner = new Scanner(System.in);

	public void addUser(User newUser) {

		if(total < 10) {

			user[total] = newUser;
			total++;
			System.out.println("Usuário cadastrado com sucesso.");
		}
		else {
			System.out.println("Lista de usuários cadastrados completa.");
		}

	}

	public boolean checkFullList() {
		return  (total == 10);
	}

	public void printUserList() {

		for(int i = 0; i < total; i++) {
			System.out.println("Id: " + user[i].getId());
			System.out.println("Nome: " + user[i].getName());
			System.out.println("CPF_CNPJ: " + user[i].getCpf_cnpj());
			System.out.println("E-mail: " + user[i].getEmail());
			System.out.println("Telefone: " + user[i].getFone());
			System.out.println("Senha: " + user[i].getPassword());
			System.out.println("Tipo: " + user[i].getType());
		}
	}

	public void switchWasteTypeUser(int id) {
		
		boolean userFound = false;
		
		for(int i = 0; i < total; i++) {
			if(id == user[i].getId()) {
				try {
					System.out.println("Usuário encontrado.");
					System.out.println("Altere o tipo de usuário:\n1 para gerador de resíduo\n2 para coletor de resíduo");
					typeChoice = scanner.nextInt();

					if(typeChoice == 1) {
						user[i].setType(UserType.PRODUCES_WASTE);
						System.out.println("Operação Efetuada.");
					}
					else if(typeChoice == 2) {
						user[i].setType(UserType.COLLECTS_WASTE);
						System.out.println("Operação Efetuada.");
					}
					else {
						System.out.println("Opção inválida. Tipo não atualizado.");
					}
					
					userFound = true;
					break;
				}
				catch(InputMismatchException e) {
					System.out.println("Digite um valor válido. Tipo não atualizado.");
					scanner.nextLine();
				}
			}
		}
		if(!userFound) {
			System.out.println("Usuário não encontrado.");
		}
	}

	public void updateUser(int id) {
		
		boolean userFound = false;
		
		for(int i = 0; i < total; i++) {
			if(id == user[i].getId()) {
				System.out.println("Usuário encontrado.");
				boolean exit = false;
				while(!exit ) {
					try {
						System.out.println("Escolha a informação a ser alterada:\n1-Nome\n2-CPF_CNPJ\n3-E-mail\n4-Telefone\n5-Senha\n6-sair");
						updateChoice = scanner.nextInt();
						scanner.nextLine();

						switch(updateChoice) {
						case 1:
							System.out.println("Digite o novo Nome: ");
							user[i].setName(scanner.nextLine());
							break;

						case 2:
							System.out.println("Digite o novo CPF_CNPJ: ");
							user[i].setCpf_cnpj(scanner.nextLine());
							break;

						case 3:
							System.out.println("Digite o novo E-mail: ");
							user[i].setEmail(scanner.nextLine());
							break;

						case 4:
							System.out.println("Digite o novo Telefone: ");
							user[i].setFone(scanner.nextLine());
							break;

						case 5:
							System.out.println("Digite o nova Senha: ");
							user[i].setPassword(scanner.nextLine());
							break;

						case 6:
							exit = true;
							break;

						default:
							System.out.println("Digite uma opção válida.");
						}
						
						userFound = true;
					}
					catch(InputMismatchException e) {
						System.out.println("Digite uma opção válida.");
						scanner.nextLine();
					}
				}
			}
		}
		if(!userFound) {
			System.out.println("Usuário não encontrado");
		}
	}

	public void deleteUser(int id) {

		User userAfterDelete[] = new User[total];
		int j = 0;
		boolean userFound = false;
		
		for(int i = 0; i < total; i++) {
			if(id == user[i].getId()) {
				user[i] = null;
				System.out.println("Usuário deletado.");
				total--;
				userFound = true;
			}
		}
		for (int i = 0; i < total; i++) {
				if (user[i] != null) {
					userAfterDelete[j++] = user[i];
				}
			}
			user = userAfterDelete;
		
		if(!userFound) {
			System.out.println("Usuário não encontrado");
		}
	}

}
