package com.dogoo.poc.account.client.function;

import javax.annotation.Generated;

/**
 * @author phidx
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}