package de.thatsich.minecraft.api.mod.module

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.api.mod.Proxy
import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.api.mod.module.registries.{BlockRegistry, ItemRegistry, TileEntityRegistry}

/**
 *
 *
 * @author thatsIch
 * @since 23.04.2014.
 */
class ModuleRegistry( modules: Seq[ Module ], log: Log ) extends ItemRegistry
                                                                 with BlockRegistry
                                                                 with TileEntityRegistry
                                                                 with Proxy
{

	//	this.registerTileEntities( this.modules )
	// 	RenderingRegistry.registerBlockHandler() ISBRH
	//	RenderingRegistry.registerEntityRenderingHandler() Entity.class, Render
	//	case entity: Entity => EntityRegistry.registerModEntity( entity.getClass, entity.getClass.toString, entity.getEntityId, )

	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	def preInit( event: FMLPreInitializationEvent ): Unit =
	{
		this.registerItems( this.modules )
		this.registerBlocks( this.modules )
	}

	/**
	 * Do your mod setup. Build whatever data structures you care about.
	 * Register recipes, send FMLInterModComms messages to other mods.
	 *
	 * @param event contains information to initialize and finalize the mod
	 */
	def init( event: FMLInitializationEvent ): Unit =
	{

	}

	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	def postInit( event: FMLPostInitializationEvent ): Unit =
	{

	}
}
