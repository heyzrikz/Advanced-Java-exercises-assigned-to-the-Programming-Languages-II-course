public interface WeightedSet<T> {
    public void add(T obj, int t);
    public WeightedSet<T> atLeast(int threshold);
}
