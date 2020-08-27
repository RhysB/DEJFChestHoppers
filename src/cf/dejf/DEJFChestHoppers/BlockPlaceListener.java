package cf.dejf.DEJFChestHoppers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener extends BlockListener {

    /*
    public static List<Block> getNearbyBlocks(Location location, int radius) {
        List<Block> blocks = new ArrayList<Block>();
        for(int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
            for(int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
                for(int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
                    blocks.add(location.getWorld().getBlockAt(x, y, z));
                }
            }
        }
        return blocks;
    }
     */



    @Override
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Block blockBelow = block.getLocation().subtract(0, 1, 0).getBlock();
        Block blockAbove = block.getLocation().add(0, 1, 0).getBlock();

        if(block.getType() == Material.CHEST && blockBelow.getType() == Material.IRON_BLOCK){
            player.sendMessage(ChatColor.YELLOW + "Hopper created!");
            DEJFChestHoppers.hopperList.add(block);
            SaveList.save("hoppers");

        } else if(block.getType() == Material.IRON_BLOCK && blockAbove.getType() == Material.CHEST) {
            player.sendMessage(ChatColor.YELLOW + "Hopper created!");
            DEJFChestHoppers.hopperList.add(blockAbove);
            SaveList.save("hoppers");
        }
    }


}