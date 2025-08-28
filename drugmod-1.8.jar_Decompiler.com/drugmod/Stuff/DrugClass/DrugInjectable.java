package drugmod.Stuff.DrugClass;

import drugmod.Init.ItemList;
import drugmod.Stuff.Class.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DrugInjectable extends ItemBase {
   private Potion[] DrugEffect;
   private int DrugDuration;

   public DrugInjectable(String Name, Potion[] Effect, int Duration) {
      super(Name);
      this.DrugEffect = Effect;
      this.DrugDuration = Duration;
   }

   public EnumActionResult func_180614_a(EntityPlayer Player, World CurrentWorld, BlockPos Position, EnumHand Hand, EnumFacing Facing, float X, float Y, float Z) {
      if (!CurrentWorld.field_72995_K && Player.field_71071_by.func_70441_a(new ItemStack(ItemList.ITEM_EMPTY_SYRINGE))) {
         Player.func_184586_b(Hand).func_190918_g(1);

         for(int I = 0; I < this.DrugEffect.length; ++I) {
            Player.func_70690_d(new PotionEffect(this.DrugEffect[I], this.DrugDuration));
         }
      }

      return EnumActionResult.SUCCESS;
   }
}
