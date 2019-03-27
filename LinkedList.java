class Node<T> {
	T data;
	Node next;

	public Node(T data){
		this.data = data;
	}

	public T get(){
		return data;
	}

	public Node getNext(){
		return next;
	}

	public void setNext(Node next){
		this.next = next;
	}
}


public class LinkedList<T> implements List<T> {
	int size;
	Node head;

	public LinkedList(){
		head = null;
		size = 0;
	}

	public void add(T item){
		/* if there's no node at the head */
		if (this.head == null){
			/* set the head to be the new node and set the next pointer to be null */
			head = new Node(item);
			head.setNext(null);
			this.size++;
		} else {
			/* start at the head and advance pointer until you hit the last element */
			Node curr = head;
			while (curr.next != null){
				curr = curr.next;
			}

			/* create new node, set the next pointer in it to be null */
			Node node = new Node(item);
			node.setNext(null);

			/* set the previous pointer's next pointer to be the new node */
			curr.setNext(node);
			this.size++;
		}
	}

	public void add(int pos, T item){

		/* if the position to be added at is zero */
		if (pos == 0){
			/* change the head to be the new node and set the next to be null */
			Node n = new Node(item);
			n.setNext(head);
			head = n;
			++size;
		} else {
			/* create a new node */
			Node<T> n = new Node(item);

			/* set the previous to be head and increment through list to find the latest filled node */
			Node prev = head;
			for (int i = 0; i < pos - 1; i++){
				prev = prev.getNext();
			}

			/* insert the new node between previous's node and the next node to previous */
			n.setNext(prev.getNext());
			prev.setNext(n);
			++size;
		}
	}

	public T get(int pos){

		/* create a node pointer and increment through the list until you get to the position */
		Node<T> n = head;
		for (int i = 0; i < pos; i++){
			n = n.getNext();
		}

		/* return the position's data */
		return n.get();
	}


	public T remove(int pos){
		/* if you need to remove the first item */
		if (pos == 0){
			/* set the head to be the next of head */
			Node<T> curr = head;
			head = head.getNext();
			this.size--;
			return curr.data;
		}

		/* set previous to be the head */
		Node prev = head;
		for (int i = 0; i < pos - 1; i++){
			/* traverse the list until you get to the position */
			prev = prev.getNext();
		}

		/* remove and set the previous's new next node */
		Node<T> curr = prev.getNext();
		prev.setNext(curr.getNext());
		size--;
		return curr.data;
	}

	public int size(){
		/* return the size of the List */
		return this.size;
	}
}