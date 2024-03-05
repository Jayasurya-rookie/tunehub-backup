package com.Kodnest.tunehub.service;

import java.util.List;

import com.Kodnest.tunehub.entity.Playlist;

public interface PlaylistService {



	public void addplaylist(Playlist playlist);

	public List<Playlist> fetchPlayListSongs();

}
