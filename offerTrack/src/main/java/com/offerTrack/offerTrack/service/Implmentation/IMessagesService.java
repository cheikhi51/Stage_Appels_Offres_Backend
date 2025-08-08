package com.offerTrack.offerTrack.service.Implmentation;

import com.offerTrack.offerTrack.model.Messages;
import com.offerTrack.offerTrack.repository.MessageRepository;
import com.offerTrack.offerTrack.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMessagesService implements MessagesService {
    @Autowired
    private final MessageRepository messageRepository;

    public IMessagesService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    @Override
    public List<Messages> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Messages getMessageById(int id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public String createMessage(Messages message) {
        messageRepository.save(message);
        return "Message créé";
    }

    @Override
    public String updateMessageById(int id, Messages message) {
        Messages existingMessage = messageRepository.findById(id).orElse(null);
        if(existingMessage != null && existingMessage.getId() == id) {
            existingMessage.setNom(message.getNom());
            existingMessage.setEmail(message.getEmail());
            existingMessage.setSujet(message.getSujet());
            existingMessage.setMessage(message.getMessage());
            messageRepository.save(message);
            return "Message modifié";
        }
        return "Message non trouvé";
    }

    @Override
    public String deleteMessageById(int id) {
        messageRepository.deleteById(id);
        return "Message supprimé";
    }
}
