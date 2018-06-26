package service;

import java.util.Collection;

import dao.AccountNoteDao;
import model.Note;
import view.MainMenu;

public class NoteService {
	
	private MainMenu mainMenu;
	
	private final AccountNoteDao accountNoteDao = new AccountNoteDao();

	public NoteService(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public void addNote() {
		Note note = mainMenu.showAndGetNote(0);
		accountNoteDao.addNote(note);
		mainMenu.showSuccessAndWait();
	}

	public void deleteNote() {
		Integer noteId = mainMenu.getNoteIdToDelete();
		accountNoteDao.deleteNote(noteId);
		mainMenu.showSuccessAndWait();
	}
	
	public void showAllNotes() {
		Collection<Note> notes = accountNoteDao.getAll();
		mainMenu.showAllNotes(notes);
		mainMenu.showSuccessAndWait();
	}
	
	public void updateNote() {
		showAllNotes();
		Integer noteId = mainMenu.getNoteIdToModify();
		Note note = mainMenu.showAndGetNote(noteId);
		accountNoteDao.addNote(note);
		mainMenu.showSuccessAndWait();
	}
	
	public void doStatic() {
		// TODO Auto-generated method stub
		
	}

}
