package cursedbread.bbmr.mixin;

import cursedbread.bbmr.biomes.BBMRBiomes;
import cursedbread.bbmr.blocks.BBMRBlocks;
import cursedbread.bbmr.generation.WorldFeatureBrickPyramid;
import cursedbread.bbmr.generation.WorldFeatureIndevHouse;
import net.minecraft.core.block.BlockLogicLeavesBase;
import net.minecraft.core.block.BlockLogicSand;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.WorldFeatureDungeon;
import net.minecraft.core.world.generate.feature.WorldFeatureFlowers;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import net.minecraft.core.world.noise.PerlinNoise;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = ChunkDecoratorOverworld.class, remap = false)

public class ChunkDecoratorOverworldMixin {
	@Shadow
	@Final
	private PerlinNoise treeDensityNoise;

	@Shadow
	@Final
	private int treeDensityOverride;
	@Final private World world;

	@Inject(method = "decorate(Lnet/minecraft/core/world/chunk/Chunk;)V", at=@At("TAIL"))
	public void decorate(Chunk chunk, CallbackInfo ci){
		this.world.scheduledUpdatesAreImmediate = true;
		int chunkX = chunk.xPosition;
		int chunkZ = chunk.zPosition;
		int minY = this.world.getWorldType().getMinY();
		int maxY = this.world.getWorldType().getMaxY();
		int rangeY = maxY + 1 - minY;
		float oreHeightModifier = (float)rangeY / 128.0F;
		BlockLogicSand.fallInstantly = true;
		int x = chunkX * 16;
		int z = chunkZ * 16;
		int y = this.world.getHeightValue(x + 16, z + 16);
		Biome biome = this.world.getBlockBiome(x + 16, y, z + 16);
		Random rand = new Random(this.world.getRandomSeed());
		long l1 = rand.nextLong() / 2L * 2L + 1L;
		long l2 = rand.nextLong() / 2L * 2L + 1L;
		rand.setSeed((long)chunkX * l1 + (long)chunkZ * l2 ^ this.world.getRandomSeed());
		Random swampRand = new Random((long)chunkX * l1 + (long)chunkZ * l2 ^ this.world.getRandomSeed());
		int j4;
		int k7;
		int k4;
		int i11;
		int l14;
		int i14;
		int treeDensity;

		double d = 0.5;
		k4 = (int)((this.treeDensityNoise.get((double)x * d, (double)z * d) / 8.0 + rand.nextDouble() * 4.0 + 4.0) / 3.0);
		treeDensity = 0;

		if (biome == BBMRBiomes.INFDEV_FOREST) {
			treeDensity += k4 + 5;

			try {
				BlockLogicLeavesBase.enableDecay = false;

				for(i11 = 0; i11 < treeDensity; ++i11) {
					i11 = x + rand.nextInt(16) + 8;
					l14 = z + rand.nextInt(16) + 8;
					WorldFeature feature = biome.getRandomWorldGenForTrees(rand);
					feature.init(1.0, 1.0, 1.0);
					feature.place(this.world, rand, i11, this.world.getHeightValue(i11, l14), l14);
				}
			} finally {
				BlockLogicLeavesBase.enableDecay = true;
			}

			if (rand.nextInt(96) == 0){
				k7 = x + rand.nextInt(16) + 8;
				treeDensity = z + rand.nextInt(16) + 8;
				k4 = this.world.getHeightValue(k7, treeDensity);
				new WorldFeatureIndevHouse().place(world, world.rand, k7, k4, treeDensity);
			}

			if (rand.nextInt(128) == 0){
				k7 = x + rand.nextInt(16) + 8;
				treeDensity = z + rand.nextInt(16) + 8;
				k4 = this.world.getHeightValue(k7, treeDensity);
				new WorldFeatureBrickPyramid().place(world, world.rand, k7, k4, treeDensity);
			}

			for(j4 = 0; (float)j4 < 10.0F * oreHeightModifier; ++j4) {
				k7 = x + rand.nextInt(16);
				k4 = minY + rand.nextInt(rangeY);
				treeDensity = z + rand.nextInt(16);
				(new WorldFeatureOre(BBMRBlocks.STONE_RETRO.id(), 64)).place(this.world, rand, k7, k4, treeDensity);
			}

			for(j4 = 0; j4 < 2; ++j4) {
				k7 = x + rand.nextInt(16) + 8;
				i14 = minY + rand.nextInt(rangeY);
				k4 = z + rand.nextInt(16) + 8;
				(new WorldFeatureFlowers(BBMRBlocks.FLOWER_CYAN_RETRO.id(), 64, true)).place(this.world, rand, k7, i14, k4);
			}
		}
	}
}
