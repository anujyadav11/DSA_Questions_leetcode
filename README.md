# Data Structures & Algorithms — Java

<p align="center">
  <strong>A structured collection of 381 LeetCode solutions, organized by the core patterns behind technical interviews.</strong>
</p>

<p align="center">
  <a href="https://github.com/anujyadav11/DSA_Questions_leetcode"><img src="https://img.shields.io/badge/Solutions-381-0A66C2?style=for-the-badge" alt="381 LeetCode solutions"></a>
  <img src="https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Focus-DSA%20%26%20Interview%20Patterns-1F8A70?style=for-the-badge" alt="Data Structures and Algorithms">
</p>

## About

This repository is my practical record of learning data structures and algorithms through LeetCode. Each solution is written in Java and placed under the concept it primarily exercises, making it easy to study a pattern intentionally instead of treating problems as isolated exercises.

My goal is not simply to reach an accepted answer. For every problem, I work through the progression from understanding the constraints, to considering a brute-force baseline, to identifying a better approach, and finally to implementing the most efficient solution that is appropriate for the problem. This process builds the pattern recognition, trade-off analysis, and code clarity needed in real technical interviews.

## Problem-solving approach

```text
Understand the problem
        ↓
Establish a brute-force baseline
        ↓
Identify the bottleneck
        ↓
Apply the right DSA pattern
        ↓
Implement and analyze the optimal solution
```

When reviewing a solution, I focus on:

- **Correctness:** defining the invariant and handling edge cases first.
- **Complexity:** comparing time and space costs before choosing an approach.
- **Pattern recognition:** connecting each problem to reusable techniques such as two pointers, sliding windows, graph traversal, dynamic programming, and monotonic stacks.
- **Readable implementation:** writing clear Java code that can be explained under interview conditions.

## Topics covered

| Topic | Solutions | Core skills |
| --- | ---: | --- |
| Arrays & Hashing | 66 | Hash maps, frequency counting, sorting, and prefix techniques |
| Greedy | 43 | Local-choice proofs, ordering, and resource allocation |
| Trees | 36 | DFS, BFS, recursion, and binary-search-tree properties |
| Sliding Window | 26 | Window invariants, frequency maps, and running totals |
| Math & Geometry | 25 | Number theory, simulation, matrix traversal, and coordinates |
| Two Pointers | 23 | Opposing pointers, partitioning, and sequence comparison |
| 1D Dynamic Programming | 21 | State transitions, memoization, and tabulation |
| Stack & Queue | 20 | Monotonic structures, parsing, and next-greater patterns |
| Backtracking | 20 | Recursive search, choices, and constraint exploration |
| Bit Manipulation | 19 | XOR, masks, binary representation, and bit counting |
| Linked List | 16 | Pointer manipulation, fast/slow pointers, and list design |
| Binary Search | 15 | Search on sorted data and answer-space optimization |
| Graphs | 15 | Connectivity, traversals, topological sorting, and shortest paths |
| Heap & Priority Queue | 13 | Top-*k*, scheduling, and streaming data |
| 2D Dynamic Programming | 11 | Grid states, sequence alignment, and two-dimensional transitions |
| Intervals | 8 | Sorting endpoints, merging, and sweep-line reasoning |
| Trie | 4 | Prefix search and dictionary-style lookup |

The topic labels are reader-friendly; every solution folder and file remains in its original location.

## Repository structure

```text
.
├── Arrays & Hashing/
├── Binary Search/
├── Graphs/
├── Sliding Window/
├── Tree/
├── 1D Dynamic Programming/
├── 2-D Dynamic Programming/
└── ... more concept-focused folders
```

## Using the solutions

Each file is designed for the LeetCode Java environment, which provides the relevant input types and calls the `Solution` class. To experiment locally, copy a solution into `Solution.java`, add required imports and a small driver program, then compile with a JDK.

## What this demonstrates

- Consistent hands-on practice across foundational and advanced DSA topics.
- The ability to move from a straightforward brute-force idea to a complexity-aware optimized solution.
- Familiarity with the patterns most frequently evaluated in coding interviews.
- Clear, language-specific implementation in Java.

---

Maintained by [Anuj Yadav](https://github.com/anujyadav11). This repository continues to grow as I solve, revisit, and improve problems.
