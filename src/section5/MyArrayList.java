package section5;

import java.util.Arrays;

public class MyArrayList<E> {
	private static final int INIT_CAPACITY = 10;
	private E [] theData;
	private int size;
	private int capacity = 0;
	
	public MyArrayList() {
//		theData = new E [INIT_CAPACITY]; NOT Working Generic Type Can't be new
		theData = (E []) new Object [INIT_CAPACITY];
		size = 0;
		capacity = INIT_CAPACITY;
	}
	
	public void add(int index, E anEntry) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if (size >= capacity) {
			reallocate();
		}
		for (int i = size -1 ; i >= index; i--) {
			theData[i+1] = theData[i];
		}
		
		theData[index] = anEntry;
		size ++;
	}
	
	private void reallocate() {
//		E [] tmp = (E []) new Object [INIT_CAPACITY];
		capacity *= 2;
		Arrays.copyOf(theData, capacity);
		
	}

	public void add(E anEntry) {
		add(size, anEntry);
	}	
	
	public int size() {
		return size;
	}
	
	public int indexOf(E anEntry) {
		for (int i=0; i<size;i++) {
			if (theData[i].equals(anEntry)) { //******
				return i;
			}
		}
		return -1;
	}
	
	public E get (int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}
	
	public E set (int index, E newValue) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue = theData[index];
		theData[index] = newValue;
		return oldValue;
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		E returnValue = theData[index];
		for (int i = index+1; i< size ; i++) {
			theData[i-1] = theData[i];
		}
		size --;
		return returnValue;
	}
	
	public static void main(String[] args) {
		MyArrayList<String> test = new MyArrayList<>();
		
		try {
		test.add(1, "Hello");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("----------");
		}
		
		System.out.println("NNNNNNNNNN");
		
	}
	
}
