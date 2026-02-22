package memory;
public class MemoryManagement {
	void run(int i) {
		System.out.println(i);
		i++;
		run(i);
	}
	public static void main(String[] args) {
		//new MemoryManagement().run(1);
		int size = 100;
		for(int i=0;i<Integer.MAX_VALUE;i++) {
			System.out.println(i);
			int[] arr = new int[size];
			size *= 2;
		}
	}
}
//-Xss2m  --> StackArea Extension to 2MB
//-Xms5000m  --> HeapArea Extension to 5GB
