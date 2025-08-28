package com.g2806.epicsustance;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import com.g2806.epicsustance.init.BlockRegistry;

public class EpicsustanceClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Epicsustance.LOGGER.info("Initializing Epic Sustance client!");
        
        // Set plants to render with cutout layer for transparency
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PLANT_WEED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PLANT_COCAINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PLANT_TOBACCO, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PLANT_OPIUM, RenderLayer.getCutout());
    }
}