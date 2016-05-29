package com.meteor.extrabotany.common.event;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import org.lwjgl.opengl.GL11;

import vazkii.botania.api.item.IBaubleRender.RenderType;

import com.meteor.extrabotany.client.render.RenderShield;
import com.meteor.extrabotany.common.handler.ConfigHandler;
import com.meteor.extrabotany.common.handler.EntityHandler;
import com.meteor.extrabotany.common.handler.ShieldHandler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EventShield{

	@SubscribeEvent
	public void onPlayerAttacked(LivingHurtEvent event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if(ShieldHandler.getShieldAmount(player) > 0F){
				float dam = event.ammount - ShieldHandler.getShieldAmount(player);
				float cur = ShieldHandler.getShieldAmount(player) - event.ammount;
				event.ammount = Math.max(0, dam);
				ShieldHandler.setShieldAmount(Math.max(0, cur), player);
				player.hurtResistantTime = 25;
				List<IMob> mobs = player.worldObj.getEntitiesWithinAABB(IMob.class, AxisAlignedBB.getBoundingBox(player.posX - 2, player.posY - 2, player.posZ - 2, player.posX + 3, player.posY + 3, player.posZ + 3));
				List<IProjectile> pros = player.worldObj.getEntitiesWithinAABB(IProjectile.class, AxisAlignedBB.getBoundingBox(player.posX - 2, player.posY - 2, player.posZ - 2, player.posX + 3, player.posY + 3, player.posZ + 3));
				for(IProjectile pro : pros){
					if(pro instanceof Entity)
						((Entity)pro).setDead();
				}
				for(IMob mob : mobs){
					if(mob instanceof Entity)
						EntityHandler.knockBack(((EntityLiving)mob), player, 4F, 4F);
				}
			}
		}
		
	}
	
	@SubscribeEvent
	public void onPlayerRender(RenderPlayerEvent.Specials.Post event) {
		EntityPlayer player = event.entityPlayer;
		renderShield(event, RenderType.BODY);
	}
	
	@SideOnly(Side.CLIENT)
	public void renderShield(RenderPlayerEvent event, RenderType type){
		EntityPlayer player = event.entityPlayer;
		if(ShieldHandler.getShieldAmount(player) > 0F && ConfigHandler.disableShieldRender == false){	
			GL11.glPushMatrix();
			GL11.glColor4f(1F, 1F, 1F, 1F);
			RenderShield.renderShield(player, event.partialRenderTick);
			GL11.glPopMatrix();
		}
	}
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer && ShieldHandler.get((EntityPlayer) event.entity) == null)
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ShieldHandler.EXT_PROP_NAME) == null)
		event.entity.registerExtendedProperties(ShieldHandler.EXT_PROP_NAME, new ShieldHandler((EntityPlayer) event.entity));
	}
}
