package edu.neu.coe.info6205.final_project;

import java.util.Iterator;

public interface Bag<Item> extends Iterable<Item> {

	void add(Item item);
	boolean isEmpty();
	int size();
	Iterator<Item> iterator();
	
}
