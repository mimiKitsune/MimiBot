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
        if (event.getUser().getHostmask().endsWith("memimi.me") && event.getMessage().startsWith(".")) {
            String message = event.getMessage().substring(1);
            String[] messageArr = message.split(" ", 2);
            switch (messageArr[0]) {
                case "reg":
                    event.getBot().sendIRC().message("nickserv", "register 5c1C'7CB mimibot@memimi.me");
                    event.respond("registering with nickserv");
                    break;
                case "identify":
                    event.getBot().sendIRC().message("nickserv", "identify "+Main.config.getProperty("botNickservPassword"));
                    break;
                case "raw":
                    event.getBot().sendRaw().rawLine(messageArr[1]);
                    break;
            }
        }
    }


}
