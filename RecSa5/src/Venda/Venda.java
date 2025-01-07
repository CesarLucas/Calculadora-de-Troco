package Venda;

import java.util.List;

public class Venda {

	private double valorCompra;
    private double valorRecebido;
    private double troco;
    private List<String> notasEMoedas;
    private int idCalculadora_Troco;
    
	public Venda(double valorCompra, double valorRecebido, double troco, List<String> notasEMoedas) {
		this.valorCompra = valorCompra;
		this.valorRecebido = valorRecebido;
		this.troco = troco;
		this.notasEMoedas = notasEMoedas;
	}
	public double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public double getValorRecebido() {
		return valorRecebido;
	}
	public void setValorRecebido(double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}
	public double getTroco() {
		return troco;
	}
	public void setTroco(double troco) {
		this.troco = troco;
	}
	public List<String> getNotasEMoedas() {
		return notasEMoedas;
	}
	public void setNotasEMoedas(List<String> notasEMoedas) {
		this.notasEMoedas = notasEMoedas;
	}
	public int getIdCalculadora_Troco() {
		return idCalculadora_Troco;
	}
	public void setIdCalculadora_Troco(int idCalculadora_Troco) {
		this.idCalculadora_Troco = idCalculadora_Troco;
	}
	
	
    
}
