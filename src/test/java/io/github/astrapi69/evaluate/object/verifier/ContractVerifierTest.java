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
package io.github.astrapi69.evaluate.object.verifier;

import org.testng.annotations.Test;

import io.github.astrapi69.test.object.A;
import io.github.astrapi69.test.object.AlgorithmModel;
import io.github.astrapi69.test.object.ClonableObject;
import io.github.astrapi69.test.object.Company;
import io.github.astrapi69.test.object.Customer;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.EmployeeList;
import io.github.astrapi69.test.object.Light;
import io.github.astrapi69.test.object.Member;
import io.github.astrapi69.test.object.NotSerializable;
import io.github.astrapi69.test.object.Permission;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.PremiumMember;
import io.github.astrapi69.test.object.Television;
import io.github.astrapi69.test.object.annotation.classtype.AnnotatedClass;
import io.github.astrapi69.test.object.annotation.classtype.AnnotatedTestClass;
import io.github.astrapi69.test.object.annotation.classtype.ClassExtendsAnnotatedInterface;
import io.github.astrapi69.test.object.annotation.classtype.SubAnnotatedClass;
import io.github.astrapi69.test.object.auth.AccessRight;
import io.github.astrapi69.test.object.auth.Role;
import io.github.astrapi69.test.object.auth.Roles;
import io.github.astrapi69.test.object.exception.ExceptionEvent;

/**
 * The unit test class for the class {@link ContractVerifier}
 */
public class ContractVerifierTest
{

	/**
	 * Test method for {@link ContractVerifier#verify()}
	 */
	@Test
	public void testOfVerify()
	{
		ContractVerifier.of(AnnotatedClass.class).verify();
		ContractVerifier.of(AnnotatedTestClass.class).verify();
		ContractVerifier.of(ClassExtendsAnnotatedInterface.class).verify();
		ContractVerifier.of(SubAnnotatedClass.class).verify();
		ContractVerifier.of(AccessRight.class).verify();
		ContractVerifier.of(Roles.class).verify();
		ContractVerifier.of(Role.class).verify();
		ContractVerifier.of(ExceptionEvent.class).verify();
		ContractVerifier.of(AlgorithmModel.class).verify();
		ContractVerifier.of(A.class).verify();
		ContractVerifier.of(ClonableObject.class).verify();
		ContractVerifier.of(Company.class).verify();
		ContractVerifier.of(Customer.class).verify();
		ContractVerifier.of(EmployeeList.class).verify();
		ContractVerifier.of(Employee.class).verify();
		ContractVerifier.of(Light.class).verify();
		ContractVerifier.of(Member.class).verify();
		ContractVerifier.of(NotSerializable.class).verify();
		ContractVerifier.of(Permission.class).verify();
		ContractVerifier.of(Person.class).verify();
		ContractVerifier.of(PremiumMember.class).verify();
		ContractVerifier.of(Television.class).verify();
		ContractVerifier.of(ManifestVersion.class)
			.withFactoryFunction(clzz -> ManifestVersion.builder().build()).verify();
	}
}
