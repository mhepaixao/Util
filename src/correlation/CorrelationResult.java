package correlation;

public class CorrelationResult {
	private double correlationCoefficient;
	private double pValue;
	private boolean isSignificant;
	
	public CorrelationResult(double correlationCoefficient, double pValue, boolean isSignificant){
		this.correlationCoefficient = correlationCoefficient;
		this.pValue = pValue;
		this.isSignificant = isSignificant;
	}
	
	public double getCorrelationCoefficient(){
		return this.correlationCoefficient;
	}

	public double getPValue(){
		return this.pValue;
	}

	public boolean isSignificant(){
		return this.isSignificant;
	}
}
