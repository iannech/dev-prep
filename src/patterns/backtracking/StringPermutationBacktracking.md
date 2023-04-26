### Given a string of unique characters, find all of it's distinct permutation

3 keys of backtracking

- Choices --> choose 1 character
- Constraints ---> chosen character can only be used once
- Goal ---> build a permutation

We have certain Choices we need to take, and these choices are governed by some Constraints in order to reach a goal

Backtracking recipe

```
void Backtrack (res, args){

    if(GOAL REACHED)

        add solution to res
    
        return

    for(int i=0; i<CHOICES; i++){

        if(CHOICES[i] is valid){ 

            make choices[i]

            Backtrack(res, args)

            undo choices[i]
        }
    }
}
```

Code

````
void Backtrack(char[] input, List<>)
````
