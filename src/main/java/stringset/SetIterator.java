package stringset;

import java.util.HashMap;

import bitVector.BitVector;
import bitVector.Iterator;

public class SetIterator implements Iterator <String> {
	
	private Iterator<Integer> iterator;
	private HashMap<Integer, String> mapping;
	
	public SetIterator(BitVector adaptee, HashMap<Integer, String> mapping) {
		iterator = adaptee.iterator();
		this.mapping = mapping;
	}
	@Override
	public boolean hasAnotherElement() {
		// TODO Auto-generated method stub
		return iterator.hasAnotherElement();
	}

	@Override
	public String nextElement() {
		// TODO Auto-generated method stub
		return mapping.get(iterator.nextElement());
	}

}
