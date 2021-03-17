package oceanmonster.simplebasicplugin;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class FlyWithArrowListener implements Listener {

//    private static HashMap<Player, Long> remainingTimes = new HashMap<Player, Long>();
//    private static long cooldownTimeMs = 5000;
//
    @EventHandler
    public void onPlayerShootArrow(EntityShootBowEvent event) {
//        Long currentTime = System.currentTimeMillis();
        if (event.getEntity().getType().equals(EntityType.PLAYER)) {
            Player player = (Player) event.getEntity();

//            if (remainingTimes.containsKey(player)) {
//                if (currentTime - remainingTimes.get(player) > cooldownTimeMs) {
//                    remainingTimes.put(player, currentTime);
                    event.getProjectile().setCustomNameVisible(true);
                    event.getProjectile().setPassenger(event.getEntity());
                    event.getProjectile().setGlowing(true);
//                }
//
//            } else {
//                remainingTimes.put(player, currentTime);

//            }
        }
    }



//    @EventHandler
//    public void whenBowOnHand(PlayerItemHeldEvent event) {
//        Player player = event.getPlayer();
//        if (player.getInventory().getItem(event.getNewSlot()).getType().equals(Material.BOW)) {
//            Long currentTime = System.currentTimeMillis();
//            Long kalanSure = cooldownTimeMs -  (currentTime - remainingTimes.get(player));
//            kalanSure/=1000;
//            if(kalanSure<0)     kalanSure = 0l;
//            player.sendActionBar("§6§ Kalan Süre §9§5" + kalanSure);
//            Bukkit.getServer().
//        }
//    }


//    @EventHandler
//    public void onPlayerJoin(PlayerJoinEvent event)
//    {
//        remainingTimes.put(event.getPlayer(),System.currentTimeMillis());
//    }

    @EventHandler
    public void projectileSetterEvent(ProjectileLaunchEvent event) {
        event.getEntity().setBounce(true);
    }


}









