package jiraiyah.modmdk.datagen;

import jiraiyah.modmdk.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider
{

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture)
    {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg)
    {
        // CUSTOM MOD TAG
        //getOrCreateTagBuilder(Reference.Tags.Items.CASTS);

        getOrCreateTagBuilder(ItemTags.AXES);

        getOrCreateTagBuilder(ItemTags.HOES);

        getOrCreateTagBuilder(ItemTags.PICKAXES);

        getOrCreateTagBuilder(ItemTags.SHOVELS);

        getOrCreateTagBuilder(ItemTags.SWORDS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR);
    }
}