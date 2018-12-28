package com.arrynchaos.alchemy.container;

import com.arrynchaos.alchemy.item.MortarPestleWood;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BrewingContainer extends Container
{															//POTENTIAL CONCERN (ATTEMPT TO BIND CONTAINER TO ITEM)
	public BrewingContainer(InventoryPlayer inventoryplayer, MortarPestleWood mortarPestleWood)
	{
		if (mortarPestleWood.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH))
		{
			IItemHandler inventory = mortarPestleWood.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
			
			
			//INGREDIENT BOTTOM LEFT
			addSlotToContainer(new SlotItemHandler(inventory, 0, 87 + x * 18, 123 + y * 18));
			//INGREDIENT BOTTOM RIGHT	
			addSlotToContainer(new SlotItemHandler(inventory, 0, 185 + x * 18, 123 + y * 18));
			//INGREDIENT TOP MIDDLE
			addSlotToContainer(new SlotItemHandler(inventory, 0, 136 + x * 18, 23 + y * 18));
			//INGREDIENT WATER
			addSlotToContainer(new SlotItemHandler(inventory, 0, 68 + x * 18, 23 + y * 18));
			//MORTAR & PESTLE OUTPUT
			addSlotToContainer(new SlotItemHandler(inventory, 0, 219 + x * 18, 71 + y * 18));		
			
			
			//PLAYER INVENTORY
			for (int y = 0; y < 3; y++)
			{
				for (int x = 0; x < 9; x++)
				{
					addSlotToContainer(new Slot(inventoryPlayer, x + (y * 9) + 9, 8 + x * 18, 156 + y * 18));
				}
			}
			
			//PLAYER HOTBAR
			for (int h = 0; h < 9; h++)
			{
				addSlotToContainer(new Slot(inventoryPlayer, h, 78 + (h * 18), 214));
			}
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(index);
		
		if (slot !=null && slot.getHasStack())
		{
			ItemStack stackInSlot = slot.getStack();
			stack = stackInSlot.copy();
			
			int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();
			
			if (index < containerSlots)
			{
				if (!this.mergeItemStack(stackInSlot,  containerSlots, inventorySlots.size(), true)) 
					{
					return ItemStack.EMPTY;
					}
			}else if
		}
		return super.transferStackInSlot(playerIn, index);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
}
