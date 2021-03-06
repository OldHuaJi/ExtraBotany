package com.meteor.extrabotany.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.block.decor.slabs.BlockModSlab;

import com.meteor.extrabotany.common.block.decor.BlockElvenQuartzSlab;
import com.meteor.extrabotany.common.block.decor.BlockElvenQuartzStairs;
import com.meteor.extrabotany.common.block.decor.BlockGaiaQuartzSlab;
import com.meteor.extrabotany.common.block.decor.BlockGaiaQuartzStairs;
import com.meteor.extrabotany.common.block.subtile.SubTileInfernoidisy;
import com.meteor.extrabotany.common.block.subtile.SubTileJudasvow;
import com.meteor.extrabotany.common.block.subtile.SubTileManalinkuim;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileAnnoyobloom;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileArtifaconia;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileDiplopbamboo;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileIcebirdium;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileLaunchish;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileNecrofluer;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileNumeronbalsam;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileNumeronDandelife;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileVoiduim;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileVolatilily;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileWoodienia;
import com.meteor.extrabotany.common.block.subtile.generating.SubTileBellflower;
import com.meteor.extrabotany.common.block.subtile.generating.SubTileBlueenchantress;
import com.meteor.extrabotany.common.block.subtile.generating.SubTileCandyflower;
import com.meteor.extrabotany.common.block.subtile.generating.SubTileGeminiorchid;
import com.meteor.extrabotany.common.block.subtile.generating.SubTileMoonlightlily;
import com.meteor.extrabotany.common.block.subtile.generating.SubTileOmniviolet;
import com.meteor.extrabotany.common.block.subtile.generating.SubTilePyschobloom;
import com.meteor.extrabotany.common.block.subtile.generating.SubTileStonesia;
import com.meteor.extrabotany.common.block.subtile.generating.SubTileSunshinelily;
import com.meteor.extrabotany.common.block.tile.TileAncientPylon;
import com.meteor.extrabotany.common.block.tile.TileGaiaChest;
import com.meteor.extrabotany.common.block.tile.TileRelicPlate;
import com.meteor.extrabotany.common.lib.LibBlockName;
import com.meteor.extrabotany.common.lib.LibReference;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block specialFlower;
	//Gaia Quartz
	public static Block gaiaquartz;
	public static Block gaiaquartzslabfull;
	public static Block gaiaquartzslab;
	public static Block gaiaquartzstairs;
	//Elven Quartz
	public static Block elvenquartz;
	public static Block elvenquartzslabfull;
	public static Block elvenquartzslab;
	public static Block elvenquartzstairs;
	
	public static Block relicplate;
	public static Block resonancehouse;
	public static Block pylon;
	
	public static Block gaiachest;
	
	public static void init() {
		pylon = new BlockAncientPylon(Material.iron);
		relicplate = new BlockRelicPlate();
		specialFlower = new BlockSpecial();
		//Gaia Quartz
		gaiaquartz = new BlockMods(Material.iron, LibBlockName.GAIAQUARTZ);
		((BlockMods)gaiaquartz).setBeaconBase(true);
		gaiaquartzslab = new BlockGaiaQuartzSlab(false);
		gaiaquartzslabfull = new BlockGaiaQuartzSlab(true);
		gaiaquartzstairs = new BlockGaiaQuartzStairs();
		//Elven Quartz
		elvenquartz = new BlockMods(Material.iron, LibBlockName.ELVENQUARTZ);
		((BlockMods)elvenquartz).setBeaconBase(true);
		elvenquartzslab = new BlockElvenQuartzSlab(false);
		elvenquartzslabfull = new BlockElvenQuartzSlab(true);
		elvenquartzstairs = new BlockElvenQuartzStairs();
		
		gaiachest = new BlockGaiaChest(-1);
		
		((BlockModSlab) gaiaquartzslab).register();
		((BlockModSlab) gaiaquartzslabfull).register();
		((BlockModSlab) elvenquartzslab).register();
		((BlockModSlab) elvenquartzslabfull).register();
		
		registerTile(TileGaiaChest.class, "gaiachest");
		registerTile(TileAncientPylon.class, LibBlockName.ANCIENTPYLON);
		registerTile(TileRelicPlate.class, LibBlockName.RELICPLATE);
		
		initTileEntities();
	}
	
	private static void initTileEntities() {
		registerSubTile(LibBlockName.BELLFLOWER, SubTileBellflower.class);
		registerSubTile(LibBlockName.MANALINKUIM, SubTileManalinkuim.class);
		registerSubTile(LibBlockName.ANNOYOBLOOM, SubTileAnnoyobloom.class);
		registerSubTile(LibBlockName.LAUNCHISH, SubTileLaunchish.class);
		registerSubTile(LibBlockName.INFERNOIDISY, SubTileInfernoidisy.class);
		registerSubTile(LibBlockName.PYSCHOBLOOM, SubTilePyschobloom.class);
		registerSubTile(LibBlockName.STONESIA, SubTileStonesia.class);
		registerSubTile(LibBlockName.DIPLOPBAMBOO, SubTileDiplopbamboo.class);
		registerSubTile(LibBlockName.VOIDUIM, SubTileVoiduim.class);
		registerSubTile(LibBlockName.ARTIFACONIA, SubTileArtifaconia.class);
		registerSubTile(LibBlockName.JUDASVOW, SubTileJudasvow.class);
		registerSubTile(LibBlockName.ICEBIRDIUM, SubTileIcebirdium.class);
		registerSubTile(LibBlockName.NUMERON_BALSAM, SubTileNumeronbalsam.class);
		registerSubTile(LibBlockName.VOLATILILY, SubTileVolatilily.class);
		registerSubTile(LibBlockName.OMNIVIOLET, SubTileOmniviolet.class);
		registerSubTile(LibBlockName.WOODIENIA, SubTileWoodienia.class);
		registerSubTile(LibBlockName.NECRO_FLUER, SubTileNecrofluer.class);
		registerSubTile(LibBlockName.NUMERON_DANDELIFE, SubTileNumeronDandelife.class);
		registerSubTile(LibBlockName.GEMINIORCHID, SubTileGeminiorchid.class);
		registerSubTile(LibBlockName.CANDY_FLOWER, SubTileCandyflower.class);
		registerSubTile(LibBlockName.SUNSHINE_LILY, SubTileSunshinelily.class);
		registerSubTile(LibBlockName.MOONLIGHT_LILY, SubTileMoonlightlily.class);
		registerSubTile(LibBlockName.BLUE_ENCHANTRESS, SubTileBlueenchantress.class);	
	}
	
	private static void registerTile(Class<? extends TileEntity> clazz, String key) {
		GameRegistry.registerTileEntity(clazz, LibReference.PREFIX_MOD + key);
	}
	
	private static void registerSubTile(String key, Class<? extends SubTileEntity> clazz) {
		BotaniaAPI.registerSubTile(key, clazz);
	}
}
