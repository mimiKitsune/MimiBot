package me.memimi.mimibot;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.impl.SimpleLoggerFactory;


/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 12/11/13
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class BotListener extends ListenerAdapter {

    private Logger logger = new SimpleLoggerFactory().getLogger(this.getClass().getName());

    @Override
    public void onMessage(MessageEvent event) {
        if (event.getUser().getHostmask().endsWith("memimi.me") && event.getMessage().startsWith(Main.config.getTrigger())) {
            String message = event.getMessage().substring(1);
            String[] messageArr = message.split(" ", 2);
            String command = messageArr[0];
            if(command.equalsIgnoreCase("reg")){
                event.getBot().sendIRC().message("nickserv", "register 5c1C'7CB mimibot@memimi.me");
                event.respond("registering with nickserv");
            }
            if(command.equalsIgnoreCase("identify")){
                event.getBot().sendIRC().message("nickserv", "identify " + Main.config.getBotPassword());
            }
            if(command.equalsIgnoreCase("raw")){
                StringBuilder sb = new StringBuilder();
                //loop through all the arguments
                for(int i = 1; i < messageArr.length; i++){
                     //append each element of messageArr from index 1 until the end to the stringbuilder, followed by a space
                     sb.append(messageArr[i]).append(" ");
                }
                //send the stringbuilder.tostring, but remove any trailing spaces.
                event.getBot().sendRaw().rawLineNow(sb.toString().trim());
            }
        }
    }


}
