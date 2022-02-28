import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class BinarySearch {

	public static <T>  boolean binarySearch(
			Collection<T> collection, T element, Comparator<T> comparator) {
		
		if (collection == null || element == null || comparator == null) {
			throw new IllegalArgumentException("Null parameter");
		}
		
		if (collection.size() == 0) {
			return false;
		}
		
		T [] array = (T[]) collection.toArray();
		
		return recursiveSearch(array, element, comparator);
	}
	
	public static <T>  boolean binarySearch(
			T [] array, T element, Comparator<T> comparator) {
		
		return recursiveSearch(array, element, comparator);
	}
	
	private static <T>  boolean recursiveSearch(
			T [] array, T element, Comparator<T> comparator) {
		
		if (array.length == 0) {
			return false;
		}
		
		int midIndex = (array.length - 1) / 2;
		T midElement = array[midIndex];
		
		int comparisonResult = comparator.compare(element, midElement);
		
		if (comparisonResult == 0) {
			return true;
		} else if (comparisonResult < 0) {
			return recursiveSearch(
					Arrays.copyOfRange(array, 0, midIndex), 
					element, 
					comparator
				);
		} else {
			return recursiveSearch(
					Arrays.copyOfRange(array, midIndex + 1, array.length),
					element, 
					comparator
				);
		}
	}
}
