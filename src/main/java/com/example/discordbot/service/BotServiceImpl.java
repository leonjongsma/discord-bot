package com.example.discordbot.service;

import com.example.discordbot.Bot;
import com.example.discordbot.components.UserLogger;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.AnnotatedEventManager;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

/**
 * @author : Leon Jongsma
 */
@Service
public class BotServiceImpl implements BotService {

    @Value( "${secret.token}" )
    private String SECRET_TOKEN;
    private JDA jda;

    public void sendMessage(String guild, String channel, String message) {
        try {
            jda
                    .getGuildById(guild)
                    .getTextChannelById(channel)
                    .sendMessage(message)
                    .queue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @PostConstruct
    public void startBot() throws LoginException {
        this.jda = JDABuilder.createLight(SECRET_TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new Bot(), new UserLogger())
                .setActivity(Activity.playing("Type !ping"))
                .build();
    }

    @Override
    public void shutdownBot() {
        this.jda.shutdown();

    }

    @Override
    public JDA getJda() {
        return this.jda;
    }
}
