package default1;

public class SelectionSort implements SortStrategy {
	long endTime = 0;
	long startTime = System.currentTimeMillis();

	@Override
	public long[] sort(long popcount[]) {
		for (int i = 0; i < popcount.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < popcount.length; j++) {
				if (popcount[j] < popcount[min]) {
					min = j;
				}
			}
			long temp = popcount[i];
			popcount[i] = popcount[min];
			popcount[min] = temp;
		}
		endTime = System.currentTimeMillis();
		return popcount;
	}

	@Override
	public long getSortTime() {
		long totalMsecs = (endTime - startTime);
		return totalMsecs;
	}

	@Override
	public String strategyName() {
		return "Selection Sort";
	}
}