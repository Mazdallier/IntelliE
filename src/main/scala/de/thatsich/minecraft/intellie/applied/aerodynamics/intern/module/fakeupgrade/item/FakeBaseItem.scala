package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade.item


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.BaseItem
import de.thatsich.minecraft.common.string.id.ID


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
abstract class FakeBaseItem(override protected val modid: ID, itemName: ID, override protected val log: Log) extends BaseItem(modid, itemName, log)
{
	this.setHarvestLevel("fake", 0)
}
