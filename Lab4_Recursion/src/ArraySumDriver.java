public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		ArraySum arraySum = new ArraySum();

		myArray[index++] = 3;
		myArray[index++] = 5;
		myArray[index++] = 2;
		myArray[index++] = 6;

		int sum = arraySum.sumOfArray(myArray, 3);
		printArray(myArray);
		System.out.println(sum);

		myArray[index++] = 7;
		myArray[index++] = 1;

		sum = arraySum.sumOfArray(myArray, 5);
		printArray(myArray);
		System.out.println(sum);
	}

	public static void printArray(Integer[] a) {
		for (int i = 0; i<a.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i<a.length; i++) {
			if(a[i]!=null)
				System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}