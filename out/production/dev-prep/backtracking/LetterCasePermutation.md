### Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible stringmanipulation we could create.

Constraints
- S will be a string with length between 1 and 12.
- S will consist only of letters or digits.

Examples:  
Input: S = "a1b2"  
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"  
Output: ["3z4", "3Z4"]

Input: S = "12345"  
Output: ["12345"]

````
     public List<String> letterCasePermutation(String S) {
            
        
            char[] str = S.toCharArray();
            
            List<String> output = new ArrayList<>();
            
            if(S.length() == 0 || S == null){
                output.add(String.valueOf(str));    
                
            } else {
        
                permute(str, output, 0);    
             }
            
            return output;
                
      }
        
       public void permute(char[] str, List<String> output, int index) {
            
            output.add(String.valueOf(str));
            
            for(int i=index; i<str.length; i++) {
                
                if(!Character.isDigit(str[i])) {
                    
                    char temp = str[i];
                    
                    str[i] = (Character.isLowerCase(str[i])) ? Character.toUpperCase(str[i]) : Character.toLowerCase(str[i]);
                    permute(str, output, i+1);
                    str[i] = temp;
    
                }
            }
        }
````