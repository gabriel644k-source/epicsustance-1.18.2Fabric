package drugmod.Init;

import drugmod.Stuff.Class.ArmorBase;
import drugmod.Stuff.Class.FoodItem;
import drugmod.Stuff.Class.ItemBase;
import drugmod.Stuff.DrugClass.DrugFood;
import drugmod.Stuff.DrugClass.DrugHelper;
import drugmod.Stuff.DrugClass.DrugInjectable;
import drugmod.Stuff.DrugClass.DrugItem;
import drugmod.Stuff.DrugClass.DrugSeed;
import drugmod.Stuff.DrugClass.Syringe;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

public class ItemList {
   public static final List<Item> ITEM_LIST = new ArrayList();
   public static final ItemBase PESTLE = new ItemBase("item_pestle");
   public static final ItemBase MORTAR = new ItemBase("item_mortar");
   public static final ItemBase GRINDER = new ItemBase("item_grinder");
   public static final ItemBase ITEM_EMPTY_SYRINGE = new Syringe("item_empty_syringe");
   public static final ItemBase ITEM_MORPHINE_SYRINGE = new ItemBase("item_morphine_syringe");
   public static final DrugInjectable ITEM_HEROIN_SYRINGE;
   public static final DrugSeed SEED_WEED;
   public static final DrugSeed SEED_COCAINE;
   public static final DrugSeed SEED_TOBACCO;
   public static final DrugSeed SEED_OPIUM;
   public static final ItemBase ITEM_WEED;
   public static final ItemBase ITEM_COCAINE;
   public static final ItemBase ITEM_TOBACCO;
   public static final ItemBase ITEM_OPIUM;
   public static final ItemBase DRUG_WEED;
   public static final ItemBase DRUG_COCAINE;
   public static final ItemBase DRUG_TOBACCO;
   public static final ItemBase DRUG_OPIUM;
   public static final FoodItem FOOD_CHOCOLATE_CHIP;
   public static final FoodItem FOOD_CHOCOLATE_BALL;
   public static final DrugFood WEED_CHOCOLATE_BALL;
   public static final FoodItem FOOD_MUFFIN;
   public static final DrugFood DRUG_MUFFIN;
   public static final FoodItem FOOD_BROWNIE;
   public static final DrugFood DRUG_BROWNIE;
   public static final DrugItem ITEM_JOINT;
   public static final DrugItem ITEM_BLUNT;
   public static final DrugItem ITEM_SPLIFF;
   public static final DrugItem ITEM_HEROIN_JOINT;
   public static final DrugHelper ITEM_STRAW;
   public static final DrugHelper ITEM_TOBACCO_PIPE;
   public static final DrugHelper ITEM_OPIUM_PIPE;
   public static final ArmorMaterial DOPE;
   public static final Item DOPE_HELMET;

   public static void Go() {
      SEED_WEED.SetPlant(BlockList.PLANT_WEED);
      SEED_COCAINE.SetPlant(BlockList.PLANT_COCAINE);
      SEED_TOBACCO.SetPlant(BlockList.PLANT_TOBACCO);
      SEED_OPIUM.SetPlant(BlockList.PLANT_OPIUM);
      ITEM_STRAW.SetDrug(DRUG_COCAINE);
      ITEM_TOBACCO_PIPE.SetDrug(DRUG_TOBACCO);
      ITEM_OPIUM_PIPE.SetDrug(DRUG_OPIUM);
      MinecraftForge.addGrassSeed(new ItemStack(SEED_WEED), 10);
      MinecraftForge.addGrassSeed(new ItemStack(SEED_COCAINE), 10);
      MinecraftForge.addGrassSeed(new ItemStack(SEED_TOBACCO), 10);
      MinecraftForge.addGrassSeed(new ItemStack(SEED_OPIUM), 10);
      GRINDER.func_77625_d(1).func_77642_a(GRINDER);
      ITEM_MORPHINE_SYRINGE.func_77642_a(ITEM_EMPTY_SYRINGE);
      ITEM_HEROIN_SYRINGE.func_77642_a(ITEM_EMPTY_SYRINGE);
   }

   static {
      ITEM_HEROIN_SYRINGE = new DrugInjectable("item_heroin_syringe", new Potion[]{MobEffects.field_76424_c}, 100);
      SEED_WEED = new DrugSeed("seed_weed");
      SEED_COCAINE = new DrugSeed("seed_cocaine");
      SEED_TOBACCO = new DrugSeed("seed_tobacco");
      SEED_OPIUM = new DrugSeed("seed_opium");
      ITEM_WEED = new ItemBase("item_weed");
      ITEM_COCAINE = new ItemBase("item_cocaine");
      ITEM_TOBACCO = new ItemBase("item_tobacco");
      ITEM_OPIUM = new ItemBase("item_opium");
      DRUG_WEED = new ItemBase("drug_weed");
      DRUG_COCAINE = new ItemBase("drug_cocaine");
      DRUG_TOBACCO = new ItemBase("drug_tobacco");
      DRUG_OPIUM = new ItemBase("drug_opium");
      FOOD_CHOCOLATE_CHIP = new FoodItem("food_chocolate_chip", 1, false);
      FOOD_CHOCOLATE_BALL = new FoodItem("food_chocolate_ball", 4, false);
      WEED_CHOCOLATE_BALL = new DrugFood("drug_chocolate_ball", 4, false, new Potion[]{MobEffects.field_76428_l}, 200);
      FOOD_MUFFIN = new FoodItem("food_muffin", 6, false);
      DRUG_MUFFIN = new DrugFood("drug_muffin", 6, false, new Potion[]{MobEffects.field_76428_l}, 200);
      FOOD_BROWNIE = new FoodItem("food_brownie", 6, false);
      DRUG_BROWNIE = new DrugFood("drug_brownie", 6, false, new Potion[]{MobEffects.field_76420_g}, 200);
      ITEM_JOINT = new DrugItem("item_joint", new Potion[]{MobEffects.field_76428_l}, 100, true);
      ITEM_BLUNT = new DrugItem("item_blunt", new Potion[]{MobEffects.field_76428_l, MobEffects.field_76419_f}, 100, true);
      ITEM_SPLIFF = new DrugItem("item_spliff", new Potion[]{MobEffects.field_76428_l, MobEffects.field_76419_f}, 100, true);
      ITEM_HEROIN_JOINT = new DrugItem("item_heroin_joint", new Potion[]{MobEffects.field_76428_l, MobEffects.field_76424_c}, 200, true);
      ITEM_STRAW = new DrugHelper("item_straw", 100, new Potion[]{MobEffects.field_76420_g}, false);
      ITEM_TOBACCO_PIPE = new DrugHelper("item_pipe_tobacco", 100, new Potion[]{MobEffects.field_76419_f}, true);
      ITEM_OPIUM_PIPE = new DrugHelper("item_pipe_opium", 100, new Potion[]{MobEffects.field_76421_d}, true);
      DOPE = EnumHelper.addArmorMaterial("armor_material_dope", "drugmod:dope", 364, new int[]{3, 6, 8, 3}, 15, SoundEvents.field_187716_o, 0.0F);
      DOPE_HELMET = new ArmorBase("dope_helmet", DOPE, 1, EntityEquipmentSlot.HEAD);
   }
}
