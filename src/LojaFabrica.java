
public class LojaFabrica {
	private Cliente[] clientes;
	private Empregado[] empregados;
	private Movel[] estoque;
	private Venda[] vendas;
	private double totalVendas;
	private double lucro;
	
	public LojaFabrica() {
		this.clientes = new Cliente[0];
		this.empregados = new Empregado[0];
		this.estoque = new Movel[0];
		this.vendas = new Venda[0];
		this.totalVendas = 0;
		this.lucro = 0;
	}
	
	public boolean cadastraCliente(Cliente cliente) {
		int novoTamanho = clientes.length + 1;
		Cliente[] novosClientes = new Cliente[novoTamanho];
		
		for(int i = 0; i < clientes.length; i++) {
			novosClientes[i] = clientes[i];
			if(cliente.equals(clientes[i])) {
				return false;
			}
		}
		
		novosClientes[novoTamanho - 1] = cliente;
		this.clientes = novosClientes;
		
		return true;
	}
	
	public int quantidadeClientes() {
		return clientes.length;
	}
	
	public boolean cadastraEmpregados(Empregado empregado) {
		int novoTamanho = empregados.length + 1;
		Empregado[] novosEmpregados = new Empregado[novoTamanho];
		
		for(int i = 0; i < empregados.length; i++) {
			novosEmpregados[i] = empregados[i];
			
			if(empregado.equals(empregados[i])) {
				return false;
			}
		}
		
		novosEmpregados[novoTamanho - 1] = empregado;
		this.empregados = novosEmpregados;
		
		return true;
	}
	
	public int quantidadeEmpregados() {
		return empregados.length;
	}
	
	public boolean cadastraMoveis(Movel movel) {
		int novoTamanho = estoque.length + 1;
		Movel[] novosMoveis = new Movel[novoTamanho];
		
		for(int i = 0; i < estoque.length; i++) {
			novosMoveis[i] = estoque[i];
			if(movel.equals(estoque[i])) {
				return false;
			}
		}
		
		novosMoveis[novoTamanho - 1] = movel;
		this.estoque = novosMoveis;
		
		return true;
	}
	
	public boolean listaMoveisFiltroDimensoes(String filtroTipo, double altura, double largura, double profundidade){
		for(Movel m: estoque) {
			m.getClass().getName();
			String tipo = m.getClass().getName();
			boolean validaTipoEDimensoes = tipo.equals(filtroTipo) && m.getAltura() < altura && m.getLargura() < largura && m.getProfundidade() < profundidade;
			
			if(validaTipoEDimensoes) {
				System.out.println(m);
				
			}
		}
		
		return true;
	}
	
	public boolean listaMoveisFiltrosCorPreco(String tipo, double preco, String cor) {
		for(Movel m: estoque) {
			m.getClass().getName();
			String tipoMovel = m.getClass().getName();
			boolean validaTipoEcorEpreco = tipoMovel.equals(tipo) && m.getCor().equals(cor) && m.getPreco() < preco;
			
			if(validaTipoEcorEpreco) {
				System.out.println(m);
			}
		}
		
		return true;

	}
	
	public boolean efetuaVenda(int clienteId, int empregadoId, int movelSku, int quant) {
		Cliente refCliente = null;
		Empregado refEmpregado = null;
		Movel refMovel = null;
		int quantidadeEstoque;
		
		// 1 - procurar cliente
		for(Cliente c: clientes) {
			if(c.getId() == clienteId) {
				refCliente = c;
				break;
			}
		}
		// 2 - procurar empregado
		for(Empregado e: empregados) {
			if(e.getId() == empregadoId) {
				refEmpregado = e;
				break;
			}
		}
		// 3 - procurar movel
		for(Movel m: estoque) {
			if(m.getSku() == movelSku) {
				refMovel = m;
				break;
			}
		}
		
		if(refCliente != null && refEmpregado != null && refMovel != null) {
			quantidadeEstoque = refMovel.getQuantidade();
			
			if(quantidadeEstoque >= quant) {
				Venda novaVenda = new Venda(refEmpregado, refCliente, refMovel, quant);
				
				refMovel.decrementaQuantidade(quant);
				refCliente.adicionaCompra(novaVenda);
				refEmpregado.adicionaVenda(novaVenda);
				
				totalVendas += novaVenda.getTotalVendas();
				lucro += novaVenda.getLucro();
				
				int novoTamanho = vendas.length + 1;
				Venda[] novasVendas = new Venda[novoTamanho];
				
				for(int i = 0; i < vendas.length; i++) {
					novasVendas[i] = vendas[i];
				}
				
				novasVendas[novoTamanho - 1] = novaVenda;
				this.vendas = novasVendas;
			}
		}
		return false;
	}
	
	public void geraRelatorioVendas() {
		for(Venda v: vendas) {
			System.out.println(v);
		}
	}
	
	public void geraRelatorioFuncionario() {
		for(Empregado e: empregados) {
			for(Venda v: e.getVendas()) {
				System.out.println(v);
			}
			System.out.println(String.format("Lucro obtido pelo(a) empregado(a) %s: %.2f", e.getNome(), e.getLucroEmpregado()));
		}
	}
	
	public void geraRelatorioCliente() {
		for(Cliente c: clientes) {
			for(Venda v: c.getCompras()) {
				System.out.println(v);
			}
			System.out.println(String.format("Lucro dado pelo(a) cliente %s: %.2f", c.getNome(), c.getLucroCliente()));
		}
	}
	
}
