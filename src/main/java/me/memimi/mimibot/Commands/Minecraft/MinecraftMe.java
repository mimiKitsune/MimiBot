package me.memimi.mimibot.Commands.Minecraft;

import org.pircbotx.hooks.types.GenericMessageEvent;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 15/11/13
 * Time: 20:47
 * To change this template use File | Settings | File Templates.
 */
public class MinecraftMe extends MinecraftCommand {

    public MinecraftMe() {
        super("mcMe", "Sends an action as 'server' to minecraft");
    }

    @Override
    public void run(GenericMessageEvent event) {
        String[] messageArr = event.getMessage().split(" ", 2);
        try {
            mcCommand("/me "+messageArr[1]);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
