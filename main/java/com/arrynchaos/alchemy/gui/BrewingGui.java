package com.arrynchaos.alchemy.gui;

import com.arrynchaos.alchemy.AlchemyMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class BrewingGui extends GuiScreen 
{
	
	final ResourceLocation texture = new ResourceLocation(AlchemyMod.MODID, "textures/gui/brewing_gui.png");
	int guiWidth = 256;
	int guiHeight = 256;
	
	GuiButton grindbutton;
	final int GRINDBUTTON = 0;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		drawDefaultBackground();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		int centerX = (width/2) - guiWidth/2;
		int centerY = (height/2) - guiHeight/2;
		drawTexturedModalRect(centerX, centerY+3, 0, 0, guiWidth, guiHeight);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui()
	{
		buttonList.clear();
		buttonList.add(grindbutton = new GuiButton(GRINDBUTTON, 0, 0, 100, 20,"Grind"));
		super.initGui();
	}
	
	@Override
	public boolean doesGuiPauseGame() 
	{
		return false;
	}
}
