package com.kittehmod.ceilands.neoforge;

import com.google.common.collect.ImmutableList;
import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.ModWoodType;
import com.kittehmod.ceilands.neoforge.client.ClientHandler;
import com.kittehmod.ceilands.neoforge.compat.FarmersDelightCompat;
import com.kittehmod.ceilands.neoforge.compat.TwilightForestCompat;
import com.kittehmod.ceilands.neoforge.util.CreativeTabHelper;
import com.kittehmod.ceilands.registry.CeilandsGameRules;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack.Position;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import oshi.util.tuples.Quartet;

@Mod(Ceilands.MOD_ID)
public class CeilandsModNeoForge 
{
	public CeilandsModNeoForge(IEventBus bus, ModContainer container) {
		bus.register(CeilandsRegistry.class);
		bus.register(CreativeTabHelper.class);
		bus.addListener(this::setupCommon);
		hookCompats(bus);
		bus.addListener(this::setupDataPacks);
		CeilandsGameRules.setup();
	}

	private void hookCompats(IEventBus bus) {
		if (CompatsNeoForge.FARMERS_DELIGHT_INSTALLED) {
			bus.register(new FarmersDelightCompat(false));
		}
		if (CompatsNeoForge.TWILIGHT_FOREST_INSTALLED) {
			bus.register(new TwilightForestCompat(false));
		}
		/*if (CompatsNeoForge.WOODWORKS_INSTALLED) {
			bus.register(new WoodworksCompat(false));
		}
		if (CompatsNeoForge.BOATLOAD_INSTALLED) {
			bus.register(new BoatloadCompat(false));
		}*/
	}

	private void setupCommon(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> WoodType.register(ModWoodType.CEILTRUNK));
		event.enqueueWork(() -> WoodType.register(ModWoodType.LUZAWOOD));
		event.enqueueWork(() -> CeilandsRegistry.registerFlammable());
		event.enqueueWork(() -> CeilandsRegistry.registerFlowerPots());
	}

	public void setupDataPacks(final AddPackFindersEvent event) {
		var packFarmersDelight = new Quartet<>("farmersdelight", CompatsNeoForge.FARMERS_DELIGHT_INSTALLED, "datapacks/ceilands_fd_compat", "Ceilands - Farmers Delight Pack");
		var packTwilightForest = new Quartet<>("twilightforet", CompatsNeoForge.TWILIGHT_FOREST_INSTALLED, "datapacks/ceilands_tf_compat", "Ceilands - Twilight Forest Pack");
		var packBoatload = new Quartet<>("boatload", CompatsNeoForge.BOATLOAD_INSTALLED, "datapacks/ceilands_boatload_compat", "Ceilands - Boatload Pack");
		var packWoodworks = new Quartet<>("woodworks", CompatsNeoForge.WOODWORKS_INSTALLED, "datapacks/ceilands_woodworks_compat", "Ceilands - Woodworks Pack");
		var packs = ImmutableList.of(packFarmersDelight, packTwilightForest, packBoatload, packWoodworks);
		if (event.getPackType() == PackType.SERVER_DATA) {
			for (Quartet<String, Boolean, String, String> packToCheck : packs) {
				if (!packToCheck.getB()) {
					continue;
				}
				event.addPackFinders(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, packToCheck.getC()), PackType.SERVER_DATA, Component.literal(packToCheck.getD()), PackSource.BUILT_IN, false, Position.TOP);
				/*var resourcePath = ModList.get().getModFileById(Ceilands.MOD_ID).getFile().findResource(packToCheck.getC());
				var packInfo = Pack.readMetaAndCreate(Component.literal(packToCheck.getD()), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), false);
				var pack = Pack.readMetaAndCreate("builtin/ceilands-" + packToCheck.getA(), Component.literal(packToCheck.getD()), true, (path) -> new PathPackResources(path, resourcePath, true), packInfo, PackType.SERVER_DATA, Pack.Position.BOTTOM, false, PackSource.BUILT_IN);
				event.addRepositorySource((packConsumer) -> packConsumer.accept((Pack) pack));*/
			}
		}
	}
}
