package edu.neu.coe.info6205.final_project;

import java.util.ArrayList;

import java.util.Random;

public class ProjectMain {

	public static void main(String[] args) {
		
		int V=100;
		
		for(V = 10; V<200; V+=50) {
		
		System.out.println("Node count:" + V);	
		Random r = new Random(5);
		Edge e;
		EdgeWeightedGraph G = new EdgeWeightedGraph(V);
		
		
		/*the following piece of code generates a random connected graph with V vertices*/
		e=new Edge(0, 1, r.nextInt(20)+1);
		G.addEdge(e);
		for(int i=2;i<V;i++)
		{
			e = new Edge(i, r.nextInt(i)+0, r.nextInt(20)+0);
			G.addEdge(e);
		}
		
		for(int i=2;i<V/2;i++)
		{
			e = new Edge(r.nextInt(V), r.nextInt(V), r.nextInt(20)+0);
			G.addEdge(e);
		}
		
		
		GeneticAlgorithm solution = new GeneticAlgorithm(G);
		
		solution.run();		
		
		}
		
	}

	

}


/*debug code*/

//ArrayList<Integer> oddVertices = new ArrayList<Integer>();
//
//for(int i=0;i<V;i++)
//{
//	int degree = EdgeWeightedGraph.degree(G, i);
//	if((degree%2)!=0)
//		oddVertices.add(i);
//}
//
//System.out.println("odd vertices: ");
//for(int i:oddVertices)
//{
//	System.out.print(" "+i);
//}
//
//System.out.println();

//for(int v=0; v<V; v++	)
//{
//	for(Edge w:G.adj(v))
//		System.out.println(w.either()+"-"+w.other(w.either())+" weight "+w.W());
//}

//ArrayList<Edge> edges = G.E();
//
//for(Edge edge:edges)
//{
//	System.out.println(edge.either()+" - "+edge.other(edge.either())+ " weight: "+ edge.W());
//}


//System.out.println();



//e = new Edge(0, 1, 1);
//G.addEdge(e);
//
//e = new Edge(0, 3, 2);
//G.addEdge(e);
//
//e = new Edge(1, 2, 3);
//G.addEdge(e);
//
//e = new Edge(1, 3, 5);
//G.addEdge(e);		
//
//e = new Edge(2, 4, 6);
//G.addEdge(e);
//
//e = new Edge(2, 5, 1);
//G.addEdge(e);
//
//e = new Edge(3, 4, 4);
//G.addEdge(e);
//
//e = new Edge(4, 5, 2);
//G.addEdge(e);
//
//e = new Edge(5, 0, 8);
//G.addEdge(e);
