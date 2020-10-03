
public class ArraySum {
	public int sumOfArray(Integer[] a, int index) {
		int sum = 0;
		if(index == a.length) {
			return 0;
		}
		else if(a[index] != null){
			sum = a[index];
			sum = sum + sumOfArray(a,index+1);
		}
		return sum;
	}
}
