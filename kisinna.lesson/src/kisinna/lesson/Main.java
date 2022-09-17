package kisinna.lesson;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomList<Integer> list = new CustomList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.print();
		list.reverse();
		list.print();
	}
}
