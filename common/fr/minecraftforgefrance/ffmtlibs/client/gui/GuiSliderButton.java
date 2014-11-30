package fr.minecraftforgefrance.ffmtlibs.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSliderButton extends GuiButton
{
	public float sliderValue;
	public boolean dragging;
	private int sliderId;
	private ISliderButton iSliderButton;

	public GuiSliderButton(ISliderButton containerSliderBase, int id, int x, int y, String name, float value)
	{
		this(containerSliderBase, id, x, y, 150, 20, name, value);
	}

	public GuiSliderButton(ISliderButton containerSliderBase, int id, int x, int y, int xSize, int ySize, String name, float value)
	{
		super(id, x, y, xSize, ySize, name);
		this.sliderValue = value;
		this.sliderId = id;
		this.iSliderButton = containerSliderBase;
	}

	public void disable()
	{
		this.enabled = false;
	}

	public void enable()
	{
		this.enabled = true;
	}

	@Override
	public int getHoverState(boolean mouseOver)
	{
		return 0;
	}

	@Override
	protected void mouseDragged(Minecraft mc, int mouseX, int mouseY)
	{
		if(this.visible)
		{
			if(this.dragging)
			{
				this.sliderValue = (float)(mouseX - (this.xPosition + 4)) / (float)(this.width - 8);
				this.sliderValue = MathHelper.clamp_float(this.sliderValue, 0.0F, 1.0F);

				iSliderButton.handlerSliderAction(this.sliderId, this.sliderValue);
				this.displayString = iSliderButton.getSliderName(this.sliderId, this.sliderValue);
			}

			mc.getTextureManager().bindTexture(buttonTextures);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (this.width - 8)), this.yPosition, 0, 66, 4, 20);
			this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
		}
	}

	@Override
	public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
	{
		if(super.mousePressed(mc, mouseX, mouseY))
		{
			this.sliderValue = (float)(mouseX - (this.xPosition + 4)) / (float)(this.width - 8);
			this.sliderValue = MathHelper.clamp_float(this.sliderValue, 0.0F, 1.0F);

			iSliderButton.handlerSliderAction(this.sliderId, this.sliderValue);
			this.displayString = iSliderButton.getSliderName(this.sliderId, this.sliderValue);
			this.dragging = true;
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY)
	{
		this.dragging = false;
	}
}