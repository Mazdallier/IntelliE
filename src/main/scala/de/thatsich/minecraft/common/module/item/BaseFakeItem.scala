package de.thatsich.minecraft.common.module.item


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseItem
import de.thatsich.minecraft.common.util.string.{ModID, ID}


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
abstract class BaseFakeItem(itemName: ID, modid: ModID, log: Log) extends BaseItem(itemName, modid, log)
{
	this.setHarvestLevel("fake", 0)
	this.setTextureName(s"${modid.id}:default")
}