package com.kittehmod.ceilands.neoforge.compat;

// To be re-implemented when Blueprint gets updated to 1.21.
public class BoatloadCompat 
{
	/*public static final ResourceLocation CEILTRUNK_FURNACE_BOAT_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_furnace_boat");
	public static final ResourceLocation LUZAWOOD_FURNACE_BOAT_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_furnace_boat");
	public static final ResourceLocation LARGE_CEILTRUNK_BOAT_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "large_ceiltrunk_boat");
	public static final ResourceLocation LARGE_LUZAWOOD_BOAT_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "large_luzawood_boat");
	
	public BoatloadCompat(boolean register) {
		if (!register) {
			return;
		}
		BoatloadBoatType CEILTRUNK_BOAT_TYPE = BoatloadBoatType.register(BoatloadBoatType.create(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk"), () -> { return CeilandsItems.CEILTRUNK_PLANKS; }, () -> { return CeilandsItems.CEILTRUNK_BOAT; }, () -> { return CeilandsItems.CEILTRUNK_CHEST_BOAT; }, () -> { return BuiltInRegistries.ITEM.get(CEILTRUNK_FURNACE_BOAT_RES); }, () -> { return BuiltInRegistries.ITEM.get(LARGE_CEILTRUNK_BOAT_RES); }));
		BoatloadBoatType LUZAWOOD_BOAT_TYPE = BoatloadBoatType.register(BoatloadBoatType.create(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood"), () -> { return CeilandsItems.LUZAWOOD_PLANKS; }, () -> { return CeilandsItems.LUZAWOOD_BOAT; }, () -> { return CeilandsItems.LUZAWOOD_CHEST_BOAT; }, () -> { return BuiltInRegistries.ITEM.get(LUZAWOOD_FURNACE_BOAT_RES); }, () -> { return BuiltInRegistries.ITEM.get(LARGE_LUZAWOOD_BOAT_RES); }));
		Item CEILTRUNK_FURNACE_BOAT = new FurnaceBoatItem(CEILTRUNK_BOAT_TYPE);
		Item LARGE_CEILTRUNK_BOAT = new LargeBoatItem(CEILTRUNK_BOAT_TYPE);
		Item LUZAWOOD_FURNACE_BOAT = new FurnaceBoatItem(LUZAWOOD_BOAT_TYPE);
		Item LARGE_LUZAWOOD_BOAT = new LargeBoatItem(LUZAWOOD_BOAT_TYPE);
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_FURNACE_BOAT_RES, CEILTRUNK_FURNACE_BOAT));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_FURNACE_BOAT_RES, LUZAWOOD_FURNACE_BOAT));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LARGE_CEILTRUNK_BOAT_RES, LARGE_CEILTRUNK_BOAT));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LARGE_LUZAWOOD_BOAT_RES, LARGE_LUZAWOOD_BOAT));
		//BlueprintBoatTypes.registerType(ResourceLocation.fromNamespaceAndPath(Ceilands.MODID, "ceiltrunk"), () -> CeilandsItems.CEILTRUNK_BOAT, () -> CeilandsItems.CEILTRUNK_CHEST_BOAT, () -> CeilandsBlocks.CEILTRUNK_PLANKS, false);
		//BlueprintBoatTypes.registerType(ResourceLocation.fromNamespaceAndPath(Ceilands.MODID, "luzawood"), () -> CeilandsItems.LUZAWOOD_BOAT, () -> CeilandsItems.LUZAWOOD_CHEST_BOAT, () -> CeilandsBlocks.LUZAWOOD_PLANKS, false);
	}
	
	@SubscribeEvent
	public void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			event.insertAfter(CeilandsItems.CEILTRUNK_CHEST_BOAT.getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_FURNACE_BOAT_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(CEILTRUNK_FURNACE_BOAT_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(LARGE_CEILTRUNK_BOAT_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(CeilandsItems.LUZAWOOD_CHEST_BOAT.asItem().getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_FURNACE_BOAT_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(LUZAWOOD_FURNACE_BOAT_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(LARGE_LUZAWOOD_BOAT_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}*/
}
