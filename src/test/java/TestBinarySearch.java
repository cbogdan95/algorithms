import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestBinarySearch {
	
	@Test
	public void testBinarySearchNullCollection() {
		Collection c = null;
		Exception exception = assertThrows(IllegalArgumentException.class,
											() -> BinarySearch.binarySearch(c, null, null));
		
		String exceptionMessage = exception.getMessage();
		
		assertEquals("Null parameter", exceptionMessage);
	}

	@Test
	public void testBinarySearchEmptyCollection() {
		Collection<Integer> c = List.of();

		assertFalse(BinarySearch.binarySearch(c, 10, Comparator.naturalOrder()));
	}

	@Test
	public void testBinarySearchArrayFlow() {
		String [] str = {"Test1", "Test2", "Test3"};

		assertTrue(BinarySearch.binarySearch(str, "Test2", Comparator.naturalOrder()));
		assertFalse(BinarySearch.binarySearch(str, "Test4", Comparator.naturalOrder()));
	}
	
	@Test
	public void testBinarySearchExistingResult() {
		class TestClass {
			int age;
			
			TestClass(int age) {
				this.age = age;
			}
		}
		
		TestClass s1 = new TestClass(7);
		TestClass s2 = new TestClass(8);
		TestClass s3 = new TestClass(3);
		TestClass s4 = new TestClass(5);
		TestClass s5 = new TestClass(15);
		
		List<TestClass> students = new ArrayList<TestClass>(List.of(s1, s2, s3, s4));
		Comparator<TestClass> comparator = Comparator.comparingInt((TestClass st) -> st.age);
		Collections.sort(students, comparator);
		
		assertTrue(BinarySearch.binarySearch(students, s1, comparator));
		assertTrue(BinarySearch.binarySearch(students, s2, comparator));
		assertTrue(BinarySearch.binarySearch(students, s3, comparator));
		assertTrue(BinarySearch.binarySearch(students, s4, comparator));
		assertFalse(BinarySearch.binarySearch(students, s5, comparator));
	}

}
