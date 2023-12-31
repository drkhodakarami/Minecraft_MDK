package jiraiyah.modmdk.block.entity;

/*
public class SampleBE extends BEWithInventory implements PropertyDelegateHolder
{
    public static final int TOTAL_SLOTS = 4;

    public static final int BASE_INPUT_SLOT = 0;
    public static final int BASE_OUTPUT_SLOT = 1;
    public static final int FLUID_INPUT_SLOT = 2;
    public static final int FLUID_OUTPUT_SLOT = 3;

    public static final int DELEGATE_SIZE = 2;

    public static long FLUID_CAPACITY = FluidStack.convertDropletsToMb(FluidConstants.BLOCK) * 20; // 20k mb
    public static final int FLUID_PER_CRAFT = 125; //mb amount

    public final SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<FluidVariant>()
    {
        @Override
        protected FluidVariant getBlankVariant()
        {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant)
        {
            return FLUID_CAPACITY;
        }

        @Override
        protected void onFinalCommit()
        {
            markDirty();

            if (!world.isClient())
            {
                sendFluidPacket();
            }
        }
    };

    protected final PropertyDelegate propertyDelegate;

    public SampleBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.GEM_CLEANSER, pos, state);
        this.propertyDelegate = new PropertyDelegate()
        {
            @Override
            public int get(int index)
            {
                return switch (index)
                {
                    case 0 -> SampleBE.this.progress;
                    case 1 -> SampleBE.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value)
            {
                switch (index)
                {
                    case 0 -> SampleBE.this.progress = value;
                    case 1 -> SampleBE.this.maxProgress = value;
                }
            }

            @Override
            public int size()
            {
                return 2;
            }
        };
    }

    @Override
    public PropertyDelegate getPropertyDelegate()
    {
        return this.propertyDelegate;
    }

    public ItemStack getRenderStack()
    {
        if (this.getStack(BASE_OUTPUT_SLOT).isEmpty())
            return this.getStack(BASE_INPUT_SLOT);
        return this.getStack(BASE_OUTPUT_SLOT);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        sendFluidPacket();
        return new SampleScreenDescription(syncId, playerInventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side)
    {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(GemCleanserBlock.FACING);

        // TOP --> RAW SLOT

        if (side == Direction.UP)
            return slot == BASE_INPUT_SLOT && StackAcceptableInSlot(stack, slot);
        if (side == Direction.DOWN)
            return false;

        // RIGHT --> TOOL SLOTS
        // LEFT --> LIQUIDATION SLOT

        return switch (localDir)
        {
            default -> side.getOpposite() == Direction.NORTH && slot == BASE_INPUT_SLOT && StackAcceptableInSlot(stack, slot) || // TOP
                    */
/*side.getOpposite() == Direction.EAST && slot == MAIN_TOOL_SLOT && StackAcceptableInSlot(stack, slot) || //RIGHT*//*

                    side.getOpposite() == Direction.WEST && slot == FLUID_INPUT_SLOT && StackAcceptableInSlot(stack, slot); // LEFT
            case EAST -> side.rotateYClockwise() == Direction.NORTH && slot == BASE_INPUT_SLOT && StackAcceptableInSlot(stack, slot) || // TOP
                    */
/*side.rotateYClockwise() == Direction.EAST && slot == MAIN_TOOL_SLOT && StackAcceptableInSlot(stack, slot) || //RIGHT*//*

                    side.rotateYClockwise() == Direction.WEST && slot == FLUID_INPUT_SLOT && StackAcceptableInSlot(stack, slot); // LEFT
            case SOUTH -> side == Direction.NORTH && slot == BASE_INPUT_SLOT && StackAcceptableInSlot(stack, slot) || // TOP
                    */
/*side == Direction.EAST && slot == MAIN_TOOL_SLOT && StackAcceptableInSlot(stack, slot) || //RIGHT*//*

                    side == Direction.WEST && slot == FLUID_INPUT_SLOT && StackAcceptableInSlot(stack, slot); // LEFT
            case WEST -> side.rotateYCounterclockwise() == Direction.NORTH && slot == BASE_INPUT_SLOT && StackAcceptableInSlot(stack, slot) || // TOP
                    */
