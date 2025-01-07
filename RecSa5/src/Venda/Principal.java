package Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Venda.VendaDAO.TrocoUtil;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendaDAO vendaDAO = new VendaDAO();
        String continuar = "S";
        double valorCompra, valorRecebido;
        
        while (continuar.equalsIgnoreCase("S")) {
            System.out.println("-------------- Menu de Compras --------------");
            System.out.println(" 1 - Deseja Adicionar uma Compra ");
            System.out.println(" 2 - Listar as Compras ");
            System.out.println(" 3 - Atualizar a Compra ");
            System.out.println(" 4 - Deletar alguma Compra ");
            System.out.println(" 5 - Fechamento de Caixa ");
            System.out.println("----------------------------------------------");
            System.out.println("Selecione uma Opção: ");
            int opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("Valor total das compras: R$ ");
                    valorCompra = scanner.nextDouble();
                    System.out.print("Valor recebido: R$ ");
                    valorRecebido = scanner.nextDouble();
                    double troco = valorRecebido - valorCompra;
                    List<String> notasEMoedas = TrocoUtil.calcularNotasEMoedas(troco);
                    Venda venda = new Venda(valorCompra, valorRecebido, troco, notasEMoedas);
                    vendaDAO.create(venda);
                    System.out.println("-------------------------------");
                    System.out.printf("Troco: R$ %.2f%n", troco);
                    vendaDAO.exibirNotasEMoedas(notasEMoedas);
                    break;
                    
                case 2:
                    System.out.println("Listagem das Compras: ");                   
                    System.out.println(vendaDAO.listarVendas());
                    break;
                    
                case 3:       
                	Scanner r = new Scanner(System.in);
                    System.out.println("Digite o ID da venda que deseja atualizar:");
                    int idVenda = r.nextInt();
                    System.out.println("Digite o novo valor da compra:");
                    double novoValorCompra = r.nextDouble();
                    System.out.println("Digite o novo valor recebido:");
                    double novoValorRecebido = r.nextDouble();
                    System.out.println("Digite o novo valor do troco:");
                    double novoTroco = r.nextDouble();
                    vendaDAO.atualizarVenda(idVenda, novoValorCompra, novoValorRecebido, novoTroco);
                    System.out.println("Venda atualizada com sucesso!");
                    System.err.println("Update de uma Compra: ");
                    break;
                    
                case 4:
                	Scanner sc = new Scanner(System.in);
                    System.err.println("Deletar alguma Compra: ");
                    System.out.println(vendaDAO.listarVendas());
                    System.out.println("Qual Compra deseja Excluir ?");
                    Integer op = sc.nextInt();
                    System.out.println();
                    vendaDAO.excluirVenda(op);
                    break;
                    
                case 5:
                	double totalVendas = vendaDAO.FecharCaixa();
        	    	System.out.printf("Valor total das vendas realizadas no dia: R$ %.2f%n", totalVendas);
                    System.out.println("Fechando o Caixa........");
                    System.exit(0);
                    
                default:
                    System.out.println("Opção Inserida Errada!!!");
                    break;
            }
            
        }
       
    }

    public static void exibirNotasEMoedas(List<String> notasEMoedas) {
        for (String item : notasEMoedas) {
            System.out.println(item);
        }
    }
}

