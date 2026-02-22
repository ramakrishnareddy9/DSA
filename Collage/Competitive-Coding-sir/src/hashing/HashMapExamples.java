package hashing;
import java.util.*;
import java.util.Map.Entry;
import java.util.Map;
public class HashMapExamples {
	public static void main(String[] args) {
		//creation
		HashMap<Integer,String> map = new HashMap();
		//Hashtable<Integer, String> map2 = new Hashtable();
		//addition
		map.put(101,"Jikky");
		map.put(102, "Nikky");
		System.out.println(map);
		map.put(101, "Likky");
		map.putIfAbsent(102, "Pinky");
		System.out.println(map);
		Map<Integer,String> map2 = new Hashtable();
		map2.put(105, "Akki");
		map2.put(107, "ABC");
		map.putAll(map2);
		System.out.println(map);
		//retreival
		//keys
		Set<Integer> keys = map.keySet();
		System.out.println(keys);
		//values
		Collection values = map.values();
		System.out.println(values);
		//key-value
		Set<Entry<Integer,String>> entries= map.entrySet();
		System.out.println(entries);
		for(Entry entry:entries) {
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
		//verification
		System.out.println(map.containsKey(102));
		System.out.println(map.containsKey(109));
		System.out.println(map.containsValue("Nikky"));
		System.out.println(map.containsValue("Vignan"));
		//updation
		map.replace(105, "Vignan");
		System.out.println(map);
		map.put(101, "XYZ");
		System.out.println(map);
		//deletion
		map.remove(101);
		System.out.println(map);
		map.remove(110);
		System.out.println(map);
		map.clear();
		System.out.println(map);
	}
}
/*
 CARVUD
 */