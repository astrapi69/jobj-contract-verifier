package de.alpharogroup.evaluate.object;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BaseEnhancedRandomExtensions
{
	private static final EnhancedRandom ENHANCED_RANDOM = new EnhancedRandomBuilder().build();

	public static <T> T nextObject(Class<T> type, String... excludedFields)
	{
		return ENHANCED_RANDOM.nextObject(type, excludedFields);
	}

}
