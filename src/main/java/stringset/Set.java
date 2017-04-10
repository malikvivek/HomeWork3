package stringset;

import bitVector.Iterator;

public interface Set<T> {
	
	/*
	 * Implement add to add an element to the set
	 */
	void add ( T t );
	
	/*
	 * Implement addAll to add all elements in the argument set
	 */
	void addAll ( Set<T> s );
	
	/*
	 * Implement remove to remove an element to the set
	 */
	void remove ( T t );
	
	/*
	 * Implement size to return the number of arguments to the set
	 */
	int size ();
	
	/*
	 * Implement iterator to return the iterator over set.
	 */
	Iterator<T> iterator ();
	
}
