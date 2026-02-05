package com.example.proj.controller;

import com.example.proj.entity.Artist;
import com.example.proj.entity.ArtistDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/artist")
public class ArtistController {

    ArtistDAO dao = new ArtistDAO();

    @PostMapping
    public String add(@RequestBody Artist a){
        dao.insertArtist(a);
        return "Artist added";
    }

    @PutMapping
    public String update(@RequestBody Artist a){
        dao.updateArtist(a);
        return "Artist updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        dao.deleteArtist(id);
        return "Artist deleted";
    }

    @GetMapping
    public List<Artist> list(){
        return dao.readArtists();
    }
}