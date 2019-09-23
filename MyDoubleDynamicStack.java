package hint3;

public class MyDoubleDynamicStack<T> implements MyStack<T> {
	public MyDoubleLinkedNode<T> head;
	public MyDoubleLinkedNode<T> tail;

	
	public MyDoubleDynamicStack(){
		this.head = null;
		this.tail = null;
	}

	
	public boolean isEmpty(){
		if(head == null && tail == null) { return true; }
		else { return false; }
	}
	
	
	public T first(){
		if(head == null) {
			System.out.println("ERROR: The stack is empty");
			return null;
		}
		else {
		return this.head.getInfo();
		}
	}


	public void addByFirst(T element){
		MyDoubleLinkedNode<T> newNode = new MyDoubleLinkedNode<T>(null, element, null);
		if(isEmpty()) {
			tail = newNode;
			head = newNode;
		}
		else {
			head.setLeft(newNode);
			newNode.setRight(head);
			head = head.getLeft();
		}
		newNode.setLeft(null);
	}
	
	public void removeByFirst(){		 
		MyDoubleLinkedNode<T> Temp = null;
		if(isEmpty()) {
			System.out.println("ERROR: The list is empty");
		}
		else if(head == tail) {
			tail = null;
			head = null;
		}
		else {
			Temp = head;
			head = head.getRight();
			head.setLeft(null);
			Temp.setRight(null);
		}
		
	}

	public T last(){
		if(tail == null) {
			System.out.println("ERROR: The list is empty");
			return (T) null;
		}
		else {
		return tail.getInfo();
		}
    }

	public void addByLast(T element){
		 MyDoubleLinkedNode<T> newNode = new MyDoubleLinkedNode<T>(null, element, null);
		 if(isEmpty()) {
			 head = newNode;
			 tail = newNode;
		 }
		 else {
			 tail.setRight(newNode);
			 newNode.setLeft(tail);
			 tail = newNode;
		 }
		 newNode.setRight(null);
	}
	
	public void removeByLast(){
		MyDoubleLinkedNode<T> Temp = null;
		if(isEmpty()) {
			System.out.println("ERROR, The list is empty.");
		}
		else if(head == tail) {
			tail = null;
			head = null;
		}
		else {
			Temp = tail;
			tail = tail.getLeft();
			tail.setRight(null);
			Temp.setRight(null);
		}
	}
}
