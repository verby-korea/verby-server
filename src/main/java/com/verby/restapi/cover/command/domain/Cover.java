package com.verby.restapi.cover.command.domain;

import com.verby.restapi.common.domain.BaseEntity;
import com.verby.restapi.common.event.Events;
import com.verby.restapi.cover.command.application.CoverCreatedEvent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cover extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long contestId;

    @Column(name = "user_id")
    private long publisherId;

    private String title;

    private String content;

    private String video;

    private String highlight;

    private String image;

    private long hits;

    public Cover(long contestId, long publisherId, String title, String content, String video, String highlight, String image) {
        this.contestId = contestId;
        this.publisherId = publisherId;
        this.title = title;
        this.content = content;
        this.video = video;
        this.highlight = highlight;
        this.image = image;
    }

    @PostPersist
    private void onPostPersist() {
        Events.raise(new CoverCreatedEvent(this));
    }

}
