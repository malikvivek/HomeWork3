package bitVector;

import java.util.*;

public class BitVector {
	
	/*
	 * get
	 * - This method determines if the bit at position 'i' is set
	 * - returns true if the bit is set and false if not
	 * 
	 * @param i | Integer type argument
	 */
	
	public boolean get( int i ) {

		int wordSize = (int) Math.floor( (double) i / 32 );
		int bitPosition = ( i % 32 );
		if (wordSize >= words.length)
			return false;
		if ( ((words[wordSize]) & (1 << bitPosition)) != 0 )
			return true;
		else
			return false;
		
	} 
	
	/*
	 * set
	 * - This method Set the bit at position i.
	 * 
	 * @param i | Integer type argument
	 */
	
	public void set ( int i ) {
		
		int indexToSet = (int)Math.floor((double) i / 32);
		if ( indexToSet >= words.length ) {
			int []temp = Arrays.copyOf( words, (indexToSet + 1) );
			words = temp;
		}
		
		int bitPosition = ( i % 32);
		words [indexToSet] |= ( 1 << bitPosition );
		
	}

	/*
	 * clear
	 * - This method Clears the bit at position i.
	 * 
	 * @param i | Integer type argument
	 */
	public void clear(int i){
		int wordSize = (int) Math.floor( (double) i / 32 );
		int bitPosition = ( i % 32 );
		words [wordSize] = (words [wordSize]) & (~( 1 << bitPosition));
	}
	
	/*
	 * addAll
	 * - This method Set the bits in the argument BitVector b.
	 * 
	 * @param b | BitVector type argument
	 */
	
	public void addAll(BitVector b) {
		for ( Iterator<Integer> iterator = b.iterator(); iterator.hasAnotherElement(); ) {
			int element = (int) iterator.nextElement();
			set ( element );
		}
		
	}  
	
	public Iterator<Integer> iterator() { 
		return new ImplementIterator(this);
	}
	
	public int size() {
		
		int sizeOfArray = 0;
		for ( int i = 0; i < (words.length * 32); i++ ){
			if ( get(i) )
				sizeOfArray++;
		}
		return sizeOfArray;
		
	}
	
	private int[] words;
	
	public BitVector() {
		this.words = new int[1];
	}
	
	public int[] getWords() {
		int retWords[] = words;
		return retWords;
	}
	
//	public static void main(String []args) {
		
//		BitVector testObj = new BitVector();
//		testObj.set(31);
//		testObj.set(60);
//		BitVector testObj2 = new BitVector();
//		testObj2.set(40);
//		testObj2.set(51);
//		testObj.addAll(testObj2);
//		
//		System.out.println((testObj.words).toString());
		
//		int []arr = {1,2,3,4};
//		Vector<Integer> vector = new Vector<>(); //Diamonds are allowed in 7+
//		vector.add(10);
//		vector.add(100);
//		vector.add(1000);
//		System .out.println("Value is: "+vector.get(1));
//		List<Vector> list = new ArrayList<Vector>();
//		list.add(vector);
//		ImplementIterator it = new ImplementIterator(arr);
//		while (it.hasAnotherElement()) {
//			Object element = it.nextElement();
//			System.out.print(element + " ");
//		}
//		
//		Vector<Integer> vector = new Vector<>(); //Diamonds are allowed in 7+
//		vector.add(1);
//		vector.add(2);
//		vector.add(3);
//		System .out.println("Value is: "+vector.get(1));
//		List<Integer> list = new ArrayList<Integer>();
//		list.addAll(vector);
//		System.out.println("");
//		
//		List<Integer> intSetTest = new ArrayList<Integer>(Arrays.asList(0,1,1,4));
//		BitVector b = new BitVector();
//		int maxVal = Collections.max(intSetTest);
//		int size = maxVal*32;
//		b.arrSize = size;
//		b.get(3);
////		ImplementIterator itNew = new ImplementIterator(intSetTest);
////		while (itNew.hasAnotherElement()) {
////			Object element = itNew.nextElement();
////			System.out.print(element + " ");
////			b.set(i);
////		}
////		String tryStr = "0011010";
////		byte testInt = 0b00101;
//////		int testInt = Integer.parseInt(tryStr);
////		System.out.println(testInt);
////		b.set(2);
////		b.set(3);
//		
//		System.out.println("New String is:"+b.boolValues.toString() + " "+ b.arrSize);
//	}
}