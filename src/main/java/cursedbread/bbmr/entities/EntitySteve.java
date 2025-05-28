package cursedbread.bbmr.entities;

import com.mojang.nbt.tags.CompoundTag;
import cursedbread.bbmr.BBMRMain;
import cursedbread.bbmr.blocks.BBMRBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.monster.MobHuman;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EntitySteve extends MobHuman {
	//steve
	public EntitySteve(World world) {
		super(world);
	}
	//random job + texture based on a job number
	//0 - base
	//1 - miner
	//2 - hunter
	//3 - farmer
	//4 - lumberjack
	//5 - builder
	//6 - warrior
	private int job = random.nextInt(7);
	@Override
	public String getEntityTexture() {
		return "/assets/" + BBMRMain.MOD_ID + "/textures/entity/infdev/"+ job +".png";
	}
	//item in hand based on the job number
	private int randtoolnumber = random.nextInt(randtool.length);
	private static Item[] randtool= {
		Items.TOOL_SWORD_WOOD,
		Items.TOOL_PICKAXE_WOOD,
		Items.TOOL_AXE_WOOD,
		Items.TOOL_HOE_WOOD,
		Items.TOOL_SHOVEL_WOOD
	};

	public ItemStack getHeldItem() {
		if (job == 0){
			return new ItemStack(randtool[randtoolnumber], 1);
		} else if (job == 1){
			return new ItemStack(Items.TOOL_PICKAXE_STONE, 1);
		} else if (job == 2){
			return new ItemStack(Items.TOOL_BOW, 1);
		} else if (job == 3){
			return new ItemStack(Items.TOOL_HOE_STONE, 1);
		} else if (job == 4){
			return new ItemStack(Items.TOOL_AXE_STONE, 1);
		} else if (job == 5){
			return new ItemStack(Items.TOOL_SHOVEL_STONE, 1);
		} else if (job == 6){
			return new ItemStack(Items.TOOL_SWORD_STONE, 1);
		} else {
			return new ItemStack(Blocks.DIRT.asItem(), 1);
		}
	}
	//trading based on the job
	@Override
	public boolean interact(@NotNull Player entityplayer) {
		if (super.interact(entityplayer)) {
			return true;
		}
		ItemStack itemstack = entityplayer.inventory.getCurrentItem();
		//misc trades
		if (itemstack != null && itemstack.getItem().equals(BBMRBlocks.FLOWER_CYAN_RETRO.asItem())){
			this.target = null;
			return true;
		}
		//jobless trades
		Item[] joblesstrade = {
			Items.AMMO_PEBBLE,
			Items.AMMO_SNOWBALL,
			Items.CLAY
		};
		if (job == 0){
			randtrade(joblesstrade, 1, Items.INGOT_GOLD, random.nextInt(5)+4, itemstack, entityplayer);
			trade(Items.SUGARCANE, 1, Items.INGOT_IRON, random.nextInt(5)+4, itemstack, entityplayer);
			return true;
		}
		//miner trades
		Item[] minertrade = {
			BBMRBlocks.COBBLE_STONE_RETRO.asItem(),
			BBMRBlocks.STONE_RETRO.asItem()
		};
		if (job == 1){
			randtrade(minertrade, 32, Items.COAL, 32, itemstack, entityplayer);
			return true;
		}
		//hunter trades
		Item[] huntertrade = {

		};
		if (job == 2){
			trade(Items.FOOD_PORKCHOP_RAW, 4, Items.AMMO_ARROW, 8, itemstack, entityplayer);
		}
		//farmer trades
		Item[] farmertrade = {

		};
		if (job == 3){
			trade(Items.WHEAT, 12, Items.BONE, 4, itemstack, entityplayer);
		}
		//lumberjack trades
		Item[] lumbertrade = {

		};
		if (job == 4){
			trade(Blocks.LOG_OAK.asItem(), 64, Items.TOOL_AXE_STONE, 1, itemstack, entityplayer);
		}
		//builder trades
		Item[] buildertrade = {

		};
		if (job == 5){
			trade(BBMRBlocks.BRICK_CLAY_RETRO.asItem(), 64, Items.INGOT_IRON, 8, itemstack, entityplayer);
		}
		//warrior trades
		Item[] warriortrade = {

		};
		if (job == 6){

		}
		return false;
	}
	//trade functions to not repeat them 100000 times
	private void randtrade(Item[] trade, int ammount, Item currency, int price, ItemStack itemstack, Player entityplayer) {
		assert this.world != null;
		if (itemstack != null && itemstack.getItem().equals(currency) && itemstack.stackSize >= price){
			if (!this.world.isClientSide){
				EntityItem entityitem = this.dropItem(new ItemStack(trade[random.nextInt(trade.length)], ammount), 1.0f);
				entityitem.yd += (double)(this.random.nextFloat() * 0.05f);
				entityitem.xd += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1f);
				entityitem.zd += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1f);
			}
			this.target = null;
			for (int i = 0; i < price; i++){
				itemstack.consumeItem(entityplayer);
			}
		}
	}
	private void trade(Item trade, int ammount, Item currency, int price, ItemStack itemstack, Player entityplayer) {
		assert this.world != null;
		if (itemstack != null && itemstack.getItem().equals(currency) && itemstack.stackSize >= price){
			if (!this.world.isClientSide){
				EntityItem entityitem = this.dropItem(new ItemStack(trade, ammount), 1.0f);
				entityitem.yd += (double)(this.random.nextFloat() * 0.05f);
				entityitem.xd += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1f);
				entityitem.zd += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1f);
			}
			this.target = null;
			for (int i = 0; i < price; i++){
				itemstack.consumeItem(entityplayer);
			}
		}
	}
	//remember job
	@Override
	public void addAdditionalSaveData(@NotNull CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Job", job);
	}
	@Override
	public void readAdditionalSaveData(@NotNull CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		job = tag.getInteger("Job");
	}
	//
	@Override
	public boolean hurt(Entity attacker, int i, DamageType type) {
		if (attacker instanceof Player) {
			List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.bb.expand(32.0, 32.0, 32.0));
			for (int j = 0; j < list.size(); ++j) {
				Entity entity1 = list.get(j);
				if (!(entity1 instanceof EntitySteve)) continue;
				EntitySteve entitySteve = (EntitySteve)entity1;
				entitySteve.becomeAngryAt(attacker);
			}
		}
		return super.hurt(attacker, i, type);
	}
	private void becomeAngryAt(Entity entity) {
		this.target = entity;
	}
	//cant despawn
	@Override
	public boolean canDespawn() {
		return false;
	}
	//can spawn
	@Override
	public boolean canSpawnHere() {
		int x = (int)this.x;
		int y = (int)this.y;
		int z = (int)this.z;
		Block block = this.world.getBlock(x, y-1, z);
		return !(!super.canSpawnHere() || !this.world.canBlockSeeTheSky(x, y, z) || block == BBMRBlocks.COBBLE_STONE_RETRO);
	}
}
