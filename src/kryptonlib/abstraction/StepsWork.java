package kryptonlib.abstraction;

import java.util.ArrayList;

public class StepsWork {
	public ArrayList<char[]> steps = new ArrayList<char[]>();
	
	public void saveStep(String step) {
		steps.add(step.toCharArray());
	}
	
	public void saveStep(StringBuilder step) {
		steps.add(step.toString().toCharArray());
	}
	
	public void saveStep(String[] steps) {
		StringBuilder result = new StringBuilder();
		for (String step : steps) 
			result.append(step + ' ');
		saveStep(result);
	}
	
	public ArrayList<char[]> getAllSteps() {
		ArrayList<char[]> result = new ArrayList<char[]>(steps.size());
		for (char[] step : steps) {
			result.add(step);
		}
		return result;
	}
	
	public char[] getSelectStep(int position) { return steps.get(position); }
	
	public int size() { return steps.size(); }

	public void clear() { steps.clear(); }

}
