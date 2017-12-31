package TodoList;

import java.util.Scanner;


public class UI {
    Controller controller;

    public static void main(String[] args) {
        UI ui = new UI();
        ui.controller = new Controller();

        ui.printWelcome();

        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            ui.process(s.nextLine());
        }
        s.close();
        ui.exit();
    }

    public void printWelcome() {
        System.out.format("%s\n", "Welcome to Use Java NoteBook");
    }

    public void process(String str) {
        String[] parts = str.split(" ");
        switch(parts[0].toLowerCase()) {
            case "add":
                controller.addNote(parts[1], parts[2]);
                break;
            case "list":
                controller.printAllNote();
                break;
            case "delete":
                controller.deleteNote(parts[1]);
                break;
            default:
                System.out.println("Usage:\nadd title content\ndetele title \nlist");
                break;
        }
    }

    public void exit() {
        controller.saveData();
        System.out.println("Thanks for using");
    }
}