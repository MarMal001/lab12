package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

	private final List<Integer> list; 

	public LogicsImpl(final int size) {
		if (size <= 0){
			throw new IllegalArgumentException("Illegal size");
		}
		this.list = new ArrayList<>(size);
		for (int i = 0; i < size; i++){
			this.list.add(0);
		}
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public List<Integer> values() {
		return List.copyOf(this.list);
	}

	@Override
	public List<Boolean> enablings() { 
		return this.list.stream()
			.map(i -> i < this.list.size())
			.toList();
	}

	@Override
	public int hit(final int elem) {
		this.list.set(elem, this.list.get(elem) + 1);
		return this.list.get(elem);
	}

	@Override
	public String result() {
		return "<<" + this.list.stream()
			.map(i -> Integer.toString(i))
			.collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return this.list.stream()
			.allMatch(i -> i == this.list.get(0));
	}
}
