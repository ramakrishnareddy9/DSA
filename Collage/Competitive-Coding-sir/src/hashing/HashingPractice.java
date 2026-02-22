package hashing;
import java.util.*;
public class HashingPractice {
    static int[] sortByFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list,(a,b)->a.getValue()==b.getValue()?b.getKey()-a.getKey():a.getValue()-b.getValue());
        int index = 0;
        int res[] = new int[nums.length];
        for(Map.Entry<Integer, Integer> entry: list) {
            int freq = entry.getValue();
            int key = entry.getKey();
            for(int i = 0; i < freq; i++)
                res[index++] = key;
        }
        return res;
    }
    static boolean isPalindrome(String str) {
    	int l=0,r=str.length()-1;
    	while(l<r) {
    		if(str.charAt(l)!=str.charAt(r)) {
    			return false;
    		}
    		l++;r--;
    	}
    	return true;
    }
    static String longestPalindrome(String s) {
    	String res = "";
    	for(int i=0;i<s.length();i++) {
    		for(int j=i+1;j<=s.length();j++) {
    			String sub = s.substring(i,j);
    			if(isPalindrome(sub)) {
    				if(sub.length()>res.length())
    					res = sub;
    			}
    		}
    	}
    	return res;
    }
    static String longestPalindrome2(String s) {
    	String res = "";
    	for(int i=1;i<s.length();i++) {
    		//oddPalindrome
    		int l=i,r=i;
    		while(s.charAt(l)==s.charAt(r)) {
    			l--;r++;
    			if(l==-1 || r==s.length())
    				break;
    		}
    		String sub = s.substring(l+1,r);
    		if(sub.length()>res.length())
    			res= sub;
    		//evenPalindrome
    		int left=i-1,right=i;
    		while(s.charAt(left)==s.charAt(right)) {
    			left--;right++;
    			if(left==-1 || right==s.length())
    				break;
    		}
    		String subEven = s.substring(left+1,right);
    		if(subEven.length()>res.length())
    			res= subEven;
    	}
    	return res;
    }
	public static void main(String[] args) {
		int[] arr = {-1,1,-6,4,5,-6,1,4,1};
		//System.out.println(Arrays.toString(sortByFrequency(arr)));
		System.out.println(longestPalindrome("madamsirmaamris"));
	}
}
