package com.lolreview.summonerreview.dto;

public record ApiResponse<T>(boolean success, String message, T data) {} 