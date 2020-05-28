package stringmanipulation;

public class StringPermutations {


    //Recursive Method
    static  void  permute(String  str,int left, int right) {

        if(left == right)

            System.out.println(str);

        else{
            // fix each letter in every iteration
            for(int i=left; i<=right; i++) {

                str = swap(str, left, i); // i = 0, l=0 // swap A with A to get ABC

                permute(str,left+1, right); // fix A and pass i = 1, l = 1, r = 2

                str = swap(str, left, i); // backtrack
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
        int r = str.length()-1;

        permute(str, l, r);
    }
}
