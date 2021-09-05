package com.example.taskapplication.Pogo;

import java.util.List;

public class ResponseResult{
	private List<String> dietLabels;
	private List<Object> cautions;
	private List<String> healthLabels;
	private double totalWeight;
	private TotalDaily totalDaily;
	private int calories;
	private TotalNutrientsKCal totalNutrientsKCal;
	private String uri;
	private TotalNutrients totalNutrients;

	public List<String> getDietLabels(){
		return dietLabels;
	}

	public List<Object> getCautions(){
		return cautions;
	}

	public List<String> getHealthLabels(){
		return healthLabels;
	}

	public double getTotalWeight(){
		return totalWeight;
	}

	public TotalDaily getTotalDaily(){
		return totalDaily;
	}

	public int getCalories(){
		return calories;
	}

	public TotalNutrientsKCal getTotalNutrientsKCal(){
		return totalNutrientsKCal;
	}

	public String getUri(){
		return uri;
	}

	public TotalNutrients getTotalNutrients(){
		return totalNutrients;
	}
}