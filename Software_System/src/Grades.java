
public class Grades {
	public String ID, name;
	public String lab1, lab2, lab3, midTerm, finalExam, totalGrade;
	
	public Grades(){
		
	}
	
	
	public String calculateTotalGrade(float[] weights){
		int intValue1 = Integer.parseInt(lab1);
		int intValue2 = Integer.parseInt(lab2);
		int intValue3 = Integer.parseInt(lab3);
		int intValue4 = Integer.parseInt(midTerm);
		int intValue5 = Integer.parseInt(finalExam);
		
		/*System.out.println(intValue1 + " : " + intValue2 + " : " + intValue3 + " : " + 
							intValue4 + " : " + intValue5);
		*/
		
		float fin_val = intValue1 * weights[0] + intValue2 * weights[1] + intValue3 * weights[2]
				+ intValue4 * weights[3] + intValue5 * weights[4];
	
		
		totalGrade = Float.toString(fin_val);
		
		//System.out.println("fin_val is : " + fin_val);
		//System.out.println("String is : " + totalGrade);
		
		return totalGrade;
	}
}
