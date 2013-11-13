package me.memimi.mimibot;

import org.slf4j.Logger;
import org.slf4j.impl.SimpleLoggerFactory;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 13/11/13
 * Time: 00:34
 * To change this template use File | Settings | File Templates.
 */

public class Config {
    private String botNickname;
    private String botRealname;
    private String botLogin;
    private String botPassword;
    private String serverHostname;
    private int serverPort;
    private boolean debug;
    private String trigger;
    private List<String> channels;
    private Logger logger = new SimpleLoggerFactory().getLogger(this.getClass().getName());
    public void load() throws IOException {
        Properties properties = new Properties();
        File config = new File("bot.conf");
        if(!config.exists()){
            logger.warn("Config not found, creating example config");
            //get bot.conf from the jar, and make a reader to read from it
            BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/bot.conf")));
            //make an empty config file
            config.createNewFile();
            //make a writer to write lines to the config
            PrintWriter writer = new PrintWriter(new FileWriter(config));
            String line = "";
            //while we can read lines without them being null (end of file)
            while((line = reader.readLine()) != null){
                //write the line to the empty config
                writer.println(line);
            }
            //flush any remaining output from the writer and close it
            writer.flush();
            writer.close();
        }
        properties.load(new FileInputStream("bot.conf"));
        this.setBotNickname(properties.getProperty("botNick"));
        this.setBotLogin(properties.getProperty("botLogin"));
        this.setBotRealname(properties.getProperty("botRealname"));
        this.setBotPassword(properties.getProperty("botPassword"));
        this.setDebug(Boolean.parseBoolean(properties.getProperty("debug")));
        this.setTrigger(properties.getProperty("botTrigger"));
        this.setChannels(Arrays.asList(properties.getProperty("channels").split(" ")));
        this.setServerHostname(properties.getProperty("serverHostname"));
        this.setServerPort(Integer.parseInt(properties.getProperty("serverPort")));
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    public String getBotNickname() {
        return botNickname;
    }

    public void setBotNickname(String botNickname) {
        this.botNickname = botNickname;
    }

    public String getBotRealname() {
        return botRealname;
    }

    public void setBotRealname(String botRealname) {
        this.botRealname = botRealname;
    }

    public String getBotLogin() {
        return botLogin;
    }

    public void setBotLogin(String botLogin) {
        this.botLogin = botLogin;
    }

    public String getBotPassword() {
        return botPassword;
    }

    public void setBotPassword(String botPassword) {
        this.botPassword = botPassword;
    }

    public String getServerHostname() {
        return serverHostname;
    }

    public void setServerHostname(String serverHostname) {
        this.serverHostname = serverHostname;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
}
