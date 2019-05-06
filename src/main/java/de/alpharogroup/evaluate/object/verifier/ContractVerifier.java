/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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

	/**
	 * Factory method for create a new {@link ContractVerifier} object from the given class
	 *
	 * @param <T>
	 *            the generic type
	 * @param type
	 *            the class
	 * @return the contract verifier
	 */
	public static <T> ContractVerifier<T> of(final @NonNull Class<T> type)
	{
		return new ContractVerifier<>(type);
	}

	/** The cls. */
	Class<T> cls;

	/** The factory function. */
	@NonFinal
	Function<Class<T>, T> factoryFunction;

	/** The verification type. */
	@NonFinal
	VerificationType verificationType = VerificationType.EQUALS_HASHCODE_AND_TO_STRING;

	/**
	 * Private constructor
	 *
	 * @param cls
	 *            the class
	 */
	private ContractVerifier(final @NonNull Class<T> cls)
	{
		this.cls = cls;
	}

	/**
	 * Verify the given class and returns an {@link Optional} that is empty if the verification was
	 * successful
	 *
	 * @return an empty {@link Optional} object if the verification was successful
	 */
	public Optional<ContractViolation> verify()
	{
		Optional<ContractViolation> verificationResult = Optional.empty();
		try
		{
			if (factoryFunction != null)
			{
				verificationResult = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(cls,
					factoryFunction);
			}
			else
			{
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
		catch (NoSuchFieldException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		return verificationResult;
	}

	/**
	 * Builder method that sets the verification type
	 * {@link VerificationType#EQUALS_HASHCODE_AND_TO_STRING}
	 *
	 * @return this {@link ContractVerifier}
	 */
	public ContractVerifier<T> withEqualsHashcodeAndToString()
	{
		verificationType = VerificationType.EQUALS_HASHCODE_AND_TO_STRING;
		return this;
	}

	/**
	 * Builder method that sets the factory function
	 *
	 * @param factoryFunction
	 *            the factory function
	 * @return this {@link ContractVerifier}
	 */
	public ContractVerifier<T> withFactoryFunction(
		final @NonNull Function<Class<T>, T> factoryFunction)
	{
		this.factoryFunction = factoryFunction;
		return this;
	}

}
