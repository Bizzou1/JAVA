package com.example.healthapp;

import java.util.Scanner;

public class HealthApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collecter les informations utilisateur
        System.out.print("Entrez votre prénom: ");
        String firstName = scanner.nextLine();

        System.out.print("Entrez votre nom de famille: ");
        String lastName = scanner.nextLine();

        System.out.print("Entrez votre âge: ");
        int age = scanner.nextInt();

        System.out.print("Entrez votre poids (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Entrez votre taille (m): ");
        double height = scanner.nextDouble();

        // Calcul de l'IMC
        double bmi = weight / (height * height);

        // Évaluation de la santé
        String healthStatus;
        if (bmi < 18.5) {
            healthStatus = "Vous êtes en insuffisance pondérale. Un suivi médical est recommandé.";
        } else if (bmi >= 18.5 && bmi < 25) {
            healthStatus = "Vous êtes en bonne santé.";
        } else if (bmi >= 25 && bmi < 30) {
            healthStatus = "Vous êtes en surpoids. Un régime et de l'exercice sont recommandés.";
        } else {
            healthStatus = "Vous êtes en obésité. Un suivi médical est fortement recommandé.";
        }

        // Afficher le résultat
        System.out.println(healthStatus);

        // Stocker les données dans PostgreSQL
        DatabaseManager.saveUserData(firstName, lastName, age, weight, height, bmi, healthStatus);

        scanner.close();
    }
}
