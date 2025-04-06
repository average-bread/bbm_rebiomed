package cursedbread.bbmr.biomes;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.BiomeForest;
import net.minecraft.core.world.biome.Biomes;

public class BBMRBiomes {
	public static final Biome INFDEV_FOREST = new BiomeInfdevForest("bbmr.infdev.forest");

	public void initilixeBiomes(){
		Biomes.register("bbmr:infdev_forest", INFDEV_FOREST);
	}
}
