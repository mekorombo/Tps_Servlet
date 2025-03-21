package com.example.tpservlet;

public class Imc {
    private double taille;
    private double poids;

    // Constructeur
    public Imc(double taille, double poids) {
        this.taille = taille;
        this.poids = poids;
    }

    // Méthode pour calculer l'IMC
    public double calcul() {
        return poids / (taille * taille);
    }
}