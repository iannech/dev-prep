### Backtracking

An algorithmic technique that considers searching every possible combination in order to solve a computational problem.

#### Types of problems in backtracking

1. Decision problem - we search for a feasible solution
2. Optimization problem - we search for best solution
3. Enumeration problem - we find all feasible solutions

#### Pseudo Code for Backtracking

1. Recursive backtracking solution

   ```
   void findSolutions(n, other params) :
   // Goal
    if (found a solution) :
        solutionsFound = solutionsFound + 1;
        displaySolution();
        if (solutionsFound >= solutionTarget) :
            System.exit(0);
        return

    for (val = first to last) :
        // Constraints
        if (isValid(val, n)) :
            applyValue(val, n);
            findSolutions(n+1, other params);
            removeValue(val, n);
   ```

2. Finding whether a solution exists or not

```
boolean findSolutions(n, other params) :
    if (found a solution) :
        displaySolution();
        return true;

    for (val = first to last) :
        if (isValid(val, n)) :
            applyValue(val, n);
            if (findSolutions(n+1, other params))
                return true;
            removeValue(val, n);
        return false;
```
