package model;

import java.util.Scanner;

import services.ProdutoService;

public class Produto {
	
	private Integer idProduto;
	private String nomeProduto;
	private Double preco;
	
	
	
	public Produto() {
		
	}


	public Produto(String nomeProduto, Double preco) {
		super();
		this.nomeProduto = nomeProduto;
		this.preco = preco;
	}


	public Integer getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public void menuProduto() {
		Scanner sc = new Scanner(System.in);
		boolean sair = false;
		
		do {
			System.out.println("Digite uma das opções abaixo: ");
			System.out.println("(1) - Adicionar Produto");
			System.out.println("(2) - Alterar Produto");
			System.out.println("(3) - Mostrar Produto");
			System.out.println("(4) - Deletar Produto");
			System.out.println("(0) - Sair do programa");
			
			int opcao = sc.nextInt();
			ProdutoService produtoService = new ProdutoService();
			switch(opcao) {
			case 1:
				produtoService.save();
				break;
			case 2:
				produtoService.update();
				break;
			case 3:
				produtoService.mostrar();				
				break;
			case 4:
				produtoService.apagar();
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
	
	}}
