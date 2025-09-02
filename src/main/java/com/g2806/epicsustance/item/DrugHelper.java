package com.g2806.epicsustance.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.level.Level;

public class DrugHelper extends Item {
    private Item requiredDrugItem;
    private final MobEffectInstance[] effects;
    private final int duration;
    private final boolean producesSmoke;

    public DrugHelper(Item.Properties settings, int duration, boolean producesSmoke, MobEffectInstance... effects) {
        super(settings.stacksTo(1));
        this.duration = duration;
        this.effects = effects;
        this.producesSmoke = producesSmoke;
    }

    public DrugHelper(Item.Properties settings, Item requiredDrug, int duration, boolean producesSmoke, MobEffectInstance... effects) {
        super(settings.stacksTo(1));
        this.requiredDrugItem = requiredDrug;
        this.duration = duration;
        this.effects = effects;
        this.producesSmoke = producesSmoke;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        
        if (requiredDrugItem == null) {
            if (world.isClientSide()) {
                user.displayClientMessage(new TextComponent("This item is not configured properly!"), true);
            }
            return InteractionResultHolder.fail(itemStack);
        }
        
        if (!world.isClientSide()) {
            // Look for the required drug in player's inventory
            ItemStack drugStack = findDrugInInventory(user);
            
            if (drugStack != null) {
                // Apply drug effects
                for (MobEffectInstance effect : effects) {
                    user.addEffect(new MobEffectInstance(effect.getEffect(), duration, effect.getAmplifier()));
                }
                
                // Add nausea effect
                user.addEffect(new MobEffectInstance(MobEffects.CONFUSION, duration * 2));
                
                // Show smoke particles
                if (producesSmoke) {
                    ServerLevel serverWorld = (ServerLevel) world;
                    serverWorld.sendParticles(ParticleTypes.LARGE_SMOKE, 
                        user.getX(), user.getY() + 2.0, user.getZ(), 
                        5, 0.0, 0.1, 0.0, 0.0);
                }
                
                // Consume one drug item
                drugStack.shrink(1);
                
                return InteractionResultHolder.success(itemStack);
            } else {
                // Send message about needing the drug
                String drugName = requiredDrugItem.getDescription().getString();
                user.displayClientMessage(new TextComponent("You need " + drugName + " to use this!"), true);
            }
        }
        
        return InteractionResultHolder.fail(itemStack);
    }

    private ItemStack findDrugInInventory(Player player) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (!stack.isEmpty() && stack.getItem() == requiredDrugItem) {
                return stack;
            }
        }
        return null;
    }

    public DrugHelper setRequiredDrug(Item drugItem) {
        this.requiredDrugItem = drugItem;
        System.out.println("DrugHelper: Set required drug to " + (drugItem != null ? drugItem.getDescription().getString() : "null"));
        return this;
    }
}