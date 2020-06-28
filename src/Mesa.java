
public class Mesa extends Movel {
	private boolean arredondado;
	public Mesa(String descricao, double[] dimensoes, String cor, double preco, int quantidade, boolean arredondado) {
		super(descricao, dimensoes, cor, preco, quantidade);
		this.arredondado = arredondado;
	}
	

	public boolean getArredondada() {
		return this.arredondado;
	}
	
	

}
