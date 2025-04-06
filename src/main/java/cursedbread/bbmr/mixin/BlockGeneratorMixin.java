package cursedbread.bbmr.mixin;

import cursedbread.bbmr.biomes.BBMRBiomes;
import cursedbread.bbmr.blocks.BBMRBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicFluid;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BlockLogicFluid.class, remap = false)

public class BlockGeneratorMixin extends BlockLogic {

	public BlockGeneratorMixin(Block<?> block, Material material) {
		super(block, material);
	}

	@Unique
	protected void fizz(World world, int x, int y, int z) {
		world.playSoundEffect((Entity)null, SoundCategory.WORLD_SOUNDS, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
		for(int i = 0; i < 8; ++i) {
			world.spawnParticle("largesmoke", (double)x + Math.random(), (double)y + 1.2, (double)z + Math.random(), 0.0, 0.0, 0.0, 0);
		}
	}


	@Inject(method = "checkForHarden", at = @At("HEAD"), cancellable = true)
	private void checkForHarden(World world, int x, int y, int z, CallbackInfo ci) {
		int data = world.getBlockMetadata(x, y, z) & 15;

		if (this.material == Material.lava &&
			(world.getBlockMaterial(x, y, z - 1) == Material.water ||
				world.getBlockMaterial(x, y, z + 1) == Material.water ||
				world.getBlockMaterial(x - 1, y, z) == Material.water ||
				world.getBlockMaterial(x + 1, y, z) == Material.water ||
				world.getBlockMaterial(x, y + 1, z) == Material.water)) {
				if (data <= 4 && world.getBlockBiome(x, y, z) == BBMRBiomes.INFDEV_FOREST) {
					world.setBlockWithNotify(x, y, z, BBMRBlocks.COBBLE_STONE_RETRO.id());
					this.fizz(world, x, y, z);
			}
		}
	}
}
