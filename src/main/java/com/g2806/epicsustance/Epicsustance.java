package com.g2806.epicsustance;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.g2806.epicsustance.init.ItemRegistry;
import com.g2806.epicsustance.init.BlockRegistry;

@Mod(Epicsustance.MOD_ID)
public class Epicsustance {
    public static final String MOD_ID = "epicsustance";
    
    public static final Logger LOGGER = LogManager.getLogger();
    
    public static final CreativeModeTab DRUG_TAB = new CreativeModeTab("epicsustance") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.ITEM_WEED.get());
        }
    };

    public Epicsustance() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ItemRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);
        
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Initializing Epic Sustance mod!");
        
        event.enqueueWork(() -> {
            ItemRegistry.setupDrugHelpers();
        });
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                EpicsustanceClient.setupRenderLayers();
            });
        });
    }
}