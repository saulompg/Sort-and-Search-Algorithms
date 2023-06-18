package application;

// CLASSE ÁRVORE BINÁRIA
public class BinaryTree {
	// declara a raíz da árvore binária 
	Node root;
	
	// MÉTODOS DA ÁRVORE
	// VERIFICA SE A ÁRVORE ESTÁ VAZIA
	public boolean isEmpty() {
		return root == null;
	}
	
	// INSERE UM ELEMENTO NO NÓ DA ÁRVORE
	public void insert(int value) {
		root = insertRecursive(root, value);
	}
	
	// POSICIONA O NÓ NO LOCAL ADEQUADO DA ÁRVORE
	private Node insertRecursive(Node current, int value) {
		if(current == null) {
			return new Node(value);
		}
		
		if(value < current.value)
			current.left = insertRecursive(current.left, value);
		else
			current.right = insertRecursive(current.right, value);

		return current;
	}
	
	// REMOVE UM ELEMENTO DA ÁRVORE
	public void remove(int value) {
		// verifica se a raíz da árvore é nula
		if(isEmpty()) {
			System.out.printf("A árvore está vazia! \n");
			return;
		}
		
		// verifica se a árvore possui o elemento a ser removido
		if(!contains(value)) {
			System.out.printf("O elemento não está inserido na árvore \n");
			return;
		}
		
		// chama a função para remover o nó da árvore
		root = removeRecursive(root, value);
	}
	
	// IDENTIFICA O NÓ A SER REMOVIDO E REESTRUTURA A ÁRVORE
	public Node removeRecursive(Node current, int value) {
		// se o valor a ser removido é igual ao nó atual
		if(value == current.value) {
			System.out.printf("O elemento %d foi removido \n", current.value);
			
			// caso 1: o nó não possui filhos
			if(current.left == null && current.right == null)
				return null;
			
			// caso 2: o nó possui o filho direito
			else if(current.left == null)
				return current.right;
			
			// caso 3: o nó possui o filho esquerdo
			else if(current.right == null)
				return current.left;
			
			// case 4: o nó possui os dois filhos
			else {
				// cria uma variável auxiliar para armazenar o filho da esquerda
				Node son = current.left;
				
				// verifica se o filho da esquerda não possui filhos
				if(son.left == null && son.right == null) {
					current.value = son.value;
					current.left = null;
					return current;
				}
				
				// cria uma variável auxiliar para armazenar o elemento pai
				Node parent = current;
				
				// percorre para o elemento mais à direita do filho
				while(son.right != null) {
					parent = son;
					son = son.right;
				}
				
				// case 4.1: o elemento mais à direita possui um filho à esquerda
				if(son.left != null) {
					current.value = son.value;
					parent.right = son.left;	
				
				// case 4.2: o elemento não possui filhos
				} else {
					current.value = son.value;
					parent.right = null;
				}
				return current;
			}
		}
			
		// se o valor é menor que o nó atual - passa o filho esquerdo como parâmetro
		if(value < current.value)
			current.left = removeRecursive(current.left, value);
		
		// se o valor é maior que o nó atual - passa o filho direito como parâmetro
		if(value > current.value)
			current.right = removeRecursive(current.right, value);
		
		// retorna o elemento atual como raíz
		return current;
		
	}
	
	// IMPRIME OS ELEMENTOS DA ÁRVORE
	public void print() {
		// verifica se a árvore está vazia
		if(isEmpty())
			System.out.printf("A árvore está vazia! \n");
		// chamada recursiva para percorrer a árvore e imprimir seus elementos
		printRecursive(root);
	}
	
	// PERCORRE A ÁRVORE E IMPRIME SEUS ELEMENTOS
	private void printRecursive(Node current) {
		if(current != null) {			
			System.out.printf("id_atual: %s \n", current);
			System.out.printf("valor_atual: %d \n", current.value);
			System.out.printf("id_esquerda: %s \n", current.left);
			System.out.printf("id_direita: %s \n", current.right);
			System.out.println("--");
			printRecursive(current.left);
			printRecursive(current.right);
		}
	}
	
	// MÉTODOS DE BUSCA
	// PROCURA UM ELEMENTO NA ÁRVORE
	public boolean contains(int value) {
		return containsRecursive(root, value);
	}
		
	// PERCORRE A ÁRVORE DE FORMA RECURSIVA
	private boolean containsRecursive(Node current, int value) {
		// se o elemento atual for nulo, a árvore chegou ao fim e o elemento não foi encontrado
		if(current == null)
			return false;
		// se o valor buscado for igual ao valor do nó atual, o elemento foi encontrado
		if (value == current.value)
			return true;
		// percorre a árvore de forma recursiva, verificando se o valor buscado é maior ou menor que o valor do nó atual
		return value < current.value ? containsRecursive(current.left, value) : containsRecursive(current.right, value);
	}
	
	// RETORNA O PAI DO ELEMENTO
	public int findParent(int value) {
		// verifica se o elemento buscado está na árvore
		if(!contains(value)) {
			System.out.printf("O valor não está inserido na árvore \n");
			return -1;			
		}
		
		Node parent = findParentRecursive(root, value);
		
		// se o pai do elemento é nulo, o elemento é a raiz da árvore
		if(parent == null) {
			System.out.printf("O elemento é a raiz da árvore \n");
			return -1;
		}
		
		// retorna o valor do pai do elemento buscado
		return parent.value;
	}
	
	// PERCORRE A ÁRVORE DE FORMA RECURSIVA E RETORNA O PAI DO ELEMENTO
	private Node findParentRecursive(Node current, int value) {
		// verifica se o elemento possui filho esquerdo e se seu valor é igual ao valor procurado
		if(current.left != null && current.left.value == value)
			return current;
		// verifica se o elemento possui filho direito e se seu valor é igual ao valor procurado
		if(current.right != null && current.right.value == value)
			return current;
		
		// chama a função de forma recursiva, passando o filho esquerdo como parâmetro
		Node left = findParentRecursive(current.left, value);
		if(left != null)
			return left;
		// chama a função de forma recursiva, passando o filho direito como parâmetro
		return findParentRecursive(current.right, value);
	}
	
	// RETORNA O MENOR ELEMENTO DA ÁRVORE
	public Integer min() {
		// verifica se a árvore está vazia
		if(isEmpty())
			return null;
		
		Node current = root;
		// percorre a árvore indo para o elemento mais à esquerda
		while(current.left != null) {
			current = current.left;
		}
		// retorna o menor elemento da árvore
		return current.value;
	}

	// RETORNA O MAXIOR ELEMENTO DA ÁRVORE
	public Integer max() {
		// verifica se a árvore está vazia
		if(isEmpty())
			return null;
		
		Node current = root;
		// percorre a árvore indo para o elemento mais à direita
		while(current.right != null) {
			current = current.right;
		}
		// retorna o maior elemento da árvore
		return current.value;
	}
	
}
