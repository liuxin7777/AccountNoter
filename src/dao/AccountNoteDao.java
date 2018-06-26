package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Note;

public class AccountNoteDao {
	
	private static final Map<Integer, Note> noteStore = new HashMap<>();
	
	public void addNote(final Note note) {
		noteStore.put(note.getId(), note);
	}
	
	public void deleteNote(final Integer noteId) {
		noteStore.remove(noteId);
	}
	
	public Note findById(final Integer id) {
		return noteStore.get(id);
	}
	
	public Collection<Note> getAll() {
		return noteStore.values();
	}
}
