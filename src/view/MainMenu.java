package view;

import java.util.Collection;
import java.util.Scanner;

import model.Note;
import service.NoteService;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// View
		MainMenu mainMenu = new MainMenu();
		// Service
		NoteService noteService = new NoteService(mainMenu);

		int choice = 0;

		while (choice != 6) {
			mainMenu.showMainMenu();
			choice = mainMenu.getInputChoice();

			switch (choice) {
			case 1:
				noteService.addNote();
				break;
			case 2:
				noteService.deleteNote();
				break;
			case 3:
				noteService.showAllNotes();
				break;
			case 4:
				noteService.updateNote();
				break;
			case 5:
				noteService.doStatic();
				break;
			}
		}

	}

	public void showMainMenu() {
		System.out.println("1. Add a note ");
		System.out.println("2. Delete a note ");
		System.out.println("3. Show all notes ");
		System.out.println("4. Update a note ");
		System.out.println("5. Do static analysis ");
		System.out.println("6. Quit ");
	}

	public int getInputChoice() {
		int input = 0;

		do {
			System.out.println("Please input your choice : ");
			input = sc.nextInt();
		} while (input <= 0 || input > 6);

		return input;
	}

	public Note showAndGetNote(final Integer noteId) {
		Note note = new Note();
		if (0 == noteId) {
			System.out.println("Input note ID : ");
			note.setId(sc.nextInt());
		} else
			note.setId(noteId);
		System.out.println("Input note name : ");
		note.setName(sc.next());
		System.out.println("Input note price : ");
		note.setPrice(sc.nextDouble());

		return note;
	}

	public Integer getNoteIdToDelete() {
		System.out.println("Input note ID to delete : ");
		return sc.nextInt();
	}

	public void showAllNotes(Collection<Note> notes) {
		notes.forEach(e -> System.out.println(e.toString()));
	}

	public Integer getNoteIdToModify() {
		System.out.println("Input note ID to update : ");
		return sc.nextInt();
	}

	public void showSuccessAndWait() {
		System.out.println("Operation success, Press Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
	}
}
