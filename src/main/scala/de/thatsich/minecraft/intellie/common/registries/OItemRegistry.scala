package de.thatsich.minecraft.intellie.common.registries

import de.thatsich.minecraft.intellie.common.module.item.IItem
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.Item
import de.thatsich.minecraft.intellie.common.logger.{OIntelligentEnergisticsLog, ALog}

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
object OItemRegistry extends ARegistry[ IItem ]
{
	implicit val log: ALog = OIntelligentEnergisticsLog

	def register()(implicit log: ALog)
	{
		for( item <- this.set )
		{
			val unlocalizedName = item.getUnlocalizedName

			GameRegistry.registerItem(item.asInstanceOf[ Item ], unlocalizedName)
			this.log.debug("Registered Item %s with %s", item, unlocalizedName)
		}
		this.log.info("Registering all Items.")
	}
}