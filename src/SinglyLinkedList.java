
public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

// Returns the number of elements in the list.
	public int size() {
		return size;
	}
// Returns true if the list is empty, and false 	otherwise.

	public boolean isEmpty() {
		return size() == 0;
	}

// Returns (but does not remove) the first element inthe list.

	public E first() {
		return head.getData();
	}

// Returns (but does not remove) the last element in the list.

	public E last() {
		return tail.getData();
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		if (isEmpty()) {
			head = tail = new Node<E>(e);
		} else {
			Node<E> first = new Node<E>(e);
			first.setNext(head);
			head = first;
		}

	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		if (isEmpty()) {
			head = tail = new Node<E>(e);
		} else {
			Node<E> last = new Node<E>(e);
			tail.setNext(last);
			tail = last;
		}
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (isEmpty())
			throw new RuntimeException();
		E data = head.getData();
		head = head.getNext();
		size--;
		if (isEmpty())
			tail = null;
		return data;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		if (isEmpty())
			throw new RuntimeException();
		E data = tail.getData();
		Node<E> current = head;
		while (current.getNext() != null) {
			if (current.getNext().equals(tail)) {
				tail = null;
			}
			current = current.getNext();
		}	
		size--;
		if (isEmpty())
			head = null;
		return data;
	}
}