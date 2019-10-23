package com.codeWithElgo;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.*;

public class Main {
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Scanner input = new Scanner(System.in);
    private static String MULT = "*";
    private static String PLUS = "+";
    private static String MOINS = "-";
    private static String DIV = "/";


    public static void calculator() throws Exception {

        System.out.println("Bienvenue dans la Calculatrice RPN \nPour Recommencer le Calcul taper \"clear\" \nA la fin de votre calcul taper \"exit\"!");

        takeInput();
    }

    public static void eval(String operateur){
        int result;
        int a = 0;
        int b = 0;
        if (operateur.equals(MULT)) {
            stack.push(stack.pop() * stack.pop());

        } else if (operateur.equals(DIV)) {
            a= (int) stack.pop();
            b=(int) stack.pop();
            if (a==0)
                System.out.println("Opération Impossible. Division By Zéro Exception");
            else
                stack.push(b / a);

        } else if (operateur.equals(PLUS)) {
            a= (int) stack.pop();
            b=(int) stack.pop();
            stack.push(b + a);

        } else if (operateur.equals(MOINS)) {
            a= (int) stack.pop();
            b=(int) stack.pop();
            stack.push(b-a);

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
        } else if (operateur.equals("w")) {
            for (int i = 0; i < stack.size(); i++) {
                System.out.println(stack.get(i));
            }
        }
    }
    private static void takeInput() {
        String valeurSaisie = " ";
        while (!valeurSaisie.equals("exit")) {
            System.out.print("Entrer une opérande ou un opérateur : ");
            valeurSaisie = input.next();
            try {
                int intNumOrOperand = Integer.valueOf(valeurSaisie);
                stack.push(intNumOrOperand);
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