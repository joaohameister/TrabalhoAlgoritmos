
public class Empregado extends Pessoa {
	private Venda[] vendas;
	private double lucroEmpregado = 0;
	
	public Empregado(String nome, Data dataNascimento) {
		super(nome, dataNascimento);
		this.vendas = new Venda[0];
	}
	
	public Venda[] getVendas() {
		return this.vendas;
	}
	
	public double getLucroEmpregado() {
		return this.lucroEmpregado;
	}
	public void adicionaVenda(Venda venda) {
		lucroEmpregado += venda.getLucro();
		
		int novoTamanho = vendas.length + 1;
		Venda[] novasVendas = new Venda[novoTamanho];
		
		for(int i = 0; i < vendas.length; i++) {
			novasVendas[i] = vendas[i];
		}
		
		novasVendas[novoTamanho - 1] = venda;		
	}

	
	public String toString() {
		return String.format("ID: %d\nEmpregado: %s", getId(), getNome());
	}
}
