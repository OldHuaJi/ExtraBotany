package com.meteor.extrabotany.client.render.tile;

import org.lwjgl.opengl.GL11;

import com.meteor.extrabotany.common.blocks.BlockRelicPlate;
import com.meteor.extrabotany.common.blocks.tile.TileRelicPlate;

import vazkii.botania.client.core.handler.ClientTickHandler;
import vazkii.botania.client.core.helper.ShaderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

public class RenderTileRelicPlate extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
		TileRelicPlate plate = (TileRelicPlate) tileentity;

		float max = TileRelicPlate.MAX_MANA / 10F;
		float alphaMod = Math.min(max, plate.getCurrentMana()) / max;
		GL11.glPushMatrix();
		GL11.glTranslated(d0, d1, d2);

		GL11.glRotated(90F, 1F, 0F, 0F);
		GL11.glTranslatef(0F, 0F, -3F / 16F - 0.001F);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(2F, 2F, 0.2F, 1F);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		float alpha = (float) ((Math.sin((ClientTickHandler.ticksInGame + f) / 8D) + 1D) / 5D + 0.6D) * alphaMod;
		if(ShaderHelper.useShaders())
			GL11.glColor4f(2F, 2F, 0.2F, alpha);
		else {
			int light = 15728880;
			int lightmapX = light % 65536;
			int lightmapY = light / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lightmapX, lightmapY);
			GL11.glColor4f(1.6F + (float) ((Math.cos((ClientTickHandler.ticksInGame + f) / 6D) + 1D) / 5D), 2.0F, 0.1F, alpha);
		}

		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);

		ShaderHelper.useShader(ShaderHelper.terraPlateRune);
		renderIcon(0, 0, BlockRelicPlate.overlay, 1, 1, 240);
		ShaderHelper.releaseShader();

		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor4f(2F, 2F, 0.2F, 1F);
		GL11.glPopMatrix();
	}

	public void renderIcon(int par1, int par2, IIcon par3Icon, int par4, int par5, int brightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setBrightness(brightness);
		tessellator.addVertexWithUV(par1 + 0, par2 + par5, 0, par3Icon.getMinU(), par3Icon.getMaxV());
		tessellator.addVertexWithUV(par1 + par4, par2 + par5, 0, par3Icon.getMaxU(), par3Icon.getMaxV());
		tessellator.addVertexWithUV(par1 + par4, par2 + 0, 0, par3Icon.getMaxU(), par3Icon.getMinV());
		tessellator.addVertexWithUV(par1 + 0, par2 + 0, 0, par3Icon.getMinU(), par3Icon.getMinV());
		tessellator.draw();
	}
}