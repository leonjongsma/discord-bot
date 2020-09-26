package com.example.discordbot.components;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * @author : Leon Jongsma
 */
@Slf4j
public class UserLogger extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        Message message = event.getMessage();
        log.info (author.getName());
        log.info(message.getContentDisplay());
    }
}
