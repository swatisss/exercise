/*
 * Copyright (c) 2006-2015 Rogério Liesenfeld
 * This file is subject to the terms of the MIT license (see LICENSE.txt).
 */
package mockit;

import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import javax.annotation.*;

import mockit.internal.expectations.*;
import mockit.internal.expectations.argumentMatching.*;
import mockit.internal.startup.*;
import mockit.internal.util.*;

import org.hamcrest.Matcher;

/**
 * Provides common API for use inside {@linkplain mockit.Expectations expectation} and
 * {@linkplain mockit.Verifications verification} blocks.
 */
@SuppressWarnings({"ConstantConditions", "ClassWithTooManyFields"})
abstract class Invocations
{
   static { Startup.verifyInitialization(); }

   /**
    * Matches any {@code Object} reference received by a parameter of a reference type.
    * <p/>
    * This field can only be used as the argument value at the proper parameter position in a method/constructor
    * invocation, when recording or verifying an expectation; it cannot be used anywhere else.
    * <p/>
    * The use of this field will usually require a cast to the specific parameter type.
    * However, if there is any other parameter for which an argument matching constraint is specified, passing the
    * {@code null} reference instead will have the same effect.
    * <p/>
    * When the parameter to be matched is a <em>varargs</em> parameter of element type {@code V}, the use of
    * {@code any} should be cast to {@code V[]}.
    * <p/>
    * In invocations to <em>non-accessible</em> methods or constructors (for example, with
    * {@link Deencapsulation#invoke(Object, String, Object...)}), use {@link #withAny} instead.
    *
    * @see #anyBoolean
    * @see #anyByte
    * @see #anyChar
    * @see #anyDouble
    * @see #anyFloat
    * @see #anyInt
    * @see #anyLong
    * @see #anyShort
    * @see #anyString
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#matcherFields">Tutorial</a>
    */
   protected final Object any = null;

   /**
    * Matches any {@code String} value received by a parameter of this type.
    * <p/>
    * This field can only be used as the argument value at the proper parameter position in a method/constructor
    * invocation, when recording or verifying an expectation; it cannot be used anywhere else.
    *
    * @see #anyBoolean
    * @see #anyByte
    * @see #anyChar
    * @see #anyDouble
    * @see #anyFloat
    * @see #anyInt
    * @see #anyLong
    * @see #anyShort
    * @see #any
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#matcherFields">Tutorial</a>
    */
   // This is intentional: the empty string causes the compiler to not generate a field read,
   // while the null reference is inconvenient with the invoke(...) methods:
   protected final String anyString = new String();

   /**
    * Matches any {@code long} or {@code Long} value received by a parameter of one of these types.
    * <p/>
    * This field can only be used as the argument value at the proper parameter position in a method/constructor
    * invocation, when recording or verifying an expectation; it cannot be used anywhere else.
    *
    * @see #anyBoolean
    * @see #anyByte
    * @see #anyChar
    * @see #anyDouble
    * @see #anyFloat
    * @see #anyInt
    * @see #anyShort
    * @see #anyString
    * @see #any
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#matcherFields">Tutorial</a>
    */
   protected final Long anyLong = 0L;

   /**
    * Matches any {@code int} or {@code Integer} value received by a parameter of one of these types.
    * <p/>
    * This field can only be used as the argument value at the proper parameter position in a method/constructor
    * invocation, when recording or verifying an expectation; it cannot be used anywhere else.
    *
    * @see #anyBoolean
    * @see #anyByte
    * @see #anyChar
    * @see #anyDouble
    * @see #anyFloat
    * @see #anyLong
    * @see #anyShort
    * @see #anyString
    * @see #any
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#matcherFields">Tutorial</a>
    */
   protected final Integer anyInt = 0;

   /**
    * Matches any {@code short} or {@code Short} value received by a parameter of one of these types.
    * <p/>
    * This field can only be used as the argument value at the proper parameter position in a method/constructor
    * invocation, when recording or verifying an expectation; it cannot be used anywhere else.
    *
    * @see #anyBoolean
    * @see #anyByte
    * @see #anyChar
    * @see #anyDouble
    * @see #anyFloat
    * @see #anyInt
    * @see #anyLong
    * @see #anyString
    * @see #any
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#matcherFields">Tutorial</a>
    */
   protected final Short anyShort = 0;

