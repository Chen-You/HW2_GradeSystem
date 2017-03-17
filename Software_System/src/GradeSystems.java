import java.io.FileReader;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.*;
import java.util.LinkedList;


public class GradeSystems {
	
	public LinkedList<Grades> aList;
	private FileReader fr;
	private BufferedReader br;
	private String line;
	public float []weights;
	
	public GradeSystems(){
		try{
			weights = new float[5];
			weights[0] = (float) 0.1;
			weights[1] = (float) 0.1;
			weights[2] = (float) 0.1;
			weights[3] = (float) 0.3;
			weights[4] = (float) 0.4;
			fr = new FileReader("gradeinput.txt");
			br = new BufferedReader(fr);
			aList = new LinkedList<Grades>();
			
			while((line = br.readLine())!= null){ 
				int cnt = 0;
				int namecnt = 0;
				StringBuffer Two_name = null;
				Grades aGrade = new Grades();
				System.out.println(line);
				String[] tokens = line.split("　| ");
				
				for (String token:tokens) {
					if(token.length() == 10){
						aGrade.ID = token.substring(1, 10);
						//System.out.println(aGrade.ID);
					}
					if(token.length() == 3){
						aGrade.name = token;
					}
					else if(token.length() == 9){
						aGrade.ID = token;
					}
					else if(token.length() == 2){
						if(cnt == 0){
							aGrade.lab1 = token;
							++cnt;
						}
						else if(cnt == 1){
							aGrade.lab2 = token;
							++cnt;
						}
						else if(cnt == 2){
							aGrade.lab3 = token;
							++cnt;
						}
						else if(cnt == 3){
							aGrade.midTerm = token;
							++cnt;
						}
						else if(cnt == 4){
							aGrade.finalExam = token;
							++cnt;
						}
					}
					else if(token.length() == 1 || token.length() == 0){
						if(token.length() == 1){
							if(namecnt == 0){
								Two_name = new StringBuffer(token);
								++namecnt;
							}
							else if(namecnt == 1){
								Two_name.append(token);
								aGrade.name = Two_name.toString();
							}
						}
						
					}
					else{
						continue;
					}
					
				}
				aGrade.totalGrade = aGrade.calculateTotalGrade(weights);
				aList.add(aGrade);
			}
			
			br.close();  
	        fr.close(); 
		} catch(IOException ex){
			System.err.println(ex.getMessage());
		}
	}
	
	public boolean contains(String ID){
		boolean flag = false;
		Iterator<Grades> i = aList.iterator();
		while(i.hasNext()){
			Grades current = ((Grades)i.next());
			if(current.ID.equals(ID)){
				System.out.println("Welcome " + current.name);
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public void showGrade(String ID){
		Iterator<Grades> i = aList.iterator();
		Grades current = null;
		while(i.hasNext()){
			current = ((Grades)i.next());
			//System.out.println(current.ID + " " + current.name + " " + current.ID.length());
			if(current.ID.equals(ID)){
				break;
			}
		}
			System.out.print(current.name + "成績:lab1	" + current.lab1);
			lowThan60(current.lab1);
			System.out.print(current.name + "成績:lab2	" + current.lab2);
			lowThan60(current.lab2);
			System.out.print(current.name + "成績:lab3	" + current.lab3);
			lowThan60(current.lab3);
			System.out.print(current.name + "成績:mid-term	" + current.midTerm);
			lowThan60(current.midTerm);
			System.out.print(current.name + "成績:final exam	" + current.finalExam);
			lowThan60(current.finalExam);
			System.out.print(current.name + "成績:total grade	" + current.totalGrade);
			if(Float.parseFloat(current.totalGrade) < 60)
				System.out.println("*");
			else
				System.out.println();
	}
	
	public void lowThan60(String grade)
	{
		if(Integer.parseInt(grade) < 60)
			System.out.println("*");
		else
			System.out.println();
	}
	
	public void showRank(String ID){
		Iterator<Grades> i = aList.iterator();
		Iterator<Grades> j = aList.iterator();
		Grades current = null;
		Grades current2 = null;
		int rank = 1;
		while(i.hasNext()){
			current = ((Grades)i.next());
			if(current.ID.equals(ID)){
				break;
			}
		}
		while(j.hasNext()){
			current2 = ((Grades)j.next());
			if(Float.parseFloat(current.totalGrade) < Float.parseFloat(current2.totalGrade))
				++rank;
		}
		
		System.out.println(current.name + "排名為" + rank + "名");
	}
	
	public void updateWeights(String ID){
		System.out.print("舊配分:");
		System.out.println("lab1:	" + weights[0] * 100 + "%");
		System.out.println("	  lab2:	" + weights[1] * 100 + "%");
		System.out.println("	  lab3:	" + weights[2] * 100 + "%");
		System.out.println("	  mid-Term:	" + weights[3] * 100 + "%");
		System.out.println("	  final exam:	" + weights[4] * 100 + "%");
		
		//Need to add something
		
	}

}
