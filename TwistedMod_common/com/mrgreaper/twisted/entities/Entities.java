package com.mrgreaper.twisted.entities;

import com.mrgreaper.twisted.TwistedMod;

import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities {
	public static void init() {
//		EntityRegistry.registerModEntity(EntitySpaceship.class, "EntitySpaceship", 0, TwistedMod.instance, 80, 3, true);
//		EntityRegistry.registerModEntity(EntityBomb.class, "EntityBomb", 1, TwistedMod.instance, 80, 3, false);
		EntityRegistry.registerModEntity(EntityBalloon.class, "EntityBalloon", 0, TwistedMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityDeathOrb.class, "EntityDeathOrb", 1, TwistedMod.instance, 80, 3, true);
		
	}

}
