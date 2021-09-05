package default1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.StringTokenizer;
@SuppressWarnings("unused")
public class WorldPopulation {
	SortStrategy sortStrategy;
	long[] population = new long[13484]; // Cheating because we know number of records!!
	// Lab Exercise: After creating some strategy classes -- set the default
	// strategy here.
	long totalPopulation = 0;

	public WorldPopulation() {
		sortStrategy = new SelectionSort();
		; // Set the default strategy here.
	}

	public void readInputFile() {
		population = readPopulationFile("src\\WorldPopulation.csv");
	}

	public void setStrategy(SortStrategy strategy) {
		sortStrategy = strategy;
	}

	// Lab Exercise: Read in the WorldPopulation.csv
	// Extract ONLY the numbers and store them into population[]
	public long[] readPopulationFile(String fileName) {
		int i = 0;
		try {

			FileReader inputFile = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(inputFile);
			String line;
			while ((line = reader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				if (tokenizer.hasMoreTokens()) {
					String country = tokenizer.nextToken();
					int year = Integer.parseInt(tokenizer.nextToken());
					long count = Long.parseLong(tokenizer.nextToken());
					population[i++] = count;
					totalPopulation += count;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return population;
	}

	// Lab Exercise. Complete this method.
	// Delegate sorting to the strategy object
	public void sortPopulation() {
		population = sortStrategy.sort(population);
		long sortTime = sortStrategy.getSortTime();
		System.out.println(sortStrategy.strategyName() + " : " + sortTime + " milliseconds");
	}

	public void computeTotalPopulation() {
		System.out.println("Total World Population : " + totalPopulation);
	}

	// Experiment with various strategies.
	// Create 3 strategies -- Bubble, insertion, and selection sort.
	public static void main(String[] args) {
		WorldPopulation worldPopulation = new WorldPopulation();
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new BubbleSort()); // Bubble sort strategy.
		worldPopulation.sortPopulation();
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new InsertionSort()); // Insertion sort strategy.
		worldPopulation.sortPopulation();
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new SelectionSort()); // Selection sort strategy.
		worldPopulation.sortPopulation();
		worldPopulation.computeTotalPopulation();
	}
}