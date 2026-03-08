public class MyQueue {

	int rear;
	int front;
	int size;
	int capacity;
	int[] queue;

	public MyQueue(int capacity){

		queue = new int[capacity];
		this.capacity = capacity;
		size = 0;
		rear = front = -1;
	}

	public boolean isEmpty(){

		if(front == -1 || rear == -1)	return true;
		return false;
	}

	public boolean isFull(){

		if(rear == capacity - 1)	return true;
		return false;
	}

	public int Size(){
		return size;
	}

	public int peek(){

		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}
		return queue[front];
	}

	public void enqueue(int val){
		
		if(isFull()){
			System.out.println("Queue is full");
			return;
		}

		if(isEmpty()){
			rear = front = 0;
		} else {
			rear++;
		}

		size++;
		queue[rear] = val;
	}

	public int dequeue(){

		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}

		int val = queue[front];
		if(front == rear){
			front = -1;
			rear = -1;
		} else {
			front++;
		}
		
		size--;
		return val;
	}

	public void printQueue(){

		if(isEmpty()){

			System.out.println("Queue is empty");
			return;
		}

		for(int idx = front ; idx <= rear ; idx++){
			System.out.print(queue[idx] + " ");
		}

		System.out.println();
	}
	public static void main(String[] args) {
		
		MyQueue myQueue = new MyQueue(5);
		myQueue.enqueue(5);
		myQueue.enqueue(3);
		myQueue.dequeue();
		myQueue.printQueue();
	}
}
