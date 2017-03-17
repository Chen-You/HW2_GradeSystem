import java.util.Iterator;
import java.util.Scanner;

public class UI {
	
	private GradeSystems aGradeSystem;
	private String input;//ID or Q
	private String instruction;// G R A W E
	private Scanner scanner, scanner1;
	
	public UI(){
		aGradeSystem = new GradeSystems();
		scanner = new Scanner(System.in);
		scanner1 = new Scanner(System.in);
		ShowInScreen();
		
	}
	
	public void ShowInScreen(){
		while(true){
			System.out.println("輸入ID或Q: ");
			input = scanner.next();
			if(input.equals("Q")){
				System.out.println("結束了");
				break;
			}
			else{
				checkID(input);
			}
		}
		
	}
	
	public void checkID(String id){
		boolean flag = false;
		flag = aGradeSystem.contains(id);
		if(flag == true){
			promptCommand(id);
		}
		else{
			System.out.println("使用者輸入錯誤的ID，請重新輸入...");
		}
	}
	
	public void promptCommand(String ID){
		while(true){
			System.out.println("輸入指令：G 顯示成績");
			System.out.println("        R 顯示排名 ");
			System.out.println("        A 顯示平均");
			System.out.println("        W 更新配分 ");
			System.out.println("        E 離開選單");
			instruction = scanner1.next();
			if(instruction.equals("G")){
				aGradeSystem.showGrade(ID);
			}
			else if(instruction.equals("R")){
				aGradeSystem.showRank(ID);
			}
			else if(instruction.equals("A")){ // NOT DONE
				System.out.println("Some not done");
			}
			else if(instruction.equals("W")){ // NOT DONE
				aGradeSystem.updateWeights(ID);
			}
			else if(instruction.equals("E")){
				System.out.println("離開選單");
				break;
			}
			else{
				System.out.println("指令輸入錯誤，請重新輸入..");
			}
		}
	}
	
	
	
	
}
