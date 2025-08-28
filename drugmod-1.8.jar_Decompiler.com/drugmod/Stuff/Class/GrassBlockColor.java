package drugmod.Stuff.Class;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class GrassBlockColor implements IBlockColor {
   public static final IBlockColor INSTANCE = new GrassBlockColor();

   public int func_186720_a(IBlockState State, IBlockAccess World, BlockPos Position, int Tint) {
      return World.func_180494_b(Position).func_180627_b(Position);
   }
}
