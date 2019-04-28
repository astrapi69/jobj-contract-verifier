package de.alpharogroup.evaluate.object.verifier;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.function.Function;

import de.alpharogroup.evaluate.object.api.ContractViolation;
import de.alpharogroup.evaluate.object.checkers.EqualsHashCodeAndToStringCheck;
import de.alpharogroup.evaluate.object.enums.VerificationType;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

/**
 * The class {@link ContractVerifier} can verify if the fulfillment of contracts from a given object
 * is given. This is useful in unit tests for verifying the contracts for the methods
 * {@code equals}, {@code hashCode} and optionally {@code toString}. This can also improve the code
 * coverage of an project because the most methods of beans are tested.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class ContractVerifier<T>
{
	public static <T> ContractVerifier<T> of(final @NonNull Class<T> type)
	{
		return new ContractVerifier<>(type);
	}

	Class<T> cls;

	@NonFinal
	Function<Class<T>, T> factoryFunction;

	@NonFinal
	VerificationType verificationType = VerificationType.EQUALS_HASHCODE_AND_TO_STRING;

	ContractVerifier(final @NonNull Class<T> cls)
	{
		this.cls = cls;
	}

	public Optional<ContractViolation> verify()
	{
		Optional<ContractViolation> verificationResult = Optional.empty();
		try
		{
			if (factoryFunction != null)
			{
				verificationResult = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(cls, factoryFunction);
			} else {
				verificationResult = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(cls);
			}
		}
		catch (NoSuchMethodException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		catch (InvocationTargetException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		catch (InstantiationException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		catch (ClassNotFoundException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		catch (IOException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		return verificationResult;
	}

	public ContractVerifier<T> withEqualsHashcodeAndToString()
	{
		verificationType =  VerificationType.EQUALS_HASHCODE_AND_TO_STRING;
		return this;
	}

	public ContractVerifier<T>  withFactoryFunction(final @NonNull Function<Class<T>, T> factoryFunction)
	{
		this.factoryFunction = factoryFunction;
		return this;
	}

}
