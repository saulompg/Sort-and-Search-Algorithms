package application;

// IMPORTAÇÕES
import java.util.ArrayList;

// CLASSE QUE DEFINE OS MÉTODOS DE ORDENAÇÃO
public class Sort {

	// ORDENAR LISTA COM O BUBBLE SORT
	public static void bubble(ArrayList<Integer> arr) {
		
		// Obtém o tamanho da lista
		int n = arr.size();
		
		// Variável para identificar se houve trocar na iteração;
		boolean swapped;
		
		// Laço Externo - Percorre o vetor por inteiro
		for (int i = 0; i < n - 1; i++) {
			
			// Define swapped como false no início de cada iteração
			swapped = false;
			
			// Laço Interno - Percorre o vetor até a penúltima posição
            for (int j = 0; j < n - i - 1; j++) {
            	
            	// Verifica se o Elemento na posição atual é maior que o da próxima posição 
                if (arr.get(j) > arr.get(j + 1)) {
                	
                	// Troca o elemento da posição j com o elemento na posição j+1
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    
                    // Define swapped como true para indicar que houve uma iteração
                    swapped = true;
                    
                }
                
            }
            
           // Se não houve trocas na iteração, a lista já está ordenada e o algorítimo pode ser interrompido
           if(!swapped)
            	break;
            
        }
        
	}
	
	//	ORDENAR LISTA COM O INSERTION SORT
	public static void insertion(ArrayList<Integer> arr) {

		// Obtém o tamanho da lista
		int n = arr.size();

		// Laço externo - Percorre o vetor a partir do segundo Elemento
		for(int i = 1; i < n; i++) {
			
			// Armazena o Elemento a ser posicionado
			int key = arr.get(i);
			
			// Define um índice para percorrer a sublista de valores a ser comparados à esquerda do valor a ser posicionado
			int j = i - 1;

			// Laço interno - percorre a sublista à esquerda do valor a ser posicionado
			while(j >= 0 && arr.get(j) > key) {

				// Se o Elemento comparado arr[i] é maior que o Elemento a ser posicionado key,
				// o Elemento comparado é deslocado para a direita
				arr.set(j + 1, arr.get(j));
				// Decrementa o índice para continuar percorrendo a sublista
				j--;
			
			}

			// Posiciona o Elemento key na posição correta da sublista ordenada
			arr.set(j + 1, key);
			
		}
		
	}
	
	// ORDENAR LISTA COM O SELECTION SORT
	public static void selection(ArrayList<Integer> arr) {

		// Obtém o tamanho da lista
		int n = arr.size();
		
		// Laço externo - percorre a lista até o penúltimo Elemento
		for(int i = 0; i < n - 1; i++) {

			// Define o indice do menor Elemento como o indice atual
			int minIndex = i;

			// Laço interno - percorre a sublista à direita do elemento atual
			for(int j = i + 1; j < n; j++) {

				// Compara o elemento atual com os elementos restantes e encontra o menor elemento
				if(arr.get(j) < arr.get(minIndex))
					// Atualiza o índice do menor Elemento
					minIndex = j;
					
			}

			// // Troca o menor elemento om o elemento na posição i
			int swap = arr.get(minIndex);
			arr.set(minIndex, arr.get(i));
			arr.set(i, swap);
			
		}
		
	}
	
	//	ORDENAR LISTA COM O QUICK SORT
	public static void quick(ArrayList<Integer> arr, int low, int high) {
		
		// corpo do código
		
	}
    
    
	//	ORDENAR LISTA COM O MERGE SORT
	// Método principal do Merge Sort para ordenar o ArrayList
    public static void mergeSort(ArrayList<Integer> arranjo, int esquerda, int direita) {
        if (esquerda < direita) {
            // Calcula o ponto médio do intervalo
            int meio = esquerda + (direita - esquerda) / 2;
            
            // Recursivamente ordena a metade esquerda do arranjo
            mergeSort(arranjo, esquerda, meio);
            
            // Recursivamente ordena a metade direita do arranjo
            mergeSort(arranjo, meio + 1, direita);
            
            // Combina as duas metades ordenadas
            merge(arranjo, esquerda, meio, direita);
        }
    }

    // Método para combinar duas metades ordenadas
    public static void merge(ArrayList<Integer> arranjo, int esquerda, int meio, int direita) {
        // Calcula o tamanho de cada metade
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        // Cria arranjos temporários para armazenar as duas metades
        ArrayList<Integer> arranjoEsquerda = new ArrayList<>();
        ArrayList<Integer> arranjoDireita = new ArrayList<>();

        // Copia os elementos da metade esquerda do arranjo para o arranjoEsquerda
        for (int i = 0; i < n1; i++) {
            arranjoEsquerda.add(arranjo.get(esquerda + i));
        }
        
        // Copia os elementos da metade direita do arranjo para o arranjoDireita
        for (int i = 0; i < n2; i++) {
            arranjoDireita.add(arranjo.get(meio + 1 + i));
        }

        // Indices para percorrer as duas metades e o arranjo original
        int i = 0, j = 0, k = esquerda;
        
        // Combina os elementos das duas metades em ordem crescente
        while (i < n1 && j < n2) {
            if (arranjoEsquerda.get(i) <= arranjoDireita.get(j)) {
                arranjo.set(k, arranjoEsquerda.get(i));
                i++;
            } else {
                arranjo.set(k, arranjoDireita.get(j));
                j++;
            }
            k++;
        }

        // Copia os elementos restantes da metade esquerda, se houver
        while (i < n1) {
            arranjo.set(k, arranjoEsquerda.get(i));
            i++;
            k++;
        }

        // Copia os elementos restantes da metade direita, se houver
        while (j < n2) {
            arranjo.set(k, arranjoDireita.get(j));
            j++;
            k++;
        }
    }
	
}
