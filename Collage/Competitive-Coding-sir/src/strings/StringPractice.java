package strings;

public class StringPractice {
    public static void main(String[] args) {
        /*
         * String s1 = "Vignan";
         * String s2 = "Vignan";
         * System.out.println(s1==s2);
         * 
         * String s3 = new String("Vignan");
         * String s4 = new String("Vignan");
         * System.out.println(s3==s4);
         */
        String s = new String("Vignan University Guntur");
        System.out.println(s.contains("V"));
        System.out.println(s.contains("versity"));
        System.out.println(s.contains("gnanVi"));

        String s1 = new String("Vignan");
        String s2 = new String("Vignan");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        System.out.println(s.startsWith("V"));
        System.out.println(s.startsWith("Vignan"));
        System.out.println(s.startsWith("Vignan University"));

        System.out.println(s.endsWith("y"));
        System.out.println(s.endsWith("sity"));
        System.out.println(s.endsWith("university"));

        System.out.println(s.length());
        System.out.println(s.indexOf("gnan"));
        System.out.println(s.lastIndexOf("n"));
        System.out.println();

        String s3 = new String("vignan");
        String s4 = new String(" gnan");
        System.out.println(s1.compareToIgnoreCase(s2));
        System.out.println(s1.compareToIgnoreCase(s3));
        System.out.println(s3.compareToIgnoreCase(s4));

        System.out.println(s);
        System.out.println(s.trim());
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s1.concat(s4));

        System.out.println(s1.replace('n', 'm'));
        System.out.println(s1.replace("n", "man"));
        System.out.println(s1.replace("nan", "m"));
        System.out.println(s1.replace("nan", "man"));
        System.out.println(s1);
        System.out.println(s.substring(8));
        System.out.println(s.substring(2, 11));

        System.out.println(s.charAt(10));
        System.out.println(s.isEmpty());

        char[] chars = s1.toCharArray();
        for (char c : chars)
            System.out.println(c);

        String[] words = s.split(" ");
        for (String word : words)
            System.out.println(word);
    }
}