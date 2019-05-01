import java.util.Scanner;

class studentInfo {
	Scanner sc = new Scanner(System.in);
	private float arr[][][] = new float[3][4][2];
	private String names[] = new String[3];
	
	public void setScore() {
		for(int i = 0; i < 3; i++) {
			System.out.println();
			System.out.print("Enter name >> ");
			names[i] = sc.next();
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 2; k++) {
					System.out.print("Enter " + (j+1) + "grade " + (k+1) + "semester score >>");
					arr[i][j][k] = sc.nextFloat();
				}
			}
		}
	}
	
	public void printScore() {
		System.out.println();
		System.out.println("Name\t\t" + "1grade 1semester\t\t" + "1grade 2semester\t\t" + "2grade 1semester\t\t" + "2grade 2semester\t\t" + "3grade 1semester\t\t" + "3grade 2semester\t\t" + "4grade 1semester\t\t" + "4grade 2semester\t\t");
		for(int i = 0; i < 3; i++) {
			System.out.print(names[i] + "\t\t");
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 2; k++) {
					System.out.print(arr[i][j][k] + "\t\t");
				}
			}
			System.out.println();
		}
	}
	
	public void searchScore() {
		System.out.println();
		System.out.print("Enter name to serch >> ");
		String name = sc.next();
		for(int i = 0; i < 3; i++) {
			if(name.equals(names[i])) {
				System.out.println("Name\t\t" + "1grade 1semester\t\t" + "1grade 2semester\t\t" + "2grade 1semester\t\t" + "2grade 2semester\t\t" + "3grade 1semester\t\t" + "3grade 2semester\t\t" + "4grade 1semester\t\t" + "4grade 2semester\t\t");
				for(int j = 0; j < 4; j++) {
					for(int k = 0; k < 2; k++) {
						System.out.print(names[i] + arr[i][j][k] + "\t\t");
					}
				}
			}
		}
		System.out.println();
	}
	
	public void modifyScore() {
		int grade = 0;
		int semester = 0;
		float modify = 0;
		System.out.println();
		System.out.print("Enter name to modify >> ");
		String name = sc.next();
		for(int i = 0; i < 3; i++) {
			if(name.equals(names[i])){
				System.out.print("Enter grade to modify >> ");
				grade = sc.nextInt();
				if(grade > 4) {
					System.out.println("It's up to 4th grade.");
					modifyScore();
				}
				else {
					System.out.print("Enter semester to modify >> ");
					semester = sc.nextInt();
					if(semester > 2) {
						System.out.println("It's up to 2th semester.");
						modifyScore();
					}
					else {
						System.out.println("Current score : " + arr[i][grade-1][semester-1]);
						System.out.print("Modifiy Score : ");
						modify = sc.nextFloat();
						arr[i][grade-1][semester-1] = modify;
						System.out.println("Score modify complele.");
					}
				}
			}
		}
	}
	
	public void resetScore() {
		System.out.println();
		arr = null;
		names = null;
		System.out.println("Initialization complete.");
	}
}

public class Score {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		studentInfo sI = new studentInfo();
		
		int Choice = 0;
		while(Choice != 5) {
			System.out.println();
			System.out.println("1. Input Score");
			System.out.println("2. Print Score");
			System.out.println("3. Search Score");
			System.out.println("4. Modify Score");
			System.out.println("5. Reset Info");
			System.out.println("6. Exit Program");
			System.out.print(">> ");
			Choice = sc.nextInt();
			switch(Choice) {
			case 1 :
				sI.setScore();
				break;
			case 2:
				sI.printScore();
				break;
			case 3:
				sI.searchScore();
				break;
			case 4:
				sI.modifyScore();
				break;
			case 5:
				sI.resetScore();
				break;
			case 6:
				System.out.println("Exit the program...");
				System.exit(0);
			}
		}
	}
}