package com.example.discordbot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.joining;

/**
 * @author : Leon Jongsma
 */
public class Bot extends ListenerAdapter {

    final List<String> strings = Arrays.asList("Understanding the Java Class Structure", "Creating Objects", "Declaring and Initializing Variables","Understanding the Java Class Structure", "Creating Objects", "Declaring and Initializing Variables");







    final String joined = strings.stream()
            .collect(joining("\n"));


    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("!ping"))
        {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong!") /* => RestAction<Message> */
                    .queue(response /* => Message */ -> {
                        response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
                    });
        }

        if (msg.getContentRaw().equals("!test"))
        {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("test Pong!") /* => RestAction<Message> */
                    .queue(response /* => Message */ -> {
                        response.editMessageFormat("test Pong: %d ms", System.currentTimeMillis() - time).queue();
                    });
        }

        if (msg.getContentRaw().equals("!topics"))
        {

            Random rand = new Random();

            MessageChannel channel = event.getChannel();

            int numberOfElements = 50;


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numberOfElements; i++) {
                int randomIndex = rand.nextInt(strings.size());
                String randomElement = strings.get(randomIndex);

                sb.append(randomElement);
                sb.append(System.lineSeparator());

            }
            channel.sendMessage(sb.toString()).queue();


//
//            for (String string: strings) {
//                channel.sendMessage(string).queue(); /* => RestAction<Message> */
////                        .queue(response -> {
////                            //response.editMessageFormat(string).queue();
////                        });
//            }


        }


        if (msg.getContentRaw().equals("!abc"))
        {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("test Pong!") /* => RestAction<Message> */
                    .queue(response /* => Message */ -> {
                        response.editMessageFormat("def Pong: %d ms", System.currentTimeMillis() - time).queue();
                    });
        }
    }

}
