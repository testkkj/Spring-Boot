package com.example.board.dto;

import lombok.Data;

@Data
public class BoardDto {
    private int boardIdx;
    private String title;
    private String contents;
    private int hitcount;
    private String creatorId;
    private String createdDatetime;
    private String updaterId;
    private String updatedDatetime;
}
