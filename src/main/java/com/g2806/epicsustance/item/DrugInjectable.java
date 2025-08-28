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
        super(settings.maxCount(1));
        this.effects = effects;
        this.duration = effects.length > 0 ? effects[0].getDuration() : 100;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        
        if (!world.isClient()) {
            // Check if player has empty syringe
            if (hasEmptySyringeInInventory(user)) {
                // Apply drug effects
                for (StatusEffectInstance effect : effects) {
                    user.addStatusEffect(new StatusEffectInstance(effect));
                }
                
                // Consume the syringe
                itemStack.decrement(1);
                
                return TypedActionResult.success(itemStack);
            }
        }
        
        return TypedActionResult.fail(itemStack);
    }

    private boolean hasEmptySyringeInInventory(PlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (!stack.isEmpty() && stack.getItem() == ItemRegistry.ITEM_EMPTY_SYRINGE) {
                return true;
            }
        }
        return false;
    }
}