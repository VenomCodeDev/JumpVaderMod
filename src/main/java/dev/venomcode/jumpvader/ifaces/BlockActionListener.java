package dev.venomcode.jumpvader.ifaces;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public interface BlockActionListener {
    boolean onJump( BlockPos pos, ServerPlayerEntity player );
    void onCrouch( BlockPos pos, ServerPlayerEntity player );
}
