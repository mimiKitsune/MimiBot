package me.memimi.mimibot;

import org.pircbotx.PircBotX;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 15/11/13
 * Time: 21:19
 * To change this template use File | Settings | File Templates.
 */
public class LogTailer implements Runnable{

    private final PircBotX bot;
    private String logFile;
    private boolean keepReading;

    public LogTailer(PircBotX bot, String logFile) {
        this.bot = bot;
        this.logFile = logFile;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.logFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String line;
        while (keepReading) {
            try {
                line = br.readLine();
                if (line == null) {
                    //wait until there is more of the file for us to read
                    Thread.sleep(1000);
                }
                else {
                    bot.sendIRC().message("#mimi", line);
                }
            } catch (IOException ex) {
                stopReading();
            } catch (InterruptedException e) {
                stopReading();
            }
        }
    }

    public void stopReading() {
        this.keepReading = false;
    }
}
