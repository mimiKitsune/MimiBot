package me.memimi.mimibot;

import me.memimi.mimibot.Commands.*;
import me.memimi.mimibot.Commands.Minecraft.MinecraftLog;
import me.memimi.mimibot.Commands.Minecraft.MinecraftMe;
import me.memimi.mimibot.Commands.Minecraft.MinecraftSay;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.UtilSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.impl.SimpleLogger;
import org.slf4j.impl.SimpleLoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Config config;
    protected static final Map<String, Command> commands = new HashMap<>();
    public static LogTailer minecraftLog;

    public static void main(String[] args) throws Exception {
        config = new Config();
        config.load();

        registerCommands();

        //Setup Logger
        System.setProperty(SimpleLogger.SHOW_DATE_TIME_KEY, "true");
        System.setProperty(SimpleLogger.DATE_TIME_FORMAT_KEY, "[HH:mm:ss]");
        System.setProperty(SimpleLogger.SHOW_THREAD_NAME_KEY, "false");
        System.setProperty(SimpleLogger.LEVEL_IN_BRACKETS_KEY, "true");
        System.setProperty(SimpleLogger.SHOW_LOG_NAME_KEY, "true");
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "debug");
        Logger logger = new SimpleLoggerFactory().getLogger(Main.class.getName());
        System.out.println(logger.isDebugEnabled());

        //Setup this bot
        Configuration.Builder builder = new Configuration.Builder();
        builder.setName(config.getBotNickname());
        builder.setRealName(config.getBotRealname());
        builder.setLogin(config.getBotLogin());
        //builder.setNickservPassword(config.getBotPassword());
        builder.setAutoNickChange(true);
        builder.addListener(new BotListener());
        builder.setServer(config.getServerHostname(), config.getServerPort(), config.getServerPassword());
        builder.setSocketFactory(new UtilSSLSocketFactory().trustAllCertificates());
        for(String channel : config.getChannels()){
            builder.addAutoJoinChannel(channel);
        }
        PircBotX bot = new PircBotX(builder.buildConfiguration());

        minecraftLog = new LogTailer(bot, "/home/minecraft/1.7.2/logs/latest.log");
        //Connect to server
        try {
            logger.debug("staring bot");
            bot.startBot();
        } catch (Exception ex) {
            logger.error(null, ex);
            ex.printStackTrace();
        }
    }

    private static void registerCommands() {
        commands.put("ping", new CommandPing());
        commands.put("raw", new CommandRaw());
        commands.put("identify", new CommandIdentify());
        commands.put("bash", new CommandBash());
        commands.put("mcsay", new MinecraftSay());
        commands.put("mcme", new MinecraftMe());
        commands.put("mclog", new MinecraftLog());
    }

    public static Config getConfig() {
        return config;
    }
}