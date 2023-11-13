package jiraiyah.modmdk.block;

import jiraiyah.modmdk.Reference;

public class ModBlockEntities
{
    /*public static BlockEntityType<GemCleanserBE> GEM_CLEANSER =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Reference.MOD_ID + ":" + GemCleanserBlock.ID.getPath(),
                    FabricBlockEntityTypeBuilder.create(GemCleanserBE::new, ModBlocks.GEM_CLEANSER).build());*/

    public ModBlockEntities()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        Reference.LOGGER.info(">>> Registering Block Entities");

        //FluidStorage.SIDED.registerForBlockEntity((entity, direction) -> entity.fluidStorage, GEM_CLEANSER);
    }
}