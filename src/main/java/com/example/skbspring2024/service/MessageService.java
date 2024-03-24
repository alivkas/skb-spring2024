package com.example.skbspring2024.service;

import com.example.skbspring2024.dto.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public Message getCreateMessage() {
        return new Message("Succes", "Created");
    }
}
