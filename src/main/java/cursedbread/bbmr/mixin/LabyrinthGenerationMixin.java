package cursedbread.bbmr.mixin;

import cursedbread.bbmr.biomes.BBMRBiomes;
import cursedbread.bbmr.blocks.BBMRBlocks;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.generate.feature.WorldFeatureLabyrinth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = WorldFeatureLabyrinth.class, remap = false)
public class LabyrinthGenerationMixin {

	@Shadow
	int wallBlockA;
	@Shadow
	int wallBlockB;
	@Shadow
	int brickBlockA;
	@Shadow
	int brickBlockB;
	@Shadow
	int slabBlock;

	@Unique
	private boolean isRetro;

	@Inject(method = "place", at = @At("HEAD"))
	public void generate(World world, Random random, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
		Biome biome = world.getBlockBiome(x, y, z);
		if (biome == BBMRBiomes.INFDEV_FOREST) {
			this.wallBlockA = BBMRBlocks.COBBLE_STONE_RETRO.id();
			this.wallBlockB = BBMRBlocks.COBBLE_STONE_MOSSY_RETRO.id();
			this.brickBlockA = Blocks.BRICK_STONE_POLISHED.id();
			this.brickBlockB = Blocks.BRICK_STONE_POLISHED_MOSSY.id();
			this.slabBlock = Blocks.SLAB_STONE_POLISHED.id();
			this.isRetro = true;
		}
	}


	@Inject(method = "pickMobSpawner(Ljava/util/Random;)Ljava/lang/String;", at = @At("HEAD"), cancellable = true)
	private void pickMobSpawner(Random random, CallbackInfoReturnable<String> cir) {
		int i = random.nextInt(4);
		if (i == 0) {
			cir.setReturnValue("Skeleton");
		} else if (i == 1) {
			cir.setReturnValue("Zombie");
		} else{
			cir.setReturnValue(isRetro && i == 2 ? "Creeper" : "ArmouredZombie");
		}
	}
}
