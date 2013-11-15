package me.memimi.mimibot.Commands.Minecraft;

import me.memimi.mimibot.Main;
import org.pircbotx.hooks.types.GenericMessageEvent;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 15/11/13
 * Time: 21:45
 * To change this template use File | Settings | File Templates.
 */
public class MinecraftLog extends MinecraftCommand {

    public MinecraftLog() {
        super("mclog", "Enables/Disables echoing of minecraft logs");
    }
    @Override
    public void run(GenericMessageEvent event) {
        String[] messageArr = event.getMessage().split(" , 2");
        if (messageArr[1].equalsIgnoreCase("start")) {
            new Thread(Main.minecraftLog);
        }
        else {
            Main.minecraftLog.stopReading();
        }
    }
}
