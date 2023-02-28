package com.example.noteapp1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteRepository repo;
	
	@Autowired
	RestTemplate template;
	
	@Override
	public List<Note> showAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Note addNotes(Note note) {
		// TODO Auto-generated method stub
		return repo.save(note);
	}

	@Override
	public Optional<Note> searchByNoteId(String pid) {
		// TODO Auto-generated method stub
		return repo.findById(pid);
	}

	@Override
	public void deleteNoteById(String pid) {
		// TODO Auto-generated method stub
		repo.deleteById(pid);
		
	}

	@Override
	public List<Note> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return repo.findByTitle(title);
	}

	@Override
	public List<Note> searchByTitleandAuthor(String title, String author) {
		// TODO Auto-generated method stub
		return repo.findByTitleAndAuthor(title, author);
	}

	@Override
	public List<CommentsDto> findCommentsByPid(String pid) {
		// TODO Auto-generated method stub
		
		return template.getForObject("http://localhost:8088/comments/findByPid/"+pid, List.class);
		//return null;
	}

}
