package com.g2806.epicsustance.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DrugHelper extends Item {
    private Item requiredDrugItem;
    private final StatusEffectInstance[] effects;
    private final int duration;
    private final boolean producesSmoke;

    public DrugHelper(Item.Settings settings, int duration, boolean producesSmoke, StatusEffectInstance... effects) {
        super(settings.maxCount(1));
        this.duration = duration;
        this.effects = effects;
        this.producesSmoke = producesSmoke;
    }

    public DrugHelper(Item.Settings settings, Item requiredDrug, int duration, boolean producesSmoke, StatusEffectInstance... effects) {
        super(settings.maxCount(1));
        this.requiredDrugItem = requiredDrug;
        this.duration = duration;
        this.effects = effects;
        this.producesSmoke = producesSmoke;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        
        if (requiredDrugItem == null) {
            if (world.isClient()) {
                user.sendMessage(Text.of("This item is not configured properly!"), true);
            }
            return TypedActionResult.fail(itemStack);
        }
        
        if (!world.isClient()) {
            // Look for the required drug in player's inventory
            ItemStack drugStack = findDrugInInventory(user);
            
            if (drugStack != null) {
                // Apply drug effects
                for (StatusEffectInstance effect : effects) {
                    user.addStatusEffect(new StatusEffectInstance(effect.getEffectType(), duration, effect.getAmplifier()));
                }
                
                // Add nausea effect
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, duration * 2));
                
                // Show smoke particles
                if (producesSmoke) {
                    ServerWorld serverWorld = (ServerWorld) world;
                    serverWorld.spawnParticles(ParticleTypes.LARGE_SMOKE, 
                        user.getX(), user.getY() + 2.0, user.getZ(), 
                        5, 0.0, 0.1, 0.0, 0.0);
                }
                
                // Consume one drug item
                drugStack.decrement(1);
                
                return TypedActionResult.success(itemStack);
            } else {
                // Send message about needing the drug
                String drugName = requiredDrugItem.getName().getString();
                user.sendMessage(Text.of("You need " + drugName + " to use this!"), true);
            }
        }
        
        return TypedActionResult.fail(itemStack);
    }

    private ItemStack findDrugInInventory(PlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (!stack.isEmpty() && stack.getItem() == requiredDrugItem) {
                return stack;
            }
        }
        return null;
    }

    public DrugHelper setRequiredDrug(Item drugItem) {
        this.requiredDrugItem = drugItem;
        System.out.println("DrugHelper: Set required drug to " + (drugItem != null ? drugItem.getName().getString() : "null"));
        return this;
    }
}