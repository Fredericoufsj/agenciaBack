package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import connector.ConexaoComBanco;
import model.Cliente;

public class ClienteService {
		
	public void save() {
		Scanner sc = new Scanner(System.in);
		
		Cliente cliente = new Cliente();
		
		System.out.println("Digite seu nome");
		cliente.setNome(sc.nextLine());
		
		System.out.println("Digite seu endereço");
		cliente.setEndereco(sc.nextLine());
		
		System.out.println("Digite seu CPF");
		cliente.setCpf(sc.nextLine());
		
		String sql = "INSERT INTO Clientes(nome, endereco, cpf)VALUES (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConexaoComBanco.createConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEndereco());
			pstm.setString(3, cliente.getCpf());
			
			pstm.execute();
			System.out.println("Cliente inserido com Sucesso");
			conn.close();
			pstm.close();
			
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		
		}
		}
		
		public void update() {
			Scanner sc = new Scanner(System.in);
			
			Cliente cliente = new Cliente();
			
			System.out.println("Digite o Id do Cliente");
			cliente.setId(sc.nextInt());
			sc.nextLine();
			
			System.out.println("Digite seu nome");
			cliente.setNome(sc.nextLine());
			
			System.out.println("Digite seu endereço");
			cliente.setEndereco(sc.nextLine());
			
			System.out.println("Digite seu CPF");
			cliente.setCpf(sc.nextLine());
			
			String sql = "UPDATE clientes set nome = ?, endereco = ?, cpf = ? where id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConexaoComBanco.createConnection();
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, cliente.getNome());
				pstm.setString(2, cliente.getEndereco());
				pstm.setString(3, cliente.getCpf());
				pstm.setInt(4, cliente.getId());
				
				pstm.execute();
				System.out.println("Deu bom meu Rei");
				conn.close();
				pstm.close();
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
				
			}
				
		}
		
		public void mostrarClientes() {
			String sql = "SELECT * FROM clientes";
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet resultSet = null;
			
			
			try {
				conn = ConexaoComBanco.createConnection();
				pstm = conn.prepareStatement(sql);
				resultSet = pstm.executeQuery();
				while(resultSet.next()) {
					System.out.println("ID: " + resultSet.getInt("id"));
					System.out.println("Nome: " + resultSet.getString("nome"));
					System.out.println("Endereço: " + resultSet.getString("endereco"));
					System.out.println("CPF: " + resultSet.getString("cpf"));
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
			
			Cliente cliente = new Cliente();
			
			System.out.println("Digite o Id do Cliente");
			cliente.setId(sc.nextInt());
			sc.nextLine();
			
			String sql = "DELETE FROM clientes where id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConexaoComBanco.createConnection();
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, cliente.getNome());
				pstm.setString(2, cliente.getEndereco());
				pstm.setString(3, cliente.getCpf());
				
				pstm.execute();
				System.out.println("Cliente Apagado com Sucesso");
				conn.close();
				pstm.close();
				
				
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			
			}
			}
}


