package cursedbread.bbmr.generation;

import cursedbread.bbmr.blocks.BBMRBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureBrickPyramid extends WorldFeature {
	@Override
	public boolean place(World world, Random random, int x, int y, int z) {
		if (world.getBlockId(x, y-1, z) == Blocks.GRASS_RETRO.id()){
			int rand = random.nextInt(100);
			int j1 = 5 + random.nextInt(10);
			int i;
			int i1 = 0;
			int j;
			int k;
			int k1 = 0;
			y = world.getHeightValue(x, z);
			for (j = 0; j <= j1; j++){
				for (i = i1; i <= j; i++){
					for (k = k1; k <= j; k++){
						world.setBlock(x + i, y - j + j1, z + k, BBMRBlocks.BRICK_CLAY_RETRO.id());
						world.setBlock(x + i, y - j + j1, z - k, BBMRBlocks.BRICK_CLAY_RETRO.id());
						world.setBlock(x - i, y - j + j1, z + k, BBMRBlocks.BRICK_CLAY_RETRO.id());
						world.setBlock(x - i, y - j + j1, z - k, BBMRBlocks.BRICK_CLAY_RETRO.id());
					}
				}
				i1 = 0;
				k1 = 0;
				for (i = i1 ; i <= j - 1; i++){
					for (k = k1 ; k <= j - 1; k++){
						world.setBlock(x + i, y - j + j1, z + k, 0);
						world.setBlock(x + i, y - j + j1, z - k, 0);
						world.setBlock(x - i, y - j + j1, z + k, 0);
						world.setBlock(x - i, y - j + j1, z - k, 0);
					}
				}
			}
			for (i = i1; i <= j; i++){
				for (k = k1; k <= j; k++){
					world.setBlock(x + i, y - j + j1, z + k, BBMRBlocks.BRICK_CLAY_RETRO.id());
					world.setBlock(x + i, y - j + j1, z - k, BBMRBlocks.BRICK_CLAY_RETRO.id());
					world.setBlock(x - i, y - j + j1, z + k, BBMRBlocks.BRICK_CLAY_RETRO.id());
					world.setBlock(x - i, y - j + j1, z - k, BBMRBlocks.BRICK_CLAY_RETRO.id());
				}
			}
			return true;
		} else {
			return false;
		}
	}
}
