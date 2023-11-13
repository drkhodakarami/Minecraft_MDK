package jiraiyah.modmdk;

import jiraiyah.modmdk.networking.ModMessages;
import jiraiyah.modmdk.utils.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;

public class ModClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        ModMessages.registerS2CPackets();

        //region SCREEN REGISTRATION
        //noinspection RedundantTypeArguments
        /*HandledScreens.<GemCleanserScreenHandler, GemCleanserScreen>register(ModScreenHandlers.GEM_CLEANSER_SCREEN_HANDLER,
                (gui, inventory, title) -> new GemCleanserScreen(gui, inventory.player, title));*/
        //endregion

        //region BLOCK ENTITY RENDERER REGISTRATION
        //BlockEntityRendererFactories.register(ModBlockEntities.GEM_CLEANSER, GemCleanserBERenderer::new);
        //endregion

        //region FLUID REGISTRATION
        /*FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MOLTEN_ENDERITE, ModFluids.FLOWING_MOLTEN_ENDERITE,
                new SimpleFluidRenderHandler(
                        ModMain.identifier("block/liquid"),
                        ModMain.identifier("block/liquid_flow"),
                        0xA10C5E7C));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_MOLTEN_ENDERITE, ModFluids.FLOWING_MOLTEN_ENDERITE);*/
        //endregion

        ModModelPredicateProvider.registerModels();
    }
}