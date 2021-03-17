package oceanmonster.simplebasicplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ScoutGrapleListener implements Listener {

    @EventHandler
    public void PlayerGrapleEvent(PlayerFishEvent event) {
        Player player = event.getPlayer();
        FishHook hook = event.getHook();
        World world = player.getWorld();
        PlayerFishEvent.State state = event.getState();
        if (state.equals(PlayerFishEvent.State.REEL_IN) || state.equals(PlayerFishEvent.State.IN_GROUND)) {

            if (areThereNearBlocks(hook, world)) {
                Vector tempVector = event.getHook().getLocation().subtract(player.getLocation()).toVector().divide(new Vector(1, 1.3, 1));
                player.setVelocity(tempVector.multiply(0.3));
            }
        }
    }

    private boolean areThereNearBlocks(FishHook hook, World world) {
        Location location = hook.getLocation();

        Location up = location.clone().add(0, 0, 1);
        Location down = location.clone().add(0, 0, -1);
        Location left = location.clone().add(1, 0, 0);
        Location right = location.clone().add(-1, 1, 0);
        Location forward = location.clone().add(0, 1, 0);
        Location backward = location.clone().add(0, -1, 0);

        List<Location> nearLocations = new ArrayList<Location>();
        nearLocations.add(up);
        nearLocations.add(down);
        nearLocations.add(left);
        nearLocations.add(right);
        nearLocations.add(forward);
        nearLocations.add(backward);

        return isListContainsSolidBLock(nearLocations, world);


    }

    private boolean isListContainsSolidBLock(List<Location> list, World world) {
        boolean flag = false;

        ListIterator<Location> iterator = list.listIterator();

        while (iterator.hasNext()) {
            if (isSolidBlock(world.getBlockAt(iterator.next()))) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private boolean isSolidBlock(Block block) {
        if (block.getType().isSolid()) {
            return true;
        }
        return false;
    }

}
