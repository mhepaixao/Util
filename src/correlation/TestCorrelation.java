package correlation;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.HashMap;

public class TestCorrelation {
	public static void main(String[] args){
//		HashMap<String,double[]> samples = readSamples("cohesion_coupling.txt");
		HashMap<String,double[]> samples = readSamples("numberOfClusters_modularizationQuality.txt");
		double[] sample1 = samples.get("sample1");
		double[] sample2 = samples.get("sample2");
		
		double correlationCoefficient = PearsonCorrelation.compare(sample1, sample2);
		System.out.println(correlationCoefficient);
	}
	
	private static HashMap<String,double[]> readSamples(String fileName){
		HashMap<String, double[]> samples = new HashMap<String, double[]>();
		ArrayList<Double> dynamicSample1 = new ArrayList<Double>();
		ArrayList<Double> dynamicSample2 = new ArrayList<Double>();
		
		String[] splittedLine = null;

		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			while(reader.ready() == true){
				splittedLine = reader.readLine().split(" ");

				if(splittedLine.length == 3){
					dynamicSample1.add(Double.parseDouble(splittedLine[1]));
					dynamicSample2.add(Double.parseDouble(splittedLine[2]));
				}
			}
			
			reader.close();
		}
		catch(Exception e){
			System.out.println("Error in reading samples");
			e.printStackTrace();
		}
		
		samples.put("sample1", getStaticSample(dynamicSample1));
		samples.put("sample2", getStaticSample(dynamicSample2));
		
		return samples;
	}
	
	private static double[] getStaticSample(ArrayList<Double> dynamicSample){
		double[] staticSample = new double[dynamicSample.size()];
		
		for(int i = 0; i <= staticSample.length - 1; i++){
			staticSample[i] = dynamicSample.get(i);
		}
		
		return staticSample;
	}
}
