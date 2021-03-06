package com.meteor.extrabotany.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.meteor.extrabotany.common.item.ModItems;

public class GunRenderer implements IItemRenderer {

    private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    private TextureManager texturemanager;

    public GunRenderer(GameSettings gameSettings, TextureManager textureManager) {
        this.texturemanager = textureManager;
    }

    public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        return (type == IItemRenderer.ItemRenderType.ENTITY) || (type == IItemRenderer.ItemRenderType.EQUIPPED) || (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) || (type == IItemRenderer.ItemRenderType.INVENTORY);
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
        return (type == IItemRenderer.ItemRenderType.ENTITY) && ((helper == IItemRenderer.ItemRendererHelper.ENTITY_ROTATION) || (helper == IItemRenderer.ItemRendererHelper.ENTITY_BOBBING));
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
        if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
            float scale = 2.5F;
            GL11.glScalef(scale, scale, scale);

            GL11.glTranslatef(0.55F, -0.2F, 0.15F);
            
            if(item.getItemUseAction() == EnumAction.bow){
            	GL11.glRotatef(35.0F, 0.0F, 0.0F, 1.0F);
            }
            
            if(item.getItem() == ModItems.gunboomstick)
            	GL11.glTranslatef(0.05F, -0.1F, 0);
            else if(item.getItem() == ModItems.gunshotgun)
            	GL11.glTranslatef(0.05F, -0.1F, 0);
            else if(item.getItem() == ModItems.guntacticalshotgun)
            	GL11.glTranslatef(0.05F, -0.15F, 0);
            else if(item.getItem() == ModItems.gunflintlock)
            	GL11.glTranslatef(0.03F, -0.1F, 0);
            else if(item.getItem() == ModItems.snowballlauncher)
            	GL11.glTranslatef(0.12F, -0.2F, 0);
            else if(item.getItem() == ModItems.theseusship)
            	GL11.glTranslatef(0.12F, -0.08F, 0);

            IIcon iicon = ((EntityLivingBase) data[1]).getItemIcon(item, 0);
            renderItemEquipped(iicon, item);
        } else if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
            float scale = 1.5F;
            GL11.glScalef(scale, scale, scale);

            GL11.glTranslatef(0.345F, -0.1F, 0F);
            
            if(item.getItemUseAction() == EnumAction.bow){
            	GL11.glRotatef(35.0F, 0.0F, 0.0F, 1.0F);
            } 
            
            if(item.getItem() == ModItems.gunboomstick)
            	GL11.glTranslatef(0.05F, -0.1F, 0);
            else if(item.getItem() == ModItems.gunshotgun)
            	GL11.glTranslatef(0.05F, -0.1F, 0);
            else if(item.getItem() == ModItems.guntacticalshotgun)
            	GL11.glTranslatef(0.05F, -0.15F, 0);
            else if(item.getItem() == ModItems.gunflintlock)
            	GL11.glTranslatef(0.03F, -0.1F, 0);
            else if(item.getItem() == ModItems.snowballlauncher)
            	GL11.glTranslatef(0.12F, -0.2F, 0);
            else if(item.getItem() == ModItems.theseusship)
            	GL11.glTranslatef(0.12F, -0.38F, 0);

            IIcon iicon = ((EntityLivingBase) data[1]).getItemIcon(item, 0);
            renderItemEquipped(iicon, item);
        } else if (type == IItemRenderer.ItemRenderType.ENTITY) {
            float scale = 1.5F;
            GL11.glScalef(scale, scale, scale);

            GL11.glTranslatef(0.0F, 0.15F, 0.0F);

            EntityItem entityItem = (EntityItem) data[1];

            renderDroppedItem(entityItem, item);
        } else if (type == IItemRenderer.ItemRenderType.INVENTORY) {
            renderInventoryItem(item, (RenderBlocks) data[0]);
        }
    }

    private void renderInventoryItem(ItemStack itemStack, RenderBlocks renderBlocks) {
        IIcon iicon = itemStack.getItem().getIcon(itemStack, -1);

        GL11.glDisable(2896);
        GL11.glEnable(3008);

        RenderItem.getInstance().renderIcon(0, 0, iicon, 16, 16);

        GL11.glDisable(3008);
        GL11.glEnable(2896);

        if (itemStack.hasEffect(0)) {
            RenderItem.getInstance().renderEffect(this.texturemanager, 0, 0);
        }
        GL11.glEnable(2896);
    }

    private void renderItemEquipped(IIcon iicon, ItemStack par2ItemStack) {
        int par3 = 0;

        if (iicon == null) {
            GL11.glPopMatrix();
            return;
        }

        this.texturemanager.getTexture(this.texturemanager.getResourceLocation(par2ItemStack.getItemSpriteNumber()));
        TextureUtil.func_152777_a(false, false, 1.0F);
        Tessellator tessellator = Tessellator.instance;
        float f = iicon.getMinU();
        float f1 = iicon.getMaxU();
        float f2 = iicon.getMinV();
        float f3 = iicon.getMaxV();

        ItemRenderer.renderItemIn2D(tessellator, f1, f2, f, f3, iicon.getIconWidth(), iicon.getIconHeight(), 0.0625F);

        if (par2ItemStack.hasEffect(par3))
        {
            GL11.glDepthFunc(GL11.GL_EQUAL);
            GL11.glDisable(GL11.GL_LIGHTING);
            texturemanager.bindTexture(RES_ITEM_GLINT);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(768, 1, 1, 0);
            float f7 = 0.76F;
            GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
            GL11.glMatrixMode(GL11.GL_TEXTURE);
            GL11.glPushMatrix();
            float f8 = 0.125F;
            GL11.glScalef(f8, f8, f8);
            float f9 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
            GL11.glTranslatef(f9, 0.0F, 0.0F);
            GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
            ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f8, f8, f8);
            f9 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
            GL11.glTranslatef(-f9, 0.0F, 0.0F);
            GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
            ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
            GL11.glPopMatrix();
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDepthFunc(GL11.GL_LEQUAL);
        }

        this.texturemanager.getTexture(this.texturemanager.getResourceLocation(par2ItemStack.getItemSpriteNumber()));
        TextureUtil.func_147945_b();
    }

    private void renderDroppedItem(EntityItem entityItem, ItemStack item) {
        Tessellator tessellator = Tessellator.instance;

        float f9 = 0.5F;
        float f10 = 0.25F;

        GL11.glPushMatrix();

        float f12 = 0.0625F;
        float f11 = 0.021875F;

        GL11.glTranslatef(-f9, -f10, -(f12 + f11));

        GL11.glTranslatef(0.0F, 0.0F, f12 + f11);

        this.texturemanager.getTexture(TextureMap.locationItemsTexture);

        IIcon par2Icon = item.getIconIndex();

        ItemRenderer.renderItemIn2D(tessellator, par2Icon.getMaxU(), par2Icon.getMinV(), par2Icon.getMinU(), par2Icon.getMaxV(), par2Icon.getIconWidth(), par2Icon.getIconHeight(), f12);

        GL11.glPopMatrix();
    }
}
