package cursedbread.bbmr.blocks;

import cursedbread.bbmr.BBMRMain;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

import static net.minecraft.core.block.Blocks.GRAVEL;

public class BBMRBlocks {
	public static int blockId;
	public static Block<?> COBBLE_STONE_RETRO;
	public static Block<?> COBBLE_STONE_MOSSY_RETRO;
	public static Block<?> BRICK_CLAY_RETRO;
	public static Block<BlockLogicFlowerStackable> FLOWER_CYAN_RETRO;
	public static Block<?> STONE_RETRO;
	public static Block<BlockLogicSlab> SLAB_COBBLE_STONE_RETRO;
	public static Block<BlockLogicStairs> STAIR_COBBLE_STONE_RETRO;
	public static Block<?> STONE_BRICKS_RETRO;
	public static Block<BlockLogicSlab> SLAB_STONE_BRICKS_RETRO;
	public static Block<BlockLogicStairs> STAIR_STONE_BRICKS_RETRO;

	public void initilizeBlocks(){
		STONE_RETRO = new BlockBuilder(BBMRMain.MOD_ID)
			.build("stone.retro",
				blockId++, (b) -> {
					return new BlockLogicStone(b, COBBLE_STONE_RETRO, Material.stone);
				})
			.withSound(BlockSounds.STONE)
			.withHardness(1.5F)
			.withBlastResistance(10.0F)
			.withTags(new Tag[]{BlockTags.CAVES_CUT_THROUGH, BlockTags.MINEABLE_BY_PICKAXE});

		COBBLE_STONE_RETRO = new BlockBuilder(BBMRMain.MOD_ID)
			.build("cobble.stone.retro",
				blockId++,
				(b) -> {
					return new BlockLogicCobble(b, Material.stone, () -> {
						return GRAVEL;
					});
				})
			.withSound(BlockSounds.STONE)
			.withHardness(2.0F)
			.withBlastResistance(10.0F)
			.withTags(new Tag[]{BlockTags.MINEABLE_BY_PICKAXE});

		COBBLE_STONE_MOSSY_RETRO = new BlockBuilder(BBMRMain.MOD_ID)
			.build("cobble.stone.mossy.retro",
				blockId++,
				(b) -> {
					return new BlockLogicCobble(b, Material.stone, () -> {
						return GRAVEL;
					});
				})
			.withSound(BlockSounds.STONE)
			.withHardness(2.0F)
			.withBlastResistance(10.0F)
			.withTags(new Tag[]{BlockTags.MINEABLE_BY_PICKAXE});

		STONE_BRICKS_RETRO = new BlockBuilder(BBMRMain.MOD_ID)
			.build("stone.bricks.retro",
				blockId++,
				(b) -> {
					return new BlockLogicCobble(b, Material.stone, () -> {
						return GRAVEL;
					});
				})
			.withSound(BlockSounds.STONE)
			.withHardness(2.0F)
			.withBlastResistance(10.0F)
			.withTags(new Tag[]{BlockTags.MINEABLE_BY_PICKAXE});

		SLAB_COBBLE_STONE_RETRO = new BlockBuilder(BBMRMain.MOD_ID)
			.build("slab.cobble.stone.retro",
				blockId++, (b) -> {
					return new BlockLogicSlab(b, COBBLE_STONE_RETRO);
				})
			.withSound(BlockSounds.STONE)
			.withDisabledNeighborNotifyOnMetadataChange()
			.withLitInteriorSurface(true)
			.withTags(new Tag[]{BlockTags.MINEABLE_BY_PICKAXE});

		SLAB_STONE_BRICKS_RETRO = new BlockBuilder(BBMRMain.MOD_ID)
			.build("slab.stone.bricks.retro",
				blockId++, (b) -> {
					return new BlockLogicSlab(b, STONE_BRICKS_RETRO);
				})
			.withSound(BlockSounds.STONE)
			.withDisabledNeighborNotifyOnMetadataChange()
			.withLitInteriorSurface(true)
			.withTags(new Tag[]{BlockTags.MINEABLE_BY_PICKAXE});

		STAIR_COBBLE_STONE_RETRO  = new BlockBuilder(BBMRMain.MOD_ID)
			.build("stairs.cobble.stone.retro",
				blockId++, (b) -> {
					return new BlockLogicStairs(b, COBBLE_STONE_RETRO);
				})
			.withSound(BlockSounds.STONE)
			.withDisabledNeighborNotifyOnMetadataChange()
			.withLitInteriorSurface(true)
			.withTags(new Tag[]{BlockTags.MINEABLE_BY_PICKAXE});

		STAIR_STONE_BRICKS_RETRO  = new BlockBuilder(BBMRMain.MOD_ID)
			.build("stairs.stone.bricks.retro",
				blockId++, (b) -> {
					return new BlockLogicStairs(b, STONE_BRICKS_RETRO);
				})
			.withSound(BlockSounds.STONE)
			.withDisabledNeighborNotifyOnMetadataChange()
			.withLitInteriorSurface(true)
			.withTags(new Tag[]{BlockTags.MINEABLE_BY_PICKAXE});

		BRICK_CLAY_RETRO = new BlockBuilder(BBMRMain.MOD_ID)
			.build("brick.clay.retro",
				blockId++,
				(b) -> {
					return new BlockLogic(b, Material.stone);
				})
			.withSound(BlockSounds.STONE)
			.withHardness(3.0F)
			.withBlastResistance(10.0F)
			.withOverrideColor(MaterialColor.brick)
			.withTags(new Tag[]{BlockTags.MINEABLE_BY_PICKAXE});

		FLOWER_CYAN_RETRO =new BlockBuilder(BBMRMain.MOD_ID)
			.build("flower.cyan.retro",
				blockId++,
				(b) -> {
					return (BlockLogicFlowerStackable)(new BlockLogicFlowerStackable(b)).setKilledByWeather().setBonemealable();
				})
			.withSound(BlockSounds.GRASS)
			.withHardness(0.0F)
			.withOverrideColor(MaterialColor.paintedCyan)
			.withTags(new Tag[]{BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR, BlockTags.SHEEPS_FAVOURITE_BLOCK, BlockTags.SHEARS_DO_SILK_TOUCH});
	}
}
