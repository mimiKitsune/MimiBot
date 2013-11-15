package me.memimi.mimibot;

import org.pircbotx.User;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;
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
        String message = event.getMessage();
        if (message.startsWith(Main.getConfig().getTrigger()) && hasPermissions(event.getUser())) {
            String[] messageArr = event.getMessage().substring(1).split(" ");
            String command = messageArr[0].toLowerCase();
            executeCommand(event, command);
        }
    }

    private void executeCommand(GenericMessageEvent event, String command) {
        if (Main.commands.containsKey(command)) {
            Main.commands.get(command).run(event);
        }
    }

    private boolean hasPermissions(User user) {
        return user.getHostmask().endsWith("memimi.me") || user.getHostmask().endsWith("zack6849.com");
    }


    @Override
    public void onPrivateMessage(PrivateMessageEvent event) {
        if (hasPermissions(event.getUser())) {
            String command = event.getMessage().split(" ")[0];
            executeCommand(event, command);
        }
    }


}
