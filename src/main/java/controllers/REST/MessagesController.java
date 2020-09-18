package controllers.REST;

import model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.MessageService;
import java.util.List;

@RestController
@RequestMapping(path = "/api/messages")
public class MessagesController {
    private final MessageService messageService;

    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable long id) {
        Message message = messageService.getMessage(id);
        if (message == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> allMessages = messageService.getAllMessages();
        if (allMessages == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allMessages, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<HttpStatus> addNewMessage(@RequestBody Message message) {
        messageService.addMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/delete/{id}")
    public ResponseEntity<HttpStatus> deleteMessage(@PathVariable long id) {
        messageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/delete/all")
    public ResponseEntity<HttpStatus> deleteAllMessages() {
        messageService.deleteAllMessages();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/setViewed/{id}/{isViewed}")
    public ResponseEntity<HttpStatus> setMessageViewed(
            @PathVariable long id,
            @PathVariable boolean isViewed) {
        messageService.setViewed(id, isViewed);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
