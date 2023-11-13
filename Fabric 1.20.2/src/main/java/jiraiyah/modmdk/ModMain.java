package jiraiyah.modmdk;

import jiraiyah.modmdk.block.ModBlocks;
import jiraiyah.modmdk.block.ModBlockEntities;
import jiraiyah.modmdk.command.ModCommands;
import jiraiyah.modmdk.datagen.world.ModWorldGeneration;
import jiraiyah.modmdk.fluid.ModFluids;
import jiraiyah.modmdk.item.ModItemGroups;
import jiraiyah.modmdk.item.ModItems;
import jiraiyah.modmdk.networking.ModMessages;
import jiraiyah.modmdk.recipe.ModRecipes;
import jiraiyah.modmdk.gui.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;

// This is the flat world gen custom preset I always use
// 5*minecraft:bedrock,30*minecraft:light_blue_wool,minecraft:light_blue_carpet;minecraft:plains;village

public class ModMain implements ModInitializer
{


    @Override
    public void onInitialize()
    {
        Reference.LOGGER.info(">>> Initializing : " + Reference.MOD_ID);

        /*ServerWorldEvents.LOAD.register((world, entity) ->
        {
            var server = world.getOverworld().getServer();
            ModStatsHandler stats = ModStatsHandler.getServerState(server);
            if (!stats.worldCreated)
            {
                BlockState blockState;

                var blockStates = BlockPos.iterate(-500, 40, -500, 500, 130, 500);
                var overworld = world.getOverworld();

                for (var position : blockStates)
                {
                    blockState = overworld.getBlockState(position);
                    if (blockState.isOf(Blocks.GRASS) || blockState.isOf(Blocks.TALL_GRASS))
                        overworld.setBlockState(position, Blocks.AIR.getDefaultState());
                }
                stats.worldCreated = true;
                stats.markDirty();
            }
        });*/

        ModTicker.initialize();
        ModItems.register();
        ModBlocks.register();
        ModItemGroups.register();
        ModCommands.register();
        ModBlockEntities.register();
        ModScreenHandlers.register();
        ModRecipes.register();
        ModWorldGeneration.generateModWorldGen();
        ModMessages.registerC2SPackets();

        ModFluids.register();
    }


}