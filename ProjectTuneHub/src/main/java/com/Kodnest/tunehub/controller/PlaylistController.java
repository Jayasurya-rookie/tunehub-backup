package com.Kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Kodnest.tunehub.entity.Playlist;
import com.Kodnest.tunehub.entity.Song;
import com.Kodnest.tunehub.service.PlaylistService;
import com.Kodnest.tunehub.service.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	PlaylistService playlistService;
	@Autowired
	SongService songService;
	
	
	
	
	@GetMapping("/createplaylists")
	public String viewsongs(Model model) {
		List<Song> songList =songService.fetchAllSongs();
		//System.out.println("Song List "+songList);
		model.addAttribute("songs", songList);
		
		
		return "createplaylists";
	}

	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		//updating  play list table
		
		playlistService.addplaylist(playlist);
		
		
		//updating song table
		List<Song> songList=playlist.getSongs();
		for(Song s: songList) {
			s.getPlaylists().add(playlist);
			songService.updateSong(s);
		}
		
		return "adminhome";
		
	}
	
	@GetMapping("/viewplaylist")
	public String viewPlayListSongs(Model model1) {
		List<Playlist> playList =playlistService.fetchPlayListSongs();
	
		model1.addAttribute("playlistsongs", playList);
		
		
		return "viewplaylist";
	}
	
	
	

}
