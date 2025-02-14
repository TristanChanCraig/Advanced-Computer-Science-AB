package Q3;

public class Pelican_56_6 {
    public static int hashCode(String key) {
        final int TABLE_SIZE = 180;
        int keyInt = 0;
        key = key.toUpperCase();
        keyInt += ((int)key.charAt(0)) * 1000 + ((int)key.charAt(1)) * 100 +
                ((int)key.charAt(key.length()-2)) * 10 + ((int)key.charAt(key.length()-1));
        return keyInt % TABLE_SIZE;
    }

    public static void main(String[] args) {
        System.out.println("Bush, George >>> " + hashCode("Bush, George"));
        System.out.println("Clinton, Bill >>> " + hashCode("Clinton, Bill"));
        System.out.println("Lincoln, Abraham >>> " + hashCode("Lincoln, Abraham"));
        System.out.println("Washington, George >>> " + hashCode("Washington, George"));
    }
}
/*
Bush, George >>> 39
Clinton, Bill >>> 16
Lincoln, Abraham >>> 147
Washington, George >>> 139
 */