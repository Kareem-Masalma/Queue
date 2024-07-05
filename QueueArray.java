
public class QueueArray {
	private int front;
	private int rear;
	private int maxSize;
	private Object[] queueArray;

	public QueueArray(int maxSize) {
		this.maxSize = maxSize;
		front = rear = -1;
		queueArray = new Object[maxSize];
	}

	public void enQueu(Object element) {
		if (isFull())
			System.out.println("The queue is Full");
		else if (!isEmpty()) {
			front++;
			rear++;
			queueArray[front] = element;
		} else {
			rear = (rear + 1) % maxSize;
			queueArray[rear] = element;
		}
	}

	public Object deQueue() {
		Object element = null;
		if (isEmpty())
			System.out.println("The queue is Empty");
		else if (front == rear) {
			element = queueArray[front];
			front = rear = -1;
		} else {
			element = queueArray[front];
			front = (front + 1) % maxSize;
		}
		return element;
	}

	public Object peek() {
		if (isEmpty()) {
			System.out.println("The queue is Empty");
			return null;
		} else
			return queueArray[front];
	}

	public boolean isFull() {
		return ((rear + 1) % maxSize == front);
	}

	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("The queue is Empty");
			return;
		}
		for (int i = front; i < maxSize - Math.abs(front - rear); i = (front + i) % maxSize) {
			System.out.println(queueArray[i]);
		}
	}

	public void clear() {
		front = rear = -1;
	}
}
