package com.codeWithElgo;

import java.util.*;

public class Main {
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Scanner input = new Scanner(System.in);


    public static void calculator() throws Exception {

        System.out.println("Bienvenue dans la Calculatrice RPN \nPour Recommencer le Calcul taper \"clear\" \nA la fin de votre calcul taper \"exit\"!");

        takeInput();
    }

    private static void takeInput() {
        String valeurSaisie = " ";
        int result;
        int a=0;
        int b = 0;
        while (!valeurSaisie.equals("exit")) {
            System.out.print("Entrer une opérande ou un opérateur : ");
            valeurSaisie = input.next();
            try {
                int intNumOrOperand = Integer.valueOf(valeurSaisie);
                stack.push(intNumOrOperand);
            } catch (Exception e) {
                if (valeurSaisie.equals("*")) {
                    stack.push(stack.pop() * stack.pop());

                } else if (valeurSaisie.equals("/")) {
                    a= (int) stack.pop();
                    b=(int) stack.pop();
                    if (a==0)
                        System.out.println("Opération Impossible. Division By Zéro Exception");
                    else
                        stack.push(b / a);

                } else if (valeurSaisie.equals("+")) {
                    stack.push(stack.pop() + stack.pop());

                } else if (valeurSaisie.equals("-")) {
                    a= (int) stack.pop();
                    b=(int) stack.pop();
                    stack.push(b-a);

                } else if (valeurSaisie.equals("=")) {
                    result = (stack.pop());
                    System.out.println(result);
                    stack.push(result);

                } else if (valeurSaisie.equals("clear")) {
                    if (!stack.empty()) {
                        for (int i = 0; i < stack.size(); i++) {
                            stack.pop();
                        }
                    }
                } else if (valeurSaisie.equals("w")) {
                    for (int i = 0; i < stack.size(); i++) {
                        System.out.println(stack.get(i));
                    }
                }
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