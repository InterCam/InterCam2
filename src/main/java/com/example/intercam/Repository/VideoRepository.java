package com.example.intercam.Repository;

import com.example.intercam.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Video findByUrl(String url);
}
