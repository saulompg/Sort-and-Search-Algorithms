package application;

// IMPORTAÇÕES
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// CLASSE PARA LEITURA DO ARQUIVO CSV
public class ArquivoCSV {
	
	// MÉTODO PARA LEITURA DO ARQUIVO CSV
	static void read(String path) {
		
		// INSTANCIA AS CLASSES USADAS PARA LEITURA DO ARQUIVO CSV
		try ( BufferedReader br = new BufferedReader( new FileReader(path) ) ) {
			
			// SAÍDA DE DADOS
            System.out.println("EXIBINDO ELEMENTOS DO ARQUIVO CSV");
			String line = br.readLine(); // LÊ O CABEÇALHO DO ARQUIVO
			while((line = br.readLine()) != null) { // REALIZA A LEITURA LINHA A LINHA DOS ELEMENTOS
				
				// EXIBE OS ELEMENTOS DO ARQUIVO
				System.out.println(line);
				
			}
					
		// CAPTURA A EXCESSÃO CASO OCORRA UM ERRO NA EXECUÇÃO
		} catch (IOException ex) {
			
			// EXIBE NA TELA A MENSAGEM DE ERRO
			System.err.println("ERRO: " + ex.getMessage());
			
		}
		
	}

}
