package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.BaseItem
import de.thatsich.minecraft.common.string.{BaseID, ID}


/**
 *
 *
 * @author thatsIch
 * @since 12.08.2014.
 */
class MaxEnergyStorage(modid: ID, log: Log) extends BaseItem(modid, new MaxEnergyStorageID, log)

private[this] class MaxEnergyStorageID extends BaseID("maxenergy")