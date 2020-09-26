package com.example.discordbot.service;

import net.dv8tion.jda.api.JDA;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

/**
 * @author : Leon Jongsma
 */
public interface BotService {

    void startBot() throws LoginException;

    void shutdownBot();

    JDA getJda();
}
