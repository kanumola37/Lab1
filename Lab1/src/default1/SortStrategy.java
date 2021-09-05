package default1;

public interface SortStrategy {

	long getSortTime();

	String strategyName();

	long[] sort(long[] popcount);

}
