
public class Armario extends Movel{
	private int numeroPortas;
	public Armario(String descricao, double[] dimensoes, String cor, double preco, int quantidade, int numeroPortas) {
		super(descricao, dimensoes, cor, preco, quantidade);
		this.numeroPortas = numeroPortas;
	}
	
	public int getNumeroPortas() {
		return this.numeroPortas;
	}

}