package dev.venomcode.jumpvader.registers;

import dev.venomcode.jumpvader.JumpVaderMod;
import dev.venomcode.jumpvader.blocks.JumpVaderBlock;
import eu.pb4.polymer.api.item.PolymerBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Items;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegister
{
    public static void init()
    {
        Registry.register( Registry.BLOCK, new Identifier(JumpVaderMod.MODID, "jumpvader_block"), JUMP_VADER_BLOCK);

        Registry.register( Registry.ITEM, new Identifier(JumpVaderMod.MODID, "jumpvader_block"), new PolymerBlockItem( JUMP_VADER_BLOCK, new FabricItemSettings(), Items.ORANGE_STAINED_GLASS ) );
    }

    public static final JumpVaderBlock JUMP_VADER_BLOCK = new JumpVaderBlock(FabricBlockSettings.of(Material.GLASS), Blocks.ORANGE_STAINED_GLASS);
}