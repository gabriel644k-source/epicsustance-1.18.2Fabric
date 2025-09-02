package com.g2806.epicsustance.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.level.Level;
import com.g2806.epicsustance.init.ItemRegistry;

public class DrugInjectable extends Item {
    private final MobEffectInstance[] effects;
    private final int duration;

    public DrugInjectable(Item.Properties settings, MobEffectInstance... effects) {
        super(settings);
        this.effects = effects;
        this.duration = effects.length > 0 ? effects[0].getDuration() : 100;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        
        if (!world.isClientSide()) {
            // Apply drug effects
            for (MobEffectInstance effect : effects) {
                user.addEffect(new MobEffectInstance(effect));
            }
            
            // Consume the drug syringe
            itemStack.shrink(1);
            
            // Give back empty syringe
            ItemStack returnSyringe = new ItemStack(ItemRegistry.ITEM_EMPTY_SYRINGE.get());
            if (!user.getInventory().add(returnSyringe)) {
                // If inventory is full, drop it
                user.drop(returnSyringe, false);
            }
            
            return InteractionResultHolder.success(itemStack);
        }
        
        return InteractionResultHolder.fail(itemStack);
    }
}