package jiraiyah.modmdk.item;

import jiraiyah.modmdk.ModMain;
import jiraiyah.modmdk.Reference;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial
{
    /*AMETHYST("amethyst", 20, new int[]{2, 7, 5, 1}, 30,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            1.5f, 0.05f, () -> Ingredient.ofItems(Items.AMETHYST_SHARD)),*/
    ;

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability,
                     SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient)
    {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    @Override
    public int getDurability(ArmorItem.Type type)
    {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type)
    {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability()
    {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return this.repairIngredient.get();
    }

    @Override
    public String getName()
    {
        return Reference.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness()
    {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return this.knockbackResistance;
    }
}