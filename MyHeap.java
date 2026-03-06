public class MyHeap{

	int heapSize;
	int[] heap;
	int capacity;

	MyHeap(int[] arr){
		heap = arr;
		heapSize = arr.length;
		capacity = arr.length;
	}

	public void swap(int idx, int jdx){

		int temp = heap[idx];
		heap[idx] = heap[jdx];
		heap[jdx] = temp;
	}

	public void increaseCapacity(){

		capacity *= 2;
		int newHeap[] = new int[capacity];

		for(int idx = 0 ; idx < heapSize ; idx++){

			newHeap[idx] = heap[idx];
		}

		heap = newHeap;
	}

	public void heapify(int index){

		int largestIndex = index;
		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;

		if(leftChildIndex < heapSize && heap[leftChildIndex] > heap[largestIndex]){
			largestIndex = leftChildIndex;
		}

		if(rightChildIndex < heapSize && heap[rightChildIndex] > heap[largestIndex]){
			largestIndex = rightChildIndex;
		}

		// if leaf child :: this will not execute as largest == index
		// if parent(index) is largest :: none of above statement will execute

		// if max of parent and child nodes is not the parent
		// swap and heapify the new largestIndex :: which is actually the swapped value 
		if(largestIndex != index){
			swap(index, largestIndex);
			heapify(largestIndex);
		}
	}

	public int extractMax(){

		if(heapSize == 0){
			System.out.println("Heap is empty!!");
			return -1;
		}

		int max = heap[0]; 	// store the root
		heap[0] = heap[heapSize - 1];
		heapSize--;			// delete the last node
		heapify(0);
		return max;
	}

	public void extractMaxAndStore(){

		if(heapSize == 0){
			System.out.println("Heap is empty!!");
			return;
		}

		int max = heap[0]; 	// store the root
		heap[0] = heap[heapSize - 1];
		heap[heapSize - 1] = max;

		heapSize--;			// delete the last node
		heapify(0);
		return;
	}

	// check with parent
	// if parent smaller :: swap (bottom -> top)
	public void increaseKey(int index, int newValue){

		if(index < 0 || index >= heapSize || heap[index] >= newValue){

			System.out.println("Wrong operation");
			return;
		}

		heap[index] = newValue;

		// child value greater than parent and child != root
		while(index > 0 && heap[index] > heap[ (int)(Math.ceil(index/2.0) - 1)]){

			swap(index, (int)(Math.ceil(index/2.0) - 1));
			index = (int)(Math.ceil(index/2.0) - 1);		// move to parent
		}
	}

	public void decreaseKey(int index, int newValue){

		// see the child and heapify
		if(index < 0 || index >= heapSize || heap[index] <= newValue){

			System.out.println("Wrong operation");
			return;
		}

		heap[index] = newValue;
		heapify(index);

		// child value greater than parent and child != root
		while(index > 0 && heap[index] > heap[ (int)(Math.ceil(index/2.0) - 1)]){

			swap(index, (int)(Math.ceil(index/2.0) - 1));
			index = (int)(Math.ceil(index/2.0) - 1);		// move to parent
		}
	}

	public void insert(int newValue){

		if((heapSize + 1) >= capacity){

			increaseCapacity();
		}

		heapSize++;
		heap[heapSize - 1] = newValue;

		int index = heapSize - 1;

		// child value greater than parent and child != root
		while(index > 0 && heap[index] > heap[ (int)(Math.ceil(index/2.0) - 1)]){

			swap(index, (int)(Math.ceil(index/2.0) - 1));
			index = (int)(Math.ceil(index/2.0) - 1);		// move to parent
		}
	}

	public void buildTree(){

		// last internal node(n/2 - 1) -> root(0)
		for(int idx = (heapSize / 2) - 1 ; idx >= 0 ; idx--){
			heapify(idx);
		}
	}

	public int[] heapSort(){

		buildTree();
		int size = heapSize;

		for(int idx = 0 ; idx < size ; idx++){
			extractMaxAndStore();
		}

		return heap;
	}

	public void printTree(){

		for(int idx = 0 ; idx < heapSize ; idx++){
			System.out.print(heap[idx] + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = new int[] {10, 5, 20, 6, 11};
		MyHeap heap = new MyHeap(arr);
		heap.buildTree();
		heap.printTree();

		System.out.println("Removed max element is: " + heap.extractMax());
		heap.printTree();

		heap.increaseKey(3, 15);
		heap.printTree();

		heap.decreaseKey(0, 8);
		heap.printTree();

		heap.insert(25);
		heap.printTree();

		int[] res = heap.heapSort();

		for(int idx = 0 ; idx < res.length ; idx++){
			System.out.print(res[idx] + " ");
		}

		System.out.println();
	}
}