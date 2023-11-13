package jiraiyah.modmdk.datagen.world;

import jiraiyah.modmdk.ModMain;
import jiraiyah.modmdk.Reference;
import jiraiyah.modmdk.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures
{
    /*public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_CITRINE_KEY = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Reference.id("ore_citrine"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_NETHER_CITRINE_KEY = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Reference.id("ore_nether_citrine"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_END_CITRINE_KEY = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Reference.id("ore_end_citrine"));*/

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context)
    {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        //region OVERWORLD
        /*List<OreFeatureConfig.Target> overworldCitrineOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ORE_WORLD_CITRINE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepReplaceables, ModBlocks.ORE_DEEP_CITRINE.getDefaultState()));*/
        //endregion

        //region NETHER
        /*List<OreFeatureConfig.Target> netherCitrineOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.ORE_NETHER_CITRINE.getDefaultState()));*/

        //endregion

        //region END
        /*List<OreFeatureConfig.Target> endCitrineOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.ORE_END_CITRINE.getDefaultState()));*/
        //endregion


        // 3 : The number is vein size
        /*register(context, ORE_CITRINE_KEY, Feature.ORE, new OreFeatureConfig(overworldCitrineOres, 3));
        register(context, ORE_NETHER_CITRINE_KEY, Feature.ORE, new OreFeatureConfig(netherCitrineOres, 3));
        register(context, ORE_END_CITRINE_KEY, Feature.ORE, new OreFeatureConfig(endCitrineOres, 3));*/
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                   F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}