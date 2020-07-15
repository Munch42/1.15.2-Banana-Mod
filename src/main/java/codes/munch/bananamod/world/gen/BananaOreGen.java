package codes.munch.bananamod.world.gen;

import codes.munch.bananamod.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class BananaOreGen {
    public static void generateOre(){
        for(Biome biome : ForgeRegistries.BIOMES){
            // To spawn in a specific biome/to check a specific one
            /* if(biome == Biomes.PLAINS){

            }*/

            // count: how common it is, 20 is REALLY common more than coal. bottomOffset: offset from bottom of the world basically lowest level it can be found I think
            // topOffset is how far down from the top. maximum is basically the max height it can generate, take away the topOffset so I think 25 and a 5 topOffset would be 20.
            ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 5, 5, 25));

            // The Filler is the type of what it spawns in I think. After the block itself, is the max size of the vein
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.banana_ore_block.getDefaultState(), 10))
                    .withPlacement(customConfig));
        }
    }
}
