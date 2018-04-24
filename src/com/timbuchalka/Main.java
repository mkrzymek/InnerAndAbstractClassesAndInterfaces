package com.timbuchalka;

import com.sun.deploy.pings.Pings;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void interfaces() {
        ITelephone timsPhone;
        timsPhone = new DeskPhone(12345);
        timsPhone.powerOn();
        timsPhone.callPhone(12345);
        timsPhone.answer();

        timsPhone = new MobilePhone(24231);
        timsPhone.powerOn();
        timsPhone.callPhone(24231);
        timsPhone.answer();
    }

    public static void interfaceChallenge() {
        // Create a simple interface that allows an object to be saved to some sort of storage medium.
        // The exact type of medium is not known to the interface (nor to the classes that implement it).
        // The interface will just specify 2 methods, one to return an ArrayList of values to be saved
        // and the other to populate the object's fields from an ArrayList.
        //
        // Create some sample classes that implement your saveable interface (we've used the idea of a game,
        // with Players and Monsters, but you can create any type of classes that you want).
        //
        // Override the toString() method for each of your classes so that they can be easily printed to enable
        // the program to be tested easier.
        //
        // In Main, write a method that takes an object that implements the interface as a parameter and
        // "saves" the values.
        // We haven't covered I/O yet, so your method should just print the values to the screen.
        // Also in Main, write a method that restores the values to a saveable object.
        // Again, we are not going to use Java file I/O; instead use the readValues() method below to
        // simulate getting values from a file – this allows you to type as many values as your class
        // requires, and returns an ArrayList.

        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim.toString());
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);
        tim.setWeapon("Stormbringer");
        saveObject(tim);
//        loadObject(tim);
        System.out.println(tim);

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println("Strength = " + ((Monster) werewolf).getStrength());
        saveObject(werewolf);

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for(int i=0; i<objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }


    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");


    public static void innerClass() {

        Gearbox mcLaren = new Gearbox(6);
//        mcLaren.addGear(1, 5.3);
//        mcLaren.addGear(2, 10.6);
//        mcLaren.addGear(3, 15.9);
        mcLaren.operateClitch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClitch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClitch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClitch(false);
        System.out.println(mcLaren.wheelSpeed(6000));


//        Gearbox.Gear first = mcLaren.new Gear(1, 12.3);
//        System.out.println(first.driveSpeed(1000));

        class ClickListner implements Button.OnClickListener {
            public ClickListner() {
                System.out.println("Ive beend attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        }

//        btnPrint.setOnClickListener(new ClickListner());
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();
    }

    private static void listen() {

        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }


    private static void abstractClasses() {

        Dog dog = new Dog("Yorkie");
        dog.breath();
        dog.eat();

        Bird bird = new Parrot("Australian ringneck");
        bird.breath();
        bird.eat();
        bird.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
    }

    private static void abstractClassChallenge() {
        // For this challenge, create an abstract class to define items that can be stored in a tree.
        // The class should contain 2 references to items which will represent the next and previous
        // items (in the case of a linked tree).
        // I.e., if you call your abstract class ListItem, then it would have 2 member variables of
        // type ListItem that will hold references to the next/right and previous/left ListItems.
        //
        // The abstract class will also need to hold a value - try to be as flexible as possible
        // when defining the type of this value.
        //
        // The class will also need methods to move to the next item and back to the previous item,
        // and methods to set the next and previous items.
        //
        // You should also specify a compareTo() method that takes a parameter of the same type as the
        // class and returns 0 if the values are equal, greater than zero if the value sorts greater than
        // the parameter and less than zero if it sorts less than the parameter.
        //
        // Create a concrete class from your abstract tree item class and use this in a LinkedList
        // class to implement a linked tree that will add items in order (so that they are sorted
        // alphabetically). Duplicate values are not added.
        //
        // Note that you are creating your own LinkedList class here, not using the built-in Java one..
        //
        // The rules for adding an item to the linked tree are:
        //  If the head of the tree is null, make the head refer to the item to be added.
        //  If the item to be added is less than the current item in the tree, add the item before the
        //      current item (i.e., make the previous item's "next" refer to the new item, and the new item's
        //      "next" refer to the current item).
        //  If the item to be added is greater than the current item, move onto the next item and compare
        //      again (if there is no next item then that is where the new item belongs).
        //
        // Care will be needed when inserting before the first item in the tree (as it will not have a previous
        // item).
        //
        // You will also need a method to remove an item from the tree.
        //
        // Hint: If you are creating classes with names such as List, LinkedList, Node etc, make sure that
        // you create your classes before referring to them. In previous videos we have often referred to
        // classes that we create later, but if you use names that IntelliJ recognises as Java classes (such
        // as LinkedList) then it will create imports for them and possibly cause you problems later.
        //
        // Optional: create a class to use your concrete class to implement a Binary Search Tree:
        // When adding items to a Binary Search Tree, if the item to be added is less than the current item
        // then move to the left, if it is greater than the current item then move to the right.
        //
        // The new item is added when an attempt to move in the required direction would involve following a
        // null reference.
        // Once again, duplicates are not allowed.
        //
        // Hint: to avoid typing loads of "addItem" lines, split a string into an array and create your tree in
        // a loop as in the example below.
        //

        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());
        // Create a string data array to avoid typing loads of addItem instructions:
        String stringData = "5 7 3 9 8 2 1 0 4 6";
//        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";


        String[] data = stringData.split(" ");
        for (String s : data) {
            tree.addItem(new Node(s));
        }


        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("3"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("5"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("0"));
        tree.removeItem(new Node("4"));
        tree.removeItem(new Node("2"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("9"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("8"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("6"));
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot());
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot());
        tree.traverse(tree.getRoot());
    }



    public static void main(String[] args) {

//        interfaces();
//        interfaceChallenge();
//        innerClass();
//        abstractClasses();
        abstractClassChallenge();

    }

}
