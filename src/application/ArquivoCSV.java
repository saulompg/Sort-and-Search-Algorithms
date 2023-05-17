package application;

// IMPORTAÇÕES
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// CLASSE PARA LEITURA DO ARQUIVO CSV
public class ArquivoCSV {
	
//	MÉTODO PARA LEITURA DO ARQUIVO CSV
	static void read(String sourceFile, Lista list) {
		
//		INSTANCIA AS CLASSES USADAS PARA LEITURA DO ARQUIVO CSV
//      A CLASSE FileReader É USADA PARA LER DADOS DE UM ARQUIVO DE TEXTO
//      A CLASSE BufferedReader ARMAZENA EM CACHE OS DADOS LIDOS DA CLASSE DE ENTRADA
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
			
//			LÊ O CABEÇALHO DO ARQUIVO
			String line = br.readLine();
//			REALIZA A LEITURA LINHA A LINHA DOS ELEMENTOS
			while((line = br.readLine()) != null) { 
				
//				ARMAZENA OS DADOS EM UMA LISTA
				list.push(Integer.parseInt(line));
				
			}
					
//		CAPTURA A EXCESSÃO CASO OCORRA UM ERRO NA EXECUÇÃO
		} catch (IOException ex) {
			
//			EXIBE NA TELA A MENSAGEM DE ERRO
			System.err.println("ERRO NA LEITURA DO ARQUIVO: " + ex.getMessage());
			
		}
		
	}
	
//	MÉTODO PARA ESCRITA DO ARQUIVO CSV
	static void write(String targetFile, Lista list) {
		
//		INSTANCIA AS CLASSES USADAS PARA ESCRITA DO ARQUIVO CSV
//      A CLASSE FileWriter É USADA PARA GRAVAR CARACTERES EM UM ARQUIVO.
//      A CLASSE BuffereDWriter É USADA PARA ESCREVER CARACTERES EM UM FLIXO DE SAÍDA, COMO UM ARQUIVO DE TEXTO.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {
			
//			ESCREVE O CABEÇALHO DO ARQUIVO
			bw.write("x");
//			PERCORRE A LISTA ENQUANTO HOUVER ELEMENTOS
			while(!list.isEmpty()) { 
				
//				REMOVE O PRIMEIRO ELEMENTO DA LISTA E ESCREVE NO ARQUIVO CSV
				bw.write("\n" + list.remove().toString()); 
				
			}
			
//			OUTPUT CONFIRMAÇÃO DE ESCRITA DA LISTA
			System.out.println("A lista foi exportada com sucesso!");
			
		} catch(IOException ex) {
			
//			EXIBE NA TELA A MENSAGEM DE ERRO
			System.err.println("ERRO NA ESCRITA DO ARQUIVO: " + ex.getMessage());
			
		}
		
	}

}
