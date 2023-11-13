package jiraiyah.modmdk.command;

import jiraiyah.modmdk.Reference;

public class ModCommands
{
    public static void register()
    {
        Reference.LOGGER.info(">>> Registering Commands");

        //CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, environment) -> LCLLocate.define(dispatcher));
    }
}