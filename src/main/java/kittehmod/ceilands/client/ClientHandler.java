package kittehmod.ceilands.client;

import kittehmod.ceilands.CeilandsMod;
import kittehmod.ceilands.block.CeilandsBlocks;
import kittehmod.ceilands.blockentities.CeilandsBlockEntities;
import kittehmod.ceilands.client.renderer.CeilandsBoatRenderer;
import kittehmod.ceilands.client.renderer.CeilandsSkyEffect;
import kittehmod.ceilands.entity.CeilandsEntities;
import kittehmod.ceilands.item.CeilandsItems;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientHandler
{
	@SuppressWarnings("deprecation")
	public static void setupRenderers() {
		BlockEntityRenderers.register(CeilandsBlockEntities.CEILANDS_SIGN.get(), SignRenderer::new);
		BlockEntityRenderers.register(CeilandsBlockEntities.CEILANDS_HANGING_SIGN.get(), HangingSignRenderer::new);
		
		EntityRenderers.register(CeilandsEntities.CEILANDS_BOAT.get(), (boat) -> { return new CeilandsBoatRenderer(boat, false); } );
		EntityRenderers.register(CeilandsEntities.CEILANDS_CHEST_BOAT.get(), (boat) -> { return new CeilandsBoatRenderer(boat, true); } );
		
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILTRUNK_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILTRUNK_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILTRUNK_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILTRUNK_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.LUZAWOOD_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.LUZAWOOD_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.LUZAWOOD_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.LUZAWOOD_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.POTTED_LUZAWOOD_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILANDS_PORTAL.get(), RenderType.translucent());
	}
	
	@SubscribeEvent
	public static void registerBlockColours(RegisterColorHandlersEvent.Block event) {
		event.register((state, worldIn, pos, tintIndex) -> {
			return state != null && worldIn != null ? BiomeColors.getAverageFoliageColor(worldIn, pos) : FoliageColor.getDefaultColor();
		}, CeilandsBlocks.CEILTRUNK_LEAVES.get());
		event.register((state, worldIn, pos, tintIndex) -> {
			return getLuzawoodColour();
		}, CeilandsBlocks.LUZAWOOD_LEAVES.get());
	}
	
	@SubscribeEvent
	public static void registerItemColours(RegisterColorHandlersEvent.Item event) {
		BlockColors blockColours = event.getBlockColors();
		event.register((stack, tintIndex) -> { 
			BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
			return blockColours.getColor(blockstate, (BlockAndTintGetter)null, (BlockPos)null, tintIndex);
		}, CeilandsItems.CEILTRUNK_LEAVES.get(), CeilandsItems.LUZAWOOD_LEAVES.get());
	}
	
	@SubscribeEvent
	public static void registerSkyEffects(RegisterDimensionSpecialEffectsEvent event) {
		CeilandsMod.LOGGER.info("Registering sky effects...");
		event.register(new ResourceLocation(CeilandsMod.MODID, "the_ceilands"), new CeilandsSkyEffect.CeilandsEffects());
	}
	
	private static int getLuzawoodColour() {
		return 4637695;
	}
}
