package com.sheygam.java_221_21_11_18_hw.data.provider.dto;



public class FullContactDto extends BaseContactDto{
    private long id;

    public FullContactDto() {
    }

    public FullContactDto(long id) {
        this.id = id;
    }

    public FullContactDto(long id, String name, String lastName, String email, String phone, String address, String description) {
        super(name, lastName, email, phone, address, description);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FullContactDto{" +
                "id=" + id +
                '}';
    }
}
