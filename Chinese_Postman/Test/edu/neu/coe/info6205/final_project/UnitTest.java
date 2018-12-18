package edu.neu.coe.info6205.final_project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UnitTest {
	


	@Test
	public void testDijkstras() {
		EdgeWeightedGraph G = new EdgeWeightedGraph(6);
		ArrayList<Integer> genes = new ArrayList<>();
		for(int i=0;i<6;i++)
		{
			genes.add(i);
		}
		Individual indi = new Individual(G, genes);
		
		Edge e = new Edge(0, 1, 1);
		G.addEdge(e);
		
		e = new Edge(0, 3, 2);
		G.addEdge(e);
		
		e = new Edge(1, 2, 3);
		G.addEdge(e);
		
		e = new Edge(1, 3, 5);
		G.addEdge(e);		
		
		e = new Edge(2, 4, 6);
		G.addEdge(e);
		
		e = new Edge(2, 5, 1);
		G.addEdge(e);
		
		e = new Edge(3, 4, 4);
		G.addEdge(e);
		
		e = new Edge(4, 5, 2);
		G.addEdge(e);
					
	    assertEquals(indi.shortestPath(1, 3),3);
	    assertEquals(indi.shortestPath(0, 5),5);
	    assertEquals(indi.shortestPath(1, 4),6);
	}
	
	@Test
	public void fitnessTest() {
		EdgeWeightedGraph G = new EdgeWeightedGraph(6);
		ArrayList<Integer> genes = new ArrayList<>();
		for(int i=1;i<5;i++)
		{
			genes.add(i);
		}
		
		ArrayList<Integer> genes2 = new ArrayList<>();
		genes2.add(1);
		genes2.add(3);
		genes2.add(2);
		genes2.add(4);
		
		Individual indi = new Individual(G, genes);
		Individual indi2 = new Individual(G, genes2);
		
		Population pop = new Population();
		pop.addMember(indi);
		pop.addMember(indi2);
		
		Edge e = new Edge(0, 1, 1);
		G.addEdge(e);
		
		e = new Edge(0, 3, 2);
		G.addEdge(e);
		
		e = new Edge(1, 2, 3);
		G.addEdge(e);
		
		e = new Edge(1, 3, 5);
		G.addEdge(e);		
		
		e = new Edge(2, 4, 6);
		G.addEdge(e);
		
		e = new Edge(2, 5, 1);
		G.addEdge(e);
		
		e = new Edge(3, 4, 4);
		G.addEdge(e);
		
		e = new Edge(4, 5, 2);
		G.addEdge(e);
				
		pop.calculateFitness();
		
	    assertEquals(pop.fitnessMax, 30);
	    assertEquals(indi.getFitness(), 31);
	    assertEquals(indi2.getFitness(), 30);

	}
	
	@Test
	public void edgeWeightTest() {
		EdgeWeightedGraph G = new EdgeWeightedGraph(6);

		
		Edge e = new Edge(0, 1, 1);
		G.addEdge(e);
		
		e = new Edge(0, 3, 2);
		G.addEdge(e);
		
		e = new Edge(1, 2, 3);
		G.addEdge(e);
		
		e = new Edge(1, 3, 5);
		G.addEdge(e);		
		
		e = new Edge(2, 4, 6);
		G.addEdge(e);
		
		e = new Edge(2, 5, 1);
		G.addEdge(e);
		
		e = new Edge(3, 4, 4);
		G.addEdge(e);
		
		e = new Edge(4, 5, 2);
		G.addEdge(e);
				

		
	    assertEquals(G.sumEdgeWeight(), 24);
	    assertEquals(G.V(), 6);
	    assertEquals(G.degree(G, 1), 3);


	}

}