   /**
    * Matches any {@code byte} or {@code Byte} value received by a parameter of one of these types.
    * <p/>
    * This field can only be used as the argument value at the proper parameter position in a method/constructor
    * invocation, when recording or verifying an expectation; it cannot be used anywhere else.
    *
    * @see #anyBoolean
    * @see #anyChar
    * @see #anyDouble
    * @see #anyFloat
    * @see #anyInt
    * @see #anyLong
    * @see #anyShort
    * @see #anyString
    * @see #any
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#matcherFields">Tutorial</a>
    */
   protected final Byte anyByte = 0;

   /**
    * Matches any {@code boolean} or {@code Boolean} value received by a parameter of one of these types.
    * <p/>
    * This field can only be used as the argument value at the proper parameter position in a method/constructor
    * invocation, when recording or verifying an expectation; it cannot be used anywhere else.
    *
    * @see #anyByte
    * @see #anyChar
    * @see #anyDouble
    * @see #anyFloat
    * @see #anyInt
    * @see #anyLong
    * @see #anyShort
    * @see #anyString
    * @see #any
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#matcherFields">Tutorial</a>
    */
   protected final Boolean anyBoolean = false;

   /**
    * Matches any {@code char} or {@code Character} value received by a parameter of one of these types.
    * <p/>
    * This field can only be used as the argument value at the proper parameter position in a method/constructor
    * invocation, when recording or verifying an expectation; it cannot be used anywhere else.
    *
    * @see #anyBoolean
    * @see #anyByte
    * @see #anyDouble
    * @see #anyFloat
    * @see #anyInt
    * @see #anyLong
    * @see #anyShort
    * @see #anyString
    * @see #any
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#matcherFields">Tutorial</a>
    */
   protected final Character anyChar = '\0';

   /**
    * Matches any {@code double} or {@code Double} value received by a parameter of one of these types.
    * <p/>
    * This field can only be used as the argument value at the proper parameter position in a method/constructor
    * invocation, when recording or verifying an expectation; it cannot be used anywhere else.
    *
    * @see #anyBoolean
    * @see #anyByte
    * @see #anyChar
    * @see #anyFloat
    * @see #anyInt
    * @see #anyLong
    * @see #anyShort
    * @see #anyString
    * @see #any
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#matcherFields">Tutorial</a>
    */
   protected final Double anyDouble = 0.0;

   /**
    * Matches any {@code float} or {@code Float} value received by a parameter of one of these types.
    * <p/>
    * This field can only be used as the argument value at the proper parameter position in a method/constructor
    * invocation, when recording or verifying an expectation; it cannot be used anywhere else.
    *
    * @see #anyBoolean
    * @see #anyByte
    * @see #anyChar
    * @see #anyDouble
    * @see #anyInt
    * @see #anyLong
    * @see #anyString
    * @see #anyShort
    * @see #any
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#matcherFields">Tutorial</a>
    */
   protected final Float anyFloat = 0.0F;

   /**
    * A non-negative value assigned to this field will be taken as the exact number of times that invocations matching
    * the current expectation should occur during replay.
    *
    * @see #minTimes
    * @see #maxTimes
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#constraints">Tutorial</a>
    */
   protected int times;

   /**
    * A non-negative value assigned to this field will be taken as the minimum number of times that invocations matching
    * the current expectation should occur during replay.
    * <em>Zero</em> or a <em>negative</em> value implies there is no lower limit.
    * The <em>maximum</em> number of times is automatically adjusted to allow any number of invocations.
    * <p/>
    * Both {@code minTimes} and {@code maxTimes} can be specified for the same expectation, as long as {@code minTimes}
    * is assigned first.
    *
    * @see #times
    * @see #maxTimes
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#constraints">Tutorial</a>
    */
   protected int minTimes;

   /**
    * A non-negative value assigned to this field will be taken as the maximum number of times that invocations matching
    * the current expectation should occur during replay.
    * A <em>negative</em> value implies there is no upper limit.
    * <p/>
    * Both {@code minTimes} and {@code maxTimes} can be specified for the same expectation, as long as {@code minTimes}
    * is assigned first.
    *
    * @see #times
    * @see #minTimes
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#constraints">Tutorial</a>
    */
   protected int maxTimes;

   /**
    * An string assigned to this field will be used as a prefix for the error message shown for the current expectation
    * if it's found to be violated.
    * <p/>
    * Inside an expectation/verification block, the assignment must follow the invocation which records/verifies the
    * expectation; if there is no current expectation at the point the assignment appears, an
    * {@code IllegalStateException} is thrown.
    * <p/>
    * Notice there are only two different ways in which an expectation can be violated: either an <em>unexpected</em>
    * invocation occurs during replay, or a <em>missing</em> invocation is detected.
    */
   protected CharSequence $;

