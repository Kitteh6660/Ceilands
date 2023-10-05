package kittehmod.ceilands;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import kittehmod.ceilands.block.CeilandsBlocks;
import kittehmod.ceilands.block.ModWoodType;
import kittehmod.ceilands.blockentities.CeilandsBlockEntities;
import kittehmod.ceilands.client.ClientHandler;
import kittehmod.ceilands.entity.CeilandsEntities;
import kittehmod.ceilands.item.CeilandsItems;
import kittehmod.ceilands.worldgen.biomes.CeilandsBiomes;
import kittehmod.ceilands.worldgen.features.CeilandsFeatures;
import kittehmod.ceilands.worldgen.features.trunkplacers.CeilandsTrunkPlacerType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(CeilandsMod.MODID)
public class CeilandsMod
{
    public static final String MODID = "ceilands";
    
    public static final Logger LOGGER = LogUtils.getLogger();

    public CeilandsMod()
    {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	
        CeilandsBlocks.BLOCKS.register(bus);
        CeilandsItems.ITEMS.register(bus);
        CeilandsBlockEntities.BLOCK_ENTITIES.register(bus);
        CeilandsEntities.ENTITIES.register(bus);
        CeilandsTrunkPlacerType.TRUNK_PLACERS.register(bus);
        CeilandsPOIType.POI_TYPES.register(bus);
        CeilandsFeatures.FEATURES.register(bus);
        CeilandsBiomes.BIOMES.register(bus);
        
    	bus.addListener(this::setupCommon);
    	if (FMLEnvironment.dist == Dist.CLIENT) {
    		bus.addListener(this::setupClient);
    	}
    }

    private void setupCommon(final FMLCommonSetupEvent event)
    {
       	event.enqueueWork(() -> WoodType.register(ModWoodType.CEILTRUNK));
    	event.enqueueWork(() -> WoodType.register(ModWoodType.LUZAWOOD));
    }

    private void setupClient(FMLClientSetupEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(ClientHandler.class);
    	ClientHandler.setupRenderers();
    	event.enqueueWork(() -> { Sheets.addWoodType(ModWoodType.CEILTRUNK);} );
    	event.enqueueWork(() -> { Sheets.addWoodType(ModWoodType.LUZAWOOD);} );
    }
}
