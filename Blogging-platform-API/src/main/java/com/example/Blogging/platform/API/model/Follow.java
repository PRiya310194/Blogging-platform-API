package com.example.Blogging.platform.API.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Data
@Table(name="tbl_follow")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer followId;
    @ManyToOne
    @NotNull(message="user can not be null")
    private User user;
    @ManyToOne
    @NotNull(message="following user can not be null ")
    private User followingUsers;
}
