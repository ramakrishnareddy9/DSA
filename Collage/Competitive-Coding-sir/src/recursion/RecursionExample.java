package recursion;
public class RecursionExample {
	static int digitalSum(int n) {
		if(n<10)
			return n;
		int sum = 0;
		while(n!=0) {
			sum += n%10;
			n /= 10;
		}
		return digitalSum(sum);
	}
	static void printNum(int n) {
		if(n==5) {
			System.out.println(n);
			return;
		}
		System.out.println(n);
		printNum(n+1);
	}
	
	static void printNums(int n) {
		if(n==0) {
			return;
		}
		System.out.println(n);
		printNums(n-1);
		System.out.println(n);		
	}
	static int sum=0;
	static void reverse(int n) {
		if(n==0) {
			System.out.println(sum);
			return;
		}
		sum = sum*10+n%10;
		reverse(n/10);
	}
	
	static int sum2=0;
	static int reverse2(int n) {
		if(n==0) {
			return sum2;
		}
		sum2 = sum2*10+n%10;
		return reverse2(n/10);
	}
	static int reverse3(int n) {
		return helper(n,0);
	}
	static int helper(int n, int rev) {
		if(n==0)
			return rev;
		rev = rev*10+n%10;
		return helper(n/10, rev);
	}
	static int countZeros(int n) {
		if(n==0)
			return 1;
		return helper2(n, 0);
	}
	static int helper2(int n, int c) {
		if(n==0) {
			return c;
		}
		if(n%10==0) {
			return helper2(n/10, c+1);
		}
		return helper2(n/10, c);
	}
	public static void main(String[] args) {
		//printNums(5);
		//System.out.println(digitalSum(678999999));
		//System.out.println(reverse3(1234));
		System.out.println(countZeros(0));
	}
}




