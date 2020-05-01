package com.restriction;

import com.restriction.model.Day;
import com.restriction.model.Plate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Day> week = new ArrayList<>();

    private static void setDefaultRestrictionWeek() {
        Day monday = new Day("Lunes", Arrays.asList(1, 4, 2));
        week.add(monday);
        Day tuesday = new Day("Martes", Arrays.asList(5, 3, 8));
        week.add(tuesday);
        Day wednesday = new Day("Miercoles", Arrays.asList(6, 9, 1));
        week.add(wednesday);
        Day thursday = new Day("Jueves", Arrays.asList(7, 2, 5));
        week.add(thursday);
        Day friday = new Day("Viernes", Arrays.asList(9, 6, 3));
        week.add(friday);
        Day saturday = new Day("Sabado", Arrays.asList(4, 8, 7));
        week.add(saturday);
        Day sunday = new Day("Domingo", Arrays.asList(1, 2, 3, 5, 6, 9));
        week.add(sunday);
    }

    private static String readLine() {
        return scanner.nextLine().trim().toUpperCase();
    }

    public static void main(String[] args) {
        setDefaultRestrictionWeek();
        System.out.println("Bienvenido por favor ingrese el número de matricula de su automovil");
        String plateNumber = readPlateNumber();
        Plate plate = new Plate(plateNumber);
        if (plate.isValidPlate()) {
            printRestrictionDays(plate);
        } else {
            System.out.println("El número de matricula debe ser de 7 digitos y terminar en un numero del 1 al 9");
        }
    }

    private static void printRestrictionDays(Plate plate) {
        StringBuilder output = new StringBuilder("Los días restringidos para la placa '" + plate.getPlateNumber() + "' son: ");
        for (Day day : week) {
            int lastDigitOfPlate = plate.getLastDigitOfPlate();
            boolean hasRestriction = day.isRestricted(lastDigitOfPlate);
            if (hasRestriction) {
                output.append(day.getName()).append(", ");
            }
        }
        System.out.println(output);
    }

    private static String readPlateNumber() {
        System.out.print("Ingrese el número de placa: ");
        return readLine();
    }
}
