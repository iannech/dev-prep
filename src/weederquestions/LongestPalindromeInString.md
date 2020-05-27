## Find the longest palindrome substring from the given string

Keywords: longest, palindrome, substring

Questions/Clarification
- what is a palindrome?
- What if we have an empty string or one letter string like "a"


Examples  
Input: "fabbacd"  Output: "abba"  
Input: "racecar"  Output: "racecar"  

BrutForce Approach O(n^3)
- Generate all substrings of the string using a nested loop
- Have a third nested loop checking if each substring is a palindrome
- At the same time keep track of the length of the longest substring palindrome seen so far

- Resultant time complexity will be O(n^3) - not very good.

Better Approach O(n^2)
- Have a loop through each character and at each character, try to expand outwards in both directions to check if there
is a palindrome.
- Keep expanding as long as its a palindrome. Else get the length between the two pointers.

- Have two member vars to be used in getting the longest substring
    - resultStart - start of the longest palindrome
    - resultLength - length of longest palindrome
    

````
String longestPalindrome(String input){

            // empty or single letter
            if(input == null || input.length() < 1){
                return "";
            }

            int start = 0;
            int end = 0;
            // loop through each character    
            for(int index=0; index<input.length(); index++) {

                // takes care of a case like 'racecar', where a single char is the pivot in the palindrome
               int len1 = expandPalindromeRange(input, index, index);

                // case like 'abba'
               int len2 =  expandPalindromeRange(input, index, index + 1);

               // get max
               int len = Math.max(len1, len2);

               // setting up new longest palindrome we've seen
               if(len > end - start){
                    start = index - ((len - 1)/2);
                    end = index + (len / 2);
               }

            }   

            // return longest palindrome substring
            return input.substring(start, end + 1); 
        }

        // utility function to keep expanding in both directions of a palindrome

         int expandPalindromeRange(String input, int start, int end) {

            // edge case check
            if(input == null || start > end){
                return 0;                
            }

            // keep expanding as long as we are within bounds and what we have is a valid palindrome    
            while(start >= 0 && end < input.length() && input.charAt(start) == input.charAt(end)){

                start --; // move left
                end++; // move right
            }

            return end - start - 1;    
        }
````
   