
public class Principal {

	public static void main(String[] args) {
		LojaFabrica loja = new LojaFabrica();
		
		Cliente cliente1 = geraClienteAleatorio();
		Cliente cliente2 = geraClienteAleatorio();
		Cliente cliente3 = geraClienteAleatorio();
		
		Empregado empregado1 = geraEmpregadoAleatorio();
		Empregado empregado2 = geraEmpregadoAleatorio();
		Empregado empregado3 = geraEmpregadoAleatorio();
		
		Movel movel1 = geraMovelAleatorio();
		Movel movel2 = geraMovelAleatorio();
		Movel movel3 = geraMovelAleatorio();
		
		// teste cadastro
		
		loja.cadastraCliente(cliente1);
		loja.cadastraCliente(cliente2);
		loja.cadastraCliente(cliente3);
		
		loja.cadastraEmpregados(empregado1);
		loja.cadastraEmpregados(empregado2);
		loja.cadastraEmpregados(empregado3);
		
		loja.cadastraMoveis(movel1);
		loja.cadastraMoveis(movel2);
		loja.cadastraMoveis(movel3);
		
		// teste vendas
		
		loja.efetuaVenda(1, 4, 1, 2);
		loja.efetuaVenda(2, 5, 2, 2);
		loja.efetuaVenda(3, 6, 3, 2);
		
		//teste relatorio
		
		loja.geraRelatorioCliente();
		
		loja.geraRelatorioFuncionario();
		
		loja.geraRelatorioVendas();
		
	
	}
	
	public static String geraCorAleatoria() {
		String[] cores = {"Vermelho", "Azul", "Laranja", "Roxo", "Verde"};
		return cores[(int) (Math.random() * cores.length)];
	}
	
	public static String geraNomeAleatorio() {
		String[] nomes = {"Antonia", "Aparecida", "Cláudia", "José", "Carlos", "Bruno"};
		return nomes[(int) (Math.random() * nomes.length)];
	}
	
	public static String geraRuaAleatoria() {
		String[] ruas = {"Machado de assis", "Independencia", "Bom pastor", "Cristo Redentor", "5 de maio", "São Jacó"};
		return ruas[(int) (Math.random() * ruas.length)];
	}
	
	public static Data geraDataNascimento() {
		int dia = (int) (Math.random() * 28) + 1;
		int mes = (int) (Math.random() * 12) + 1;
		int ano = (int) (Math.random() * 50) + 1950;
		return new Data(dia, mes, ano);
	}
	
	public static String geraDescricao(String tipo) {
		return tipo + " de excelente qualidade";
	}
	
	public static Movel geraMovelAleatorio() {
		int tipo = (int) (Math.random() * 3);
		double[] dimensoes = {1 + Math.random(), 1 + Math.random(), 1 + Math.random()};
		String cor = geraCorAleatoria();
		double preco = (Math.random() * 300) + 200;
		int quantidade = (int) (Math.random() * 10) + 2;
		
		switch (tipo) {
		case 0:
			boolean arredondado = Math.random() > 0.5;
			
			return new Mesa(geraDescricao("Mesa"), dimensoes, cor, preco, quantidade, arredondado);
			
		case 1:
			int numeroPortas = (int) ((Math.random() * 5) + 1);
			return new Armario(geraDescricao("Armario"), dimensoes, cor, preco, quantidade, numeroPortas);

		default:
			int numeroPrateleiras = (int) ((Math.random() * 6) + 2);
			return new Estante(geraDescricao("Estante"), dimensoes, cor, preco, quantidade, numeroPrateleiras);
			
		}
	}
	
	public static Cliente geraClienteAleatorio() {
		String nome = geraNomeAleatorio();
		Data dataNascimento = geraDataNascimento();
		String endereco = geraRuaAleatoria() + " número " + ((int) Math.random() * 2000) + 1;
		
		return new Cliente(nome, dataNascimento, endereco);
	}
	
	public static Empregado geraEmpregadoAleatorio() {
		String nome = geraNomeAleatorio();
		Data dataNascimento = geraDataNascimento();
		
		return new Empregado(nome, dataNascimento);
	}

}
