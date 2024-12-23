package com.kittehmod.ceilands.forge;

import com.google.common.collect.ImmutableList;
import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.ModWoodType;
import com.kittehmod.ceilands.forge.client.ClientHandler;
import com.kittehmod.ceilands.forge.compat.BoatloadCompat;
import com.kittehmod.ceilands.forge.compat.FarmersDelightCompat;
import com.kittehmod.ceilands.forge.compat.TwilightForestCompat;
import com.kittehmod.ceilands.forge.compat.WoodworksCompat;
import com.kittehmod.ceilands.registry.CeilandsGameRules;
import com.kittehmod.ceilands.util.CreativeModeTabDatabase;

import net.minecraft.SharedConstants;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import oshi.util.tuples.Quartet;

import net.minecraft.world.item.TridentItem;

@Mod(Ceilands.MOD_ID)
public class CeilandsModForge 
{
	public CeilandsModForge() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(CeilandsRegistry.class);
		bus.addListener(this::setupCommon);
		hookCompats(bus);
		if (FMLEnvironment.dist == Dist.CLIENT) {
			bus.addListener(this::setupClient);
		}
		bus.addListener(this::setupDataPacks);
		CeilandsGameRules.setup();
	}

	private void hookCompats(IEventBus bus) {
		if (CompatsForge.FARMERS_DELIGHT_INSTALLED) {
			bus.register(new FarmersDelightCompat(false));
		}
		if (CompatsForge.TWILIGHT_FOREST_INSTALLED) {
			bus.register(new TwilightForestCompat(false));
		}
		if (CompatsForge.WOODWORKS_INSTALLED) {
			bus.register(new WoodworksCompat(false));
		}
		if (CompatsForge.BOATLOAD_INSTALLED) {
			bus.register(new BoatloadCompat(false));
		}
	}

	private void setupCommon(final FMLCommonSetupEvent event) {
		CreativeModeTabDatabase.populateContents();
		event.enqueueWork(() -> WoodType.register(ModWoodType.CEILTRUNK));
		event.enqueueWork(() -> WoodType.register(ModWoodType.LUZAWOOD));
		event.enqueueWork(() -> CeilandsRegistry.registerFlammable());
		event.enqueueWork(() -> CeilandsRegistry.registerFlowerPots());
	}

	private void setupClient(FMLClientSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(ClientHandler.class);
		ClientHandler.setupRenderers();
		event.enqueueWork(() -> {
			Sheets.addWoodType(ModWoodType.CEILTRUNK);
		});
		event.enqueueWork(() -> {
			Sheets.addWoodType(ModWoodType.LUZAWOOD);
		});
	}

	public void setupDataPacks(final AddPackFindersEvent event) {
		var packFarmersDelight = new Quartet<>("farmersdelight", CompatsForge.FARMERS_DELIGHT_INSTALLED, "datapacks/ceilands_fd_compat", "Ceilands - Farmers Delight Pack");
		var packTwilightForest = new Quartet<>("twilightforet", CompatsForge.TWILIGHT_FOREST_INSTALLED, "datapacks/ceilands_tf_compat", "Ceilands - Twilight Forest Pack");
		var packBoatload = new Quartet<>("boatload", CompatsForge.BOATLOAD_INSTALLED, "datapacks/ceilands_boatload_compat", "Ceilands - Boatload Pack");
		var packWoodworks = new Quartet<>("woodworks", CompatsForge.WOODWORKS_INSTALLED, "datapacks/ceilands_woodworks_compat", "Ceilands - Woodworks Pack");
		var packs = ImmutableList.of(packFarmersDelight, packTwilightForest, packBoatload, packWoodworks);
		if (event.getPackType() == PackType.SERVER_DATA) {
			for (Quartet<String, Boolean, String, String> packToCheck : packs) {
				if (!packToCheck.getB()) {
					continue;
				}
				var resourcePath = ModList.get().getModFileById(Ceilands.MOD_ID).getFile().findResource(packToCheck.getC());
				var packInfo = new Pack.Info(Component.literal(packToCheck.getD()), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), false);
				var pack = Pack.create("builtin/ceilands-" + packToCheck.getA(), Component.literal(packToCheck.getD()), true, (path) -> new PathPackResources(path, resourcePath, true), packInfo, PackType.SERVER_DATA, Pack.Position.BOTTOM, false, PackSource.BUILT_IN);
				event.addRepositorySource((packConsumer) -> packConsumer.accept((Pack) pack));
			}
		}
	}
}
