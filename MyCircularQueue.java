public class MyCircularQueue {

	int rear;
	int front;
	int size;
	int capacity;
	int[] circularQueue;

	public MyCircularQueue(int capacity){

		circularQueue = new int[capacity];
		this.capacity = capacity;
		size = 0;
		rear = front = -1;
	}

	public boolean isEmpty(){

		return (size == 0);
	}

	public boolean isFull(){

		return (size == capacity);
	}

	public int Size(){
		return size;
	}

	public int peek(){

		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}
		return circularQueue[front % capacity];
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
		circularQueue[rear % capacity] = val;
	}

	public int dequeue(){

		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}

		int val = circularQueue[front % capacity];
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
			System.out.print(circularQueue[idx % capacity] + " ");
		}

		System.out.println();
	}
	public static void main(String[] args) {
		
		MyCircularQueue myCircularQueue = new MyCircularQueue(5);
		myCircularQueue.enqueue(5);
		myCircularQueue.enqueue(3);
		myCircularQueue.dequeue();
		myCircularQueue.printQueue();
	}
}
