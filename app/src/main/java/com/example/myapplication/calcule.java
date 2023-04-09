package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class calcule extends AppCompatActivity {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la valeur de Q : ");
        double Q = scanner.nextDouble();
        System.out.print("Entrez les coordonnées x : ");
        double x = scanner.nextDouble();

        System.out.print("Entrez la valeur de y : ");
        double y = scanner.nextDouble();

        System.out.print("Entrez la valeur de z : ");
        double z = scanner.nextDouble();

        System.out.print("Entrez la valeur de h : ");
        double h = scanner.nextDouble();
        System.out.print("Entrez la vitesse du vent u : ");
        double u = scanner.nextDouble();

        System.out.print("Entrez la stabilité atmosphérique (A, B, C, D, E, F) : ");
        String stability = scanner.next();
        // Calculer les valeurs de a, b, c, d et f à partir du tableau
        double a, b, c, d, f;
        switch (stability) {
            case "A":
                a = x < 1000 ? 213 : 440.8;
                c = 459.7;
                d = 1.941;
                f = 9.27;
                break;
            case "B":
                a = x < 1000 ? 156 : 106.6;
                c = 108.2;
                d = 1.149;
                f = 3.3;
                break;
            case "C":
                a = x < 1000 ? 104 : 61;
                c = 61;
                d = 0.911;
                f = 0;
                break;
            case "D":
                a = x < 1000 ? 68 : 33.2;
                c = 44.5;
                d = 0.725;
                f = -1.7;
                break;
            case "E":
                a = x < 1000 ? 50.5 : 22.8;
                c = 55.4;
                d = 0.678;
                f = -1.3;
                break;
            case "F":
                a = x < 1000 ? 34 : 14.35;
                c = 62.6;
                d = 0.74;
                f = -0.35;
                break;
            default:
                System.out.println("Stabilité atmosphérique invalide !");
                return;
        }
        b = 0.894;

        // Calculer les valeurs de sigma y et sigma z
        double sigmaY = a * Math.pow(b, y);
        double sigmaZ = c * Math.pow(d, z) + f;

        double pi = Math.PI;

        double numerator = Q;
        double denominator = 2 * pi * sigmaY * sigmaZ;
        double exponent = -(Math.pow(y, 2) / (2 * Math.pow(sigmaY, 2))) - (Math.pow(z - h, 2) / Math.pow(sigmaZ, 2));

        double Calcule = numerator / denominator * Math.exp(exponent);

        System.out.println("C(x,y,z) = " + Calcule);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);


    }

    }