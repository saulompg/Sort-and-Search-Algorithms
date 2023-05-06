package application;

// CLASSE PRINCIPAL
public class App {

	// MÉTODO PRINCIPAL
	public static void main(String[] args) {
		
		// DEFININDO O CAMINHO DO ARQUIVO CSV
		String path = "src/data/grupo_3.csv";
		
		// CHAMA A FUNÇÃO PARA LEITURA DO ARQUIVO CSV
		ArquivoCSV.read(path);
		
	}

}
