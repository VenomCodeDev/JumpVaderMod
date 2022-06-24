package dev.venomcode.jumpvader.registers;

import dev.venomcode.jumpvader.blocks.JumpVaderBlock;
import dev.venomcode.vanillify.api.VanillaUtils;
import dev.venomcode.vanillify.api.item.ServerBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Items;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegister
{
    public static void init()
    {
        Registry.register( Registry.BLOCK, JUMP_VADER_BLOCK.getIdentifier(), JUMP_VADER_BLOCK);

        Registry.register( Registry.ITEM, JUMP_VADER_BLOCK.getIdentifier() ,new ServerBlockItem( JUMP_VADER_BLOCK, Items.SEA_LANTERN, JUMP_VADER_BLOCK.getIdentifier(), new FabricItemSettings().maxCount( 64 ) , VanillaUtils.getText( JUMP_VADER_BLOCK.getDisplayName(), Formatting.LIGHT_PURPLE ) ) );
    }

    public static final JumpVaderBlock JUMP_VADER_BLOCK = new JumpVaderBlock();
}