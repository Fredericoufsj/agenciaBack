package services;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.Scanner;

	import connector.ConexaoComBanco;
	import model.Produto;

	public class ProdutoService {
			
		public void save() {
			Scanner sc = new Scanner(System.in);
			
			Produto produto = new Produto();
			
			System.out.println("Digite nome do produto");
			produto.setNomeProduto(sc.nextLine());
			
			System.out.println("Digite o Preço do produto");
			produto.setPreco(sc.nextDouble());
			
			System.out.println("Digite o Preço do produto");
			produto.setPreco(sc.nextDouble());
			
						
			String sql = "INSERT INTO Produtos(nomeProduto, preco)VALUES (?,?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConexaoComBanco.createConnection();
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, produto.getNomeProduto());
				pstm.setDouble(2, produto.getPreco());
				
				
				pstm.execute();
				System.out.println("Produto inserido com Sucesso");
				conn.close();
				pstm.close();
				
				
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			
			}
			}
			
			public void update() {
				Scanner sc = new Scanner(System.in);
				
				Produto produto = new Produto();
				
				System.out.println("Digite o Id do Produto");
				produto.setIdProduto(sc.nextInt());
				sc.nextLine();
				
				System.out.println("Digite nome do produto");
				produto.setNomeProduto(sc.nextLine());
				
				System.out.println("Digite o Preço do produto");
				produto.setPreco(sc.nextDouble());
				
				
				String sql = "UPDATE produtos set nomeProduto = ?, preco = ? where idProduto = ?";
				
				Connection conn = null;
				PreparedStatement pstm = null;
				
				try {
					conn = ConexaoComBanco.createConnection();
					pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, produto.getNomeProduto());
					pstm.setDouble(2, produto.getPreco());
					pstm.setInt(3, produto.getIdProduto());
					
					pstm.execute();
					System.out.println("Deu bom meu Rei");
					conn.close();
					pstm.close();
				}catch(Exception e) {
					
					System.out.println(e.getMessage());
					
				}
					
			}
			
			public void mostrar() {
				String sql = "SELECT * FROM produtos";
				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet resultSet = null;
				
				
				try {
					conn = ConexaoComBanco.createConnection();
					pstm = conn.prepareStatement(sql);
					resultSet = pstm.executeQuery();
					while(resultSet.next()) {
						System.out.println("ID: " + resultSet.getInt("idProduto"));
						System.out.println("Nome: " + resultSet.getString("nomeProduto"));
						System.out.println("Endereço: " + resultSet.getString("Preco"));
						System.out.println();
						}
					
						conn.close();
						pstm.close();
						
				}catch(Exception ex) {
					
					System.out.println(ex.getMessage());
					
				}
			}
			public void apagar() {
				Scanner sc = new Scanner(System.in);
				
				Produto produto = new Produto();
				
				System.out.println("Digite o Id do Cliente");
				produto.setIdProduto(sc.nextInt());
				sc.nextLine();
				
				String sql = "DELETE FROM clientes where id = ?";
				
				Connection conn = null;
				PreparedStatement pstm = null;
				
				try {
					conn = ConexaoComBanco.createConnection();
					pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, produto.getNomeProduto());
					pstm.setDouble(2, produto.getPreco());
					
					
					pstm.execute();
					System.out.println("Produto apagado com Sucesso");
					conn.close();
					pstm.close();
					
					
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				
				}
				}

}
