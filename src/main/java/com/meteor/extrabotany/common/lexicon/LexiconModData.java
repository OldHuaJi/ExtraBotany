package com.meteor.extrabotany.common.lexicon;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.LexiconCategory;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;
import vazkii.botania.common.lexicon.BLexiconEntry;
import vazkii.botania.common.lexicon.DLexiconEntry;
import vazkii.botania.common.lexicon.page.PageCraftingRecipe;
import vazkii.botania.common.lexicon.page.PageManaInfusionRecipe;
import vazkii.botania.common.lexicon.page.PageMultiblock;
import vazkii.botania.common.lexicon.page.PagePetalRecipe;
import vazkii.botania.common.lexicon.page.PageText;

import com.meteor.extrabotany.common.block.ModBlocks;
import com.meteor.extrabotany.common.block.ModMultiBlocks;
import com.meteor.extrabotany.common.item.ModItems;
import com.meteor.extrabotany.common.lib.LibBlockName;
import com.meteor.extrabotany.common.lib.LibLexiconName;
import com.meteor.extrabotany.common.lib.LibReference;
import com.meteor.extrabotany.common.recipe.ModManaInfusionRecipe;
import com.meteor.extrabotany.common.recipe.ModPetalRecipe;
import com.meteor.extrabotany.common.recipe.ModRecipe;

public class LexiconModData {
	//Generating 
	public static LexiconEntry candyflower;
	public static LexiconEntry blueenchantress;
	public static LexiconEntry sunshinelily;
	public static LexiconEntry moonlightlily;
	public static LexiconEntry geminiorchid;
	public static LexiconEntry ominiviolet;
	//Functional
	public static LexiconEntry necrofleur;
	public static LexiconEntry numerondandelife;
	public static LexiconEntry woodienia;
	public static LexiconEntry icebirdium;
	public static LexiconEntry numeronbalsam;
	public static LexiconEntry volatilily;
	public static LexiconEntry judasvow;
	//Fun
	public static LexiconEntry infinitymana;
	//Relics
	public static LexiconEntry hestiachastity;
	public static LexiconEntry maxwelldemon;
	public static LexiconEntry athenabless;
	public static LexiconEntry aphroditegrace;
	public static LexiconEntry dice20;
	public static LexiconEntry excaliber;
	public static LexiconEntry excaliberfake;
	public static LexiconEntry vpowerbattleaxe;
	public static LexiconEntry vhandgun;
	public static LexiconEntry vrangerboots;
	public static LexiconEntry cronusphantom;
	public static LexiconEntry hermestravelclothing;
	public static LexiconEntry phoenixblaster;
	public static LexiconEntry snowballcannon;
	public static LexiconEntry tacticalshotgun;
	public static LexiconEntry gaia3;
	//Cosmetic
	public static LexiconEntry cosmetic;
	//Basic
	public static LexiconEntry blankcard;
	public static LexiconEntry shard;
	public static LexiconEntry petal;
	public static LexiconEntry goldstring;
	public static LexiconEntry astralforce;
	public static LexiconEntry quartz;
	//Gun
	public static LexiconEntry gunbase;
	public static LexiconEntry gunphoenixblaster;
	public static LexiconEntry gunsnowballcannon;
	public static LexiconEntry guntacticalshotgun;
	public static LexiconEntry gunbullet;
	//Category
	public static LexiconCategory categoryExtra;
	
