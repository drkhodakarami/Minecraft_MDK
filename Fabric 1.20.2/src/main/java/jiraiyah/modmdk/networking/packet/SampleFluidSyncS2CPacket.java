package jiraiyah.modmdk.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class SampleFluidSyncS2CPacket
{
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender)
    {
        /*FluidVariant variant = FluidVariant.fromPacket(buf);
        long fluidLevel = buf.readLong();
        BlockPos position = buf.readBlockPos();

        if (client.world.getBlockEntity(position) instanceof GemCleanserBE blockEntity)
        {
            blockEntity.setFluidLevel(variant, fluidLevel);

            if (client.player.currentScreenHandler instanceof SampleScreenDescription screenHandler &&
                    screenHandler.loaderEntity.getPos().equals(position))
            {
                blockEntity.setFluidLevel(variant, fluidLevel);
                screenHandler.setFluid(new FluidStack(variant, fluidLevel));
            }
        }*/
    }
}