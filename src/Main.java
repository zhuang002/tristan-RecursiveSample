import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//binarySeachSample();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(feb(n));
	}
	
	private static int feb(int n) {
		// TODO Auto-generated method stub
		// f(n) = f(n-1)+f(n-2); f(0) = 0, f(1) = 1;
		/*int prev1 = 0;
		int prev2 = 1;*/
		if (n==0) return 0;
		if (n==1) return 1;
		/*for (int i=2; i<=40;i++) {
			int current = prev1+prev2;
			prev1 = prev2;
			prev2 = current;
		}
		return prev2;*/
		return feb(n-1)+feb(n-2);
		
	}

	private static void binarySeachSample() {
		// TODO Auto-generated method stub
		String[] names;
		names = sc.nextLine().split(" ");
		Arrays.sort(names);
		for (String name:names) {
			System.out.println(name);
		}
		
		int index = search(names, "John");
		if (index<0)
		{
			System.out.println("I cannot find John");
		} else {
			System.out.println("John is at position "+index);
		}
		
		index = binarySearch(names, "John");
		if (index<0)
		{
			System.out.println("I cannot find John");
		} else {
			System.out.println("John is at position "+index);
		}
		
		// binary search only apply to sorted sequences
		index = Arrays.binarySearch(names, "John");
		if (index<0)
		{
			System.out.println("I cannot find John");
		} else {
			System.out.println("John is at position "+index);
		}
	}

	private static int binarySearch(String[] names, String name) {
		// TODO Auto-generated method stub
		return recursiveBinarySearch(names, 0, names.length-1, name);
	}

	private static int recursiveBinarySearch(String[] names, int start, int end, String name) {
		// TODO Auto-generated method stub
		
		// learning point: recursive method(function)
		// definition: a function which calls itself.
		// noting point: you must downsize the parameter(s).
		// noting point: there must be an exit point.
		
		// exit point
		if (start > end) {
			return -1;
		}
		if (start == end) {
			if (names[start].equals(name))
				return start;
			else
				return -1;
		}
		
		
		
		// recursive body
		int indexToCompare = (start+end)/2;
		int compare = names[indexToCompare].compareTo(name);
		if (compare<0) {
			return recursiveBinarySearch(names, indexToCompare+1, end, name);
		} else if (compare>0) {
			return recursiveBinarySearch(names, start, indexToCompare-1, name);
		} else { // equal
			return indexToCompare;
		}
	}

	private static int search(String[] names, String name) {
		// TODO Auto-generated method stub
		// we will use n compares where n = names.length; the best case is 1 compares, 
		// the worst case is to compare n times. the average is n/2
		
		for (int i=0;i<names.length;i++) {
			if (names[i].equals(name))
				return i;
		}
		return -1;
	}
	
	

}
