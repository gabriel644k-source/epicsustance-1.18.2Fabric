package drugmod;

import drugmod.Init.BlockList;
import drugmod.Init.ColorList;
import drugmod.Init.ItemList;
import drugmod.Init.RecipeList;
import drugmod.Proxy.CommonProxy;
import drugmod.Stuff.Class.CreativeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(
   modid = "drugmod",
   name = "Drug Mod",
   version = "1.8",
   acceptedMinecraftVersions = "[1.12.2]"
)
public class Main {
   public static final CreativeTabs CREATIVE_TAB = new CreativeTab("tab_drugmod");
   @Instance
   public static Main instance;
   @SidedProxy(
      clientSide = "drugmod.Proxy.ClientProxy",
      serverSide = "drugmod.Proxy.CommonProxy"
   )
   public static CommonProxy proxy;

   @EventHandler
   public static void Init(FMLInitializationEvent Event) {
      BlockList.Go();
      ItemList.Go();
      RecipeList.Go();
   }

   @SideOnly(Side.CLIENT)
   @EventHandler
   public static void ClientInit(FMLInitializationEvent Event) {
      ColorList.Go();
   }
}
