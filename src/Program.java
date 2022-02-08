import java.util.Scanner;

import model.Cliente;
import model.Produto;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean sair = false;
		
		do {
			System.out.println("Digite uma das opções abaixo: ");
			System.out.println("(1) - Clientes");
			System.out.println("(2) - Produtos");
			System.out.println("(0) - Sair do programa");
			
			int opcao = sc.nextInt();
			Cliente cliente = new Cliente();
			Produto produto = new Produto();
			switch(opcao) {
			case 1:
				cliente.menuCliente();
				break;
			case 2:
				produto.menuProduto();
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
