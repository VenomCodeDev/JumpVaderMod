package dev.venomcode.jumpvader.mixin;

import com.mojang.authlib.GameProfile;
import dev.venomcode.jumpvader.ifaces.BlockActionListener;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;

import java.security.PublicKey;

@Mixin( ServerPlayerEntity.class )
public abstract class ServerPlayerMixin extends PlayerEntity
{
    @Override
    public void jump( )
    {
        BlockPos p = this.getBlockPos().down();
        Block blk = this.world.getBlockState( p ).getBlock();

        if(blk instanceof BlockActionListener bActioner)
        {
            if(bActioner.onJump( p, (ServerPlayerEntity ) (Object)this ))
            {
                return;
            }
        }

        super.jump( );
    }

    @Override
    public void setSneaking( boolean sneaking )
    {
        super.setSneaking( sneaking );
        if(sneaking)
        {
            BlockPos p = this.getBlockPos().down();
            Block blk = this.world.getBlockState( p ).getBlock();

            if(blk instanceof BlockActionListener bActioner)
            {
                bActioner.onCrouch( p, (ServerPlayerEntity ) (Object)this );
            }
        }
    }

    public ServerPlayerMixin(World world , BlockPos pos , float yaw , GameProfile profile, PlayerPublicKey pubKey)
    {
        super(world, pos, yaw, profile, pubKey);
    }
}