	public static void init() {
		categoryExtra = new LexiconCategory(StatCollector.translateToLocal("category.Botania:extra"));
		categoryExtra.setIcon(LibReference.EXTRA);
		categoryExtra.setPriority(0);
		BotaniaAPI.addCategory(categoryExtra);	
		//Basic
		blankcard = new BLexiconEntry(LibLexiconName.BA_BLANKCARD, categoryExtra);
		blankcard.setLexiconPages(new PageText("0"), 
				new PageManaInfusionRecipe("1", ModManaInfusionRecipe.blankCardRecipe));
		blankcard.setIcon(new ItemStack(ModItems.material, 1, 1));
		shard = new BLexiconEntry(LibLexiconName.BA_PRISMATICSHARD, categoryExtra);
		shard.setLexiconPages(new PageText("0"));
		shard.setIcon(new ItemStack(ModItems.material));
		petal = new BLexiconEntry(LibLexiconName.BA_PETAL, categoryExtra);
		petal.setLexiconPages(new PageText("0"));
		petal.setIcon(new ItemStack(ModItems.lycorisrandom));
		goldstring = new ELexiconEntry(LibLexiconName.BA_GOLDSTRING, categoryExtra);
		goldstring.setLexiconPages(new PageText("0"), 
				new PageCraftingRecipe("1", ModRecipe.goldString));
		goldstring.setIcon(new ItemStack(ModItems.material,1,9));
		quartz = new ELexiconEntry(LibLexiconName.BA_QUARTZ, categoryExtra);
		quartz.setLexiconPages(new PageText("0"), 
				new PageCraftingRecipe("1", ModRecipe.elvenQuartz), 
				new PageCraftingRecipe("2", ModRecipe.gaiaQuartz));
		quartz.setIcon(new ItemStack(ModItems.material,1,7));
		//Gun
		gunbase = new BLexiconEntry(LibLexiconName.G_GUNBASE, categoryExtra);
		gunbase.setLexiconPages(new PageText("0"),
				new PageText("1"));
		gunbase.setIcon(new ItemStack(ModItems.gunboomstick));
		gunphoenixblaster = new ELexiconEntry(LibLexiconName.G_GUNPHOENIXBLASTER, categoryExtra);
		gunphoenixblaster.setLexiconPages(new PageText("0"));
		gunphoenixblaster.setIcon(new ItemStack(ModItems.gunphoenixblaster));
		gunsnowballcannon = new ELexiconEntry(LibLexiconName.G_GUNSNOWBALLCANNON, categoryExtra);
		gunsnowballcannon.setLexiconPages(new PageText("0"));
		gunsnowballcannon.setIcon(new ItemStack(ModItems.snowballlauncher));
		guntacticalshotgun = new ELexiconEntry(LibLexiconName.G_GUNTACTICALSHOTGUN, categoryExtra);
		guntacticalshotgun.setLexiconPages(new PageText("0"));
		guntacticalshotgun.setIcon(new ItemStack(ModItems.guntacticalshotgun));
		gunbullet = new BLexiconEntry(LibLexiconName.G_GUNBULLET, categoryExtra);
		gunbullet.setLexiconPages(new PageText("0"),
				new PageCraftingRecipe("1", ModRecipe.bullet0),
				new PageCraftingRecipe("2", ModRecipe.bullet1),
				new PageCraftingRecipe("3", ModRecipe.bullet2),
				new PageCraftingRecipe("4", ModRecipe.bullet3),
				new PageCraftingRecipe("5", ModRecipe.bullet4));
		gunbullet.setIcon(new ItemStack(ModItems.bullet,1,4));
		//Bauble
		cosmetic = new ELexiconEntry(LibLexiconName.B_COSMETIC, categoryExtra);
		cosmetic.setLexiconPages(new PageText("0"), 
				new PageCraftingRecipe("1", ModRecipe.baubleDog0), 
				new PageCraftingRecipe("2", ModRecipe.baubleDog1), 
				new PageCraftingRecipe("3", ModRecipe.baubleDog2), 
				new PageCraftingRecipe("4", ModRecipe.baubleDog3));
		cosmetic.setIcon(new ItemStack(ModItems.dog, 1, 0));
		//Generating
		candyflower = new ELexiconEntry(LibLexiconName.GFLOWER_CANDYFLOWER, BotaniaAPI.categoryGenerationFlowers);
		candyflower.setLexiconPages(new PageText("0"), new PageText("1"),
				new PagePetalRecipe("2", ModPetalRecipe.candyflowerRecipe));
		candyflower.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.CANDY_FLOWER));
		
		blueenchantress = new ELexiconEntry(LibLexiconName.GFLOWER_BLUEENCHANTRESS, BotaniaAPI.categoryGenerationFlowers);
		blueenchantress.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.blueenchantressRecipe));
		blueenchantress.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.BLUE_ENCHANTRESS));
		
		sunshinelily = new ELexiconEntry(LibLexiconName.GFLOWER_SUNSHINELILY, BotaniaAPI.categoryGenerationFlowers);
		sunshinelily.setLexiconPages(new PageText("0"), new PageText("1"),
				new PagePetalRecipe("2", ModPetalRecipe.sunshinelilyRecipe));
		sunshinelily.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.SUNSHINE_LILY));
		
		moonlightlily = new ELexiconEntry(LibLexiconName.GFLOWER_MOONLIGHTLILY, BotaniaAPI.categoryGenerationFlowers);
		moonlightlily.setLexiconPages(new PageText("0"), new PageText("1"),
				new PagePetalRecipe("2", ModPetalRecipe.moonlightlilyRecipe));
		moonlightlily.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.MOONLIGHT_LILY));
		
		ominiviolet = new ELexiconEntry(LibLexiconName.GFLOWER_OMINIVIOLET, BotaniaAPI.categoryGenerationFlowers);
		ominiviolet.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.ominivioletRecipe));
		ominiviolet.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.OMNIVIOLET));
		
		geminiorchid = new ELexiconEntry(LibLexiconName.GFLOWER_GEMINIORCHID, BotaniaAPI.categoryGenerationFlowers);
		geminiorchid.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.geminiorchidRecipe));
		geminiorchid.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.GEMINIORCHID));
		//Functional
		necrofleur = new ELexiconEntry(LibLexiconName.FFLOWER_NECROFLEUR, BotaniaAPI.categoryFunctionalFlowers);
		necrofleur.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.necrofleurRecipe));
		necrofleur.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.NECRO_FLUER));
		
		numerondandelife = new ELexiconEntry(LibLexiconName.FFLOWER_NUMERONDANDELIFE, BotaniaAPI.categoryFunctionalFlowers);
		numerondandelife.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.numerondandelifeRecipe));
		numerondandelife.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.NUMERON_DANDELIFE));
		
		icebirdium = new ELexiconEntry(LibLexiconName.FFLOWER_ICEBIRDIUM, BotaniaAPI.categoryFunctionalFlowers);
		icebirdium.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.icebirdiumRecipe));
		icebirdium.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.ICEBIRDIUM));
		
		judasvow = new ELexiconEntry(LibLexiconName.FFLOWER_JUDASVOW, BotaniaAPI.categoryFunctionalFlowers);
		judasvow.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.judasvowRecipe));
		judasvow.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.JUDASVOW));
		
		volatilily = new ELexiconEntry(LibLexiconName.FFLOWER_VOLATILILY, BotaniaAPI.categoryFunctionalFlowers);
		volatilily.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.volatililyRecipe));
		volatilily.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.VOLATILILY));
		
		numeronbalsam = new ELexiconEntry(LibLexiconName.FFLOWER_NUMERONBALSAM, BotaniaAPI.categoryFunctionalFlowers);
		numeronbalsam.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.numeronbalsamRecipe));
		numeronbalsam.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.NUMERON_BALSAM));
		
		woodienia = new ELexiconEntry(LibLexiconName.FFLOWER_WOODIENIA, BotaniaAPI.categoryFunctionalFlowers);
		woodienia.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.woodieniaRecipe));
		woodienia.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.WOODIENIA));
		//For Fun
		infinitymana = new DLexiconEntry(LibLexiconName.D_INFINITYMANA, categoryExtra);
		infinitymana.setIcon(new ItemStack(vazkii.botania.common.block.ModBlocks.pool));
		//Relics
		hestiachastity = new ELexiconEntry(LibLexiconName.R_HESTIACHASTITY, BotaniaAPI.categoryAlfhomancy);
		hestiachastity.setIcon(new ItemStack(ModItems.hestiachastity));
		hestiachastity.setLexiconPages(new PageText("0"));
		
		maxwelldemon = new ELexiconEntry(LibLexiconName.R_MAXWELLDEMON, BotaniaAPI.categoryAlfhomancy);
		maxwelldemon.setIcon(new ItemStack(ModItems.maxwelldemon));
		maxwelldemon.setLexiconPages(new PageText("0"));
		
		athenabless = new ELexiconEntry(LibLexiconName.R_ATHENABLESS, BotaniaAPI.categoryAlfhomancy);
		athenabless.setIcon(new ItemStack(ModItems.athenabless));
		athenabless.setLexiconPages(new PageText("0"));
		
		aphroditegrace = new ELexiconEntry(LibLexiconName.R_APHRODITEGRACE, BotaniaAPI.categoryAlfhomancy);
		aphroditegrace.setIcon(new ItemStack(ModItems.aphroditegrace));
		aphroditegrace.setLexiconPages(new PageText("0"));
		
		dice20 = new ELexiconEntry(LibLexiconName.R_DICE20, BotaniaAPI.categoryAlfhomancy);
		dice20.setIcon(new ItemStack(ModItems.dice20));
		dice20.setLexiconPages(new PageText("0"));
		
		excaliber = new ELexiconEntry(LibLexiconName.R_EXCALIBER, BotaniaAPI.categoryAlfhomancy);
		excaliber.setIcon(new ItemStack(ModItems.excaliber));
		excaliber.setLexiconPages(new PageText("0"));
		
		excaliberfake = new ELexiconEntry(LibLexiconName.R_EXCALIBERFAKE, BotaniaAPI.categoryAlfhomancy);
		excaliberfake.setIcon(new ItemStack(ModItems.excaliberfake));
		excaliberfake.setLexiconPages(new PageText("0"));
		
		vpowerbattleaxe = new ELexiconEntry(LibLexiconName.R_VPOWERBATTLEAXE, BotaniaAPI.categoryAlfhomancy);
		vpowerbattleaxe.setIcon(new ItemStack(ModItems.vpowerbattleaxe));
		vpowerbattleaxe.setLexiconPages(new PageText("0"));
		
		vhandgun = new ELexiconEntry(LibLexiconName.R_VHANDGUN, BotaniaAPI.categoryAlfhomancy);
		vhandgun.setIcon(new ItemStack(ModItems.vhandgun));
		vhandgun.setLexiconPages(new PageText("0"));
		
		vrangerboots = new ELexiconEntry(LibLexiconName.R_VRANGERBOOTS, BotaniaAPI.categoryAlfhomancy);
		vrangerboots.setIcon(new ItemStack(ModItems.vrangerboots));
		vrangerboots.setLexiconPages(new PageText("0"));
		
		gaia3 = new ELexiconEntry(LibLexiconName.R_GAIAIII, BotaniaAPI.categoryAlfhomancy);
		gaia3.setIcon(new ItemStack(Item.getItemFromBlock(ModBlocks.pylon), 1, 2));
		gaia3.setLexiconPages(new PageText("0"), new PageText("1"), new PageMultiblock("3", ModMultiBlocks.gaia), new PageText("2"));
	}
}
