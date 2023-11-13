package jiraiyah.modmdk.block;

import jiraiyah.modmdk.Reference;
import jiraiyah.modmdk.block.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks
{
    //region CUSTOM BLOCKS
    /*public static final Block CITRINE = registerBlock("block_citrine",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));*/
    //endregion

    public static final SampleBlock GEM_CLEANSER = (SampleBlock) registerBlock("gem_cleanser",
            new SampleBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    private ModBlocks()
    {
        throw new AssertionError();
    }

    //region Helper Methods
    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Reference.id(name), block);
    }

    private static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, Reference.id(name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void register()
    {
        Reference.LOGGER.info(">>> Registering Blocks");
    }
    //endregion
}