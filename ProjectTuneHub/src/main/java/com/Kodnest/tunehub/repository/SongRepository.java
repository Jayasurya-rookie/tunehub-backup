package com.Kodnest.tunehub.repository;

//import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kodnest.tunehub.entity.Song;


@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{


	public Song findByName(String name);
	
//	public List<Song> fetchAllSongs();

}
