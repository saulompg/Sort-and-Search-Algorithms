package application;

import java.util.ArrayList;

// IMPORTAÇÕES

// CLASSE LISTA DINÂMICA
public class Lista {

//	ATRIBUTOS
	private ArrayList<Integer> arr = new ArrayList<Integer>();
	
//	MÉTODOS DA LISTA
//	VERIFICA SE A LISTA ESTÁ VAZIA
	public boolean isEmpty() {
		
		return arr.size() == 0;
		
	}
	
//	ADICIONA ELEMENTO AO FINAL DA LISTA
	public void push(int element) {
		
		arr.add(element);
		
	}
	
//	REMOVE O ULTIMO ELEMENTO DA LISTA
	public Integer pop() {
		
		Integer element = null;
		
		if(!isEmpty()) {
			
			element = arr.get(arr.size() - 1);
			arr.remove(arr.size() - 1);
			
		}
		
		return element;
		
	}
	
//	ADICIONA ELEMENTO AO INICIO DA LISTA
	public void add(Integer element) {
		
		arr.add(0, element);
		
	}
	
//	REMOVE O PRIMEIRO ELEMENTO DA LISTA
	public Integer remove() {
		
		Integer element = null;
		
		if(!isEmpty()) {
			
			element = arr.get(0);
			arr.remove(0);
			
		}
		
		return element;
		
	}
	
//	EXIBE OS ELEMENTOS DA LISTA
	public void print() {
		
		if(!isEmpty())
			
			for(int i = 0; i < arr.size(); i++)
				System.out.printf("[%d] \t-->\t[%s]\n", i, arr.get(i).toString());
		
		else
			
			System.err.println("A lista está vazia");
		
	}
	
//	MÉTODOS DE ORDENAÇÃO
//	BUBBLE SORT
	public void bubbleSort() {
		
		System.out.println("LISTA ORDENADA PELO MÉTODO BUBBLE SORT");
		Sort.bubble(arr);
		
	}
	
//	INSERTION SORT
	public void insertionSort() {
		
		System.out.println("LISTA ORDENADA PELO MÉTODO INSERTION SORT");
		Sort.insertion(arr);
		
	}
	
//	SELECTION SORT
	public void selectionSort() {
		
		System.out.println("LISTA ORDENADA PELO MÉTODO SELECTION SORT");
		Sort.selection(arr);
		
	}
	
//	QUICK SORT
	public void quickSort() {
		
		System.out.println("LISTA ORDENADA PELO MÉTODO QUICK SORT");
		Sort.quick(arr);
		
	}
	
//	MERGE SORT
	public void mergeSort() {
		
		System.out.println("LISTA ORDENADA PELO MÉTODO MERGE SORT");
		Sort.merge(arr);
		
	}
	
}
