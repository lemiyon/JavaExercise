package performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class TestGetPerformance {
	ArrayList<Integer> arrayList = new ArrayList<>();
	CopyOnWriteArrayList<Integer> cwArrayList = new CopyOnWriteArrayList<>();
	Vector<Integer> vector = new Vector<>();
	LinkedList<Integer> linkedList = new LinkedList<>();

	@Setup
	public void setUp() {
		for(int i = 0; i < 10000; i++) {
			arrayList.add(i);
			cwArrayList.add(i);
			vector.add(i);
			linkedList.add(i);
		}
	}
	/**
	 * Test Get Method
	 */
	@Benchmark 
	public  void testArrayListGet() {
		for(int i = 0; i < 10000; i++) {
			arrayList.get(i);
		}
	}

	@Benchmark
	public  void testVectorGet() {

		for(int i = 0; i < 10000; i++) {
			vector.get(i);
		}
	}

	@Benchmark
	public  void testLinkedListGet() {

		for(int i = 0; i < 10000; i++) {
			linkedList.get(i);
		}
	}

	//Concurrent 관련 
	@Benchmark
	public  void testCopyOnWriteListGet() {
		for(int i = 0; i < 10000; i++) {
			cwArrayList.get(i);
		}
	}
	
	@TearDown
	public void tearDown() {
		arrayList.clear();
		cwArrayList.clear();
		vector.clear();
		linkedList.clear();
	}
}


