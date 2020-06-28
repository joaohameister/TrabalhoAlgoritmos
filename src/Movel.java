
public class Movel {
	//atributos
	private static int countSku = 0;
	private int sku;
	private String descricao;
	private double dimensoes[] = new double [3];
	private String cor;
	private double preco;
	private int quantidade;
	
	//metodos
	public Movel(String descricao, double[] dimensoes, String cor, double preco, int quantidade) {
		this.descricao = descricao;
		this.dimensoes = dimensoes;
		this.cor = cor;
		this.preco = preco;
		this.quantidade = quantidade;
		
		this.sku = ++countSku;
	}
	
	public int getSku() {
		return this.sku;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double[] getDimensoes() {
		return this.dimensoes;
	}
	public String getCor() {
		return this.cor;
	}
	public double getPreco() {
		return this.preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return this.quantidade;
	}
	public double getAltura() {
		return dimensoes[0];
	}
	public double getLargura() {
		return dimensoes[1];
	}
	public double getProfundidade() {
		return dimensoes[2];
	}
	//------------------------------------------------------------------------------------------------------------------------------------------
	public void decrementaQuantidade(int quantidade) {
		this.quantidade -= quantidade;
	}
	public String toString() {
		return String.format("SKU: %d, Tipo: %s", getSku(), this.getClass().getName());
	}
	
}
