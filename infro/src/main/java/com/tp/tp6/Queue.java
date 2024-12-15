package com.tp.tp6;

import java.util.LinkedList;

public class Queue<E> {
    private LinkedList<E> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E elem) {
		if (elem == null) {
            throw new QueueNullElementException("Null elements are not allowed in the queue");
        }
        list.addLast(elem);
    }

    public E pop() {
        if (isEmpty()) {
            throw new QueueEmptyException("Cannot pop from an empty queue");
        }
        return list.removeLast();
    }

	public int size(){
		if(list.size() == 0){
			throw new QueueEmptyException("Size cannot be zero");
		}
		return list.size();
	}
	public E front(){
		if (isEmpty()) {
            throw new QueueEmptyException("Cannot retrieve from an empty queue");
        }
		return list.getFirst();

	}
}


// 1- i can follows FIFO (First In, First Out)
// 2- give me helper functions : addLast / removeFirst / getFirst / isEmpty / size