### Given a string say “ABAABCD”. Calculate minimum number of letters to be removed such that remaining letters can form a palindrome string.

Example:  
Input - ABAABCDCDDCBADC   
Output - 2

Approach  
Add the Letters to a Map together with their count.   
Iterate through the map removing ones with least count

````
public int removeMinimumNumber(String S) {
    
    if(S == null || S.length() == 0)
        return -1;
        
    Map<Character, Integer> map = new HashMap<>();
    
    int count = 0;
    int poll = 1;
    
    for(int i=0; i<S.length(); i++) {
      
      if(map.contains(S.charAt(i))) {
         map.put(S.charAt(i), poll+1);
      } else {
         map.put(S.charAt(i), poll));
      }        
        
    }
    
    
    for(Map.Entry<Character,Integer> entry : map.entrySet()) {
        if(entry.getValue() == 1)
            count++;
    }
    
    return count;
}
````