package de.alpharogroup.evaluate.object.verifier;

import java.util.function.Function;

import org.testng.annotations.Test;

import de.alpharogroup.evaluate.object.BaseEnhancedRandomExtensions;
import de.alpharogroup.test.objects.Member;
import de.alpharogroup.test.objects.Person;

public class ContractVerifierTest
{

	@Test
	public void testOfVerify()
	{
		Function<Class<Person>, Person> factoryFunction = clazz -> Person.builder()
			.name(BaseEnhancedRandomExtensions.nextObject(String.class))
			.about(BaseEnhancedRandomExtensions.nextObject(String.class))
			.married(BaseEnhancedRandomExtensions.nextObject(Boolean.class))
			.nickname(BaseEnhancedRandomExtensions.nextObject(String.class)).build();
		ContractVerifier.of(Person.class)
		.withFactoryFunction(factoryFunction)
		.verify();
		ContractVerifier.of(Member.class).verify();
	}
}
