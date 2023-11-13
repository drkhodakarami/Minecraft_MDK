package jiraiyah.modmdk.recipe;

import jiraiyah.modmdk.Reference;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModRecipes
{
    //public static final RecipeType<GemCleanserRecipe> INFUSING_STATION_TYPE = new RecipeType<>(){};
    //public static final RecipeSerializer<GemCleanserRecipe> INFUSING_STATION_SERIALIZER = new GemCleanserRecipe.Serializer();

    private ModRecipes()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        Reference.LOGGER.info(">>> Registering Recipes");

        //register("gem_cleanser", INFUSING_STATION_TYPE);
        //register("gem_cleanser", INFUSING_STATION_SERIALIZER);
    }

    private static void register(String name, RecipeSerializer<?> serializer)
    {
        Registry.register(Registries.RECIPE_SERIALIZER, Reference.id(name), serializer);
    }

    private static void register(String name, RecipeType<?> serializer)
    {
        Registry.register(Registries.RECIPE_TYPE, Reference.id(name), serializer);
    }
}