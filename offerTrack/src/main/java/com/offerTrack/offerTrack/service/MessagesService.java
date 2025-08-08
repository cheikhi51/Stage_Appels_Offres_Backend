package com.offerTrack.offerTrack.service;

import com.offerTrack.offerTrack.model.Messages;

import java.util.List;

public interface MessagesService {

    List<Messages> getAllMessages();

    Messages getMessageById(int id);

    String createMessage(Messages message);

    String updateMessageById(int id, Messages message);

    String deleteMessageById(int id);
}
