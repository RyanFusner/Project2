package com.fusner.Project2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    static ArrayList<Item> list = new ArrayList<Item>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        Boolean isInputCorrect = true;
        int choice = -1;
        scanner.useDelimiter("\\n");
        displayMenu();

        try
        {
            choice = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            isInputCorrect = false;
        }

        while (choice != 0)
        {
            if (isInputCorrect)
            {
                switch (choice)
                {
                    case 1:
                        add();
                        break;
                    case 2:
                        displayByPriority();
                        break;
                    case 3:
                        displayAll();
                        break;
                }
            }
            scanner = new Scanner(System.in);
            scanner.useDelimiter("\\n");
            displayMenu();
            try
            {
                choice = scanner.nextInt();
                isInputCorrect = true;
            }
            catch (InputMismatchException e)
            {
                isInputCorrect = false;
            }
        }
    }

    static void add()
    {

        System.out.println("\nEnter a title:");
        String title = scanner.next();

        System.out.println("\nEnter a description:");
        String description = scanner.next();

        boolean isInputCorrect = false;
        int priority = 0;
        while (!isInputCorrect)
        {
            scanner = new Scanner(System.in);
            scanner.useDelimiter("\\n");
            try
            {
                System.out.println("\nEnter the priority (0-5):");
                priority = scanner.nextInt();
                isInputCorrect = true;
            }
            catch (InputMismatchException e)
            {
                isInputCorrect = false;
            }
        }


        list.add(new Item(title, description, priority));
    }

    static void displayAll()
    {
        System.out.println("\nTo-Do:");
        for (int i = 0; i < list.size(); i++)
        {
            list.get(i).display();
        }
        System.out.println();
    }

    static void displayByPriority()
    {
        boolean isInputCorrect = false;
        int priority = 0;
        while (!isInputCorrect)
        {
            scanner = new Scanner(System.in);
            scanner.useDelimiter("\\n");
            try
            {
                System.out.println("\nEnter the priority:");
                priority = scanner.nextInt();
                isInputCorrect = true;
            }
            catch (InputMismatchException e)
            {
                isInputCorrect = false;
            }
        }

        if (priority > 5)
        {
            priority = 5;
        }
        else if (priority < 0)
        {
            priority = 0;
        }

        System.out.println("\nTo-Do:");
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getPriority() == priority)
            {
                list.get(i).display();
            }
        }
        System.out.println();
    }

    static void displayMenu()
    {
        System.out.println("(1) Add an item.\n(2) List task by priority.\n(3) List all tasks.\n(0) Exit.\nPlease choose an option:");
    }
}
