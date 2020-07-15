package net.minecraft.world.gen.feature.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.jigsaw.EmptyJigsawPiece;
import net.minecraft.world.gen.feature.jigsaw.FeatureJigsawPiece;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.template.AlwaysTrueRuleTest;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.BlockStateMatchRuleTest;
import net.minecraft.world.gen.feature.template.RandomBlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleEntry;
import net.minecraft.world.gen.feature.template.RuleStructureProcessor;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;

public class SnowyVillagePools {
   public static void init() {
   }

   static {
      ImmutableList<StructureProcessor> immutablelist = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new TagMatchRuleTest(BlockTags.DOORS), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.TORCH), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.WALL_TORCH), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.LANTERN), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.SPRUCE_PLANKS, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.SPRUCE_SLAB, 0.4F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STRIPPED_SPRUCE_LOG, 0.05F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STRIPPED_SPRUCE_WOOD, 0.05F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GLASS_PANE, 0.5F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.NORTH, Boolean.valueOf(true)).with(PaneBlock.SOUTH, Boolean.valueOf(true))), AlwaysTrueRuleTest.INSTANCE, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.NORTH, Boolean.valueOf(true)).with(PaneBlock.SOUTH, Boolean.valueOf(true))), new RuleEntry(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.EAST, Boolean.valueOf(true)).with(PaneBlock.WEST, Boolean.valueOf(true))), AlwaysTrueRuleTest.INSTANCE, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.EAST, Boolean.valueOf(true)).with(PaneBlock.WEST, Boolean.valueOf(true))), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.CARROTS.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.8F), AlwaysTrueRuleTest.INSTANCE, Blocks.POTATOES.getDefaultState()))));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/snowy/town_centers"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/snowy/town_centers/snowy_meeting_point_1"), 100), new Pair<>(new SingleJigsawPiece("village/snowy/town_centers/snowy_meeting_point_2"), 50), new Pair<>(new SingleJigsawPiece("village/snowy/town_centers/snowy_meeting_point_3"), 150), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/town_centers/snowy_meeting_point_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/town_centers/snowy_meeting_point_2"), 1), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/town_centers/snowy_meeting_point_3"), 3)), JigsawPattern.PlacementBehaviour.RIGID));
      ImmutableList<StructureProcessor> immutablelist1 = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new BlockMatchRuleTest(Blocks.GRASS_PATH), new BlockMatchRuleTest(Blocks.WATER), Blocks.SPRUCE_PLANKS.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GRASS_PATH, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.GRASS_BLOCK.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.GRASS_BLOCK), new BlockMatchRuleTest(Blocks.WATER), Blocks.WATER.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.DIRT), new BlockMatchRuleTest(Blocks.WATER), Blocks.WATER.getDefaultState()))));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/snowy/streets"), new ResourceLocation("village/snowy/terminators"), ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/snowy/streets/corner_01", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/streets/corner_02", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/streets/corner_03", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/streets/square_01", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/streets/straight_01", immutablelist1), 4), new Pair<>(new SingleJigsawPiece("village/snowy/streets/straight_02", immutablelist1), 4), new Pair<>(new SingleJigsawPiece("village/snowy/streets/straight_03", immutablelist1), 4), new Pair<>(new SingleJigsawPiece("village/snowy/streets/straight_04", immutablelist1), 7), new Pair<>(new SingleJigsawPiece("village/snowy/streets/straight_06", immutablelist1), 4), new Pair<>(new SingleJigsawPiece("village/snowy/streets/straight_08", immutablelist1), 4), new Pair<>(new SingleJigsawPiece("village/snowy/streets/crossroad_02", immutablelist1), 1), new Pair<>(new SingleJigsawPiece("village/snowy/streets/crossroad_03", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/streets/crossroad_04", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/streets/crossroad_05", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/streets/crossroad_06", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/streets/turn_01", immutablelist1), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/snowy/zombie/streets"), new ResourceLocation("village/snowy/terminators"), ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/corner_01", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/corner_02", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/corner_03", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/square_01", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/straight_01", immutablelist1), 4), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/straight_02", immutablelist1), 4), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/straight_03", immutablelist1), 4), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/straight_04", immutablelist1), 7), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/straight_06", immutablelist1), 4), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/straight_08", immutablelist1), 4), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/crossroad_02", immutablelist1), 1), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/crossroad_03", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/crossroad_04", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/crossroad_05", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/crossroad_06", immutablelist1), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/streets/turn_01", immutablelist1), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      ImmutableList<StructureProcessor> immutablelist2 = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.CARROTS.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.8F), AlwaysTrueRuleTest.INSTANCE, Blocks.POTATOES.getDefaultState()))));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/snowy/houses"), new ResourceLocation("village/snowy/terminators"), ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_small_house_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_small_house_2"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_small_house_3"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_small_house_4"), 3), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_small_house_5"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_small_house_6"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_small_house_7"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_small_house_8"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_medium_house_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_medium_house_2"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_medium_house_3"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_butchers_shop_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_butchers_shop_2"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_tool_smith_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_fletcher_house_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_shepherds_house_1"), 3), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_armorer_house_1"), 1), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_armorer_house_2"), 1), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_fisher_cottage"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_tannery_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_cartographer_house_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_library_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_masons_house_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_masons_house_2"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_weapon_smith_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_temple_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_farm_1", immutablelist2), 3), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_farm_2", immutablelist2), 3), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_animal_pen_1"), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_animal_pen_2"), 2), Pair.of(EmptyJigsawPiece.INSTANCE, 6)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/snowy/zombie/houses"), new ResourceLocation("village/snowy/terminators"), ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/snowy/zombie/houses/snowy_small_house_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/houses/snowy_small_house_2", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/houses/snowy_small_house_3", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/houses/snowy_small_house_4", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/houses/snowy_small_house_5", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/houses/snowy_small_house_6", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/houses/snowy_small_house_7", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/houses/snowy_small_house_8", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/houses/snowy_medium_house_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/houses/snowy_medium_house_2", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/houses/snowy_medium_house_3", immutablelist), 1), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_butchers_shop_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_butchers_shop_2", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_tool_smith_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_fletcher_house_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_shepherds_house_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_armorer_house_1", immutablelist), 1), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_armorer_house_2", immutablelist), 1), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_fisher_cottage", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_tannery_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_cartographer_house_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_library_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_masons_house_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_masons_house_2", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_weapon_smith_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_temple_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_farm_1", immutablelist), 3), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_farm_2", immutablelist), 3), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_animal_pen_1", immutablelist), 2), new Pair<>(new SingleJigsawPiece("village/snowy/houses/snowy_animal_pen_2", immutablelist), 2), Pair.of(EmptyJigsawPiece.INSTANCE, 6)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/snowy/terminators"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/plains/terminators/terminator_01", immutablelist1), 1), new Pair<>(new SingleJigsawPiece("village/plains/terminators/terminator_02", immutablelist1), 1), new Pair<>(new SingleJigsawPiece("village/plains/terminators/terminator_03", immutablelist1), 1), new Pair<>(new SingleJigsawPiece("village/plains/terminators/terminator_04", immutablelist1), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/snowy/trees"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new FeatureJigsawPiece(Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG)), 1)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/snowy/decor"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/snowy/snowy_lamp_post_01"), 4), new Pair<>(new SingleJigsawPiece("village/snowy/snowy_lamp_post_02"), 4), new Pair<>(new SingleJigsawPiece("village/snowy/snowy_lamp_post_03"), 1), new Pair<>(new FeatureJigsawPiece(Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG)), 4), new Pair<>(new FeatureJigsawPiece(Feature.BLOCK_PILE.withConfiguration(DefaultBiomeFeatures.SNOW_PILE_CONFIG)), 4), new Pair<>(new FeatureJigsawPiece(Feature.BLOCK_PILE.withConfiguration(DefaultBiomeFeatures.BLUE_ICE_PILE_CONFIG)), 1), Pair.of(EmptyJigsawPiece.INSTANCE, 9)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/snowy/zombie/decor"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/snowy/snowy_lamp_post_01", immutablelist), 1), new Pair<>(new SingleJigsawPiece("village/snowy/snowy_lamp_post_02", immutablelist), 1), new Pair<>(new SingleJigsawPiece("village/snowy/snowy_lamp_post_03", immutablelist), 1), new Pair<>(new FeatureJigsawPiece(Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG)), 4), new Pair<>(new FeatureJigsawPiece(Feature.BLOCK_PILE.withConfiguration(DefaultBiomeFeatures.SNOW_PILE_CONFIG)), 4), new Pair<>(new FeatureJigsawPiece(Feature.BLOCK_PILE.withConfiguration(DefaultBiomeFeatures.BLUE_ICE_PILE_CONFIG)), 4), Pair.of(EmptyJigsawPiece.INSTANCE, 7)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/snowy/villagers"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/snowy/villagers/nitwit"), 1), new Pair<>(new SingleJigsawPiece("village/snowy/villagers/baby"), 1), new Pair<>(new SingleJigsawPiece("village/snowy/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/snowy/zombie/villagers"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/snowy/zombie/villagers/nitwit"), 1), new Pair<>(new SingleJigsawPiece("village/snowy/zombie/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));
   }
}