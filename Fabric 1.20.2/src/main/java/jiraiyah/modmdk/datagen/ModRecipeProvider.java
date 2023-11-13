package jiraiyah.modmdk.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;

public class ModRecipeProvider extends FabricRecipeProvider
{
    /*private static final List<ItemConvertible> CITRINE_SMELTABLES = List.of(
            ModItems.RAW_CITRINE,
            ModBlocks.ORE_WORLD_CITRINE
    );*/

    public ModRecipeProvider(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter)
    {
        //offerSmelting(exporter, CITRINE_SMELTABLES, RecipeCategory.MISC, ModItems.CITRINE, 0.7f, 200, "citrine");
        //offerBlasting(exporter, CITRINE_SMELTABLES, RecipeCategory.MISC, ModItems.CITRINE, 0.7f, 100, "citrine");

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.CITRINE, RecipeCategory.DECORATIONS, ModBlocks.CITRINE);
        //offerFoodCookingRecipe(exporter, "smoking", RecipeSerializer.SMOKING, 400, Items.ROTTEN_FLESH, Items.LEATHER, 0.1F);
        //offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, 800, Items.ROTTEN_FLESH, Items.LEATHER, 0.1F);

        /*ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SHULKER_NORMAL, 1)
                .pattern(" E ")
                .pattern("ESE")
                .pattern(" E ")
                .input('E', ModItems.ENDERITE)
                .input('S', Items.SHULKER_BOX)
                .criterion(hasItem(Items.SHULKER_BOX), conditionsFromItem(Items.SHULKER_BOX))
                .criterion(hasItem(ModItems.ENDERITE), conditionsFromItem(ModItems.ENDERITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SHULKER_NORMAL)));*/

        /*ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SHULKER_BLACK, 1)
                .input(ModBlocks.SHULKER_NORMAL)
                .input(Items.BLACK_DYE)
                .criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE))
                .criterion(hasItem(ModBlocks.SHULKER_NORMAL), conditionsFromItem(ModBlocks.SHULKER_NORMAL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SHULKER_BLACK) + "shapeless"));*/
    }
}