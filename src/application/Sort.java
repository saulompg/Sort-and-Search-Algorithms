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
	
	// ORDENAR LISTA COM O QUICK SORT
	public static void quick(ArrayList<Integer> arr, int start, int end) {
		if (start < end) {
            // Encontra o índice do pivô e realiza a partição do array
            int pivotIndex = particionar(arr, start, end);       
            // Chama o quickSort para a sublista à esquerda do pivô
            quick(arr, start, pivotIndex - 1);
            // Chama o quickSort para a sublista à direita do pivô
            quick(arr, pivotIndex + 1, end);
        }
	}
	
	// Método que encontra o índice do pivô e realiza a partição do array
    private static int particionar(ArrayList<Integer> arr, int start, int end) {
    	int pivot = arr.get(end); // Define o último elemento como pivô
        int i = start - 1; // Índice do menor elemento
        
        for (int j = start; j < end; j++) {
            // Se o elemento atual é menor ou igual ao pivô
            if (arr.get(j) <= pivot) {
                i++; // Incrementa o índice do menor elemento
                // Troca o elemento atual com o elemento na posição i
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        
        // Troca o pivô com o elemento na posição i+1
        int temp = arr.get(i+1);
        arr.set(i+1, arr.get(end));
        arr.set(end, temp);
        
        return i+1; // Retorna o índice do pivô
    }
    
	// ORDENAR LISTA COM O MERGE SORT
    // Método principal do Merge Sort para ordenar o arranjo
	public static void merge(ArrayList<Integer> arr, int start, int end) {
		if (start < end) {
            int middle = start + (end - start) / 2; // Encontra o meio do array    
            // Recursivamente ordena a sublista à esquerda do arranjo
            merge(arr, start, middle);     
            // Recursivamente ordena a sublista à direita do arranjo
            merge(arr, middle + 1, end);
            // Combina as duas sublistas ordenadas
            mergeArr(arr, start, middle, end);
		}
	}
	
    // Método que combina duas sublistas ordenadas em um único array
    private static void mergeArr(ArrayList<Integer> arr, int start, int middle, int end) {
    	int n1 = middle - start + 1; // Tamanho da sublista à esquerda do meio
        int n2 = end - middle; // Tamanho da sublista à direita do meio
        
        // Cria dois arrays temporários para armazenar as sublistas
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        
        // Copia os elementos das sublistas para os arrays temporários
        for (int i = 0; i < n1; i++)
            leftArr.add(arr.get(start + i));
        for (int j = 0; j < n2; j++)
            rightArr.add(arr.get(middle + 1 + j));
        
        // Merge dos dois arrays temporários de volta para o array original
        int i = 0; // Índice do array da sublista à esquerda
        int j = 0; // Índice do array da sublista à direita
        int k = start; // Índice do array original
        
        // Combina os elementos das duas metades em ordem crescente
        while (i < n1 && j < n2) {
        	// Se o elemento da sublista à esquerda é menor ou igual ao da sublista à direita
            if (leftArr.get(i) <= rightArr.get(j)) {
                arr.set(k, leftArr.get(i)); // Copia o elemento para o array original
                i++; // Incrementa o índice da sublista à esquerda
            // Se o elemento da sublista à direita é menor que o da sublista à esquerda
            } else {
                arr.set(k, rightArr.get(j)); // Copia o elemento para o array original
                j++; // Incrementa o índice da sublista à direita
            }
            k++; // Incrementa o índice do array original
        }
        
        // Copia o restante dos elementos da sublista à esquerda, se houver
        while (i < n1) {
            arr.set(k, leftArr.get(i));
            i++;
            k++;
        }
        
        // Copia o restante dos elementos da sublista à direita, se houver
        while (j < n2) {
            arr.set(k, rightArr.get(j));
            j++;
            k++;
        }
    }
}
