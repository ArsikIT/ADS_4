# Graph Search Algorithms

This project implements various graph search algorithms including **Breadth-First Search (BFS)**, **Depth-First Search (DFS)**, and **Dijkstra's Algorithm**. It uses both **weighted** and **unweighted graphs**. The graph is represented using vertices and edges.

## Overview

- **Vertex** represents a graph vertex and contains a list of edges.
- **Edge** represents an edge between two vertices and includes the weight for weighted graphs.
- **WeightedGraph** supports graphs where edges have weights.
- **UnweightedGraph** supports graphs where edges do not have weights.
- **Search** is an abstract class for common operations, implemented by BFS, DFS, and Dijkstra.
- **Main** class demonstrates the usage of these algorithms on sample graphs.
