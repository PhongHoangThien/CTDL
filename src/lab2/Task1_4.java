package lab2;

public class Task1_4 {
	public static void moveTower(int disk, int source, int dest, int spare) {
		if (disk == 0) return;
		else {
			moveTower(disk - 1, source, dest, spare);
		}
	}
}
