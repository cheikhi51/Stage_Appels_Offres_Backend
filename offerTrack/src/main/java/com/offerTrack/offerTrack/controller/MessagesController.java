package com.offerTrack.offerTrack.controller;

import com.offerTrack.offerTrack.model.Messages;
import com.offerTrack.offerTrack.service.MessagesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/")
public class MessagesController {
    private MessagesService messagesService;

    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping("/api/messages")
    public List<Messages> getAllMessages(){
        return messagesService.getAllMessages();
    }
    @GetMapping("/api/messages/{id}")
    public Messages getAllMessagesById(@PathVariable("id") int id){
        return messagesService.getMessageById(id);
    }
    @PostMapping("/api/messages")
    public String createMessageById(@RequestBody Messages message){
        messagesService.createMessage(message);
        return "le message  crée avec succès";
    }
    @PutMapping("/api/messages/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public  String updateMessage(@PathVariable("id") int id,Messages message){
        messagesService.updateMessageById(id,message);
        return "Le message Modifiée avec succès";
    }
    @DeleteMapping("/api/messages/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public  String deleteMessage(@PathVariable("id") int id){
        messagesService.deleteMessageById(id);
        return "Le message supprimée avec succès";
    }
}
