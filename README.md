# PriorityQueue

###Summary

Created a generic priority queue in java that uses a min-heap (because that's how I think of priorities) binary tree strucutre to store and order nodes of varying priorities. The nodes each represent a linkedList object, which provides a FIFO queue for storage and retrieval of items within a given priority level.

Tests are constructed and ran using junit4.

##Instructions

Please create a generic priority queue in your favorite language.  Specifications for required and optional functionality can be found below.  If any requirements are unclear, please feel free to reach out and ask for clarification.

###Code a generic Priority Queue:

- Priority is UInts

- Number of priorities bound by the limits of UInts

- Higher priorities are returned first

- Items within a given priority will be returned in FIFO order.

- Support the Enqueue, Dequeue and Count methods

###Problem focus:

- Solve for performance

- Write unit tests that validate the items are returned in the order expected.

###Extra Credit:

- Make thread safe

- Write a Count(unit priority) method.
