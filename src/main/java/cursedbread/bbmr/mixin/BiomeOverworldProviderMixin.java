package cursedbread.bbmr.mixin;

import cursedbread.bbmr.biomes.BBMRBiomes;
import net.minecraft.core.world.biome.data.BiomeRange;
import net.minecraft.core.world.biome.data.BiomeRangeMap;
import net.minecraft.core.world.biome.provider.BiomeProviderOverworld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= BiomeProviderOverworld.class,remap=false)
public abstract class BiomeOverworldProviderMixin {
	@Shadow
	@Final
	private static BiomeRangeMap brm;
	@Inject(method="init",at=@At(value = "INVOKE",ordinal=0,target = "Lnet/minecraft/core/world/biome/data/BiomeRangeMap;lock()V"))
	private static void wishthisworks(CallbackInfo ci) {
		brm.addRange(BBMRBiomes.INFDEV_FOREST, new BiomeRange[]{
			new BiomeRange(0.75, 0.95, 0.4, 0.85, 0.0, 1.0, 0.0, 1.0),
			new BiomeRange(0.95, 1.0, 0.4, 0.85, 0.0, 1.0, 0.0, 1.0)});
	}
}