   @Nonnull abstract TestOnlyPhase getCurrentPhase();

   /**
    * Calling this method causes the expectation recorded/verified on the given mocked instance to match only those
    * invocations that occur on the <em>same</em> instance, at replay time.
    * <p/>
    * By default, such instances can be different between the replay phase and the record or verify phase, even though
    * the method or constructor invoked is the same, and the invocation arguments all match.
    * The use of this method allows invocations to also be matched on the instance invoked.
    * <p/>
    * Typically, tests that need to match instance invocations on the mocked instances invoked will declare two or more
    * mock fields and/or mock parameters of the exact same mocked type.
    * These instances will then be passed to the code under test, which will invoke them during the replay phase.
    * To avoid the need to explicitly call {@code onInstance(Object)} on each of these different instances of the
    * same type, instance matching is <em>implied</em> (and automatically applied to all relevant invocations) whenever
    * two or more mocked instances of the same type are in scope for a given test method. This property of the API makes
    * the use of {@code onInstance} much less frequent than it might otherwise be.
    * <p/>
    * In most cases, an invocation to the given mocked instance will be made on the value returned by this method (ie,
    * a chained invocation).
    * However, in the situation where the tested method calls an instance method defined in a mocked super-class
    * (possibly an overridden method called through the {@code super} keyword), it will be necessary to match on a
    * different instance than the one used for recording invocations.
    * To do so, this method should be given the desired instance to match, while the invocation to be recorded should be
    * done on the available mocked instance, which must be a different one (otherwise a non-mocked method would get
    * executed).
    * This is valid only if the instance to be matched is assignable to the mocked type, and typically occurs when
    * partially mocking a class hierarchy.
    *
    * @return the given mocked instance, allowing the invocation being recorded/verified to immediately follow the call
    * to this method
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#onInstance">Tutorial</a>
    */
   protected final <T> T onInstance(T mockedInstance)
   {
      if (mockedInstance == null) {
         throw new NullPointerException("Missing mocked instance to match");
      }

      getCurrentPhase().setNextInstanceToMatch(mockedInstance);
      return mockedInstance;
   }

   // Methods for argument matching ///////////////////////////////////////////////////////////////////////////////////

   /**
    * Applies a <em>Hamcrest</em> argument matcher for a parameter in the current expectation.
    *
    * @param argumentMatcher any {@code org.hamcrest.Matcher} object
    *
    * @return the value recorded inside the given Hamcrest matcher, or {@code null} if there is no such value to be
    * found
    *
    * @see #with(Delegate)
    */
   protected final <T> T withArgThat(Matcher<? super T> argumentMatcher)
   {
      HamcrestAdapter matcher = new HamcrestAdapter(argumentMatcher);
      addMatcher(matcher);

      Object argValue = matcher.getInnerValue();
      //noinspection unchecked
      return (T) argValue;
   }

