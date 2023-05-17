package application;

// IMPORTAÇÕES
import java.util.ArrayList;

// CLASSE QUE DEFINE OS MÉTODOS DE ORDENAÇÃO
public class Sort {

//	ORDENAR LISTA COM O BUBBLE SORT
	public static void bubble(ArrayList<Integer> arr) {
		
		int size = arr.size();
        
		for (int i = 0; i < size - 1; i++) {
			
            for (int j = 0; j < size - i - 1; j++) {
            	
                if (arr.get(j) > arr.get(j + 1)) {
                	
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    
                }
                
            }
            
        }
        
	}
	
//	ORDENAR LISTA COM O INSERTION SORT
	public static void insertion(ArrayList<Integer> arr) {

		int i, j, k;

		for(j = 1; j < arr.size(); j++) {
			
			k = arr.get(j);
			i = j - 1;

			while(i >= 0 && arr.get(i) > k) {

				arr.set(i + 1, arr.get(i));
				i--;			
			}

			arr.set(i + 1, k);
			
		}
		
	}
	
//	ORDENAR LISTA COM O SELECTION SORT
	public static void selection(ArrayList<Integer> arr) {

		int i, j, min, swap;

		for(i = 0; i < arr.size() - 1; i++) {

			min = i;

			for(j = (i+1); j < arr.size(); j++) {

				if(arr.get(j) < arr.get(min))
					min = j;
					
			}

			swap = arr.get(i);
			arr.set(i, arr.get(min));
			arr.set(min, swap);
			
		}
		
	}
	
//	ORDENAR LISTA COM O QUICK SORT
	public static void quick(ArrayList<Integer> arr) {
		
		// corpo do código
		
	}
    
    
//	ORDENAR LISTA COM O MERGE SORT
	public static void merge(ArrayList<Integer> arr) {

		//  corpo do código
		
	}
	
}
