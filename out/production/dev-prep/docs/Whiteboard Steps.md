## Step By Step through a problem:-

1. When the interviewer says the question, write down the key points at the top. (Sorted array, etc..) Make sure you have all the details. Show how organized you are.

2. Make sure you check inputs: What are the inputs? What are the outputs?

3. What is the most important value of the problem. Do you have time, and space and memory, etc...What is the main goal?

4. Don't be annoying and ask too many questions.

5. Start with the naive/brute force approach. First thing that comes to mind. It shows you are able to think well and critically. you don't need to write this code, just speak about it

6. Tell him why this approach is not the best.

7. Walk through your approach, comment things and see where you may be able to break thing. Any repetion, bottlenecks like O(N^2) or unnecessary work. Bottleneck is part of the code with the biggest Big O.

8. Before you start coding, walk through your code and write down the steps you are going to follow.

9. Modularize your code from the beginning. Break up your code into beautiful small pieces and add comments only if you need to.

10. Start actually writing the code. Never start a whiteboard interview not being sure how things are going to work out [Recipe For Disaster]

11. Think about error checks and how you can break this code. Never make assumptions about the input. Always check for false inputs that you dont want.
Trick::> Comment in the code, the checks that you want to do...write the function then tell the interviewer that you would write tests now to make your function fail.[[You dont need to write actual tests.]]

12. Write code that reads well. Don't use bad/confusing names like i, j for variables.

13. Test your code: Check for no params, 0, undefined, null, massive arrays, async code etc...Ask the interviewer if we can make assumptions about the code. Can you make the answer return an error? Poke holes into your solution. Are you repeating yourself?

14. Finally talk to the interviewer where you would improve the code. Does it work? Are there different approaches?Is it readable? What would you google to improve? How can performance be improved?

15. If the interviewer is happy with your solution, the interview usually ends here. Extension questions are common at this stage:> How would you handle the problem if the whole input is too large to fit into memory, or if the input arrives as a stream - Answer is usually divide-and-conquer approach -> perform distriubuted processing of the data and only read certain chunks of the inputs from Disk into memory. Write the output back to disk and combine them later.
