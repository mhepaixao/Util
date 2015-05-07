package correlation;

import java.util.HashMap;

public class PearsonCorrelation {
	public static double compare(double[] sample1, double[] sample2){
		int samplesSize = sample1.length;
		HashMap<String,Double> values = getValues(sample1, sample2);
		
		return ((samplesSize * values.get("sample1TimesSample2Sum")) - (values.get("sample1Sum") * values.get("sample2Sum"))) / 
			   Math.sqrt(((samplesSize * values.get("squaredSample1Sum") - Math.pow(values.get("sample1Sum"), 2)) * (samplesSize * values.get("squaredSample2Sum") - Math.pow(values.get("sample2Sum"), 2))));
	}
	
	private static HashMap<String,Double> getValues(double[] sample1, double[] sample2){
		HashMap<String,Double> values = new HashMap<String,Double>();
		double sample1Sum = 0;
		double sample2Sum = 0;
		double sample1TimesSample2Sum = 0;
		double squaredSample1Sum = 0;
		double squaredSample2Sum = 0;
		
		for(int i = 0; i <= sample1.length - 1; i++){
			sample1Sum += sample1[i];
			sample2Sum += sample2[i];
			sample1TimesSample2Sum += sample1[i] * sample2[i];
			squaredSample1Sum += Math.pow(sample1[i], 2);
			squaredSample2Sum += Math.pow(sample2[i], 2);
		}
		
		values.put("sample1Sum", sample1Sum);
		values.put("sample2Sum", sample2Sum);
		values.put("sample1TimesSample2Sum", sample1TimesSample2Sum);
		values.put("squaredSample1Sum", squaredSample1Sum);
		values.put("squaredSample2Sum", squaredSample2Sum);
		
		return values;
	}
}
