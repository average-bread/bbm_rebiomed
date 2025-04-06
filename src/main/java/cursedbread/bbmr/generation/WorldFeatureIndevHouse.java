package cursedbread.bbmr.generation;

import cursedbread.bbmr.blocks.BBMRBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntityMobSpawner;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureIndevHouse extends WorldFeature {
	@Override
	public boolean place(World world, Random random, int x, int y, int z) {
		if (world.getBlockId(x, y-1, z) == Blocks.GRASS_RETRO.id()){
			int i;
			int j;
			int k;
			int door = random.nextInt(4);
			for (i = -4; i <= 4; i++) {
				for (k = -4; k <= 4; k++) {
					for (j = 0; j <= 5; j++) {
						world.setBlock(x + i, y + j, z + k, Blocks.PLANKS_OAK.id());
					}
				}
			}
			for (i = -3; i <= 3; i++) {
				for (k = -3; k <= 3; k++) {
					for (j = 0; j <= 3; j++) {
						world.setBlock(x + i, y + j, z + k, 0);
					}
				}
			}
			for (i = -4; i <= 4; i++) {
				for (k = -4; k <= 4; k++) {
					j = -1;
					int moss = random.nextInt(100);
					if (moss <= 10) {
						world.setBlock(x + i, y + j, z + k, BBMRBlocks.COBBLE_STONE_MOSSY_RETRO.id());
					} else {
						world.setBlock(x + i, y + j, z + k, BBMRBlocks.COBBLE_STONE_RETRO.id());
					}
				}
			}
			if (door == 0) {
				world.setBlock(x + 4, y, z, 0);
				world.setBlock(x + 4, y+1, z, 0);
			} else if (door == 1) {
				world.setBlock(x - 4, y, z, 0);
				world.setBlock(x - 4, y+1, z, 0);
			} else if (door == 2) {
				world.setBlock(x, y, z + 4, 0);
				world.setBlock(x, y+1, z + 4, 0);
			} else {
				world.setBlock(x, y, z - 4, 0);
				world.setBlock(x, y+1, z - 4, 0);
			}


			world.setBlock(x, y, z, Blocks.TORCH_COAL.id());

			return true;
		} else {
			return false;
		}
	}
}
