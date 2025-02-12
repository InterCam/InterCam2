package com.example.intercam.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long video_id;

    @OneToOne // 동영상 리스트
    @JoinColumn(name = "list_id")
    private VideoList listid;

    @NotNull // 제목
    private String title;

    @NotNull
    private String url;

    private String graph;

    @Builder
    public Video(@NotNull String title, @NotNull String url) {
        this.title = title;
        this.url = url;
    }
    // VideoList랑 양방향
    public void addVideoList(VideoList videoList){ // VideoList에서 addVideo로 할 것
        this.listid = videoList;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }
}
