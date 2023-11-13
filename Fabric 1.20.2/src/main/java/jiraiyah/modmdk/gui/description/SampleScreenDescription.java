package jiraiyah.modmdk.gui.description;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import jiraiyah.modmdk.block.ModBlocks;
import jiraiyah.modmdk.gui.ModScreenHandlers;
import jiraiyah.modmdk.utils.fluid.FluidStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

/*
public class SampleScreenDescription extends SyncedGuiDescription
{
    private final ScreenHandlerContext context;

    //public GemCleanserBE loaderEntity;
    public FluidStack fluidStack;

    public SampleScreenDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context)
    {
        super(ModScreenHandlers.SAMPLE_SCREEN_DESCRIPTION, syncId, playerInventory, getBlockInventory(context, SampleBE.TOTAL_SLOTS), getBlockPropertyDelegate(context, SampleBE.DELEGATE_SIZE));

        this.context = context;

        //this.context.run((world, pos) -> loaderEntity = (GemCleanserBE) world.getBlockEntity(pos));
        //this.fluidStack = new FluidStack(loaderEntity.fluidStorage.variant, loaderEntity.fluidStorage.amount);

        this.setTitleVisible(false);

        WPlainPanel  root = new WPlainPanel ();
        setRootPanel(root);

        root.setSize(200, 178);
        root.setInsets(Insets.ROOT_PANEL);

        //WItemSlot base_input_slot = WItemSlot.of(blockInventory, GemCleanserBE.BASE_INPUT_SLOT);
        //WItemSlot base_output_slot = WItemSlot.of(blockInventory, GemCleanserBE.BASE_OUTPUT_SLOT);

        //base_input_slot.setInputFilter(itemStack -> itemStack.isOf(ModItems.RAW_ENDERITE));
        //base_output_slot.setInsertingAllowed(false);

        */
/*WBar progressBar = new WBar(ModMain.identifier("textures/gui/empty_vertical_progress.png"),
                ModMain.identifier("textures/gui/full_vertical_progress.png"),
                0, 1, WBar.Direction.DOWN);// <<< 0 and 1 are indices in the PropertyDelegate*//*


        */
/*WSprite fluidBackground = new WSprite(ModMain.identifier("textures/gui/fluid_tank_background.png"));*//*


        //root.add(base_input_slot, 116, 14);
        //root.add(base_output_slot, 116, 59);

        //progressBar.setProperties(this.propertyDelegate);

        //root.add(progressBar, 135, 33, 8, 26);
        //root.add(fluidBackground, 85, 14, 18, 63);
        root.add(this.createPlayerInventoryPanel(), 7, 85);

        root.validate(this);
    }

    @Override
    public boolean canUse(PlayerEntity entity)
    {
        return canUse(this.context, entity, ModBlocks.GEM_CLEANSER);
    }

    public void setFluid(FluidStack stack)
    {
        fluidStack = stack;
    }
}*/