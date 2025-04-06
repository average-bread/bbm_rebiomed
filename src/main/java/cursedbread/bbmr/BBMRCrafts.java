package cursedbread.bbmr;

import cursedbread.bbmr.blocks.BBMRBlocks;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class BBMRCrafts implements RecipeEntrypoint {
	@Override
	public void initNamespaces() {

	}

	@Override
	public void onRecipesReady() {
		RecipeBuilder.addItemsToGroup("minecraft","cobblestones", BBMRBlocks.COBBLE_STONE_RETRO);
		RecipeBuilder.addItemsToGroup("minecraft","stones", BBMRBlocks.STONE_RETRO);

		RecipeBuilder.Shaped(BBMRMain.MOD_ID)
			.setShape("XXX")
			.addInput('X', BBMRBlocks.COBBLE_STONE_RETRO)
			.create("retroslabs", new ItemStack(BBMRBlocks.SLAB_COBBLE_STONE_RETRO, 6));

		RecipeBuilder.Shaped(BBMRMain.MOD_ID)
			.setShape("X  ", "XX ", "XXX")
			.addInput('X', BBMRBlocks.COBBLE_STONE_RETRO)
			.create("retrostairs", new ItemStack(BBMRBlocks.STAIR_COBBLE_STONE_RETRO, 6));

		RecipeBuilder.Shaped(BBMRMain.MOD_ID)
			.setShape("XX", "XX")
			.addInput('X', BBMRBlocks.STONE_RETRO)
			.create("retrostonebricks", new ItemStack(BBMRBlocks.STONE_BRICKS_RETRO, 4));

		RecipeBuilder.Shaped(BBMRMain.MOD_ID)
			.setShape("X", "X")
			.addInput('X', BBMRBlocks.STONE_RETRO)
			.create("polishing", new ItemStack(Blocks.STONE_POLISHED, 2));

		RecipeBuilder.Shaped(BBMRMain.MOD_ID)
			.setShape("XXX")
			.addInput('X', BBMRBlocks.STONE_BRICKS_RETRO)
			.create("retroslabs", new ItemStack(BBMRBlocks.SLAB_STONE_BRICKS_RETRO, 6));

		RecipeBuilder.Shaped(BBMRMain.MOD_ID)
			.setShape("X  ", "XX ", "XXX")
			.addInput('X', BBMRBlocks.STONE_BRICKS_RETRO)
			.create("retrostairs", new ItemStack(BBMRBlocks.STAIR_STONE_BRICKS_RETRO, 6));

		RecipeBuilder.Shapeless(BBMRMain.MOD_ID)
			.addInput(BBMRBlocks.FLOWER_CYAN_RETRO)
			.create("cyandyecraft", new ItemStack(Items.DYE, 2, 6));

		RecipeBuilder.Furnace(BBMRMain.MOD_ID)
			.setInput(BBMRBlocks.COBBLE_STONE_RETRO)
			.create("retrosmelting", new ItemStack(BBMRBlocks.STONE_RETRO));
	}
}
