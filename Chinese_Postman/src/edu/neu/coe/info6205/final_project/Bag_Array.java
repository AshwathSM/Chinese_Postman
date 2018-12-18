package edu.neu.coe.info6205.final_project;

import java.util.Arrays;
import java.util.Iterator;

public class Bag_Array<Item> implements Bag<Item> {
	
	private Item[] items = null;
	private int count = 0;
	
	public Bag_Array()
	{
		grow((Item[])new Object[0], 32);
	}
	
	public int size()
	{
		return count;
	}
	
	public Iterator<Item> iterator()
	{
		return Arrays.asList(Arrays.copyOf(items,count)).iterator();
	}
	
	public boolean isEmpty()
	{
		return count==0;
	}
	
	private int capacity()
	{
		return items.length;
	}
	

	
	private boolean full()
	{
		return size()==capacity();
	}
	
	public void add(Item item)
	{
		if(full())
			grow(items,2*capacity());
		items[count++]=item;
	}
	
	
		
	private static <T> T[] growFrom(T[] from, int size)
	{
		T[] result = (T[]) new Object[size];
		System.arraycopy(from, 0, result, 0, from.length);
		return result;
	}
	
	private void grow(Item[] source, int size)
	{
		items = growFrom(source, size);
	}
	
	
	

}
