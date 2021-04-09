# dev-prep

## Preparation Links
### Coding
1. https://hackernoon.com/14-patterns-to-ace-any-coding-interview-question-c5bb3357f6ed - Patterns to Ace Coding Interview
2. https://medium.com/leetcode-patterns - LeetCode Patterns (Article)
3. https://seanprashad.com/leetcode-patterns/ - LeetCode Patterns (Questions)
4. https://www.bigocheatsheet.com/ - Understanding Big O
5. https://java2blog.com/java-coding-interview-questions/ - Java2Blog Common Interview Questions
6. https://www.geeksforgeeks.org/microsoft-interview-preparation/ - Geeks For Geeks (Microsoft Interview prep)
7. https://www.byte-by-byte.com/coding-interview-questions/all/ - Byte by Byte -> explore their crash course on Dynamic Programming
8. https://github.com/arialdomartini/Back-End-Developer-Interview-Questions/blob/master/README.md - Backend Developer
9. https://yangshun.github.io/tech-interview-handbook/best-practice-questions Interview Handbook and best practice questions

### System Design
0. https://github.com/donnemartin/system-design-primer - System Design Primer - start here
1. https://hackernoon.com/design-to-shine-how-to-ace-your-next-system-design-interview-2282bbf45c40 - Ace your System Design
2. https://www.hiredintech.com/courses/system-design - Hired in Tech (System Design)
3. https://hackernoon.com/the-top-10-object-oriented-design-interview-questions-developers-should-know-c7fc2e13ce39 - Top OOP Design Questions


## Sample Questions (on-site) 
NOTE: **These Questions are bound to change in each interview cycle.**

### Identity Team
- Given an array [1,0,0,0,2,0,4,3] you need to take all 0 s to the left and maintain the order of non zeros. I.e [0,0,0,0,1,2,4,3] dont use extra space. Do it in one loop.
- Given a linked list write an algorithm to reverse it.
- Given a weighted graph. Write an algorithm to find the shortest path
- Design a lift system. Put the algorithm in code
- Given a 2d matrix. Write an algorithm to rotate it.
- Write an algorithm for the tic tac toe game
- Write an algorithm to generate an n by n magic square
- Give an array like this [1,2,6,5,3] find the missing element i.e in this case it will be 4. Dont use extra space. Do it in one loop

### MS 365 App Substrate
1. Given an array of values and a target sum k. Return the index of pair elements adding up to the sum.
2. You're given an array of elements. Find the largest pair and the 2nd largest pair. Return the product of elements that make up this pair.
3. Design a scheduler based on priorities. This scheduler should have some level of fairness i.e for every two schedule events prioritize one with a low priority.
4. Write a program to schedule 4 lanes at a roundabout.

### MS AI
1. Given a list of cities and their populations, create a function that returns a city based on a random generator that gives a random number. The output of the function should be proportional to the population if the city 
E.g. 
Chicago - 4,000,000
Seattle - 200, 000
Washington - 800,000
Calling the function for example 100 times should return chicago 80

2. Given an api that takes a single input e.g. '2018' that is a prefix of a timestamp yyyymmddhhss create a program that takes in a date range e.g. 19700225000000 & 20190230000000 and returns the minimal number of calls that can be made to the API

3. Design a url shortening service (System design) 

4. Create a load test program

### MS Identity
1. Find all root to leaf paths in a binary tree
2. Write a function to deep clone a linked list
3. Given the root of a binary tree and an integer target sum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals target sum
