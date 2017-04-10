package bitVector;

public interface Iterator<T> {
	boolean hasAnotherElement();
	T nextElement();
}
