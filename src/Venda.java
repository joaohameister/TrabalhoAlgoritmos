
public class Venda {
	Empregado empregado;
	Cliente cliente;
	Movel movel;
	int quant;

	public Venda(Empregado empregado, Cliente cliente, Movel movel, int quant) {
		this.empregado = empregado;
		this.cliente = cliente;
		this.movel = movel;
		this.quant = quant;
	}
	
	public String toString() {
		return String.format("%s: %s\nPreço individual: %.2f\nQuantidade: %d\nPreço total: %.2f\nCliente: %s\nEmpregado: %s\n",
				movel.getClass().getName(),
				movel.getDescricao(),
				movel.getPreco(), 
				quant,
				quant*movel.getPreco(),
				cliente.toString(),
				empregado.toString()
				);

	}
	
	public double getTotalVendas() {
		return this.movel.getPreco() * this.quant;
	}
	
	public double getLucro() {
		return this.getTotalVendas() * 0.2;
	}
	
	
	
}
