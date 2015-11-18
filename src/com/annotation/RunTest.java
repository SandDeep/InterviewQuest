package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RunTest {

	public static void main(String[] args) {
		System.out.println("Testing...");

		int passed = 0, failed = 0, count = 0, ignore = 0;

		Class<TestExample> obj = TestExample.class;

		// Process @TesterInfo
		if (obj.isAnnotationPresent(TesterInfo.class)) {
			Annotation annotation = obj.getAnnotation(TesterInfo.class);
			TesterInfo info = (TesterInfo) annotation;

			System.out.println("Priority : " + info.priority());
			System.out.println("CreatedBy : " + info.createdBy());
			System.out.println("Tags ");

			int tagLength = info.tags().length;
			for (String tag : info.tags()) {
				if (tagLength > 1) {
					System.out.print(tag + ", ");
				} else {
					System.out.print(tag);
				}
				tagLength--;
			}

			System.out.println("\nLastModified : " + info.lastModified());
		}

		// Process @Test
		for (Method method : obj.getDeclaredMethods()) {

			if (method.isAnnotationPresent(Test.class)) {
				Annotation annotation = method.getAnnotation(Test.class);
				Test test = (Test) annotation;

				if (test.enable()) {

					try {
						method.invoke(obj.newInstance());
						System.out.println(++count + " Test "
								+ method.getName() + " - passed.");
						passed++;
					} catch (Throwable ex) {
						System.out.println(++count + " Test "
								+ method.getName() + " - failed : "
								+ ex.getCause());
						failed++;
					}

				} else {
					System.out.println(++count + " Test " + method.getName()
							+ " - ignored.");
					ignore++;
				}
			}
		}

		System.out.println("\nResult : Total : " + count + " , Passed: "
				+ passed + ", Failed " + failed + " , Ignore  : " + ignore);
	}
}
