package com.codeWithElgo;

import java.util.*;

public class Main {
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Scanner input = new Scanner(System.in);
    private static String MULT = "*";
    private static String PLUS = "+";
    private static String MOINS = "-";
    private static String DIV = "/";

    //Lancement du menu Calculatrice RPN
    public static void calculator() throws Exception {

        System.out.println("Bienvenue dans la Calculatrice RPN " +
                "           \nPour Recommencer le Calcul taper \"clear\" " +
                "           \nA la fin de votre calcul taper \"exit\"!");

        takeInput();
    }
    //Analyse de l'opérateur saisie et Calcul
    public static void eval(String operateur){
        int result;
        int a = 0;
        int b=  0;
        if (operateur.equals(MULT)) {
            a= (int) stack.pop();
            b=(int) stack.pop();
            stack.push(multiplication(a, b));

        } else if (operateur.equals(DIV)) {
            a= (int) stack.pop();
            b=(int) stack.pop();
            stack.push(division(a , b));

        } else if (operateur.equals(PLUS)) {
            a= (int) stack.pop();
            b=(int) stack.pop();
            stack.push(addition(a, b));

        } else if (operateur.equals(MOINS)) {
            a= (int) stack.pop();
            b=(int) stack.pop();
            stack.push(soustraction(a,b));

        } else if (operateur.equals("=")) {
            result = (stack.pop());
            System.out.println(result);
            stack.push(result);

        } else if (operateur.equals("clear")) {
            if (!stack.empty()) {
                for (int i = 0; i < stack.size(); i++) {
                    stack.pop();
                }
            }
        }
    }

    //Definition des méthodes des différentes opérations
    public static Integer division(int a, int b) {
        if (a==0)
            System.out.println("Opération Impossible. Division By Zéro Exception");
        return b / a;
    }
    public static Integer multiplication(int a, int b) {
        return a * b;
    }

    public static Integer soustraction(int a, int b) {
        return b - a;
    }

    public static Integer addition(int a, int b) {
        return a + b;
    }

    //récupération des valeurs saisies par l'utilisateur et analayse du type (Opérateur ou opérande)
    //Puis appelle de la fonction eval pour effectuer les opérations
    private static void takeInput() {
        String valeurSaisie = " ";
        while (!valeurSaisie.equals("exit")) {
            System.out.print("Entrer une opérande ou un opérateur : ");
            valeurSaisie = input.next();
            try {
                int intNumOrOperand = Integer.valueOf(valeurSaisie);
                stack.push(intNumOrOperand);
                for (int i = 0; i < stack.size(); i++) {
                    System.out.println(stack.get(i));
                }
            } catch (Exception e) {
                eval(valeurSaisie);
            }

        }
    }



    public static void main(String[] args) {
        try {
            calculator();
        } catch (Exception e) {
            System.out.println("Oops, Opération mal saisie! ");
        }

    }

}