package jiraiyah.modmdk.compat;

import jiraiyah.modmdk.block.ModBlocks;
import jiraiyah.modmdk.recipe.ModRecipes;
import jiraiyah.modmdk.recipe.custom.SampleRecipe;
import jiraiyah.modmdk.gui.screen.SampleScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class ModREIClientPlugin implements REIClientPlugin
{
    @Override
    public void registerCategories(CategoryRegistry registry)
    {
        //registry.add(new GemCleanserCategory());
        //registry.addWorkstations(GemCleanserCategory.GEM_CLEANSER, EntryStacks.of(ModBlocks.GEM_CLEANSER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry)
    {
        //registry.registerRecipeFiller(SampleRecipe.class, ModRecipes.INFUSING_STATION_TYPE, GemCleanserDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry)
    {
        /*registry.registerClickArea(screen ->
                        new Rectangle(75, 30, 20, 30),
                SampleScreen.class, GemCleanserCategory.GEM_CLEANSER);*/
    }
}