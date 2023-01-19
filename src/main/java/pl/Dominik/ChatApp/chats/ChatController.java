package pl.Dominik.ChatApp.chats;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//@RequestMapping("/chats")
@RestController
@RequestMapping("/chats")
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {

    private final ChatRepository repository;
    private final SimpMessagingTemplate template;
    @Autowired
    public ChatController(ChatRepository repository, SimpMessagingTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    @PostMapping("/addchat")
    public ResponseEntity<?> addChat(@RequestBody Chat chat){
        repository.save(chat);
        return ResponseEntity.ok(chat.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getChats(@PathVariable String id){
    List<Chat> chats = repository.findAllByFirstChatUser_Email(id);
    List<Chat> chatsWithIndex2 = repository.findAllBySecondChatUser_Email(id);
    chatsWithIndex2.forEach(chat -> chats.add(chat) );
    ArrayList<ChatResponse> chatResponses = new ArrayList<ChatResponse>();
    ArrayList<String> a = new ArrayList<String>();
        chats.forEach(chat ->   chatResponses.add
                (new ChatResponse(chat.getId(), new ArrayList<>(Arrays.asList(chat.getFirstChatUser().getEmail(),chat.getSecondChatUser().getEmail())),new ArrayList<>(Arrays.asList(chat.getFirstChatUser(),chat.getSecondChatUser())),chat.isLastMessageUnread(), chat.getLastMessage() )));
        return ResponseEntity.ok(chatResponses);
    }

    @PostMapping("/addmessage/{chatid}")
    public ResponseEntity<?> addMessage(@PathVariable int chatid, @RequestBody Message message){
       Chat chat = repository.findChatById(chatid).orElseThrow();
        chat.getMessages().add(message);
        repository.save(chat);
        return ResponseEntity.ok(chat.getMessages());
    }

    //    @SendTo("/message/greetings")
    @MessageMapping("/chat/{chatId}")
    public void sendMessage(Message message, @DestinationVariable int chatId){
        System.out.println(message);
        Chat chat = this.repository.findChatById(chatId).orElseThrow();
        chat.getMessages().add(message);
        repository.save(chat);
        this.template.convertAndSend("/topic/messages/" + chatId,  message);
    }


    @PatchMapping("/lastmessage/{chatid}")
    public ResponseEntity<?> lastMessageUpdate(@PathVariable int chatid, @RequestBody Chat requestChat){
        Chat chat = repository.findChatById(chatid).orElseThrow();
        chat.setLastMessageUnread(requestChat.isLastMessageUnread());
        LastMessage lastMessage = requestChat.getLastMessage();
        chat.setLastMessage(new LastMessage(lastMessage.getLastMessage(), lastMessage.getLastMessageAuthor(), lastMessage.getLastMessageDate()));
        repository.save(chat);
        return ResponseEntity.ok(chat);
    }

    @GetMapping("/messages/{chatId}")
    public ResponseEntity<?> getMessages(@PathVariable int chatId){
        Chat chat = repository.findChatById(chatId).orElseThrow();
        return ResponseEntity.ok(chat.getMessages());
    }

    @PatchMapping("/setlastmessageunreadtofalse/{chatId}")
    public ResponseEntity<Chat> setLastMessageUnreadToFalse(@PathVariable int chatId){
        Chat chat = repository.findChatById(chatId).orElseThrow();
        chat.setLastMessageUnread(false);
        repository.save(chat);
        return ResponseEntity.ok(chat);
    }
}
