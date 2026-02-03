package com.example.proj.entity;


import com.example.proj.repository.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {

    public void insertArtist(Artist artist) {
        String sql = "INSERT INTO artist (name, genre) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, artist.getName());
            ps.setString(2, artist.getGenre());
            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }
    }

    public void updateArtist(Artist artist) {
        String sql = "UPDATE artist SET name=?, genre=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, artist.getName());
            ps.setString(2, artist.getGenre());
            ps.setInt(3, artist.getId());
            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }
    }

    public void deleteArtist(int id) {
        String sql = "DELETE FROM artist WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Artist> readArtists() {
        List<Artist> list = new ArrayList<>();
        String sql = "SELECT * FROM artist";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Artist(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("genre")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }

        return list;
    }
}
