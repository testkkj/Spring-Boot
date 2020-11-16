package com.example.board.dto;

import lombok.Data;

@Data
public class BoardFileDto {
    private int idx;
    private int boardIdx;
    private String originalFileName;
    private String storedFilePath;
    private int fileSize;
}