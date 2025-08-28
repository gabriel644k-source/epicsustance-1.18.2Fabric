package drugmod.Stuff;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Type;

@Config(
   modid = "drugmod",
   name = "drugmod",
   type = Type.INSTANCE
)
public class Configuration {
   public static boolean DRUG_NAUSEA = true;
   public static boolean DRUG_SMOKE = true;
}
