package fr.dauphine.javaavance.td5;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Panel {

	public static Iterator<Integer> panel1(int i, int j) {
			return new Iterator<Integer>() {
				int nbFirst = i;
				int nbEnd = j;
				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					if(nbFirst <= nbEnd) {
						return true;
					}
					return false;
				}

				@Override
				public Integer next() {
					// TODO Auto-generated method stub
					if(!hasNext()) {
						throw new NoSuchElementException("no such element");

					}
					return nbFirst++;

				}

			
		};

		
	}


	public static Iterable<Integer> panel2(int i, int j) {
		return new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {
				// TODO Auto-generated method stub
				return panel1(i, j);
			}

		};

	}

	public static List<Integer> panel(int i, int j) {
		if(i > j) {
			throw new IllegalArgumentException("i can not be greater than j");
		}
		return new AbstractList<Integer>() {
			int nbFirst = i;
			int nbEnd = j;
			@Override
			public Integer get(int index) {
				// TODO Auto-generated method stub
				return i + index;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return j - i + 1;
			}

		};
	}

	public static void main(String[] args) {

		Iterator<Integer> it = panel1(1,5);
		for (;it.hasNext();) {
			System.out.println(it.next());
		}

		System.out.println("---------------------------");


		for(int i:panel2(1, 5)) {
			System.out.println(i);
		}

		System.out.println("---------------------------");

		List<Integer> l = panel(3,6);
		for(int i:l) {
			System.out.println(i);
		}

		System.out.println(l.get(1));
	}



}
