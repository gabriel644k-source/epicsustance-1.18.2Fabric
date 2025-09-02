package com.g2806.epicsustance.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

import com.g2806.epicsustance.Epicsustance;
import com.g2806.epicsustance.block.WeedPlant;
import com.g2806.epicsustance.block.CocainePlant;
import com.g2806.epicsustance.block.TobaccoPlant;
import com.g2806.epicsustance.block.OpiumPlant;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, Epicsustance.MOD_ID);
    
    public static final RegistryObject<WeedPlant> PLANT_WEED = registerBlock("plant_weed", 
        WeedPlant::new, false);
    public static final RegistryObject<CocainePlant> PLANT_COCAINE = registerBlock("plant_cocaine", 
        CocainePlant::new, false);
    public static final RegistryObject<TobaccoPlant> PLANT_TOBACCO = registerBlock("plant_tobacco", 
        TobaccoPlant::new, false);
    public static final RegistryObject<OpiumPlant> PLANT_OPIUM = registerBlock("plant_opium", 
        OpiumPlant::new, false);
    
    public static final RegistryObject<Block> DRUG_FARMER = registerBlock("drug_farmer", 
        () -> new Block(Block.Properties.of(Material.STONE).strength(3.0f)), true);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean shouldRegisterItem) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        if (shouldRegisterItem) {
            registerBlockItem(name, toReturn);
        }
        return toReturn;
    }
    
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), 
            new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}