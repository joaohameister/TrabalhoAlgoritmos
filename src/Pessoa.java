
public class Pessoa {
	private String nome;
	private Data dataNascimento;
	private static int countPessoa = 0;
	private int id;
	public Pessoa(String nome, Data dataNascimento) {
		this.id = ++countPessoa;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public String getNome() {
		return this.nome;
	}
	public Data getDataNascimento() {
		return this.dataNascimento;
	}
	public int getId() {
		return this.id;
	}

}
