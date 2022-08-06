package com.mycompany.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.springboot.Entities.Songs;

@Repository
public interface SongsRepository extends JpaRepository<Songs, Integer> {

}
