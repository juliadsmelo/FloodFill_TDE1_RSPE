// Implementação de uma Fila (FIFO: First In, First Out)
public class Queue<T> {
    private T[] data;       // vetor que guarda os elementos
    private int front, rear, size, capacity;

    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enfileirar (adicionar no fim da fila)
    public void enqueue(T value) {
        if (size == capacity) {
            throw new RuntimeException("Queue overflow");
        }
        rear = (rear + 1) % capacity;
        data[rear] = value;
        size++;
    }

    // Desenfileirar (remover do início da fila)
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        T value = data[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    // Verificar se a fila está vazia
    public boolean isEmpty() {
        return size == 0;
    }
}
