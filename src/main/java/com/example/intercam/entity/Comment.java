package com.example.intercam.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="list_id") // 유저 리스트
    private VideoList list_Id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="user_id") // 유저 리스트
    private Analyst analyst_id;

    @Lob @NotNull // 내용
    private String contents;

    @NotNull
    private int score;

    @Builder
    public Comment(@NotNull String contents, int score) {
        this.contents = contents;
        this.score = score;
    }

    public void addAnalyst(Analyst analyst){
        this.analyst_id = analyst;
    }

    public void addVideoList(VideoList videoList) {
        this.list_Id = videoList;
    }
}
