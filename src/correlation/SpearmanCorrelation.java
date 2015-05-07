package correlation;

import java.util.ArrayList;

public class SpearmanCorrelation {
	public static double compare(double[] sample1, double[] sample2){
		double[] rankedSample1 = getRankedSample(sample2);
		
		for(int i = 0; i <= rankedSample1.length - 1; i++){
			System.out.println(rankedSample1[i]);
		}
		return 0;
	}
	
	private static double[] getRankedSample(double[] sample){
		double[] rankedSample = new double[sample.length];
		boolean[] alreadyRankedFlag = new boolean[rankedSample.length];
		ArrayList<Integer> bestRankedIndexes = null;
		double rateRank = 0;
		
		int i = 1;
		while(i <= rankedSample.length){
			bestRankedIndexes = getBestRankedIndexes(sample, alreadyRankedFlag);
			
			if(bestRankedIndexes.size() > 1){
				rateRank = 1.0 / (double) bestRankedIndexes.size();
				
				for(int j = 0; j <= bestRankedIndexes.size() - 1; j++){
					rankedSample[bestRankedIndexes.get(j)] = i + rateRank;
				}

				i += bestRankedIndexes.size();
			}
			else{
				rankedSample[bestRankedIndexes.get(0)] = i;
				i++;
			}

			for(int j = 0; j <= bestRankedIndexes.size() - 1; j++){
				alreadyRankedFlag[bestRankedIndexes.get(j)] = true;
			}
		}
		
		return rankedSample;
	}
	
	private static ArrayList<Integer> getBestRankedIndexes(double[] sample, boolean[] alreadyRankedFlag){
		ArrayList<Integer> bestRankedIndexes = new ArrayList<Integer>();
		double maxValueNotAlreadyRanked = getMaxValueNotAlreadyRanked(sample, alreadyRankedFlag);

		for(int i = 0; i <= sample.length - 1; i++){
			if(sample[i] == maxValueNotAlreadyRanked){
				bestRankedIndexes.add(i);
			}
		}
		
		return bestRankedIndexes;
	}
	
	private static double getMaxValueNotAlreadyRanked(double[] sample, boolean[] alreadyRankedFlag){
		double maxValueNotAlreadyRanked = 0;
		
		for(int i = 0; i <= sample.length - 1; i++){
			if(alreadyRankedFlag[i] == false && sample[i] > maxValueNotAlreadyRanked){
				maxValueNotAlreadyRanked = sample[i];
			}
		}
		
		return maxValueNotAlreadyRanked;
	}
}
