import java.util.PriorityQueue;

class NewStudent implements Comparable<NewStudent>{

	int marks;
	String name;

	NewStudent(String name, int marks){
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student name: " + this.name + " ,marks: " + this.marks;
	}

	@Override
	public int compareTo(NewStudent that) {
		// this smaller than that :: -ve	-> leave as it is
		// that smaller than this :: +ve	-> swap
		// equal :: 0						-> leave as it is
		if(this.marks == that.marks)	return this.name.compareTo(that.name);		
		return this.marks - that.marks; 	// ascending :: less marks more priority
	}

	@Override
	public boolean equals(Object obj) {
		// tells how two objects are compared
		if(obj instanceof NewStudent){
			NewStudent that = (NewStudent) obj;
			if(this.marks == that.marks && (this.name.compareTo(that.name)) == 0)	return true;
		}
		return false;	
	}
}

public class MyPriorityQueue {
	public static void main(String[] args) {
		
		PriorityQueue<NewStudent> pq = new PriorityQueue<>();
		pq.offer(new NewStudent("anshika", 95));
		pq.offer(new NewStudent("ansh", 90));
		pq.offer(new NewStudent("astha", 85));
		System.out.println(pq.peek());
		System.out.println(pq.contains(new NewStudent("anshika", 95)));
	}
}
