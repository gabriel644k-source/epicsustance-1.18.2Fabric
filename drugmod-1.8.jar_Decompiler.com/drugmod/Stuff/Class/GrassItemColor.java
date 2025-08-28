package drugmod.Stuff.Class;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ColorizerGrass;

public class GrassItemColor implements IItemColor {
   public static final GrassItemColor INSTANCE = new GrassItemColor();

   public int func_186726_a(ItemStack Stack, int Tint) {
      return ColorizerGrass.func_77480_a(0.5D, 0.5D);
   }
}
