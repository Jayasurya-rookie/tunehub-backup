package com.Kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kodnest.tunehub.entity.Song;
import com.Kodnest.tunehub.repository.SongRepository;
import com.Kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService{
	@Autowired
	SongRepository songRepository;
	
	
	public String addSong(Song song) {
		songRepository.save(song);
		return "Song added sucessfully";
	}
	// to check duplicate song name
	public boolean songExists(String name) {
		
		if(songRepository.findByName(name)==null) {
//			System.out.println("prese");
			return false;
		}
		else {
//			System.out.println("absent");
			return true;
		}
		
	}
	public List<Song> fetchAllSongs(){
		List<Song> songs=songRepository.findAll();
		return songs;
	}
	@Override
	public void updateSong(Song s) {
		songRepository.save(s);
		
		
		
	}
	

}
