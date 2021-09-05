package default1;

public class InsertionSort implements SortStrategy {
	long endTime = 0;
	long startTime = System.currentTimeMillis();

	public long[] sort(long popcount[]) {
		for (int i = 1; i < popcount.length; i++) {
			long index = popcount[i];
			int j = i;
			while (j > 0 && popcount[j - 1] > index) {
				popcount[j] = popcount[j - 1];
				j--;
			}
			popcount[j] = index;
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
		return "Insertion Sort";
	}
}
