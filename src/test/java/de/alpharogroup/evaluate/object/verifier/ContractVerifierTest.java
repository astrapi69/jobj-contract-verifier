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

import org.testng.annotations.Test;

import de.alpharogroup.test.objects.A;
import de.alpharogroup.test.objects.AlgorithmModel;
import de.alpharogroup.test.objects.ClonableObject;
import de.alpharogroup.test.objects.Company;
import de.alpharogroup.test.objects.Customer;
import de.alpharogroup.test.objects.Employee;
import de.alpharogroup.test.objects.EmployeeList;
import de.alpharogroup.test.objects.Light;
import de.alpharogroup.test.objects.Member;
import de.alpharogroup.test.objects.NotSerializable;
import de.alpharogroup.test.objects.Permission;
import de.alpharogroup.test.objects.Person;
import de.alpharogroup.test.objects.PremiumMember;
import de.alpharogroup.test.objects.Television;
import de.alpharogroup.test.objects.annotations.classes.AnnotatedClass;
import de.alpharogroup.test.objects.annotations.classes.AnnotatedTestClass;
import de.alpharogroup.test.objects.annotations.classes.ClassExtendsAnnotatedInterface;
import de.alpharogroup.test.objects.annotations.classes.SubAnnotatedClass;
import de.alpharogroup.test.objects.auth.AccessRight;
import de.alpharogroup.test.objects.auth.Role;
import de.alpharogroup.test.objects.auth.Roles;
import de.alpharogroup.test.objects.exceptions.ExceptionEvent;

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
		ContractVerifier.of(ManifestVersion.class).withFactoryFunction(clzz -> ManifestVersion.builder().build()).verify();
	}
}
