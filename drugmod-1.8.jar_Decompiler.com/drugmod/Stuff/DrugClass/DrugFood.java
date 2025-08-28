package drugmod.Stuff.DrugClass;

import drugmod.Stuff.Configuration;
import drugmod.Stuff.Class.FoodItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class DrugFood extends FoodItem {
   private Potion[] DrugEffect;
   private int DrugDuration;

   public DrugFood(String Name, int Amount, boolean Wolf, Potion[] Effect, int Duration) {
      super(Name, Amount, Wolf);
      this.DrugEffect = Effect;
      this.DrugDuration = Duration;
      this.func_77848_i();
   }

   protected void func_77849_c(ItemStack Stack, World CurrentWorld, EntityPlayer Player) {
      for(int I = 0; I < this.DrugEffect.length; ++I) {
         Player.func_70690_d(new PotionEffect(this.DrugEffect[I], this.DrugDuration));
      }

      if (Configuration.DRUG_NAUSEA) {
         Player.func_70690_d(new PotionEffect(MobEffects.field_76431_k, this.DrugDuration * 2));
      }

   }
}
