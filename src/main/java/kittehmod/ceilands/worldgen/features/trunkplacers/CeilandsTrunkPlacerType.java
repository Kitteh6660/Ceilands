package kittehmod.ceilands.worldgen.features.trunkplacers;

import kittehmod.ceilands.CeilandsMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CeilandsTrunkPlacerType
{	
	public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registry.TRUNK_PLACER_TYPE_REGISTRY, CeilandsMod.MODID);
	
	public static final RegistryObject<TrunkPlacerType<CeiltrunkTrunkPlacer>> CEILTRUNK_TRUNK_PLACER = TRUNK_PLACERS.register("ceiltrunk_trunk_placer", () -> new TrunkPlacerType<>(CeiltrunkTrunkPlacer.CODEC)); 
	public static final RegistryObject<TrunkPlacerType<LargeCeiltrunkTrunkPlacer>> LARGE_CEILTRUNK_TRUNK_PLACER = TRUNK_PLACERS.register("large_ceiltrunk_trunk_placer", () -> new TrunkPlacerType<>(LargeCeiltrunkTrunkPlacer.CODEC)); 
	public static final RegistryObject<TrunkPlacerType<LuzawoodTrunkPlacer>> LUZAWOOD_TRUNK_PLACER = TRUNK_PLACERS.register("luzawood_trunk_placer", () -> new TrunkPlacerType<>(LuzawoodTrunkPlacer.CODEC));
	public static final RegistryObject<TrunkPlacerType<DoubleLuzawoodTrunkPlacer>> DOUBLE_LUZAWOOD_TRUNK_PLACER = TRUNK_PLACERS.register("double_luzawood_trunk_placer", () -> new TrunkPlacerType<>(DoubleLuzawoodTrunkPlacer.CODEC));
	
}
