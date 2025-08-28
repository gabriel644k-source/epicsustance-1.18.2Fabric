package drugmod.Stuff.DrugClass;

import drugmod.Stuff.Class.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class DrugFarmer extends BlockBase {
   public DrugFarmer(String Name, Material Material) {
      super(Name, Material);
   }

   public BlockRenderLayer func_180664_k() {
      return BlockRenderLayer.CUTOUT;
   }
}
