package jiraiyah.modmdk.datagen.world;

import jiraiyah.modmdk.ModMain;
import jiraiyah.modmdk.Reference;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures
{
    //public static final RegistryKey<PlacedFeature> ORE_CITRINE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, ModMain.identifier("ore_citrine_placed"));
    //public static final RegistryKey<PlacedFeature> ORE_NETHER_CITRINE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, ModMain.identifier("ore_nether_citrine_placed"));
    //public static final RegistryKey<PlacedFeature> ORE_END_CITRINE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, ModMain.identifier("ore_end_citrine_placed"));

    public static void bootstrap(Registerable<PlacedFeature> context)
    {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //region OVERWORLD
        /*register(context, ORE_CITRINE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_CITRINE_KEY),
                ModOrePlacement.modifiersWithCount(10, // Veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(55))));*/
        //endregion

        //region NETHER
        /*register(context, ORE_NETHER_CITRINE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_CITRINE_KEY),
                ModOrePlacement.modifiersWithCount(6, // Veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(32), YOffset.belowTop(5))));*/
        //endregion

        //region END
        /*register(context, ORE_END_CITRINE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_END_CITRINE_KEY),
                ModOrePlacement.modifiersWithCount(3, // Veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(50), YOffset.fixed(65))));*/
        //endregion
    }

    public static RegistryKey<PlacedFeature> registerKey(String name)
    {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Reference.id(name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers)
    {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context,
                                                                                   RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers)
    {
        register(context, key, configuration, List.of(modifiers));
    }
}