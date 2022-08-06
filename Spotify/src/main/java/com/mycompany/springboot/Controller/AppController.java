package com.mycompany.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.springboot.Entities.Artists;
import com.mycompany.springboot.Entities.Songs;
import com.mycompany.springboot.Repository.ArtistsRepository;
import com.mycompany.springboot.Repository.SongsRepository;
import com.mycompany.springboot.Repository.UserRepository;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ArtistsRepository artistsRepository;
	@Autowired
	private SongsRepository songsRepository;
	
	
	@GetMapping("/postArtist")
	public String saveArtist(Model model) {
		Artists artist=new Artists();
		model.addAttribute("artist",artist);
		return "AddArtists";
		
	}
	
	@GetMapping("/view-artists")
	public String viewArtisits(Model model) {
		model.addAttribute("artists",artistsRepository.findAll());
		model.addAttribute("songs",songsRepository.findAll());
		return "Homepage";
	}
	
	@GetMapping("/view-songs")
	public String viewSongs(Model model) {
		model.addAttribute("songs",songsRepository.findAll());
		return "Homepage";
	}
	
	@PostMapping("/saveArtist")
	public String saveartistof(@ModelAttribute("artist") Artists artist) {
	
		artistsRepository.save(artist);
		return "redirect:/view-artists";
	}
	/*
	 * @DeleteMapping("/delete/artist/{id}") public void deleteArtist(@PathVariable
	 * int id) { artistsRepository.deleteById(id); }
	 */
	
	
	
	@GetMapping("/postSong/{id}")
	public String saveSong(Model model,@PathVariable int id) {
		Songs song= new Songs();
		model.addAttribute("song",song);
		model.addAttribute("id",id);
		
		return "AddSong";
		
	}
	@PostMapping("/saveSong")
	public String saveSongof(@ModelAttribute("song") Songs song) {
		songsRepository.save(song);
		return "redirect:/view-artists";
	}
	
	
}
