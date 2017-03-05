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
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class TestAddPerformance {
	ArrayList<Integer> arrayList = new ArrayList<>();
	CopyOnWriteArrayList<Integer> cwArrayList = new CopyOnWriteArrayList<>();
	Vector<Integer> vector = new Vector<>();
	LinkedList<Integer> linkedList = new LinkedList<>();
	/**
	 * Test Add Method
	 */
	@Benchmark 
	public  void testArrayListAdd() {

		for(int i = 0; i < 10000; i++) {
			arrayList.add(i);
		}
	}

	@Benchmark
	public  void testVectorAdd() {
		for(int i = 0; i < 10000; i++) {
			vector.add(i);
		}
	}

	@Benchmark
	public  void testLinkedListAdd() {
		for(int i = 0; i < 10000; i++) {
			linkedList.add(i);
		}
	}

	//Concurrent 관련 
	@Benchmark
	public  void testCopyOnWriteListAdd() {
		for(int i = 0; i < 10000; i++) {
			cwArrayList.add(i);
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
