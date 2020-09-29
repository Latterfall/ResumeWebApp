package services;

import model.Message;
import org.springframework.stereotype.Service;
import repository.impl.MessageRepository;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addMessage(Message message) {
        messageRepository.add(message);
    }

    public Message getMessage(long id) {
        return messageRepository.get(id);
    }

    public List<Message> getAllMessages() {
        return messageRepository.getAll();
    }

    public void deleteMessage(long id) {
        messageRepository.delete(id);
    }

    public void deleteAllMessages() {
        messageRepository.deleteAll();
    }

    public void setViewed(long id, boolean isViewed) {
        Message message = messageRepository.get(id);
        message.setViewed(isViewed);
        messageRepository.update(message);
    }
}
