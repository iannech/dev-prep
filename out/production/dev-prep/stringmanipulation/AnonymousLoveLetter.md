### You have written an anonymous love letter and you don’t want your handwriting to be recognized. Since you don’t have a printer within reach, you are trying to write this letter by copying and pasting characters from a newspaper.
### Given a string L representing the letter and a string N representing the newspaper, return true if the L can be written entirely from N and false otherwise. The letter includes only ascii characters.

Example:

Input: L = {I love you dear}  
       N = {AaBbCcDdEeFfGgHhIiJjIiKkLlMmNnOoPpQqRrOoUuVv}
       
Output: true

L = {Ziki my love.}  
N = {AaBbCcDdEeFfGgHhIiJjIiKkLlMmNnOoPpQqRrOoUuVv}

Output: false

Approach:  

1. Put the Newspaper N characters in a Set and check the letters in L if they exist in the Set.
2. If L[i] exists, proceed to check the next one else break and return false
````
boolean anonymousLoveLetter(String L, String N) {

    if(N == null || L == null || N.length() == 0 || L.length() == 0)
        return false;
        
    int[] availableChars = new int[256];
    int[] charMessage = L.toCharArray();
    int j = 0;
    
    for(int i=0; i<N.length(); i++) {
        availableChars[i] = String.charAt(i);
    }   
    
    while(j < charMessage.length) {
        
        if(availableChars.contains(charMessage[j])){
            j++;
        } else {
            return false;
        }
    }
    
    return true;
}
````