package Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class VendaDAO {
	
	public void create(Venda venda) {
		Connection connection = ConexaoMySql.iniciarConexao();
		PreparedStatement ps = null;
				
		try {
			ps = connection.prepareStatement("INSERT INTO calculadora_troco (valorCompra, valorRecebido, troco) VALUES (?, ?, ?) ");
			ps.setDouble(1, venda.getValorCompra());
			ps.setDouble(2, venda.getValorRecebido());
			ps.setDouble(3, venda.getTroco());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConexaoMySql.encerrarConexao(connection, ps);
		}	
	}
	
	public List<Venda> listarVendas() {
	    List<Venda> vendas = new ArrayList<>();
	    Connection connection = ConexaoMySql.iniciarConexao();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        stmt = connection.prepareStatement("SELECT * FROM calculadora_troco");
	        rs = stmt.executeQuery();

	        System.out.println("-------------------------------------------------------------");
	        System.out.println("| ID  | Valor da Compra | Valor Recebido | Troco    |");
	        System.out.println("-------------------------------------------------------------");
	        for (Venda venda : vendas) {
				System.out.println("compra"+ venda.getValorRecebido());
			}

	        while (rs.next()) {
	            Venda venda = new Venda(
	                rs.getDouble("valorCompra"),
	                rs.getDouble("valorRecebido"),
	                rs.getDouble("troco"),
	                null
	            );
	            vendas.add(venda);
	            System.out.printf("| %3d | R$ %12.2f | R$ %11.2f | R$ %6.2f |\n",
	                rs.getInt("idCalculadora_Troco"), 
	                venda.getValorCompra(),
	                venda.getValorRecebido(),
	                venda.getTroco()
	            );
	        }

	        System.out.println("-------------------------------------------------------------");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        ConexaoMySql.encerrarConexao(connection, stmt, rs);
	    }

	    return vendas;
	}
	

    public void atualizarVenda(int id, double novoValorCompra, double novoValorRecebido, double novoTroco) {
        Connection connection = ConexaoMySql.iniciarConexao();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("UPDATE calculadora_troco SET valorCompra = ?, valorRecebido = ?, troco = ? WHERE idCalculadora_Troco = ?");
            stmt.setDouble(1, novoValorCompra);
            stmt.setDouble(2, novoValorRecebido);
            stmt.setDouble(3, novoTroco);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMySql.encerrarConexao(connection, stmt);
        }
    }

    public void excluirVenda(int id) {
        Connection connection = ConexaoMySql.iniciarConexao();
        PreparedStatement stmt = null;
        try {
        	System.out.println("oi");
            stmt = connection.prepareStatement("DELETE FROM calculadora_troco WHERE idCalculadora_troco = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMySql.encerrarConexao(connection, stmt);
        }
    }

    public double FecharCaixa() {
        List<Venda> vendas = listarVendas();
        double total = 0.0;
        for (Venda venda : vendas) {
            total += venda.getValorCompra();     
        }
        return total;
    }

public class TrocoUtil {
    public static List<String> calcularNotasEMoedas(double troco) {
        List<String> resultado = new ArrayList<>();
        int[] valoresNotas = {100, 50, 20, 10, 5, 2, 1};
        int[] valoresMoedas = {100, 50, 25, 10, 5, 1};

        for (int valorNota : valoresNotas) {
            int quantidade = (int) (troco / valorNota);
            if (quantidade > 0) {
                resultado.add("Nota: \n " + quantidade + " x R$ " + valorNota + ",00 ");
                troco -= quantidade * valorNota;
            }
        }
        for (int valorMoeda : valoresMoedas) {
            double valorEmReais = valorMoeda / 100.0;
            int quantidade = (int) (troco / valorEmReais);
            if (quantidade > 0) {
                resultado.add("Moeda: \n" + quantidade + " x R$ " + valorEmReais);
                troco -= quantidade * valorEmReais;
            }
        }
        return resultado;
    }
}
   
    public static void exibirNotasEMoedas(List<String> notasEMoedas) {
        for (String item : notasEMoedas) {
            System.out.println(item);
            
        }
    }
    
}
 

