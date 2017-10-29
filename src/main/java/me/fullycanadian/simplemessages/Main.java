package me.fullycanadian.simplemessages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

        private FileConfiguration config = getConfig();

        @Override
        public void onEnable() {
            Bukkit.getLogger().info("---------------------------------------------------------------");
            Bukkit.getLogger().info("");
            Bukkit.getLogger().info("Simple Messages V " + getDescription().getVersion() + " has been enabled");
            Bukkit.getLogger().info("If you notice any errors contact FullyCanadian#8749 on Discord");
            Bukkit.getLogger().info("");
            Bukkit.getLogger().info("---------------------------------------------------------------");

            handleConfig();

        }


        private void handleConfig() {

            String path = "messages.";
            config.addDefault(path + "website", "&aYou can find our website at example.com");
            config.addDefault(path + "facebook", "&dfacebook.com/facebooklink");
            config.addDefault(path + "twitter", "&5Twitter.com/ourtwitter");
            config.addDefault(path + "apply", "&1You can apply for staff at example.com/apply");
            config.addDefault(path + "store", "&bYou can visit our store at store.example.com");

            config.options().copyDefaults(true);

            saveConfig();

        }



        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (config.getConfigurationSection("messages").getKeys(true).contains(label.toLowerCase())) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages." + label.toLowerCase())));

                return true;
            }

            return false;
        }


}
