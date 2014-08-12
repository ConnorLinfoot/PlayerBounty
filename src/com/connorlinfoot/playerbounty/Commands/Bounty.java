package com.connorlinfoot.playerbounty.Commands;

import com.connorlinfoot.playerbounty.Main;
import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.UserDoesNotExistException;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

public class Bounty implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        String prefix = Main.prefix();
        if( Main.bountyRunning ){
            sender.sendMessage( prefix + "The current bounty is " + Main.bountyCurrent + " for a reward of $" + Main.bountyReward );
        } else {
            if( sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 3) {
                    if (args[0].equalsIgnoreCase("set")) {
                        if (Bukkit.getPlayer(args[1]) != null) {
                            BigDecimal money = BigDecimal.valueOf(0);
                            try {
                                money = Economy.getMoneyExact(player.getName());
                            } catch (UserDoesNotExistException ignored) { }

                            if( money.equals(BigDecimal.valueOf(Long.parseLong(args[2]))) ){
                                sender.sendMessage(prefix + "Bounty has been set on " + args[1]);
                                Main.bountyCurrent = args[1];
                                Main.bountyRunning = true;
                                Main.bountyReward = Integer.valueOf(args[2]);
                            } else {
                                sender.sendMessage(prefix + "You dont have that much money");
                            }
                        } else {
                            sender.sendMessage(prefix + "Player not found");
                        }
                    } else {
                        sender.sendMessage(prefix + "Usage: /bounty <set> <player> <reward>");
                    }
                } else {
                    sender.sendMessage(prefix + "Usage: /bounty <set> <player> <reward>");
                }
            }
        }
        return false;
    }
}
