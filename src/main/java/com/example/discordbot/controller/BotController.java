package com.example.discordbot.controller;

import com.example.discordbot.MyMessage;
import com.example.discordbot.service.BotService;
import com.example.discordbot.service.BotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Leon Jongsma
 */
@RestController
public class BotController {

    @Autowired
    BotService bot;

    @RequestMapping(value="/testmsg", method = RequestMethod.POST)
    public void msgDiscord(@RequestBody MyMessage message) {
        System.out.println(message);
        //bot.sendMessage(message.getGuild(), message.getChannel(), message.getMessage());
    }
}
