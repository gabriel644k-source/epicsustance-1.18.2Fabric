package drugmod.Init;

import drugmod.Stuff.Class.GrassBlockColor;
import drugmod.Stuff.Class.GrassItemColor;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ColorList {
   public static void Go() {
      Minecraft.func_71410_x().func_184125_al().func_186722_a(GrassBlockColor.INSTANCE, new Block[]{BlockList.DRUG_FARMER});
      Minecraft.func_71410_x().getItemColors().func_186731_a(GrassItemColor.INSTANCE, new Block[]{BlockList.DRUG_FARMER});
   }
}
