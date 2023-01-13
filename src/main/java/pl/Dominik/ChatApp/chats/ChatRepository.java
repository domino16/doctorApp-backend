package pl.Dominik.ChatApp.chats;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat,Integer> {
    Optional<Chat> findChatById(int id);

    List<Chat> findAllByFirstChatUser_Email(String id);
    List<Chat> findAllBySecondChatUser_Email(String id);



}
