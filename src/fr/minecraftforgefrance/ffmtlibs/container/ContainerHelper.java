package fr.minecraftforgefrance.ffmtlibs.container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public class ContainerHelper
{
	/**
	 * Consume a item with medatata
	 * 
	 * @param player the player
	 * @param item the item to consume
	 * @param metadata the metadata of the item
	 * @return true if the item was consume, false if not
	 */
	public static boolean consumeItemWithMetadataInInventory(EntityPlayer player, Item item, int metadata)
	{
		for(int j = 0; j < player.inventory.mainInventory.length; ++j)
		{
			if(player.inventory.mainInventory[j] != null && player.inventory.mainInventory[j].getItem().equals(item) && player.inventory.mainInventory[j].getItemDamage() == metadata)
			{
				if(--player.inventory.mainInventory[j].stackSize <= 0)
				{
					player.inventory.mainInventory[j] = null;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Consume a block with medatata
	 * 
	 * @param player the player
	 * @param block the block to consume
	 * @param metadata the metadata of the block
	 * @return true if the item was consume, false if not
	 */
	public static boolean consumeItemWithMetadataInInventory(EntityPlayer player, Block block, int metadata)
	{
		return consumeItemWithMetadataInInventory(player, Item.getItemFromBlock(block), metadata);
	}
}