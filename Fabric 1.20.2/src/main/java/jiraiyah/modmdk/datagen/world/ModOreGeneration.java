package jiraiyah.modmdk.datagen.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration
{
    public static void generateOres()
    {
        //region OVERWORLD
        /*BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_CITRINE_PLACED_KEY);*/
        //endregion

        //region NETHER
        /*BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_NETHER_CITRINE_PLACED_KEY);*/
        //endregion

        //region END
        /*BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_END_CITRINE_PLACED_KEY);*/
        //endregion

        /*BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RED_MAPLE_PLACED_KEY);*/
    }
}