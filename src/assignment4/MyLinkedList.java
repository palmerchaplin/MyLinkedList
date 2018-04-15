/*
 * Copyright OrangeDog LLC.
 * All rights reserved.
 */
package assignment4;

import java.util.Iterator;

/**
 *
 * @author graham
 */
public class MyLinkedList<E> extends AbstractList<E> implements IFiniteList<E>, Iterable<E> {


	ListNode<E> head;
	ListNode<E> last;

	public MyLinkedList() {
		super();
		this.head = null;
		this.last = null;
	}

	// start at the head, hop i times, and return the node pointed to
	private ListNode<E> hop(int i) {
		ListNode<E> current = this.head;
		for (int j = 0; j < i; j++) {
			current = current.next;
		}

		return current;
	}

	public void delete(int i) {
		checkIndex(i);
		if (i == 0) {
			// deleting the head
			this.head = this.head.next;
		} else if (i == size - 1) {
			// deleting the tail
			ListNode<E> prev = hop(i - 1);
			this.last = prev;
		} else {
			ListNode<E> prev = hop(i - 1);
			ListNode<E> ith = prev.next;
			prev.next = ith.next;
			this.size--;
		}
	}

	public void set(E element, int i) {
		checkIndex(i);
		ListNode<E> current = hop(i);
		current.value = element;
	}

	// get from a list pointed to by this
	public E get(int i) {
		checkIndex(i);
		ListNode<E> current = hop(i);
		return current.value;
	}

	public void add(E d) {
		if (this.head == null) {
			// the list is empty
			ListNode<E> node = new ListNode<E>(d);
			this.head = node;
			this.last = node;
		} else {
			// ListNode current = this.head;
			// while (current.next != null)
			// {
			// // hop current
			// current = current.next;
			// }

			ListNode<E> node = new ListNode<E>(d);
			this.last.next = node;
			this.last = node;
		}
		this.size++;
	}

	// the list we are adding to is pointed to by this
	public void addFront(E d) {
		// make new node to contain d
		ListNode<E> node = new ListNode<E>(d);
		if (this.head == null) {
			// the list is empty so make the head point at the node
			this.head = node;
			this.last = node;
		} else {
			// the list it not empty, so the old head's next points at the node
			// the head points at the node
			node.next = this.head;
			this.head = node;
		}
		this.size++;
	}

	public void addMiddle(E d, int i) {
		checkIndex(i);
		if (i == 0) {
			this.addFront(d);
		} else {
			ListNode<E> prev = hop(i - 1);
			ListNode<E> node = new ListNode<E>(d);
			node.next = prev.next;
			prev.next = node;
		}
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		ListNode<E> current = this.head;
		while (current.next != null) {
			builder.append(current.value + ", ");
			current = current.next;
		}
		builder.append(this.last.value + "]");
		return builder.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new MyLinkedListIterator<>(this);
	}
}