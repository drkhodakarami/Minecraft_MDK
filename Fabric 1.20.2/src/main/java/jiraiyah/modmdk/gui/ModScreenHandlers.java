package jiraiyah.modmdk.gui;

import jiraiyah.modmdk.Reference;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers
{
    // VANILLA SCREENS
    /*public static ScreenHandlerType<EnderiteShulkerScreenHandler> ENDERITE_SCREEN_HANDLER_TYPE =
            Registry.register(Registries.SCREEN_HANDLER, Reference.id("enderiteshulker"),
                    new ExtendedScreenHandlerType<>(EnderiteShulkerScreenHandler::new));*/

    // LIB GUI SCREENS
    public static ScreenHandlerType SAMPLE_SCREEN_DESCRIPTION;/* = Registry.register(Registries.SCREEN_HANDLER, Reference.id("screen"),
            new ExtendedScreenHandlerType((syncId, inventory, buf) -> new SampleScreenDescription(syncId, inventory,
                ScreenHandlerContext.create(inventory.player.getWorld(), buf.readBlockPos()))));*/

    public static void register()
    {
        Reference.LOGGER.info(">>> Registering Screen Handlers");

        // OLD WAY, MARKED DEPRICATED
        /*SAMPLE_SCREEN_DESCRIPTION = ScreenHandlerRegistry.registerExtended(GemCleanserBlock.ID,
                (syncId, inventory, buf) -> new SampleScreenDescription(syncId, inventory,
                        ScreenHandlerContext.create(inventory.player.getWorld(), buf.readBlockPos())));*/
    }
}