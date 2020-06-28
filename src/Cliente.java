
public class Cliente extends Pessoa {
	private String endereco;
	private Venda[] compras;
	
	private double lucroDado = 0;
	
	public Cliente(String nome, Data dataNascimento, String endereco, Venda[] compras) {
		super(nome, dataNascimento);
		this.endereco = endereco;
		this.compras = compras;
		
	}
	
	public Cliente(String nome, Data dataNascimento, String endereco) {
		super(nome, dataNascimento);
		this.endereco = endereco;
		this.compras = new Venda[0];
		
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Venda[] getCompras() {
		return this.compras;
	}
	public double getLucroCliente() {
		return this.lucroDado;
	}
	
	public void adicionaCompra(Venda venda) {
		lucroDado += venda.getLucro();
		
		int novoTamanho = compras.length + 1;
		Venda[] novasCompras = new Venda[novoTamanho];
		
		for(int i = 0; i < compras.length; i++) {
			novasCompras[i] = compras[i];
		}
		
		novasCompras[novoTamanho - 1] = venda;		
	}
	
	public String toString() {
		return String.format("ID: %d\nCliente: %s", getId(), getNome());
	}
}
