package com.softserve.edu.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		boolean main = true;
		boolean create = true;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Triangle> triangles = new ArrayList<Triangle>();
		for (; main;) {
			System.out.println("Enter - <1> to create triangle");
			System.out.println("Enter - <2> to show all triangles");
			System.out.println("Enter - <3> exit");
			if (scanner.hasNextInt()) {
				switch (Integer.valueOf(scanner.next())) {
				case 1: {
					for (; create;) {
						System.out.println("Format - <name>, <side1>, <side2>, <side3>");
						try {
							triangles.add(Triangle.valueOf(scanner.next()));
						} catch (IllegalArgumentException e) {
							System.out.println("Wrong format");
							scanner.close();
						}
						System.out.println("More?");
						switch (scanner.next().toLowerCase()) {
						case "y": {

						}
						case "yes": {
							break;
						}
						default: {
							Collections.sort(triangles, new Comparator<Triangle>(){
							     public int compare(Triangle o1, Triangle o2){
							         if(o1.getArea() == o2.getArea())
							             return 0;
							         return o1.getArea() < o2.getArea() ? 1 : -1;
							     }
							});
							create = false;
							break;
						}
						}
					}
					break;
				}
				case 2: {
					System.out.println("============= Triangles list: ===============");
					int i = 1;
					for (Triangle item : triangles) {
						System.out.println(i + ". " + item.toString());
						i++;
					}
					break;
				}
				case 3: {
					main = false;
					break;
				}
				default: {
					System.out.println("srsly? pls enter 1 or 2");
					break;
				}
				}
			}
		}
		scanner.close();

	}

}
