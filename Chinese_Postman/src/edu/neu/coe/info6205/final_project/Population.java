package edu.neu.coe.info6205.final_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Population {
	
	ArrayList<Individual> members;
	int fitnessMax=Integer.MAX_VALUE;
	Individual fittest;
	
	public Population() {
		
		members = new ArrayList<Individual>();

	}
	
	/*adds individuals to the population*/
	public void addMember(Individual organism)
	{
		members.add(organism);
	}
	
	public void killMember(Individual organism)
	{
		members.remove(organism);
	}
	
	/*calculates the fitness of all the individuals in the population
	 * and identifies the most fit candidate and sorts them by decreasing order of ranks*/
	public void calculateFitness()
	{
		int fitScore = 0;
		for(int i=0; i<members.size();i++)
		{
			fitScore = members.get(i).getFitness();
			if(fitScore<fitnessMax)
			{
				fitnessMax=fitScore;
				fittest = members.get(i);
			}
			
		}
		
		
	}
	
	
	/*returns the most fit individual in the population*/
	public Individual fittestIndividual() {
		calculateFitness();
		return fittest;
	}
	
}