   /**
    * Applies a custom argument matcher for a parameter in the current expectation.
    * <p/>
    * The class of the given delegate object should define a single non-<code>private</code> <em>delegate</em> method
    * (plus any number of helper {@code private} methods).
    * The name of the delegate method doesn't matter, but it must have a single parameter capable of receiving the
    * relevant argument values.
    * <p/>
    * The return type of the delegate method should be {@code boolean} or {@code void}.
    * In the first case, a return value of {@code true} will indicate a successful match for the actual invocation
    * argument at replay time, while a return of {@code false} will fail to match the invocation.
    * In the case of a {@code void} return type, the actual invocation argument should be validated through a suitable
    * JUnit/TestNG assertion.
    *
    * @param objectWithDelegateMethod an instance of a class defining a single non-<code>private</code> delegate method
    *
    * @return the default primitive value corresponding to {@code T} if it's a primitive wrapper type, or {@code null}
    * otherwise
    *
    * @see #withArgThat(org.hamcrest.Matcher)
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T> T with(Delegate<? super T> objectWithDelegateMethod)
   {
      Class<?> delegateClass = objectWithDelegateMethod.getClass();
      Type[] genericInterfaces = delegateClass.getGenericInterfaces();

      while (genericInterfaces.length == 0) {
         delegateClass = delegateClass.getSuperclass();
         genericInterfaces = delegateClass.getGenericInterfaces();
      }

      if (!(genericInterfaces[0] instanceof ParameterizedType)) {
         throw new IllegalArgumentException("Delegate class lacks the parameter type");
      }

      ParameterizedType type = (ParameterizedType) genericInterfaces[0];
      Type parameterType = type.getActualTypeArguments()[0];

      addMatcher(new ReflectiveMatcher(objectWithDelegateMethod));

      return DefaultValues.computeForWrapperType(parameterType);
   }

   private void addMatcher(@Nonnull ArgumentMatcher<?> matcher)
   {
      getCurrentPhase().addArgMatcher(matcher);
   }

   /**
    * Same as {@link #withEqual(Object)}, but matching any argument value of the appropriate type.
    * <p/>
    * Consider using instead the "anyXyz" field appropriate to the parameter type:
    * {@link #anyBoolean}, {@link #anyByte}, {@link #anyChar}, {@link #anyDouble}, {@link #anyFloat}, {@link #anyInt},
    * {@link #anyLong}, {@link #anyShort}, {@link #anyString}, or {@link #any} for other reference types.
    * <p/>
    * Note: when using {@link Deencapsulation#invoke(Object, String, Object...)}, etc., it's valid to pass
    * {@code withAny(ParameterType.class)} if an actual instance of the parameter type cannot be created.
    *
    * @param arg an arbitrary value which will match any argument value in the replay phase
    *
    * @return the input argument
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T> T withAny(T arg)
   {
      ArgumentMatcher<?> matcher;
      if (arg instanceof String) matcher = AlwaysTrueMatcher.ANY_STRING;
      else if (arg instanceof Integer) matcher = AlwaysTrueMatcher.ANY_INT;
      else if (arg instanceof Boolean) matcher = AlwaysTrueMatcher.ANY_BOOLEAN;
      else if (arg instanceof Character) matcher = AlwaysTrueMatcher.ANY_CHAR;
      else if (arg instanceof Double) matcher = AlwaysTrueMatcher.ANY_DOUBLE;
      else if (arg instanceof Float) matcher = AlwaysTrueMatcher.ANY_FLOAT;
      else if (arg instanceof Long) matcher = AlwaysTrueMatcher.ANY_LONG;
      else if (arg instanceof Byte) matcher = AlwaysTrueMatcher.ANY_BYTE;
      else if (arg instanceof Short) matcher = AlwaysTrueMatcher.ANY_SHORT;
      else matcher = AlwaysTrueMatcher.ANY_VALUE;

      addMatcher(matcher);
      return arg;
   }

   /**
    * Captures the argument value passed into the associated expectation parameter, for each invocation that matches the
    * expectation when the tested code is exercised.
    * As each such value is captured, it gets added to the given list so that it can be inspected later.
    * 
    * @param valueHolderForMultipleInvocations list into which the arguments received by matching invocations will be
    *                                          added
    *
    * @return the default value for type {@code T}
    *
    * @see Verifications#withCapture()
    * @see Verifications#withCapture(Object)
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withCapture">Tutorial</a>
    */
   protected final <T> T withCapture(List<T> valueHolderForMultipleInvocations)
   {
      addMatcher(new CaptureMatcher<T>(valueHolderForMultipleInvocations));
      return null;
   }

