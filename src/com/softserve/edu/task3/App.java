package com.softserve.edu.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {

    public static final double PRECISION = 0.000001;

    private ArrayList<Triangle> triangles;

    public App() {
        triangles = new ArrayList<Triangle>();
    }

    public void showTriangleList() {
        System.out.println("============= Triangles list: ===============");
        int i = 1;
        for (Triangle item : triangles) {
            System.out.println(i + ". " + item.toString());
            i++;
        }
    }

    public void sortTriangleList() {
        Collections.sort(triangles, new Comparator<Triangle>() {
            public int compare(Triangle o1, Triangle o2) {
                double delta = o1.getArea() - o2.getArea();
                if (delta > PRECISION) {
                    return -1;
                } else {
                    return delta < -PRECISION ? 1 : 0;
                }
            }
        });
    }

    public void addTriangle(Triangle tr) {
        triangles.add(tr);
    }

    public static void main(String[] args) {
        App app = new App();
        boolean mainMenuIsRun = true;
        boolean createMenuIsRun = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        int choice = 0;
        while (mainMenuIsRun) {
            System.out.println("Enter - <1> to create triangle");
            System.out.println("Enter - <2> to show all triangles");
            System.out.println("Enter - <3> exit");
            key = scanner.nextLine();
            try {
                choice = Integer.valueOf(key);
                switch (choice) {
                    case 1: {
                        while (createMenuIsRun) {
                            System.out.println("Format - <name>, <side1>, <side2>, <side3>");
                            try {
                                app.addTriangle(Triangle.valueOf(scanner.nextLine()));
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println("More(y/n)?");
                            switch (scanner.nextLine().toLowerCase()) {
                                case "y": {

                                }
                                case "yes": {
                                    break;
                                }
                                default: {
                                    app.sortTriangleList();
                                    createMenuIsRun = false;
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    case 2: {
                        app.showTriangleList();
                        break;
                    }
                    case 3: {
                        mainMenuIsRun = false;
                        break;
                    }
                    default: {
                        System.out.println("srsly? pls enter 1 or 2");
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(key + " - Incorrect choice");
            }
        }
        scanner.close();
    }
}
