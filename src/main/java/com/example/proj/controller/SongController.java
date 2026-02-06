package com.example.proj.controller;

import com.example.proj.entity.Song;
import com.example.proj.entity.SongDAO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    SongDAO dao = new SongDAO();

    @PostMapping
    public String add(@RequestBody Song s) {
        dao.insertSong(s);
        return "Song added";
    }

    @GetMapping("/artist/{artistId}")
    public List<Song> listByArtist(@PathVariable int artistId) {
        return dao.getSongsByArtistId(artistId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        dao.deleteSong(id);
        return "Song deleted";
    }
}