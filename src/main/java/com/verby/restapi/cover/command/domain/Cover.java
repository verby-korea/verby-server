package com.verby.restapi.cover.command.domain;

import com.verby.restapi.common.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cover extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long contestId;

    private long covererId;

    private String title;

    private String video;

    private String highlight;

    private String image;

    private long hits;

    public Cover(long contestId, long covererId, String title, String video, String highlight, String image) {
        this.contestId = contestId;
        this.covererId = covererId;
        this.title = title;
        this.video = video;
        this.highlight = highlight;
        this.image = image;
    }
}
