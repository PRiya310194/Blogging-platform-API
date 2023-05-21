package com.example.Blogging.platform.API.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tbl_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private Integer commentId;
    private String comment;
    @ManyToOne
    @NotNull(message="sender missing")
    private User sender;
    @ManyToOne
    @NotNull(message="receiver missing")
    private User receiver;

}
