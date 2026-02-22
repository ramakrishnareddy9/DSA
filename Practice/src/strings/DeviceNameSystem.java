package strings;

import java.util.*;

public class DeviceNameSystem {
    static void deviceNameSystem(String arr[]){
        HashMap<String, Integer> map = new HashMap<>();
        String[] result = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            String name = arr[i];

            if (!map.containsKey(name)) {
                result[i] = name;
                map.put(name, 1);
            } else {
                int count = map.get(name);
                String newName = name + count;
                while (map.containsKey(newName)) {
                    count++;
                    newName = name + count;
                }
                result[i] = newName;
                map.put(name, count + 1);
                map.put(newName, 1);
            }
        }
        for(String i : result){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String []arr = new String[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.next();
        }
        deviceNameSystem(arr);
        s.close();
    }
}
