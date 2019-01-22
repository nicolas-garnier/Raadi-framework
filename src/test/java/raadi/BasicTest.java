package raadi;

import raadi.aspects.AfterInvocation;
import raadi.aspects.AroundInvocation;
import raadi.aspects.BeforeInvocation;
import raadi.aspects.ExecutionContext;
import raadi.provider.Prototype;
import raadi.provider.Singleton;
import raadi.scope.AnyScope;

import java.lang.reflect.Method;
import java.util.function.Function;

public class BasicTest
{
    public static Method getMethod(final Class<?> objectClass, final String methodName) {
        try {
            return objectClass.getMethod(methodName);
        } catch (NoSuchMethodException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void testBasicUseCase() throws InterruptedException {
        final Raadi raadi = new Raadi();

        // Add a provider to the scope, of type prototype, that binds on Nested.class.
        raadi.provider(Nested.class, new Prototype<>(() -> new Nested(raadi.instanceOf(TestService.class))));

        // Shortcut for singleton addition.
        raadi.bean(TestService.class, new TestServiceImpl());

        // Shortcurt for singleton, binding on the element class.
        raadi.bean(new Nested(raadi.instanceOf(TestService.class)));

        // Stacks a scope.
        raadi.scope(new AnyScope(), scope -> {

            // Adds a singleton with aspect
            scope.bean(TestService.class, new TestServiceBlipImpl(),

                    // Define AoP behaviour on the before(Pong)
                    new BeforeInvocation(getMethod(TestService.class, "pong"), ExecutionContext -> {
                        System.out.println("before >> ");
                        return Unit.INSTANCE; // Kotlin compatibility.
                    }),

                    // Define AoP behaviour around calls to the pong method.
                    new AroundInvocation(getMethod(TestService.class, "pong"), (Function<ExecutionContext, Object>) ctx -> {

                        try {
                            final long before = System.nanoTime();
                            final Object result;
                            result = ctx.proceed();
                            System.out.println("Method " + ctx.method.getName() + " executed in " + (System.nanoTime() - before / 1000000.0));
                            return result;
                        } catch (final Exception exception) {
                            throw new RuntimeException(exception);
                        }
                    }),

                    // Adds behaviour after the calls to pong.
                    new AfterInvocation(getMethod(TestService.class, "pong"), ctx -> {
                        System.out.println("<< after!");
                        return Unit.INSTANCE; // Kotlin compatibility.
                    })
            );

            return Unit.INSTANCE; // Kotlin compatibility.
        });

        // Define AoP behaviour around calls to the pong method.
        raadi.provider(Nested.class, new Singleton<>(new Nested(raadi.instanceOf(TestService.class))));
        raadi.provider(Nested.class, new Prototype<>(() -> new Nested(raadi.instanceOf(TestService.class))));

        // Test call
        final TestService testService = raadi.instanceOf(TestService.class);
        for (int i = 0; i < 5; i++) {
            testService.ping();
        }
        Thread.sleep(5000000);
    }

}
