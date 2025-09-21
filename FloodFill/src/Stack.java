public class Stack<T> {
    private T[] data;  // vetor que guarda os elementos
    private int top;  //  índice do topo da pilha
    private int capacity;  // tamanho máximo da pilha

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        capacity = size;
        data = (T[]) new Object[size];  // cria vetor de tamanho 'size'
        top = -1; // pilha começa vazia
    }

    // Empilhar (adicionar elemento no topo)
    public void push(T value) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack overflow");
        }
        data[++top] = value; //coloca no top
    }

    // Desempilhar (remover do topo)
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return data[top--]; // remove do topo
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
