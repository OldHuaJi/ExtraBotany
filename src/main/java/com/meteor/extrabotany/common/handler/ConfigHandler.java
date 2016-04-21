package com.meteor.extrabotany.common.handler;

import com.meteor.extrabotany.common.lib.LibReference;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	private static Configuration config;

	public static int shieldBarHeight;
	public static int efficiencySunshinelily;
	public static int efficiencyMoonlightlily;
	public static int efficiencyBlueenchantress;
	public static int efficiencyCandyflower;

	public ConfigHandler(FMLPreInitializationEvent event)
	{
	        config = new Configuration(event.getSuggestedConfigurationFile());
	        config.load();
	        registerConfig();
	        config.save();
	}

	private static void registerConfig()
	{	
		efficiencySunshinelily = config.get(LibReference.CATEGORY_COMMON, "efficiencySunshinelily", 3, StatCollector.translateToLocal(LibReference.PREFIX_CONFIG + "efficiencySunshinelily.desc")).getInt();
		efficiencyMoonlightlily = config.get(LibReference.CATEGORY_COMMON, "efficiencyMoonlightlily", 3, StatCollector.translateToLocal(LibReference.PREFIX_CONFIG + "efficiencyMoonlightlily.desc")).getInt();
		efficiencyBlueenchantress = config.get(LibReference.CATEGORY_COMMON, "efficiencyBlueenchantress", 100, StatCollector.translateToLocal(LibReference.PREFIX_CONFIG + "efficiencyBlueenchantress.desc")).getInt();
		efficiencyCandyflower = config.get(LibReference.CATEGORY_COMMON, "efficiencyCandyflower", 5, StatCollector.translateToLocal(LibReference.PREFIX_CONFIG + "efficiencyCandyflower.desc")).getInt();
		shieldBarHeight = config.get(LibReference.CATEGORY_CLIENT, "shieldBarHeight", 29, StatCollector.translateToLocal(LibReference.PREFIX_CONFIG + "shieldBarHeight.desc")).getInt();
	}
}
