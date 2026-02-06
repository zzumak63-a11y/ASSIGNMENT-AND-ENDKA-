package com.example.proj.entity;

import com.example.proj.repository.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDAO {

    public void insertSong(Song song) {
        String sql = "INSERT INTO song (title, duration, artist_id) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, song.getTitle());
            ps.setInt(2, song.getDuration());
            ps.setInt(3, song.getArtistId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Song> getSongsByArtistId(int artistId) {
        List<Song> list = new ArrayList<>();
        String sql = "SELECT * FROM song WHERE artist_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, artistId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Song(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("duration"),
                        rs.getInt("artist_id")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void deleteSong(int id) {
        String sql = "DELETE FROM song WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}