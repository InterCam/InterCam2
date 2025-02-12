package com.example.intercam.entity;

import com.example.intercam.dto.UserJoinDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}) // 동영상 리스트
    private List<VideoList> list_id;

    @NotNull @Column(unique = true, columnDefinition = "varchar(100)")
    private String username; // 이메일(아이디)
    @NotNull
    private String password; // 비밀번호
    @NotNull @Column(columnDefinition = "varchar(20)")
    private String phone; // 전화번호
    @NotNull @Column(columnDefinition = "varchar(20)")
    private String birth; // 생일
    @NotNull @Column(columnDefinition = "varchar(20)")
    private String name;

    @Column(columnDefinition = "varchar(32) default 'User'")
    private String auth;

    public User(UserJoinDto userJoinDto) {
        this.username = userJoinDto.getUsername();
        this.password = userJoinDto.getPassword();
        this.phone = userJoinDto.getPhone();
        this.birth = userJoinDto.getBirth();
        this.name = userJoinDto.getName();
        this.auth = Auth.USER.getKey();
    }

    public User(@NotNull String username, @NotNull String password,
                @NotNull String phone, @NotNull String name,
                @NotNull String birth) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.name = name;
        this.auth = Auth.ANALYST.getKey();
    }

    public void addVideoList(VideoList videoList){
        if(list_id == null){
            list_id = new ArrayList<>();
        }
        list_id.add(videoList);
        videoList.addUser(this);
    }

    public void changePassword(String password){
        this.password = password;
    }

}
