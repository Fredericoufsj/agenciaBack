package model;

import java.util.Scanner;

import services.ClienteService;

public class Cliente {

	private Integer id;
	private String nome;
	private String endereco;
	private String cpf;
	
	public Cliente() {
		
	}
			
	public Cliente(String nome, String endereco, String cpf) {
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void menuCliente() {
		Scanner sc = new Scanner(System.in);
		boolean sair = false;
		
		do {
			System.out.println("Digite uma das opções abaixo: ");
			System.out.println("(1) - Adicionar Cliente");
			System.out.println("(2) - Alterar Cliente");
			System.out.println("(3) - Mostrar Clientes");
			System.out.println("(4) - Deletar Cliente");
			System.out.println("(0) - Sair do programa");
			
			int opcao = sc.nextInt();
			ClienteService clienteService = new ClienteService();
			switch(opcao) {
			case 1:
				clienteService.save();
				break;
			case 2:
				clienteService.update();
				break;
			case 3:
				clienteService.mostrarClientes();				
				break;
			case 4:
				clienteService.apagar();
				break;
			case 0:
				sair = true;
				System.out.println("Vai com Deus!!");
				
				break;
				default:
					System.out.println("Opção Inválida!");
					break;
			}
		} while( sair == false);
	}
		
}
