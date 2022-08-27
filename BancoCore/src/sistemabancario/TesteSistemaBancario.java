package sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteSistemaBancario {

	// Referencia
	static GerenciadoraClientes gerClientes;
	static GerenciadoraContas gerContas;

	public static void main(String[] args) {
		inicializaSistemaBancario();// Inicializar dados de contas e clientes

		Scanner sc = new Scanner(System.in);
		boolean continua = true;

		while (continua) {
			printMenu();

			System.out.println("Informe uma opção: ");
			int opcao = sc.nextInt();

			switch (opcao) {
				case 1:{
					System.out.println("Digite o ID do cliente: ");
					int idCliente = sc.nextInt();
					Cliente cliente = gerClientes.pesquisaCliente(idCliente);

					if (cliente != null) {
						System.out.println(cliente.toString());
					} else {
						System.out.println("Cliente não encontrado!");
					}

				break;
				}
				case 2:{
					System.out.println("Digite o ID da conta: ");
					int idConta = sc.nextInt();
					ContaCorrente conta = gerContas.pesquisaConta(idConta);

					if (conta != null) {
						System.out.println(conta.toString());
					} else {
						System.out.println("Conta não encontrada!");
					}

				break;
				}
				case 3:{
					System.out.println("Digite o ID do cliente: ");
					int idCliente2 = sc.nextInt();
					Cliente cliente2 = gerClientes.pesquisaCliente(idCliente2);
					
					if(cliente2 != null) {
						cliente2.setAtivo(true);
						System.out.println("Cliente ativado com sucesso! ");
					} else {
						System.out.println("Cliente não encontrado");
					}
					
				break;
				}
				case 4:{
					System.out.println("Digite o ID do cliente: ");
					int idCliente3 = sc.nextInt();
					Cliente cliente3 = gerClientes.pesquisaCliente(idCliente3);
					
					if(cliente3 != null) {
						cliente3.setAtivo(false);
						System.out.println("Cliente desativado com sucesso! ");
					} else {
						System.out.println("Cliente não encontrado");
					}
					
				break;
				}
				case 5:{
					continua = false;
					System.out.println("*************Bye bye*************");

				break;
				}
				default:{
					System.out.println();
				break;
				}
			}//Fechamento do Switch
			
		}
		sc.close();
	}

	private static void printMenu() {
		System.out.println("Qual operação você deseja executar?\n");
		System.out.println("1) consulta por um cliente");
		System.out.println("2) Consultar por uma conta corrente");
		System.out.println("3) Ativar um cliente");
		System.out.println("4) Desativar um cliente");
		System.out.println("5) Sair");
		System.out.println();
	}

	private static void inicializaSistemaBancario() {
		// Criar lista vazia de contas e clientes:
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		List<Cliente> clientesDoBanco = new ArrayList<>();

		// Criar e inserir duas contas no banco
		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);

		// Criar e inserir dois clientes no banco
		Cliente cliente01 = new Cliente(1, "Carlos", 21, "carlos@gmail.com", conta01.getId(), true);
		Cliente cliente02 = new Cliente(2, "Lucas", 22, "carlos@gmail.com", conta02.getId(), true);
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		gerContas = new GerenciadoraContas(contasDoBanco);
	}
}
