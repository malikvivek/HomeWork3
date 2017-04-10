package bitVector;

public class ImplementIterator implements Iterator<Integer>{
	
	private int indexPosition;
	private int size;
	private BitVector bVector;
	
	public ImplementIterator( BitVector bitObj){

		this.indexPosition = 0;
		this.size = (bitObj.getWords().length * 32 );
		this.bVector = bitObj;
		
	}
	
	@Override
	public boolean hasAnotherElement() {
		// TODO Auto-generated method stub
		
		boolean result = ((( size ) - indexPosition) > 0) ? true:false;
//		System.out.println(result + "     " + size + "   " + indexPosition);
		return result;
		
	}

	@Override
	public Integer nextElement() {
		// TODO Auto-generated method stub
		
		while (indexPosition < size ) {
			indexPosition++;
			if (bVector.get(indexPosition))
				break;
		}
		return indexPosition;
//		int start = indexPosition;
//		for (; start < ( size ); start++) {
//			if ( bVector.get (start) )
//				break;
//		}
//		indexPosition = start + 1;
//		return start; 
		
	}

}
