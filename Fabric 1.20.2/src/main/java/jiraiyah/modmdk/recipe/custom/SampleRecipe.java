package jiraiyah.modmdk.recipe.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import java.util.List;

public class SampleRecipe implements Recipe<Inventory>
{
    private final ItemStack output;
    private final List<Ingredient> recipeItems;

    public SampleRecipe(List<Ingredient> ingredients, ItemStack itemStack)
    {
        this.output = itemStack;
        this.recipeItems = ingredients;
    }

    @Override
    public boolean matches(Inventory inventory, World world)
    {
        if (world.isClient())
            return false;

        //return recipeItems.get(0).test(inventory.getStack(GemCleanserBE.BASE_INPUT_SLOT));
        return false;
    }

    @Override
    public ItemStack craft(Inventory inventory, DynamicRegistryManager registryManager)
    {
        return output;
    }

    @Override
    public boolean fits(int width, int height)
    {
        return true;
    }

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager)
    {
        return output;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients()
    {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(this.recipeItems.size());
        list.addAll(recipeItems);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        //return ModRecipes.INFUSING_STATION_SERIALIZER;
        return null;
    }

    @Override
    public RecipeType<?> getType()
    {
        //return ModRecipes.INFUSING_STATION_TYPE;
        return null;
    }

    public static class Serializer implements RecipeSerializer<SampleRecipe>
    {
        public static final Codec<SampleRecipe> CODEC = RecordCodecBuilder.create(in ->
                in.group(validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 9) //<<< maybe you need more than 9 ingredients, then change
                                .fieldOf("ingredients").forGetter(SampleRecipe::getIngredients),
                        RecipeCodecs.CRAFTING_RESULT.fieldOf("output").forGetter(r -> r.output)
                ).apply(in, SampleRecipe::new));

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max)
        {
            return Codecs.validate(Codecs.validate(
                    delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
        }

        @Override
        public Codec<SampleRecipe> codec()
        {
            return CODEC;
        }

        @Override
        public SampleRecipe read(PacketByteBuf buf)
        {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++)
                inputs.set(i, Ingredient.fromPacket(buf));

            ItemStack output = buf.readItemStack();
            return new SampleRecipe(inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, SampleRecipe recipe)
        {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients())
                ingredient.write(buf);

            buf.writeItemStack(recipe.getResult(null));
        }
    }
}