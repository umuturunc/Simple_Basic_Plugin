package oceanmonster.simplebasicplugin;

import javafx.print.PageLayout;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleBasicPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //getServer().getPluginManager().registerEvents(new FlyWithArrowListener(),this);
        getServer().getPluginManager().registerEvents(new ScoutGrapleListener(),this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            if(command.getName().equalsIgnoreCase("enderchest"))
            {
                player.openInventory(player.getEnderChest());
            }
        }

        return super.onCommand(sender, command, label, args);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
