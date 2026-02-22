package sorting;
public class BubbleSortPractice {
	static void swap(int[] arr, int first, int second) {
		int temp=arr[first];
		arr[first] =arr[second];
		arr[second] = temp;
	}
	static int thirdMaximum(int[] arr){
		if(arr.length<3)
			return Math.max(arr[0],arr[1]);
		boolean isSwapped;
		for(int i=0;i<3;i++) {
			isSwapped=false;
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
					isSwapped = true;
				}
			}
			if(!isSwapped)
				break;
		}
		return arr[arr.length-3];
	}
	public static void main(String[] args) {
		int[] arr = {2,1,9,5,8};
		System.out.println(thirdMaximum(arr));
	}
}