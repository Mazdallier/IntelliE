package de.thatsich.minecraft.integration.applied.aerodynamics


import codechicken.nei.api.API
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 30.08.2014.
 */
class NEIFakeItemHider(modules: Seq[Module], log: Log)
{
	def hideItemsInNEI(): Unit =
	{
		var counter = 0
		for (module <- this.modules; item <- module.items)
		{
			if (item.getToolClasses(null).contains("fake"))
			{
				API.hideItem(new ItemStack(item))
				counter += 1
				this.log.debug(s"Hid ${item.getClass.getSimpleName} from NEI.")
			}
		}
		this.log.info(s"Hid $counter elements from NEI.")
	}
}