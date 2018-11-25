package com.sheygam.java_221_21_11_18_hw.data.provider.dto;

public class DeleteContactResponseDto {
    private String status;

    public DeleteContactResponseDto() {
    }

    public DeleteContactResponseDto(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DeleteContactResponseDto{" +
                "status='" + status + '\'' +
                '}';
    }
}
