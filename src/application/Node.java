package application;

// CLASSE NÓ
public class Node {
	// ATRIBUTOS
	public int value;			// armazena o valor do nó
	public Node left, right;	// armazena os filhos do nó
	
	// CONSTRUTOR
	public Node(int value) {
		this.value = value;		// inicializa o valor do nó com o valor passado no parâmetro do construtor 
		left = right = null;	// inicializa os filhos do nó como elementos nulos
	}
}
