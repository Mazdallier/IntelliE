package de.thatsich.minecraft.api.mod.module.entity

import net.minecraft.entity.{Entity => MCEntity}
import net.minecraft.world.World

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class BaseEntity( world: World )
	extends MCEntity( world ) with Entity
{}
