package de.thatsich.common.registries;

import dagger.Module;

/**
 * @author thatsIch
 * @date 05.03.14.
 */
@Module(
		injects = {
				RegistryConfig.class,
				RegistryBlock.class,
				RegistryItem.class,
				RegistryTileEntity.class
		}
)
public class RegistryModule
{}