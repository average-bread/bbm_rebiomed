package cursedbread.bbmr.biomes;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTree;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeFancy;

import java.util.Random;

public class BiomeInfdevForest extends Biome {
	public BiomeInfdevForest(String key) {
		super(key);
		this.topBlock = (short)Blocks.GRASS_RETRO.id();
	}

	public WorldFeature getRandomWorldGenForTrees(Random random) {
		if (random.nextInt(3) == 0) {
			return new WorldFeatureTreeFancy(Blocks.LEAVES_OAK_RETRO.id(), Blocks.LOG_OAK.id());
		} else {
			return new WorldFeatureTree(Blocks.LEAVES_OAK_RETRO.id(), Blocks.LOG_OAK.id(), 4);
		}
	}
}
