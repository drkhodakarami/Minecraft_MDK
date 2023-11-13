package jiraiyah.modmdk.datagen;

import jiraiyah.modmdk.block.ModBlocks;
import jiraiyah.modmdk.fluid.ModFluids;
import jiraiyah.modmdk.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider
{
    public ModModelProvider(FabricDataOutput output)
    {
        super(output);
    }

    /**
     * The method to create BLOCK MODELS
     *
     * @param blockStateModelGenerator
     */
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CITRINE);

        //blockStateModelGenerator.registerSingleton(ModBlocks.ORE_ENDERITE, TexturedModel.CUBE_BOTTOM_TOP);
    }

    /**
     * The method to create ITEM MODELS
     *
     * @param itemModelGenerator
     */
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        //itemModelGenerator.register(ModItems.CITRINE, Models.GENERATED);

        //region TOOLS
        /*itemModelGenerator.register(ModItems.TOOL_CITRINE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_CITRINE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_CITRINE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_CITRINE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_CITRINE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_CITRINE_SWORD, Models.HANDHELD);*/
        //endregion

        //region ARMOR
        /*itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_AMETHYST_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_AMETHYST_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_AMETHYST_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_AMETHYST_BOOTS));*/
        //endregion
    }
}