   /**
    * When passed as argument for an expectation, creates a new matcher that will check if the given value is
    * {@link Object#equals(Object) equal} to the corresponding argument received by a matching invocation.
    * <p/>
    * The matcher is added to the end of the list of argument matchers for the invocation being recorded/verified.
    * It cannot be reused for a different parameter.
    * <p/>
    * Usually, this particular method should <em>not</em> be used. Instead, simply pass the desired argument value
    * directly, without any matcher.
    * Only when specifying values for a <em>varargs</em> method it's useful, and even then only when some other argument
    * matcher is also used.
    *
    * @param arg the expected argument value
    *
    * @return the given argument
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T> T withEqual(T arg)
   {
      Map<Object, Object> instanceMap = getCurrentPhase().getInstanceMap();
      addMatcher(new LenientEqualityMatcher(arg, instanceMap));
      return arg;
   }

   /**
    * Same as {@link #withEqual(Object)}, but checking that a numeric invocation argument in the replay phase is
    * sufficiently close to the given value.
    *
    * @param value the center value for range comparison
    * @param delta the tolerance around the center value, for a range of [value - delta, value + delta]
    *
    * @return the given {@code value}
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final double withEqual(double value, double delta)
   {
      addMatcher(new NumericEqualityMatcher(value, delta));
      return value;
   }

   /**
    * Same as {@link #withEqual(Object)}, but checking that a numeric invocation argument in the replay phase is
    * sufficiently close to the given value.
    *
    * @param value the center value for range comparison
    * @param delta the tolerance around the center value, for a range of [value - delta, value + delta]
    *
    * @return the given {@code value}
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final float withEqual(float value, double delta)
   {
      addMatcher(new NumericEqualityMatcher(value, delta));
      return value;
   }

   /**
    * Same as {@link #withEqual(Object)}, but checking that an invocation argument in the replay phase is an instance of
    * the same class as the given object.
    * <p/>
    * Equivalent to a <code>withInstanceOf(object.getClass())</code> call, except that it returns {@code object} instead
    * of {@code null}.
    *
    * @param object an instance of the desired class
    *
    * @return the given instance
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T> T withInstanceLike(T object)
   {
      addMatcher(ClassMatcher.create(object.getClass()));
      return object;
   }

   /**
    * Same as {@link #withEqual(Object)}, but checking that an invocation argument in the replay phase is an instance of
    * the given class.
    *
    * @param argClass the desired class
    *
    * @return always {@code null}; if you need a specific return value, use {@link #withInstanceLike(Object)}
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T> T withInstanceOf(Class<T> argClass)
   {
      addMatcher(ClassMatcher.create(argClass));
      return null;
   }

   /**
    * Same as {@link #withEqual(Object)}, but checking that the invocation argument in the replay phase is different
    * from the given value.
    *
    * @param arg an arbitrary value, but different from the ones expected to occur during replay
    *
    * @return the given argument value
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T> T withNotEqual(T arg)
   {
      addMatcher(new InequalityMatcher(arg));
      return arg;
   }

   /**
    * Same as {@link #withEqual(Object)}, but checking that an invocation argument in the replay phase is {@code null}.
    *
    * @return always {@code null}
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T> T withNull()
   {
      addMatcher(NullityMatcher.INSTANCE);
      return null;
   }

   /**
    * Same as {@link #withEqual(Object)}, but checking that an invocation argument in the replay phase is not
    * {@code null}.
    *
    * @return always {@code null}
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T> T withNotNull()
   {
      addMatcher(NonNullityMatcher.INSTANCE);
      return null;
   }

   /**
    * Same as {@link #withEqual(Object)}, but checking that an invocation argument in the replay phase is the exact same
    * instance as the one in the recorded/verified invocation.
    *
    * @param object the desired instance

    * @return the given object
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T> T withSameInstance(T object)
   {
      addMatcher(new SamenessMatcher(object));
      return object;
   }

   // Text-related matchers ///////////////////////////////////////////////////////////////////////////////////////////

   /**
    * Same as {@link #withEqual(Object)}, but checking that a textual invocation argument in the replay phase contains
    * the given text as a substring.
    *
    * @param text an arbitrary non-null textual value
    *
    * @return the given text
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T extends CharSequence> T withSubstring(T text)
   {
      addMatcher(new StringContainmentMatcher(text));
      return text;
   }

   /**
    * Same as {@link #withEqual(Object)}, but checking that a textual invocation argument in the replay phase starts
    * with the given text.
    *
    * @param text an arbitrary non-null textual value
    *
    * @return the given text
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T extends CharSequence> T withPrefix(T text)
   {
      addMatcher(new StringPrefixMatcher(text));
      return text;
   }

   /**
    * Same as {@link #withEqual(Object)}, but checking that a textual invocation argument in the replay phase ends with
    * the given text.
    *
    * @param text an arbitrary non-null textual value
    *
    * @return the given text
    *
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T extends CharSequence> T withSuffix(T text)
   {
      addMatcher(new StringSuffixMatcher(text));
      return text;
   }

   /**
    * Same as {@link #withEqual(Object)}, but checking that a textual invocation argument in the replay phase matches
    * the given {@link Pattern regular expression}.
    * <p/>
    * Note that this can be used for any string comparison, including case insensitive ones (with {@code "(?i)"} in the
    * regex).
    *
    * @param regex an arbitrary (non-null) regular expression against which textual argument values will be matched
    *
    * @return the given regex
    *
    * @see Pattern#compile(String, int)
    * @see <a href="http://jmockit.org/tutorial/BehaviorBasedTesting.html#withMethods">Tutorial</a>
    */
   protected final <T extends CharSequence> T withMatch(T regex)
   {
      addMatcher(new PatternMatcher(regex.toString()));
      return regex;
   }
}
