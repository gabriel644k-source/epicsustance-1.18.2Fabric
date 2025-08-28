package com.g2806.epicsustance.init;

import net.minecraft.item.Item;
import net.minecraft.item.FoodComponent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;

import com.g2806.epicsustance.Epicsustance;
import com.g2806.epicsustance.item.DrugItem;
import com.g2806.epicsustance.item.DrugFood;
import com.g2806.epicsustance.item.DrugSeed;

public class ItemRegistry {
    
    public static final Item PESTLE = registerItem("item_pestle", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item MORTAR = registerItem("item_mortar", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item GRINDER = registerItem("item_grinder", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB).maxCount(1)));
    
    public static final Item ITEM_EMPTY_SYRINGE = registerItem("item_empty_syringe", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item ITEM_MORPHINE_SYRINGE = registerItem("item_morphine_syringe", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final DrugItem ITEM_HEROIN_SYRINGE = registerItem("item_heroin_syringe", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB), 
        new StatusEffectInstance(StatusEffects.NAUSEA, 100)));
    
    public static final DrugSeed SEED_WEED = registerItem("seed_weed", 
        new DrugSeed(BlockRegistry.PLANT_WEED, new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final DrugSeed SEED_COCAINE = registerItem("seed_cocaine", 
        new DrugSeed(BlockRegistry.PLANT_COCAINE, new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final DrugSeed SEED_TOBACCO = registerItem("seed_tobacco", 
        new DrugSeed(BlockRegistry.PLANT_TOBACCO, new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final DrugSeed SEED_OPIUM = registerItem("seed_opium", 
        new DrugSeed(BlockRegistry.PLANT_OPIUM, new Item.Settings().group(Epicsustance.DRUG_TAB)));
    
    public static final Item ITEM_WEED = registerItem("item_weed", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item ITEM_COCAINE = registerItem("item_cocaine", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item ITEM_TOBACCO = registerItem("item_tobacco", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item ITEM_OPIUM = registerItem("item_opium", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    
    public static final Item DRUG_WEED = registerItem("drug_weed", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item DRUG_COCAINE = registerItem("drug_cocaine", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item DRUG_TOBACCO = registerItem("drug_tobacco", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item DRUG_OPIUM = registerItem("drug_opium", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    
    public static final Item FOOD_CHOCOLATE_CHIP = registerItem("food_chocolate_chip", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(1).build())));
    public static final Item FOOD_CHOCOLATE_BALL = registerItem("food_chocolate_ball", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(4).build())));
    public static final DrugFood WEED_CHOCOLATE_BALL = registerItem("drug_chocolate_ball", 
        new DrugFood(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(4).build()),
        new StatusEffectInstance(StatusEffects.REGENERATION, 200)));
    
    public static final Item FOOD_MUFFIN = registerItem("food_muffin", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(6).build())));
    public static final DrugFood DRUG_MUFFIN = registerItem("drug_muffin", 
        new DrugFood(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(6).build()),
        new StatusEffectInstance(StatusEffects.REGENERATION, 200)));
    
    public static final Item FOOD_BROWNIE = registerItem("food_brownie", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(6).build())));
    public static final DrugFood DRUG_BROWNIE = registerItem("drug_brownie", 
        new DrugFood(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(6).build()),
        new StatusEffectInstance(StatusEffects.SPEED, 200)));
    
    public static final DrugItem ITEM_JOINT = registerItem("item_joint", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB), 
        new StatusEffectInstance(StatusEffects.REGENERATION, 100)));
    public static final DrugItem ITEM_BLUNT = registerItem("item_blunt", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB), 
        new StatusEffectInstance(StatusEffects.REGENERATION, 100),
        new StatusEffectInstance(StatusEffects.SLOWNESS, 100)));
    public static final DrugItem ITEM_SPLIFF = registerItem("item_spliff", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB), 
        new StatusEffectInstance(StatusEffects.REGENERATION, 100),
        new StatusEffectInstance(StatusEffects.SLOWNESS, 100)));
    public static final DrugItem ITEM_HEROIN_JOINT = registerItem("item_heroin_joint", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB), 
        new StatusEffectInstance(StatusEffects.REGENERATION, 200),
        new StatusEffectInstance(StatusEffects.NAUSEA, 200)));
    
    public static final Item ITEM_STRAW = registerItem("item_straw", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item ITEM_TOBACCO_PIPE = registerItem("item_pipe_tobacco", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item ITEM_OPIUM_PIPE = registerItem("item_pipe_opium", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));

    private static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(Registry.ITEM, new Identifier(Epicsustance.MOD_ID, name), item);
    }

    public static void registerItems() {
        Epicsustance.LOGGER.info("Registering items for " + Epicsustance.MOD_ID);
    }
}