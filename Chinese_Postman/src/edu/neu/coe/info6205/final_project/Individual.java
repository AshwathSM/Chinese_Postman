package edu.neu.coe.info6205.final_project;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Individual implements Comparable<Individual> {

	private int rank;  //lower the rank, better is the individual
	private ArrayList<Integer> genes = new ArrayList<Integer>();
	private EdgeWeightedGraph G;
	
	public Individual(EdgeWeightedGraph G, ArrayList<Integer> genes) {
	
		for(int i=0;i<genes.size();i++)
			this.genes.add(genes.get(i));
		
		this.G= G;
		
		
	}
	
	/*calculates the fitness*/
	private void calcFitness()
	{
		int sumOfPairs=0;
		for(int i=0;i<genes.size();i+=2)
		{
			sumOfPairs+= shortestPath(genes.get(i), genes.get(i+1));
		}
		rank = G.sumEdgeWeight()+sumOfPairs;
		 
	}
	
	/*return genes*/
	public ArrayList<Integer> getGenes()
	{
		return genes;
	}
	
	/*set genes*/
	public void setGenes(ArrayList<Integer> genes)
	{
		this.genes = genes;
	}
	
	/*returns the fitness of the individual*/
	public int getFitness()
	{
		calcFitness();
		return rank;
	}
		
	/* gives the shortest path between the vertices 
	 * in a graph passed as parameters
	 * Dijkstra's Shortest Path Algorithm*/
	public int shortestPath(int s, int d)
	{
		Boolean[] marked =new Boolean[G.V()];
		int[] dist = new int[G.V()];
		int[] prev = new int[G.V()];
				
		for(int i = 0; i<G.V();i++)
		{
			dist[i]=Integer.MAX_VALUE;
			marked[i] = false;			
		}
		
		dist[s] = 0;
		prev[s] = s;
		
		Queue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(s);
		
		while(!pq.isEmpty())
		{
			int v = pq.poll();
			
			if(marked[v]) continue;
			marked[v]=true;
			for(Edge e: G.adj(v))
			{
				int x = e.either();
				int w = e.other(x);
				if(x!=v)
					w=x;
					
				if(dist[w]>dist[v]+e.W())
				{
					dist[w] = dist[v]+e.W();
				
					prev[w] = v;
					pq.add(w);
				}
			}
		}
		
		return dist[d];
	}
	
	
	/*implements compareTo() method inherited from interface Comparable*/
	public int compareTo(Individual that)
	{
		if(this.rank>that.rank) return 1;
		else if(this.rank<that.rank) return -1;
		else return 0;
	}
	

}
