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

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class TestDeletePerformance {
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
	public  void testArrayListDelete() {
		int size =  arrayList.size();
		for(int i = size - 1; i >= 0; i--) {
			arrayList.remove(i);
		}
	}

	@Benchmark
	public  void testVectorDelete() {
		int size = vector.size();
		for(int i = size - 1; i >= 0; i--) {
			vector.remove(i);
		}
	}

	@Benchmark
	public  void testLinkedListDelete() {
		int size =  linkedList.size();
		for(int i = size - 1; i >= 0; i--) {
			linkedList.remove(i);
		}
	}

	//Concurrent 관련 
	@Benchmark
	public  void testCopyOnWriteListDelete() {
		int size =  cwArrayList.size();
		for(int i = size - 1; i >= 0; i--) {
			cwArrayList.remove(i);
		}
	}
}
