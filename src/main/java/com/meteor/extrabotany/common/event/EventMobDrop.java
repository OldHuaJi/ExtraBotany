package com.meteor.extrabotany.common.event;

import java.util.Random;

import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.meteor.extrabotany.common.item.ModItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventMobDrop {
	@SubscribeEvent
	public void onMobDeath(LivingDeathEvent event) {
		if(event.entity instanceof IMob){
			if(!event.entity.worldObj.isRemote){
				Random r = event.entity.worldObj.rand;
				if(Math.random() > 0.95F)
					event.entity.entityDropItem(new ItemStack(ModItems.material, 1 + r.nextInt(3), 12), 1F);
				if(Math.random() > 0.97F)
					event.entity.entityDropItem(new ItemStack(ModItems.material, 1 + r.nextInt(3), 13), 1F);
				if(Math.random() < 0.04F)
					event.entity.entityDropItem(new ItemStack(ModItems.material, 1 + r.nextInt(3), 14), 1F);
				if(Math.random() < 0.03F)
					if(event.entity.worldObj.rand.nextInt(10) == 2)
						event.entity.entityDropItem(new ItemStack(ModItems.key), 1F);
				if(Math.random() > 0.97F)
					if(event.entity.worldObj.rand.nextInt(10) == 6)
						event.entity.entityDropItem(new ItemStack(ModItems.boxs), 1F);
				if(!event.entity.worldObj.isDaytime())
					if(Math.random() < 0.015F)
						event.entity.entityDropItem(new ItemStack(ModItems.nightmarefuel, 1), 1F);
			}
		}
    }
}
