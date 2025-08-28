package com.g2806.epicsustance.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import com.g2806.epicsustance.init.ItemRegistry;

public class DrugInjectable extends Item {
    private final StatusEffectInstance[] effects;
    private final int duration;

    public DrugInjectable(Item.Settings settings, StatusEffectInstance... effects) {
        super(settings); // Remove maxCount(1) to allow stacking
        this.effects = effects;
        this.duration = effects.length > 0 ? effects[0].getDuration() : 100;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        
        if (!world.isClient()) {
            // Apply drug effects
            for (StatusEffectInstance effect : effects) {
                user.addStatusEffect(new StatusEffectInstance(effect));
            }
            
            // Consume the drug syringe
            itemStack.decrement(1);
            
            // Give back empty syringe
            ItemStack returnSyringe = new ItemStack(ItemRegistry.ITEM_EMPTY_SYRINGE);
            if (!user.getInventory().insertStack(returnSyringe)) {
                // If inventory is full, drop it
                user.dropItem(returnSyringe, false);
            }
            
            return TypedActionResult.success(itemStack);
        }
        
        return TypedActionResult.fail(itemStack);
    }
}