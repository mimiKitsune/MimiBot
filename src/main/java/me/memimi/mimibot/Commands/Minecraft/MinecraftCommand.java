package me.memimi.mimibot.Commands.Minecraft;

import me.memimi.mimibot.Commands.Command;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 15/11/13
 * Time: 18:37
 * To change this template use File | Settings | File Templates.
 */
public abstract class MinecraftCommand extends Command {

    public MinecraftCommand(String name, String help) {
        super(name, help);
    }

    public void mcCommand(String command) throws IOException {
        String s = "sudo -u minecraft screen -X stuff '" + command + "^M'";
        Runtime.getRuntime().exec(s);
//        new ProcessBuilder(s).start();
        System.out.println(s);
    }
}
