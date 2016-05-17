package com.meteor.extrabotany.common.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.meteor.extrabotany.common.potion.PotionEffectMods;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;


public class EventHighDamageResistance {
	@SubscribeEvent
	 public void HurtEvent(LivingHurtEvent event) { 
	        if(!(event.entity instanceof EntityPlayerMP)) {
	            return;
	        }
	        EntityPlayer player = (EntityPlayer) event.entity;
	        if(player.isPotionActive(PotionEffectMods.slowparticlesorting)){
	        	if(event.ammount >= (float) (player.getMaxHealth()*0.2) && event.ammount <= (float)(player.getMaxHealth()*3)){
	        		event.ammount = (float) (player.getMaxHealth()*0.2);
	        	}
	        }              
	}
}


