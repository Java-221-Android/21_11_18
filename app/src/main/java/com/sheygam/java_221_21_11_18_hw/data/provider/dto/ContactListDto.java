package com.sheygam.java_221_21_11_18_hw.data.provider.dto;

import java.util.List;

public class ContactListDto {
    private List<FullContactDto> contacts;

    public ContactListDto() {
    }

    public ContactListDto(List<FullContactDto> contacts) {
        this.contacts = contacts;
    }

    public List<FullContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<FullContactDto> contacts) {
        this.contacts = contacts;
    }
}
