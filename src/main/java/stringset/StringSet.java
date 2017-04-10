package stringset;

import java.util.HashMap;

import bitVector.BitVector;
import bitVector.Iterator;

public class StringSet implements Set<String> {
	
	private BitVector adaptee;
	private HashMap <Integer, String> mapping;
	
	public StringSet() {
		adaptee = new BitVector();
		mapping = new HashMap<Integer, String>();
	}
	
	@Override
	public void add(String t) {
		// TODO Auto-generated method stub
		
		int position = adaptee.size();
		
		while ( adaptee.get(position) ) {
			position += 1;
		}
		
		mapping.put(position, t);
		adaptee.set(position);
	}

	@Override
	public void addAll(Set<String> s) {
		// TODO Auto-generated method stub
		
		for ( Iterator<String> iterator = s.iterator(); iterator.hasAnotherElement();) {
			String str = (String) iterator.nextElement();
//			System.out.println(str);
			this.add(str);
		}
	}

	@Override
	public void remove(String t) {
		// TODO Auto-generated method stub
		
		int position = -1;
		for ( int key: mapping.keySet() ) {
			if ( mapping.get(key).equals(t))
				position = key;
		}
		if ( position != -1 ) {
			mapping.remove(position);
			adaptee.clear(position);
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return adaptee.size();
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new SetIterator(adaptee, mapping);
	}

}
