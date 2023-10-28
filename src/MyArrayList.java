import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

// creates an array of double-size if the array of elements is full

	public void growSize() {
		elements = Arrays.copyOf(elements, size()*2);
	}

// Returns the number of elements in this list.
	public int size() {
		size=elements.length;
		return size;
	}

// Returns whether the list is empty.
	public boolean isEmpty() {
		return size()==0;
	}

// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if(i>=size()) throw new IndexOutOfBoundsException();
		return elements[i];
	}
	// Replaces the element at index i with e, and returns the replaced element. ∗/

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if(i>=size()) throw new IndexOutOfBoundsException();
		E temp = elements[i];
		elements[i] = e;
		return temp;
	}
	// It is used to append the specified element at the end of a list.

	public boolean add(E e) {
		if(size()==elements.length) {
			growSize();
		}
		elements[size()-1]=e;
		
		return true;
	}
	// Inserts element e to be at index i, shifting all subsequent elements later.

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if(i>=size()) throw new IndexOutOfBoundsException();
		for (int j = i; j < size(); j++) {
			if(size()==elements.length) growSize();
			elements[j+1] = elements[j];
		}
		elements[i]=e;
		
	}
	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.

	public E remove(int i) throws IndexOutOfBoundsException {
		if(i>=size()) throw new IndexOutOfBoundsException();
		for (int j = i+1; j < size(); j++) {
			elements[j-1] = elements[j];
		}
		
		return elements[i];
	}

	// It is used to clear all elements in the list.
	public void clear() {
		elements=(E[]) new Object[DEFAULT_CAPACITY];
	}
	// It is used to return the index in this list of the last occurrence of the
	// specified element, or -1 if the list does not contain this element.

	public int lastIndexOf(Object o) {
		for (int i = size(); i >= 0 ; i++) {
			if(o.equals(elements[i])) return i;
		}
		return -1;
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order.
	public E[] toArray() {
		return elements;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> clone = new MyArrayList<E>(elements.length);
		
		for (int i = 0; i < size(); i++) {
			elements[i]=clone.set(i, elements[i]);
		}
		return clone;
	}
	// It returns true if the list contains the specified element

	public boolean contains(E o) {
		for (int i = 0; i < size(); i++) {
			if(elements[i].equals(o)) return true;
		}
		return false;
	}
	// It is used to return the index in this list of the first occurrence of the
	// specified element, or -1 if the List does not contain this element.

	public int indexOf(E o) {
		for (int i = 0; i < size(); i++) {
			if(elements[i].equals(o)) return i;
		}
		return -1;
	}
	// It is used to remove the first occurrence of the specified element.

	public boolean remove(E e) {
		int i=indexOf(e);
		elements[i]=null;
		return true;
	}
	// It is used to sort the elements of the list on the basis of specified
	// comparator.

	public void sort(Comparator<E> c) {
		Arrays.sort(elements, c);
	}
}
