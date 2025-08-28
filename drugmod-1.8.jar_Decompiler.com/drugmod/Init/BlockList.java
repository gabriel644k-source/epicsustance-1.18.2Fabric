package drugmod.Init;

import drugmod.Stuff.DrugClass.DrugFarmer;
import drugmod.Stuff.DrugClass.DrugPlant;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockList {
   public static final List<Block> BLOCK_LIST = new ArrayList();
   public static final DrugPlant PLANT_WEED = new DrugPlant("plant_weed");
   public static final DrugPlant PLANT_COCAINE = new DrugPlant("plant_cocaine");
   public static final DrugPlant PLANT_TOBACCO = new DrugPlant("plant_tobacco");
   public static final DrugPlant PLANT_OPIUM = new DrugPlant("plant_opium");
   public static final DrugFarmer DRUG_FARMER;

   public static void Go() {
      PLANT_WEED.SetSeed(ItemList.SEED_WEED);
      PLANT_COCAINE.SetSeed(ItemList.SEED_COCAINE);
      PLANT_TOBACCO.SetSeed(ItemList.SEED_TOBACCO);
      PLANT_OPIUM.SetSeed(ItemList.SEED_OPIUM);
      PLANT_WEED.SetDrug(ItemList.ITEM_WEED);
      PLANT_COCAINE.SetDrug(ItemList.ITEM_COCAINE);
      PLANT_TOBACCO.SetDrug(ItemList.ITEM_TOBACCO);
      PLANT_OPIUM.SetDrug(ItemList.ITEM_OPIUM);
   }

   static {
      DRUG_FARMER = new DrugFarmer("drug_farmer", Material.field_151573_f);
   }
}
