package kittehmod.ceilands;

import com.google.common.collect.ImmutableSet;

import kittehmod.ceilands.block.CeilandsBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CeilandsPOIType
{
	public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, CeilandsMod.MODID);
	
	public static final RegistryObject<PoiType> CEILANDS_PORTAL_POI = POI_TYPES.register("ceilands_portal_poi", () -> new PoiType(ImmutableSet.copyOf(CeilandsBlocks.CEILANDS_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
