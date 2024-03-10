package com.kittehmod.ceilands;

import com.kittehmod.ceilands.block.CeilandsBlocks;
import com.kittehmod.ceilands.block.ModWoodType;
import com.kittehmod.ceilands.blockentities.CeilandsBlockEntities;
import com.kittehmod.ceilands.client.ClientHandler;
import com.kittehmod.ceilands.entity.CeilandsEntities;
import com.kittehmod.ceilands.item.CeilandsItems;
import com.kittehmod.ceilands.worldgen.biomes.CeilandsBiomes;
import com.kittehmod.ceilands.worldgen.features.CeilandsFeatures;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.CeilandsTrunkPlacerType;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

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
