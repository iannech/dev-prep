package stringmanipulation;

public class StringPermutations {


    //Recursive Method
    static  void  permute(String  str,int l, int r) {

        if(l == r)

            System.out.println(str);

        else{

            for(int i=l; i<=r; i++) {

                str = swap(str, l, i); // i = 0, l=0 // swap A with A to get ABC

                permute(str,l+1, r); // fix A and pass i = 1, l = 1, r = 2

                str = swap(str, l, i); // backtrack
            }
        }

    }

    // swap util
    static String swap(String str, int x, int y) {

        char[] chars = str.toCharArray();

        char temp;

        temp = chars[x];

        chars[x] = chars[y];

        chars[y] = temp;

        return String.valueOf(chars);
    }

    public static void main(String[]args) {
        String str = "123";
        int l =0;
        int r = str.length() - 1;

        permute(str, l, r);
    }
}
