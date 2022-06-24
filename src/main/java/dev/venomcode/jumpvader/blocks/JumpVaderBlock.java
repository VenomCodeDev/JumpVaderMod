package dev.venomcode.jumpvader.blocks;

import dev.venomcode.jumpvader.JumpVaderMod;
import dev.venomcode.jumpvader.ifaces.BlockActionListener;
import dev.venomcode.vanillify.api.interfaces.BlockStateProxy;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class JumpVaderBlock extends Block implements BlockActionListener, BlockStateProxy
{
    public JumpVaderBlock(  )
    {
        super( FabricBlockSettings.of( Material.STONE ).strength( 4.0f ).requiresTool() );
    }

    @Override
    public boolean onJump(BlockPos pos , ServerPlayerEntity player )
    {
        pos = pos.up();
        ServerWorld w = player.getWorld();
        int count = 0;

        while(count < 300 && pos.getY() < 318)
        {
            Block blk = w.getBlockState( pos ).getBlock();

            if(blk instanceof JumpVaderBlock)
            {
                final BlockPos tpPos = pos.up();

                if(w.getBlockState( tpPos ).getBlock().equals( Blocks.AIR ) && w.getBlockState( tpPos.up() ).getBlock().equals( Blocks.AIR ))
                {
                    player.requestTeleport( tpPos.getX() + 0.5f, tpPos.getY(), tpPos.getZ() + 0.5f );

                    w.playSound( null, tpPos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 0.5f, 1.5f );
                    w.spawnParticles( ParticleTypes.END_ROD, tpPos.getX() + 0.5f, tpPos.getY(), tpPos.getZ() + 0.5f, 10, 0, 0, 0, 0.25f );

                    return true;
                }
            }
            pos = pos.up();
            count++;
        }
        return false;
    }

    @Override
    public void onCrouch( BlockPos pos , ServerPlayerEntity player )
    {
        pos = pos.down();
        ServerWorld w = player.getWorld();
        int count = 0;

        while(count < 300 && pos.getY() >= -64)
        {
            Block blk = w.getBlockState( pos ).getBlock();

            if(blk instanceof JumpVaderBlock)
            {
                final BlockPos tpPos = pos.up();

                if(w.getBlockState( tpPos ).getBlock().equals( Blocks.AIR ) && w.getBlockState( tpPos.up() ).getBlock().equals( Blocks.AIR ))
                {
                    player.requestTeleport( tpPos.getX() + 0.5f, tpPos.getY(), tpPos.getZ() + 0.5f );

                    w.playSound( null, tpPos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 0.5f, 1.5f );
                    w.spawnParticles( ParticleTypes.END_ROD, tpPos.getX() + 0.5f, tpPos.getY(), tpPos.getZ() + 0.5f, 10, 0, 0, 0, 0.25f );

                    return;
                }
            }
            pos = pos.down();
            count++;
        }

    }

    @Override
    public BlockState getClientBlockState(BlockState blockState )
    {
        return Blocks.SEA_LANTERN.getDefaultState();
    }

    @Override
    public Identifier getIdentifier( )
    {
        return new Identifier( JumpVaderMod.MODID, "jumpvader_block" );
    }

    @Override
    public String getDisplayName( )
    {
        return "JumpVader";
    }

    private static final Identifier _identifier = new Identifier( JumpVaderMod.MODID, "jumpvader_block" );
}