/*side.rotateYCounterclockwise() == Direction.EAST && slot == MAIN_TOOL_SLOT && StackAcceptableInSlot(stack, slot) || //RIGHT*//*

                    side.rotateYCounterclockwise() == Direction.WEST && slot == FLUID_INPUT_SLOT && StackAcceptableInSlot(stack, slot); // LEFT
        };

    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side)
    {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(GemCleanserBlock.FACING);
        if (side == Direction.DOWN)
            return slot == BASE_OUTPUT_SLOT || slot == FLUID_OUTPUT_SLOT;

        return switch (localDir)
        {
            default -> side.getOpposite() == Direction.SOUTH && (slot == BASE_OUTPUT_SLOT || slot == FLUID_OUTPUT_SLOT);
            case EAST -> side.rotateYClockwise() == Direction.SOUTH && (slot == BASE_OUTPUT_SLOT || slot == FLUID_OUTPUT_SLOT);
            case SOUTH -> side == Direction.SOUTH && (slot == BASE_OUTPUT_SLOT || slot == FLUID_OUTPUT_SLOT);
            case WEST -> side.rotateYCounterclockwise() == Direction.SOUTH && (slot == BASE_OUTPUT_SLOT || slot == FLUID_OUTPUT_SLOT);
        };
    }

    @Override
    public void setFluidLevel(FluidVariant fluidVariant, long fluidLevel)
    {
        this.fluidStorage.variant = fluidVariant;
        this.fluidStorage.amount = fluidLevel;
    }

    @Override
    protected void writeNbt(NbtCompound nbt)
    {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("atm.infusing_station.progress", progress);
        nbt.put("atm.infusing_station.fluid_variant", fluidStorage.variant.toNbt());
        nbt.putLong("atm.infusing_station.fluid_level", fluidStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt)
    {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("atm.infusing_station.progress");
        fluidStorage.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("atm.infusing_station.fluid_variant"));
        fluidStorage.amount = nbt.getLong("atm.infusing_station.fluid_level");
    }

    @Override
    protected int totalSlots()
    {
        return TOTAL_SLOTS;
    }

    @Override
    protected void handleFluidTick(World world, BlockPos pos, BlockState state)
    {
        if (!this.isTankEmpty(this.fluidStorage) && isLiquidOutputReceivable(FLUID_OUTPUT_SLOT))
        {
            if (this.isItemStackEmptyBucket(FLUID_INPUT_SLOT))
            {
                this.transferFromFluidTank(this.fluidStorage, Fluids.WATER, Items.WATER_BUCKET, FLUID_INPUT_SLOT, FLUID_OUTPUT_SLOT);
                markDirty(world, pos, state);
            }
        }
        if ((this.isTankEmpty(this.fluidStorage) || this.isTankReceivable(this.fluidStorage)) && isLiquidOutputReceivable(FLUID_OUTPUT_SLOT))
        {
            if (this.hasFluidSourceInSlot(FLUID_INPUT_SLOT, Items.WATER_BUCKET))
            {
                if (this.isItemStackCompatibleWithTank(this.fluidStorage, Fluids.WATER, Items.WATER_BUCKET, FLUID_INPUT_SLOT))
                {
                    if (this.isItemStackLiquidBucket(FLUID_INPUT_SLOT, Items.WATER_BUCKET))
                        this.transferToFluidTank(this.fluidStorage, Fluids.WATER, Items.BUCKET, FLUID_INPUT_SLOT, FLUID_OUTPUT_SLOT);
                    markDirty(world, pos, state);
                }
            }
        }
    }

    @Override
    protected void handleItemCraftingTick(World world, BlockPos pos, BlockState state)
    {
        if (this.isOutputSlotEmptyOrReceivable(BASE_OUTPUT_SLOT))
        {
            if (this.hasRecipe(ModRecipes.INFUSING_STATION_TYPE, BASE_OUTPUT_SLOT))
            {
                if (this.shouldUseFluid() &&
                    this.hasEnoughFluid(this.fluidStorage, FLUID_PER_CRAFT) &&
                    this.fluidIsAcceptable(this.fluidStorage, Fluids.WATER))
                {
                    this.increaseCraftProgress();
                    if (hasCraftingFinished())
                    {
                        this.useFluid(this.fluidStorage, FLUID_PER_CRAFT);
                        this.craftItem(ModRecipes.INFUSING_STATION_TYPE, BASE_INPUT_SLOT, BASE_OUTPUT_SLOT);
                        this.resetProgress();
                    }
                    markDirty(world, pos, state);
                }
            }
            else
                this.resetProgress();
        }
        else
        {
            if (this.progress != 0)
            {
                this.resetProgress();
                markDirty(world, pos, state);
            }
        }
    }

    @Override
    protected void handleEnergyCreationTick(World world, BlockPos pos, BlockState state)
    {
        */
/*if((this.isCapacitorEmpty() || this.isCapacitorReceivable()) &&
                isEnergyOutputReceivable())
        {
            if(this.hasEnergySourceInSlot())
            {
                // check if fuel source is battery
                // check if batter still has charge
                // reduce energy from battery and add to capacitor
                // if battery is empty, put to output slot

                // if fuel is not battery
                // burn the fuel
                // start fueling timer
                // check if timer is greater than zero
                // give energy to capacitor
                markDirty(world, pos, state);
            }
            if(!this.isCapacitorEmpty() && isEnergyChargingOutputReceivable())
            {
                // check if input is battery and can charge
                // charge the battery
                // check if battery if full
                // if full, put to output slot
                markDirty(world, pos, state);
            }
        }*//*

    }

    @Override
    protected boolean hasFluidSourceInSlot(int slotIndex, Item item)
    {
        return getStack(slotIndex).isOf(item);
    }

    @Override
    protected boolean shouldUseFluid()
    {
        return true;
    }

    //region PRIVATE METHODS
    private boolean StackAcceptableInSlot(ItemStack stack, int slot)
    {
        if (slot == BASE_INPUT_SLOT)
            return StackIsRawGem(stack);
        if (slot == FLUID_INPUT_SLOT)
            return StackIsLiquidable(stack);
        return false;
    }

    private boolean StackIsLiquidable(ItemStack stack)
    {
        return stack.isOf(Items.WATER_BUCKET);
    }

    private boolean StackIsRawGem(ItemStack stack)
    {
        return stack.isOf(ModItems.RAW_SAPPHIRE) ||
                stack.isOf(ModItems.RAW_RUBY) ||
                stack.isOf(ModItems.RAW_CITRINE) ||
                stack.isOf(ModItems.RAW_ENDERITE);
    }

    private void sendFluidPacket()
    {
        PacketByteBuf data = PacketByteBufs.create();
        fluidStorage.variant.toPacket(data);
        data.writeLong(fluidStorage.amount);
        data.writeBlockPos(getPos());
        ModMessages.sendToServerPlayerEntities(world, getPos(), ModMessages.INFUSING_STATION_FLUID_SYNC, data);
    }
    //endregion
}*/