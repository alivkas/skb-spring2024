package com.example.skbspring2024.web.service;

import com.example.skbspring2024.web.dto.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public Message getCreateMessage(String name) {
        return new Message(name, "Create");
    }

    public Message getDeleteMessage(String name) {
        return new Message(name, "Deleted");
    }
}
