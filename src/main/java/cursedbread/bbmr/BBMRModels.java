package cursedbread.bbmr;

import cursedbread.bbmr.blocks.BBMRBlocks;
import cursedbread.bbmr.entities.EntitySteve;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.*;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.entity.MobRendererBiped;
import net.minecraft.client.render.entity.MobRendererHuman;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.model.ModelBiped;
import net.minecraft.client.render.model.ModelPlayer;
import net.minecraft.client.render.model.ModelZombie;
import net.minecraft.core.util.helper.Side;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

@Environment(EnvType.CLIENT)
public class BBMRModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {
		ModelHelper.setBlockModel(
			BBMRBlocks.COBBLE_STONE_RETRO,
			() -> new BlockModelStandard<>(BBMRBlocks.COBBLE_STONE_RETRO)
				.setTex(0,"bbmr:block/infdev/cobbled_stone_retro", Side.sides)
		);

		ModelHelper.setBlockModel(
			BBMRBlocks.SLAB_COBBLE_STONE_RETRO,
			() -> new BlockModelSlab<>(BBMRBlocks.SLAB_COBBLE_STONE_RETRO)
				.setTex(0,"bbmr:block/infdev/cobbled_stone_retro", Side.sides)
		);

		ModelHelper.setBlockModel(
			BBMRBlocks.STAIR_COBBLE_STONE_RETRO,
			() -> new BlockModelStairs<>(BBMRBlocks.STAIR_COBBLE_STONE_RETRO)
				.setTex(0,"bbmr:block/infdev/cobbled_stone_retro", Side.sides)
		);

		ModelHelper.setBlockModel(
			BBMRBlocks.STONE_BRICKS_RETRO,
			() -> new BlockModelStandard<>(BBMRBlocks.STONE_BRICKS_RETRO)
				.setTex(0,"bbmr:block/infdev/brick_stone_retro", Side.sides)
		);

		ModelHelper.setBlockModel(
			BBMRBlocks.SLAB_STONE_BRICKS_RETRO,
			() -> new BlockModelSlab<>(BBMRBlocks.SLAB_STONE_BRICKS_RETRO)
				.setTex(0,"bbmr:block/infdev/brick_stone_retro", Side.sides)
		);

		ModelHelper.setBlockModel(
			BBMRBlocks.STAIR_STONE_BRICKS_RETRO,
			() -> new BlockModelStairs<>(BBMRBlocks.STAIR_STONE_BRICKS_RETRO)
				.setTex(0,"bbmr:block/infdev/brick_stone_retro", Side.sides)
		);

		ModelHelper.setBlockModel(
			BBMRBlocks.COBBLE_STONE_MOSSY_RETRO,
			() -> new BlockModelStandard<>(BBMRBlocks.COBBLE_STONE_MOSSY_RETRO)
				.setTex(0,"bbmr:block/infdev/mossy_cobbled_stone_retro", Side.sides)
		);

		ModelHelper.setBlockModel(
			BBMRBlocks.BRICK_CLAY_RETRO,
			() -> new BlockModelStandard<>(BBMRBlocks.BRICK_CLAY_RETRO)
				.setTex(0,"bbmr:block/infdev/brick_clay_retro", Side.sides)
		);

		ModelHelper.setBlockModel(
			BBMRBlocks.FLOWER_CYAN_RETRO,
			() -> new BlockModelFlowerStackable<>(BBMRBlocks.FLOWER_CYAN_RETRO,
				"bbmr:block/infdev/flower_cyan/")
		);

		ModelHelper.setBlockModel(
			BBMRBlocks.STONE_RETRO,
			() -> new BlockModelStandard<>(BBMRBlocks.STONE_RETRO)
				.setTex(0,"bbmr:block/infdev/stone_retro", Side.sides)
		);
	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {

	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {
		ModelHelper.setEntityModel(EntitySteve.class, ()->new MobRendererBiped<>(new ModelPlayer(0), 0.5f));
	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}
}
