### Design a scheduler based on priorities. This scheduler should have some level of fairness i.e for every two schedule events prioritize one with a low priority.

**Approach**

Use case -> lets say we want to schedule people in banking hall.

Customers are assigned priority based on what they came to do:  
- Withdrawal/Banking services - High priority
- Consultation on banking services - High priority
- Normal Account queries - Low priority

Data Structure -> Priority Queue
- For all incoming customers assign priority(1-10) 1 - very high, 10 - low , based on what they want to do in the bank.

Fairness
