package com.stream.app.springStream_backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "yt_videos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    private String videoId;

    private String title;

    private String description;

    private String contentType;

    private String filePath;

//    @ManyToOne
//    private Courses courses;

}
