
#!/usr/bin/env python3

import sys
import math

'''
Chase Dickerson
Dijkstras Algorithm
4/9/2019
'''

'''
Dijkstras Algorithm is used to find the shortest path between a start vertex and
    every other vertex in the graph
'''
def dijkstras(adjacency_list, start_vertex):
   
        # Finding the length of the graph (will be used to loop through graph)
	n = len(adjacency_list)
	infinity = math.inf

        # Setting all path lengths to infinity
	path_lengths = {val: infinity for val in adjacency_list}
	path_lengths[start_vertex] = 0
	visited = {start_vertex} 

	while len(visited) != n:
		min_path_length = infinity
		v_star = None
		w_star = None

                # Looping through vertexes that have been added to visited
		for v_from in visited:
			for v, weight, in adjacency_list[v_from]:
				if v not in visited:
                                        # Dijkstra's greedy greedy criterion 
					dgc = path_lengths[v_from] + weight
					if dgc < min_path_length:
						min_path_length = dgc
						v_star = v_from
						w_star = v

                # Adding w star to visited 
		visited.add(w_star)
                # Adding the mininum path length to path_lengths
		path_lengths[w_star] = min_path_length
	return path_lengths

def main():

    file_name = input('Please provide a filename containing an adjacency list:\n')
    start_vertex = input('Please provide a start vertex label (1..n):\n')

    adjacency_list = {}

    # Reading in the file as an adjacency list
    with open(file_name, 'r') as adjacency_list_file:
        for line in adjacency_list_file:
            vals = [int(val) for val in line.replace(",", " ").split()]
            adjacency_list[vals[0]] = [e for e in zip(vals[1::2], vals[2::2])]
    length = dijkstras(adjacency_list, int(start_vertex)) 

    # Printing the lengths
    for num in length:
        if num < len(length):
            print(length[num], end=",")
        else:
            print(length[num], end="\n")

if __name__ == '__main__':
    main()
 