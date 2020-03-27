package com.ninos.operations;

public class SimpleMath {

	// Sum
	public Double sum(Double numberone, Double numbertow) {
		return numberone + numbertow;
	}

	// Sub
	public Double sub(Double numberone, Double numbertow) {
		return numberone - numbertow;
	}

	// Multiple
	public Double mul(Double numberone, Double numbertow) {
		return numberone * numbertow;
	}

	// Division
	public Double div(Double numberone, Double numbertow) {
		return numberone / numbertow;
	}

	// Average
	public Double ave(Double numberone, Double numbertow) {
		return (numberone + numbertow) / 2;
	}

	// Square Root
	public Double sqrt(Double number) {
		return Math.sqrt(number);
	}

}
