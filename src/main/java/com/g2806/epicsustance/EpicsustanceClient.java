package com.g2806.epicsustance;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import com.g2806.epicsustance.init.BlockRegistry;

@Mod.EventBusSubscriber(modid = Epicsustance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EpicsustanceClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            setupRenderLayers();
        });
    }
    
    public static void setupRenderLayers() {
        Epicsustance.LOGGER.info("Initializing Epic Sustance client - setting up transparent render layers!");
        
        // Set plants to render with cutout layer for transparency
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PLANT_WEED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PLANT_COCAINE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PLANT_TOBACCO.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PLANT_OPIUM.get(), RenderType.cutout());
    }
}