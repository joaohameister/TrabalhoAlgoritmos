
public class Estante extends Movel {
	private int numPrateleiras;
	public Estante(String descricao, double[] dimensoes, String cor, double preco, int quantidade, int numPrateleiras) {
		super(descricao, dimensoes, cor, preco, quantidade);
		this.numPrateleiras = numPrateleiras;
	}
	public int getNumPrateleiras() {
		return this.numPrateleiras;
	}

}
