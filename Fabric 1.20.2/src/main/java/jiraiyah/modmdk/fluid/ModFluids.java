package jiraiyah.modmdk.fluid;

import jiraiyah.modmdk.Reference;

public class ModFluids
{
    /*public static FlowableFluid STILL_MOLTEN_ENDERITE = Registry.register(Registries.FLUID,
            ModMain.identifier("molten_enderite"),
            new MoltenEnderite.Still());
    public static FlowableFluid FLOWING_MOLTEN_ENDERITE = Registry.register(Registries.FLUID,
            ModMain.identifier("flowing_molten_enderite"),
            new MoltenEnderite.Flowing());

    public static Block MOLTEN_ENDERITE_BLOCK = Registry.register(Registries.BLOCK, "molten_ender_block",
            new FluidBlock(ModFluids.STILL_MOLTEN_ENDERITE, FabricBlockSettings.copyOf(Blocks.WATER)));

    public static Item MOLTEN_ENDERITE_BUCKET = Registry.register(Registries.ITEM, Reference.id("molten_enderite_bucket"),
            new BucketItem(ModFluids.STILL_MOLTEN_ENDERITE, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));*/

    public ModFluids()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        Reference.LOGGER.info(">>> Registering Fluids");
    }
}