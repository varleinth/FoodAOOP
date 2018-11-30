import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	static int price, jumlah=0;
	static String type, name;
	static float calories;
	
	static Vector<String> arrayType = new Vector<>();
	static Vector<String> arrayName = new Vector<>();
	static Vector<Float> arrayCalories = new Vector<>();
	static Vector<Integer> arrayPrice = new Vector<>();
	
	public static void delete() {
		int delete;
		if(jumlah==0) {
			return;
		}
	
		else {
			for(int i = 0; i<jumlah;i++) {
			loop(i);
		}
		
		System.out.print("Input number<No> to be deleted ["+1+".."+jumlah+"] [0 to cancel] : ");
		delete = scanner.nextInt();
		scanner.nextLine();
		
		if(delete == 0) {
			return;
		}
		else {
			arrayType.remove(delete-1);
			arrayName.remove(delete-1);
			arrayCalories.remove(delete-1);
			arrayPrice.remove(delete-1);
			jumlah--;
			System.out.println("Data has been succesfully deleted!");
			scanner.nextLine();
			System.out.println();
			System.out.println();
		}
		
		}
		
	}
	
	public static void loop(int i) {
		
			System.out.println("No	: " + (i+1));
			System.out.println("=============");
			System.out.println("Type		: " + arrayType.get(i));
			System.out.println("Name		: " + arrayName.get(i));
			System.out.println("Calories	: " + arrayCalories.get(i));
			System.out.println("Price		: " + arrayPrice.get(i));
			System.out.println();
			
	}
	
	public static void search() {
		String search;
		int index;
		System.out.print("Input food name [3-20] : ");
		search = scanner.nextLine();
		index = arrayName.indexOf(search);
		
		if(index < 0) {
			System.out.println("No data found!");
			System.out.println();
		}
		else {
			loop(index);
		}
	}
	
	public static void insert() {
		do {
		System.out.print("Input food type : ");
		type = scanner.nextLine();
		type = type.toLowerCase();
		}while(!type.equals("appetizer") && !type.equals("main course") && !type.equals("dessert"));
		
		do {
			System.out.print("Input food name [3-20] : ");
			name = scanner.nextLine();
			
		}while(name.length() < 3 || name.length() > 20);
		
		do {
			System.out.print("Insert food calories [1.0 - 4.0] : ");
			calories = scanner.nextFloat();
			scanner.nextLine();
		}while(calories < 1.0 || calories > 4.0);
		
		do {
			System.out.print("Insert food price [10000..50000] : ");
			price = scanner.nextInt();
			scanner.nextLine();
		}while(price < 10000 || price > 50000);
		
		arrayType.add(type);
		arrayName.add(name);
		arrayCalories.add(calories);
		arrayPrice.add(price);
		jumlah++;
		System.out.println("Data has been succesfully inserted!");
		scanner.nextLine();
		
		
	}
	
	public static void menu() {
		System.out.println("1. Insert new Food");
		System.out.println("2. List of Food");
		System.out.println("3. Search Food");
		System.out.println("4. Delete Food");
		System.out.println("5. Exit");
	}

	public static void main(String[] args) {
		int menu;
		
		
		do {
			menu();
			menu = scanner.nextInt();
			scanner.nextLine();
			
			switch(menu) {
			case 1:
				insert();
				
				break;
			case 2:
				for(int i = 0; i<jumlah;i++) {
					loop(i);
				}
				break;
			case 3:
				search();
				break;
			
			case 4:
				delete();
				break;
			
			case 5:
				System.exit(0);
				break;
			}
		}while(menu > 0 && menu < 6);
	}

}
