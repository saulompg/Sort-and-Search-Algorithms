package application;

// CLASSE PRINCIPAL
public class Etapa3 {
	
	// MÉTODO PRINCIPAL
	public static void main(String[] args) {
				
		// DEFININDO O CAMINHO DO ARQUIVO CSV DE ENTRADA
		String sourceFile = "src/data/lista_ordenada.csv";
		
		// INICIALIZANDO LISTA E ÁRVORE PARA ARMAZENAR OS DADOS DO ARQUIVO CSV
		List list = new List();
		BinaryTree tree = new BinaryTree();
		Integer element = null;

		// CHAMA A FUNÇÃO PARA LEITURA DO ARQUIVO CSV
		ArquivoCSV.read(sourceFile, list, tree);
		
		try {
			// DEFINE A VARIÁVEl AUXILIAR
			String method = args[0];
			
			// REGISTRA O TEMPO DO INÍCIO
			long start = System.nanoTime();
			
			// ALTERA O MODO DE ORDENAÇÃO SEGUNDO O PARÂMETRO PASSADO NA CHAMADA DA FUNÇÃO
			switch(method) {			
				case "1":
					// BUSCAR MENOR ELEMENTO NA LISTA
					method = "Buscar menor elemento - lista";
					element = list.min();
					break;
					
				case "2":
					// BUSCAR MAIOR ELEMENTO NA LISTA
					method = "Buscar maior elemento - lista";
					element = list.max();
					break;

				case "3":
					// BUSCAR MENOR ELEMENTO NA ÁRVORE
					method = "Buscar menor elemento - árvore";
					element = tree.min();
					break;
					
				case "4":
					// BUSCAR MAIOR ELEMENTO NA ÁRVORE
					method = "Buscar maior elemento - árvore";
					element = tree.max();
					break;

				default:
					// EXIBE MENSAGEM DO ERRO DE PARÂMETRO 
					System.err.print("O PARÂMETRO PASSADO PARA O PROGRAMA É INVÁLIDO!\n");
					menu();
					return;
			}
			
			// REGISTRA O TEMPO DO TERMINO
	        long finish = System.nanoTime();
			
	        
	        // OUTPUT
	        // INDICA O MÉTODO ESCOLHIDO
	        System.out.printf("%s \n", method);
	        // EXIBE O ELEMENTO ENCONTRADO
	        System.out.printf("O elemento é: %d \n", element);
	        // EXIBE A DURAÇÃO EM SEGUNDOS COM 6 CASAS DECIMAIS
	        System.out.printf("O tempo de execução foi de %.6f segundos.\n", (finish - start) / 1e9);
	        
        // O MENU COM AS OPÇÕES É EXIBIDO CASO NÃO SEJA PASSADO NENHUM PARÂMETRO PARA A FUNÇÃO
		} catch (ArrayIndexOutOfBoundsException ex) {
			menu();
		}
	}

	// MENU DE OPÇÕES
	static void menu() {
		System.out.printf("PASSE UM PARÂMETRO NUMÉRICO NA CHAMADA DA FUNÇÃO PARA SELECIONAR O MÉTODO DE BUSCA \n");
		System.out.printf("> 1: Buscar menor elemento na lista \n");
		System.out.printf("> 2: Buscar maior elemento na lista \n");
		System.out.printf("> 3: Buscar menor elemento na árvore binária \n");
		System.out.printf("> 4: Buscar maior elemento na árvore binária \n");
	}
}
