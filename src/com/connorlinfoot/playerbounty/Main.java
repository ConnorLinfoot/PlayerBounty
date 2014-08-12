package com.connorlinfoot.playerbounty;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    private static Plugin instance;
    public static boolean bountyRunning = false;
    public static String bountyCurrent = null;
    public static Integer bountyReward = null;

    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        Server server = getServer();
        ConsoleCommandSender console = server.getConsoleSender();

        /*if(getConfig().getString( "Send Stats" ).equals("enabled" ) ) {
            try {
                Metrics metrics = new Metrics(this);
                metrics.start();
                console.sendMessage("MC Stats (Metrics) is enabled!");
            } catch (IOException e) {
                // Failed to submit the stats :-( <-- Dat face doe
            }
        }*/

        console.sendMessage(ChatColor.GREEN + "=========== PlayerBounty ===========");
        console.sendMessage(ChatColor.GREEN + "=========== VERSION: 1.0 ===========");
        console.sendMessage(ChatColor.GREEN + "======== BY CONNOR LINFOOT! ========");
    }

    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled!");
    }

    public static Plugin getInstance() {
        return instance;
    }

    public static String prefix() {
        return "[Bounty] ";
    }
}
