package domain;

@FunctionalInterface
public interface ChickenFunction<T, V> {
	void run(T t, V v);
}
