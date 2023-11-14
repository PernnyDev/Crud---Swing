package br.com.recoleta;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.recoleta.dao.RecoletaDAO;
import br.com.recoleta.enums.UserType;
import br.com.recoleta.model.User;

public class RecoletaApplication {

	public static void main(String[] args) {

		RecoletaDAO  recoletaDAO = new RecoletaDAO();


		int choice = 0;
		boolean exit = false;
		
		 int generateId = 1;


		while(!exit) {

			try (Scanner scanner = new Scanner(System.in)) {
				User newUser = new User();

				int findId = 0;

				try {
					int typeChoice = 0;

					System.out.println("Digite a opção desejada:\n1-Inserir novo usuário\n2-Atualizar dados do usuário\n3-Deletar usuário\n4-Imprimir lista com todos usuários\n5-Alterar o tipo de usuário\n6-Sair");
					choice = scanner.nextInt();
					scanner.nextLine();

					switch(choice) {

					case 1:
						if(!recoletaDAO.checkFullList()) {
							System.out.println("Insira os dados do usuário:");
							System.out.println("Nome:");
							newUser.setName(scanner.nextLine());
							System.out.println("CPF ou CNPJ:");
							newUser.setCpf_cnpj(scanner.nextLine());
							System.out.println("E-mail:");
							newUser.setEmail(scanner.nextLine());
							System.out.println("Telefone:");
							newUser.setFone(scanner.nextLine());
							System.out.println("Senha:");
							newUser.setPassword(scanner.nextLine());

							System.out.println("Tipo de Usuário:\n1 para gerador de resíduo\n2 para coletor de resíduo");
							typeChoice = scanner.nextInt();
							scanner.nextLine();

							if(typeChoice == 1) {
								newUser.setType(UserType.PRODUCES_WASTE);
							}
							else if(typeChoice == 2) {
								newUser.setType(UserType.COLLECTS_WASTE);
							}
							else {
								System.out.println("Opção inválida. Tipo não atribuído.");
							}
							
							newUser.setId(generateId);
							generateId++;
							recoletaDAO.addUser(newUser);
							break;
						}
						else {
							System.out.println("Lista de usuários cadastrados completa.");
							break;
						}

					case 2:
						System.out.println("Digite o Id do usuário: ");
						findId = scanner.nextInt();
						scanner.nextLine();
						recoletaDAO.updateUser(findId);
						break;

					case 3:
						System.out.println("Digite o Id do usuário: ");
						findId = scanner.nextInt();
						scanner.nextLine();
						recoletaDAO.deleteUser(findId);
						break;

					case 4:
						recoletaDAO.printUserList();
						break;

					case 5:
						System.out.println("Digite o Id do usuário: ");
						findId = scanner.nextInt();
						recoletaDAO.switchWasteTypeUser(findId);
						break;	

					case 6:
						exit = true;
						break;

					default:
						System.out.println("Digite uma opção válida");
						scanner.nextLine();
					}
				}
				catch(InputMismatchException e) {
					System.out.println("Digite uma opção válida");
					scanner.nextLine();
				}
			}
		}
	}
}



