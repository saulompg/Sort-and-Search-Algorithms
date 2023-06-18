package application;

// CLASSE PRINCIPAL
public class Etapa2 {
	// MÉTODO PRINCIPAL
	public static void main(String[] args) {	
		// DEFININDO O CAMINHO DO ARQUIVO CSV DE ENTRADA
		String sourceFile = "src/data/lista_original.csv";
		// DEFININDO O CAMINHO DO ARQUIVO CSV DE SAÍDA
		String targetFile = "src/data/lista_ordenada.csv";
		// INICIALIZANDO LISTA PARA ARMAZENAR OS DADOS DO ARQUIVO CSV
		List list = new List();
		// CHAMA A FUNÇÃO PARA LEITURA DO ARQUIVO CSV
		ArquivoCSV.read(sourceFile, list);
		
		try {
			// DEFINE A VARIÁVEl AUXILIAR
			String method = args[0];
			
			// REGISTRA O TEMPO DO INÍCIO
			long start = System.nanoTime();
			
			// ALTERA O MODO DE ORDENAÇÃO SEGUNDO O PARÂMETRO PASSADO NA CHAMADA DA FUNÇÃO
			switch(method) {
				case "1":
					// ORDENA A LISTA PELO MÉTODO BUBBLE SORT
					method = list.bubbleSort();
					break;
				
				case "2":
					// ORDENA A LISTA PELO MÉTODO INSERTION SORT
					method = list.insertionSort();
					break;
					
				case "3":
					// ORDENA A LISTA PELO MÉTODO SELECTION SORT
					method = list.selectionSort();
					break;
	
				case "4":
					// ORDENA A LISTA PELO MÉTODO QUICK SORT
					method = list.quickSort();
					break;
					
				case "5":
					// ORDENA A LISTA PELO MÉTODO MERGE SORT
					method = list.mergeSort();
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
	        System.out.printf("LISTA ORDENADA PELO MÉTODO %s \n", method);

	        // EXIBE A DURAÇÃO EM SEGUNDOS COM 6 CASAS DECIMAIS
	        System.out.printf("O tempo de execução foi de %.6f segundos.\n", (finish - start) / 1e9);

	        // EXPORTA A LISTA ORDENADA PARA UM ARQUIVO CSV
	        ArquivoCSV.write(targetFile, list);
        // O MENU COM AS OPÇÕES É EXIBIDO CASO NÃO SEJA PASSADO NENHUM PARÂMETRO PARA A FUNÇÃO
		} catch (ArrayIndexOutOfBoundsException ex) {
			menu();
		}
	}

	// MENU DE OPÇÕES
	static void menu() {
		System.out.printf("PASSE UM PARÂMETRO NUMÉRICO NA CHAMADA DA FUNÇÃO PARA SELECIONAR O MÉTODO DE ORDENAÇÃO \n");
		System.out.printf("> 1: Bubble Sort \n");
		System.out.printf("> 2: Insertion Sort \n");
		System.out.printf("> 3: Selection Sort \n");
		System.out.printf("> 4: Quick Sort \n");
		System.out.printf("> 5: Merge Sort \n");
	}
}
