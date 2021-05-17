package Banco;

public class Relatorio {

	private String Produto;
	private Short qty;
	
	public Relatorio() {
		Produto = "";
		this.qty = 0;
	}
	public String getProduto() {
		return Produto;
	}
	public void setProduto(String produto) {
		Produto = produto;
	}
	public Short getQty() {
		return qty;
	}
	public void setQty(Short qty) {
		this.qty = qty;
	}
	
	

}
