package com.Kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kodnest.tunehub.entity.Playlist;
import com.Kodnest.tunehub.entity.Song;
import com.Kodnest.tunehub.repository.PlaylistRepository;
import com.Kodnest.tunehub.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService {
	
	@Autowired
	PlaylistRepository playlistRepository;
	
	@Override
	 public void addplaylist(Playlist playlist) {
		 
		 playlistRepository.save(playlist);
		 
		 
		
	}

	
	public List<Playlist> fetchPlayListSongs(){
		List<Playlist> playList=playlistRepository.findAll();
		return playList;
		
	}

}
