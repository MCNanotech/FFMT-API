package fr.minecraftforgefrance.ffmtlibs;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FFMTRegistry
{
    public static final int HELMET_TYPE = 0;
    public static final int CHESTPLATE_TYPE = 1;
    public static final int LEGGINS_TYPE = 2;
    public static final int BOOTS_TYPE = 3;

    public static final int AXE_TYPE = 0;
    public static final int SHOVEL_TYPE = 1;
    public static final int HOE_TYPE = 2;
    public static final int PICKAXE_TYPE = 3;
    public static final int SWORD_TYPE = 4;

    /**
     * Helper for crafting armors
     * @param material the item or block used for the craft
     * @param type Helmet:0 Chestplate:1 Leggings:2 Boots:3
     * @param output your helmet or your chest plate, etc ...
     */
    public static void addArmorCrafting(ItemStack material, int type, ItemStack output)
    {
        if(type == 0)
        {
            GameRegistry.addRecipe(output, new Object[] {"XXX", "X X", 'X', material});
        }
        else if(type == 1)
        {
            GameRegistry.addRecipe(output, new Object[] {"X X", "XXX", "XXX", 'X', material});
        }
        else if(type == 2)
        {
            GameRegistry.addRecipe(output, new Object[] {"XXX", "X X", "X X", 'X', material});
        }
        else if(type == 3)
        {
            GameRegistry.addRecipe(output, new Object[] {"X X", "X X", 'X', material});
        }
        else
        {
            FFMTLibs.ffmtLog.error("Failed to register armor crafting, couldn't handle type " + type);
        }
    }

    /**
     * Helper for crafting all armors
     * @param material the item or block used for the craft
     * @param outputHelmet an itemstack with your helmet
     * @param outputChestPlate an itemstack with your chest plate
     * @param outputLeggings an itemstack with your leggings
     * @param outputBoots an itemstack with your boots
     */
    public static void addAllArmorCrafting(ItemStack material, ItemStack outputHelmet, ItemStack outputChestPlate, ItemStack outputLeggings, ItemStack outputBoots)
    {
        GameRegistry.addRecipe(outputHelmet, new Object[] {"XXX", "X X", 'X', material});
        GameRegistry.addRecipe(outputChestPlate, new Object[] {"X X", "XXX", "XXX", 'X', material});
        GameRegistry.addRecipe(outputLeggings, new Object[] {"XXX", "X X", "X X", 'X', material});
        GameRegistry.addRecipe(outputBoots, new Object[] {"X X", "X X", 'X', material});
    }

    /**
     * Helper for crafting tools
     * @param material the item or block used for the craft
     * @param type Axe:0 Shovel:1 Hoe:2 Pickaxe:3 Sword:4
     * @param output the instance of your tool
     * @param stick the stick of the tool
     */
    public static void addToolsCrafting(ItemStack material, int type, ItemStack output, ItemStack stick)
    {
        if(type == 0)
        {
            GameRegistry.addRecipe(output, new Object[] {"XX", "XS", " S", 'X', material, 'S', stick});
            GameRegistry.addRecipe(output, new Object[] {"XX", "SX", "S ", 'X', material, 'S', stick});
        }
        else if(type == 1)
        {
            GameRegistry.addRecipe(output, new Object[] {"X", "S", "S", 'X', material, 'S', stick});
        }
        else if(type == 2)
        {
            GameRegistry.addRecipe(output, new Object[] {"XX", " S", " S", 'X', material, 'S', stick});
            GameRegistry.addRecipe(output, new Object[] {"XX", "S ", "S ", 'X', material, 'S', stick});
        }
        else if(type == 3)
        {
            GameRegistry.addRecipe(output, new Object[] {"XXX", " S ", " S ", 'X', material, 'S', stick});
        }
        else if(type == 4)
        {
            GameRegistry.addRecipe(output, new Object[] {"X", "X", "S", 'X', material, 'S', stick});
        }
        else
        {
            FFMTLibs.ffmtLog.error("Failed to register tools crafting, couldn't handle type " + type);
        }
    }

    public static void addAllToolsCrafting(ItemStack material, ItemStack outputAxe, ItemStack outputShovel, ItemStack outputHoe, ItemStack outputPickaxe, ItemStack outputSword, ItemStack stick)
    {
        GameRegistry.addRecipe(outputAxe, new Object[] {"XX", "XS", " S", 'X', material, 'S', stick});
        GameRegistry.addRecipe(outputAxe, new Object[] {"XX", "SX", "S ", 'X', material, 'S', stick});
        GameRegistry.addRecipe(outputShovel, new Object[] {"X", "S", "S", 'X', material, 'S', stick});
        GameRegistry.addRecipe(outputHoe, new Object[] {"XX", " S", " S", 'X', material, 'S', stick});
        GameRegistry.addRecipe(outputHoe, new Object[] {"XX", "S ", "S ", 'X', material, 'S', stick});
        GameRegistry.addRecipe(outputPickaxe, new Object[] {"XXX", " S ", " S ", 'X', material, 'S', stick});
        GameRegistry.addRecipe(outputSword, new Object[] {"X", "X", "S", 'X', material, 'S', stick});
    }

    /**
     * Helper to add all armors. You just need to register them after.
     * @param armorMaterial material of the armor
     * @param name e.g. iron, gold, stone, wood, diamond
     * @param modid your modid
     * @param helmet the object of your helmet (non initialized)
     * @param chestplate the object of your chest plate (non initialized)
     * @param leggings the object of your leggings (non initialized)
     * @param boots the object of your boots (non initialized)
     * @param creativeTabs where the item will be display
     * @author superloup10
     */
    public static void addAllArmors(ArmorMaterial armorMaterial, String name, String modid, Item helmet, Item chestplate, Item leggings, Item boots, CreativeTabs creativeTabs)
    {
        addAllArmors(armorMaterial, name, modid, helmet, chestplate, leggings, boots, null, creativeTabs);
    }

    /**
     * Helper to add all armors. You just need to register them after.
     * @param armorMaterial material of the armor
     * @param name e.g. iron, gold, stone, wood, diamond
     * @param modid your modid
     * @param helmet the object of your helmet (non initialized)
     * @param chestplate the object of your chest plate (non initialized)
     * @param leggings the object of your leggings (non initialized)
     * @param boots the object of your boots (non initialized)
     * @param creativeTabs where the item will be display
     * @param repair the item to repair your armor in an anvil
     */
    @Deprecated
    public static void addAllArmors(ArmorMaterial armorMaterial, String name, String modid, Item helmet, Item chestplate, Item leggings, Item boots, Item repair, CreativeTabs creativeTabs)
    {
//        helmet = new ItemFFMTArmor(armorMaterial, 0, modid, name, repair).setUnlocalizedName(name + "Helmet").setCreativeTab(creativeTabs);
//        chestplate = new ItemFFMTArmor(armorMaterial, 1, modid, name, repair).setUnlocalizedName(name + "Chestplate").setCreativeTab(creativeTabs);
//        leggings = new ItemFFMTArmor(armorMaterial, 2, modid, name, repair).setUnlocalizedName(name + "Leggings").setCreativeTab(creativeTabs);
//        boots = new ItemFFMTArmor(armorMaterial, 3, modid, name, repair).setUnlocalizedName(name + "Boots").setCreativeTab(creativeTabs);
    }

    /**
     * Helper to add all tool. You just need to register them after.
     * @param toolMaterial material of the tool
     * @param name e.g. iron, gold, stone, wood, diamond
     * @param modid your modid
     * @param sword the object of your sword (non initialized)
     * @param pickaxe the object of your pickaxe (non initialized)
     * @param axe the object of your axe (non initialized)
     * @param shovel the object of your shovel (non initialized)
     * @param hoe the object of your hoe (non initialized)
     * @param creativeTabs where the item will be display
     * @author superloup10
     */
    public static void addAllTools(ToolMaterial toolMaterial, String name, String modid, Item sword, Item pickaxe, Item axe, Item shovel, Item hoe, CreativeTabs creativeTabs)
    {
        addAllTools(toolMaterial, name, modid, sword, pickaxe, axe, shovel, hoe, null, creativeTabs);
    }

    /**
     * Helper to add all tool. You just need to register them after.
     * @param toolMaterial
     * @param name e.g. iron, gold, stone, wood, diamond
     * @param modid your modid
     * @param sword the object of your sword (non initialized)
     * @param pickaxe the object of your pickaxe (non initialized)
     * @param axe the object of your axe (non initialized)
     * @param shovel the object of your shovel (non initialized)
     * @param hoe the object of your hoe (non initialized)
     * @param repair the item to repair yours tools in an anvil
     * @param creativeTabs where the item will be display
     */
    @Deprecated
    public static void addAllTools(ToolMaterial toolMaterial, String name, String modid, Item sword, Item pickaxe, Item axe, Item shovel, Item hoe, Item repair, CreativeTabs creativeTabs)
    {
//        sword = new ItemFFMTSword(toolMaterial, repair).setUnlocalizedName(name + "Sword").setCreativeTab(creativeTabs);
//        pickaxe = new ItemFFMTPickaxe(toolMaterial, repair).setUnlocalizedName(name + "Pickaxe").setCreativeTab(creativeTabs);
//        axe = new ItemFFMTAxe(toolMaterial, repair).setUnlocalizedName(name + "Axe").setCreativeTab(creativeTabs);
//        shovel = new ItemFFMTSpade(toolMaterial, repair).setUnlocalizedName(name + "Shovel").setCreativeTab(creativeTabs);
//        hoe = new ItemFFMTHoe(toolMaterial, repair).setUnlocalizedName(name + "Hoe").setCreativeTab(creativeTabs);
    }

    /**
     * Remove a recipe
     * @param stack The removed ItemStack
     */
    public static void removeRecipe(ItemStack stack)
    {
        List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
        for(int i = 0; i < recipeList.size(); i++)
        {
            ItemStack output = recipeList.get(i).getRecipeOutput();
            if(output != null && stack.getItem() == output.getItem() && stack.getItemDamage() == output.getItemDamage())
            {
                recipeList.remove(i);
                FFMTLibs.ffmtLog.info("Removed recipe for : " + output.getItem().getUnlocalizedName(output));
            }
        }
    }
}