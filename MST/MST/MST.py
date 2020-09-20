#!/usr/bin/env python3

import sys
import math
import re

'''
Chase Dickerson
Minimum Spanning Tree
4/22/2019
'''

#Prim's algorithm is used to find the minimum spanning tree of a graph
def prims(G, input_vertex):
    n = len(G)
    X = set()
    X.add(input_vertex)
    tree = []

    #Looping until all vertices have been visited
    while len(X) != n:
        #Creating an empty list that will be used to hold all potential edges
        edges = []
        for vertex in X:
            for v1, weight in G[vertex]: 
                #Putting edges of vertices that are not already in X
                if v1 not in X:
                    edges.append((v1, weight))
        #Finding the smallest weight and adding it to tree and corresponding vertex to X 
        edges.sort(key=sortSecond)
        tree.append(edges[0][1])
        X.add(edges[0][0])
        
    treeSum = sum(tree)
    return treeSum  

# Used to sort by the second value in the list edges            
def sortSecond(val):
    return val[1]        

def add_edge(G, v1, v2, ce):
    if v1 in G:
        G[v1].append((v2, ce))
    else:
        G[v1] = [(v2, ce)]
    if v2 in G:
        G[v2].append((v1, ce))
    else:
        G[v2] = [(v1, ce)]


def main():
    input_filename = input('Please provide an input filename:\n')
    input_vertex = int(input('Please provide a start vertex label (1..n):\n'))
    G = {}
    with open(input_filename, 'r') as input_graph_file:
        n, m = tuple(int(x) for x in input_graph_file.readline().split())
        G = {}
        for line in input_graph_file:
            v1, v2, ce = tuple(int(v) for v in line.split())
            add_edge(G, v1, v2, ce)

    print(prims(G, input_vertex))

if __name__ == '__main__':
    main()