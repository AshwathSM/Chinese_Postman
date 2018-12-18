package edu.neu.coe.info6205.final_project;

import java.util.ArrayList;


public class EdgeWeightedGraph {
	private final int V;
//	private final int E;
	private Bag<Edge>[] adj;
	private ArrayList<Edge> allEdges = new ArrayList<Edge>();
	
	EdgeWeightedGraph(int V)
	{
//		this.E = 0;
		this.V = V;
		adj = (Bag<Edge>[]) new Bag[V];
		for(int v=0; v<V; v++)
			adj[v]= new Bag_Array<Edge>();
	}
	
//	EdgeWeightedGraph(int V, int E)
//	{
//		
//		this(V);
//		Random r = new Random(0);
//		for(int i=0; i<E;i++)
//		{
//			int v = r.nextInt(V)+0;
//			int w = r.nextInt(V)+0;
//			int weight = r.nextInt(100)+0;
//			
//		}
//		
//		this.E = E;
//		this.V = V;
//		adj = (Bag<Integer>[]) new Bag[V];
//		for(int v=0; v<V; v++)
//			adj[v]= new Bag_Array<Integer>();
//	}
	
	public static int degree(EdgeWeightedGraph G, int v)
	{
		int degree = 0;
		for(Edge w: G.adj(v))
			degree++;
		return degree;
	}
	
	public void addEdge(Edge e)
	{
		int v= e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		allEdges.add(e);
		
	}
	
	/*returns an iterator to the bag containing all edges connected to the vertex v*/
	public Iterable<Edge> adj(int v)
	{
		return adj[v];
	}
	
	/*returns the number of vertices in the graph */
	public int V()
	{
		return V;
	}
	
	/*returns all the edges in the graph*/
	public ArrayList<Edge> E()
	{
		return allEdges;
	}
	
	
	/*returns the sum of all edge weights*/
	public int sumEdgeWeight()
	{
		int sum = 0;
		for(Edge edge: allEdges)
		{
			sum+= edge.W();
		}
		
		return sum;
	}

}
