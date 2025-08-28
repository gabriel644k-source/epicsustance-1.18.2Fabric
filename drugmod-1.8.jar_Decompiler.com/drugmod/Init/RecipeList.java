package drugmod.Init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeList {
   public static void Go() {
      GameRegistry.addSmelting(new ItemStack(Items.field_151100_aR, 1, 3), new ItemStack(ItemList.FOOD_CHOCOLATE_CHIP, 4), 0.0F);
   }
}
