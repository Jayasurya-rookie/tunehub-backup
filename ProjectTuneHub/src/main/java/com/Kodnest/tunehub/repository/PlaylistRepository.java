package com.Kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kodnest.tunehub.entity.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository <Playlist, Integer>{

	

}
