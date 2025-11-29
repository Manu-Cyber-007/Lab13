package com.lab13;

import java.util.Scanner;

import com.lab13.models.Course;
import com.lab13.models.OnSiteCourse;
import com.lab13.models.OnlineCourse;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de cursos a registrar: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        Course[] courses = new Course[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nCurso #" + (i + 1));

            System.out.print("Type (Online/OnSite): ");
            String type = sc.nextLine().trim();

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Duration(hs): ");
            int duration = sc.nextInt();
            sc.nextLine();

            System.out.print("Professor: ");
            String professor = sc.nextLine();

            if (type.equalsIgnoreCase("Online")) {
                System.out.print("Platform: ");
                String platform = sc.nextLine();

                if (professor.isEmpty()) {
                    courses[i] = new OnlineCourse(title, duration, platform);
                } else {
                    courses[i] = new OnlineCourse(title, duration, professor, platform);
                }

            } else if (type.equalsIgnoreCase("OnSite")) {
                System.out.print("Room: ");
                String room = sc.nextLine();

                System.out.print("Quota: ");
                int quota = sc.nextInt();
                sc.nextLine();

                if (professor.isEmpty()) {
                    courses[i] = new OnSiteCourse(title, duration, room, quota);
                } else {
                    courses[i] = new OnSiteCourse(title, duration, professor, room, quota);
                } 
            } else {
                System.out.println("Tipo de curso inválido  Intente de nuevo...");
                i--; // para repetir el curso actual
            }
        }

        System.out.println("\n--- Información de cursos registrados ---");
        for (Course c : courses) {
            c.showInformation();
        }

        sc.close();
    }
}
