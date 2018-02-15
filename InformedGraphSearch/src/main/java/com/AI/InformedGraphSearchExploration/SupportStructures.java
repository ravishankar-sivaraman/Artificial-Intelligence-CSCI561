package com.AI.InformedGraphSearchExploration;

import java.util.*;


final class Node
{
	LinkedHashMap<Integer, Integer> adjacencyList;//Child, cost
	boolean visited = false;
	int number = -1;
	String name;
	int parent = -1;
	int pathCost = -1;
	int heuristic = -1;

	Node(int num, String name)
	{
		this.number = num;
		this.name = name;
		this.adjacencyList = new LinkedHashMap<Integer, Integer>();
		this.visited = false;
	}
}

final class pQueueNode
{
	Integer srcNode = -1;
	Integer edgeCost = -1;
	Integer heuristics = -1;
	
	public pQueueNode(Integer sNode, Integer eCost) 
	{
		this.srcNode = sNode;
		this.edgeCost = eCost;
	}
	
	public pQueueNode(Integer sNode, Integer eCost, Integer heuristic) 
	{
		this.srcNode = sNode;
		this.edgeCost = eCost;
		this.heuristics = heuristic;
	}
}

final class PriorityQueueComparator implements Comparator<pQueueNode>
{
    @Override
    public int compare(pQueueNode X, pQueueNode Y)
    {
        if(X.edgeCost > Y.edgeCost)
        	return 1;
        else if(X.edgeCost < Y.edgeCost)
        	return -1;
        else
        {
        	if(X.srcNode > Y.srcNode)
        		return 1;
        	else if(X.srcNode < Y.srcNode)
        		return -1;
        	else
        		return 0;
        }
        //return 0;
    }
}


final class PriorityQueueHeuristicComparator implements Comparator<pQueueNode>
{
    @Override
    public int compare(pQueueNode X, pQueueNode Y)
    {
        if(X.edgeCost + X.heuristics > Y.edgeCost + Y.heuristics)
        	return 1;
        else if(X.edgeCost + X.heuristics < Y.edgeCost + Y.heuristics)
        	return -1;
        else
        {
        	if(X.srcNode > Y.srcNode)
        		return 1;
        	else if(X.srcNode < Y.srcNode)
        		return -1;
        	else
        		return 0;
        }
        
    }
}