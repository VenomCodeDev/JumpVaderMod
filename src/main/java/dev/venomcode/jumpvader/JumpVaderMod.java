package dev.venomcode.jumpvader;

import dev.venomcode.jumpvader.registers.BlockRegister;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JumpVaderMod implements DedicatedServerModInitializer {

	public static final String MODID = "jumpvader";

	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	@Override
	public void onInitializeServer()
	{
		BlockRegister.init();
	}
}
