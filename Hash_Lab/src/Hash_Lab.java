
public class Hash_Lab {

	public static void main(String arg[]) {
		int[] arr = {27, 53, 13, 10, 138, 109, 49, 174, 26, 24};
		//LQHash(arr);
		BucketHash(arr);
	}
	
	public static void LQHash(int[] a) {
		int q, index, offset, n =13;
		int[] hash = new int[n];
		for(int i = 0; i< a.length; i++) {
			index = a[i] % n;
			q = a[i] / n;
			if(q%n != 0) {
				offset = q;
			}
			else
				offset = 19;
			while(hash[index]!=0) {
				index = (index + offset) % n;
			}
			hash[index] = a[i];
		}
		for(int i : hash) {
			System.out.println(i);
		}
	}
	
	public static void BucketHash(int[] a) {
		Node[] hash = new Node[a.length];
		int index;
		for(int i =0; i<a.length; i++) {
			index = a[i] % 10;
			if(hash[index] == null) {
				hash[index] = new Node();
				hash[index].num = a[i];
			}
			else {
				Node n = new Node(a[i]);
				n.next = hash[index].next;
				hash[index].next = n;
			}
		}
		for(Node n : hash) {
			if(n != null) {
				System.out.print(n.num + " ");
				if(n.next!=null) {
					Node c = n.next;
					System.out.print(c.num + " ");
					while(c.next != null) {
						System.out.print(c.num + " ");
						c = n.next;
					}
				}
			}
			else
				System.out.print("null");
			System.out.println();
		}
	}	
	
}
