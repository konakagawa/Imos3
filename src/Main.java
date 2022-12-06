
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		int N = Integer.parseInt(line);

		// cube index
		// 0:min 頂点、1:max 頂点
		// x,y,z
		int[][][] cubes = new int[N][2][3];
		for (int i = 0; i < N; i++) {
			line = sc.nextLine();
			String[] str = line.split(" ");
			for (int j = 0; j < 3; j++) {
				cubes[i][0][j] = Integer.parseInt(str[j]);
				cubes[i][1][j] = Integer.parseInt(str[j + 3]);
			}

		}

		// 領域の初期化 area[z][y][x]
		int[][][] area = new int[10][10][10];
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[i].length; j++) {
				Arrays.fill(area[i][j], 0);
			}
		}

		// 1と-1をコーナーに設置
		for (int i = 0; i < N; i++) {
			int[] xyz = cubes[i][0];
			int[] XYZ = cubes[i][1];
			// 下の面
			area[xyz[2]][xyz[1]][xyz[0]] += 1;
			area[xyz[2]][XYZ[1]][xyz[0]] += -1;
			area[xyz[2]][xyz[1]][XYZ[0]] += -1;
			area[xyz[2]][XYZ[1]][XYZ[0]] += 1;
			// 上の面
			area[XYZ[2]][xyz[1]][xyz[0]] += -1;
			area[XYZ[2]][XYZ[1]][xyz[0]] += 1;
			area[XYZ[2]][xyz[1]][XYZ[0]] += 1;
			area[XYZ[2]][XYZ[1]][XYZ[0]] += -1;
		}

		// 領域の計算
		// x軸方向に累積和
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[i].length; j++) {
				for (int k = 1; k < area[i][j].length; k++) {
					area[i][j][k] += area[i][j][k - 1];
				}
			}
		}

		// y軸方向に累積和
		for (int i = 0; i < area.length; i++) {
			for (int j = 1; j < area[i].length; j++) {
				for (int k = 0; k < area[i][j].length; k++) {
					area[i][j][k] += area[i][j - 1][k];
				}
			}
		}

		// z軸方向に累積和
		for (int i = 1; i < area.length; i++) {
			for (int j = 0; j < area[i].length; j++) {
				for (int k = 0; k < area[i][j].length; k++) {
					area[i][j][k] += area[i - 1][j][k];
				}
			}
		}

		// 結果の出力
		int taiseki = 0;
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[i].length; j++) {
				for (int k = 0; k < area[i][j].length; k++) {
					// 一つ以上重なっている場合
					if (area[i][j][k] > 1) {
						taiseki++;
					}
				}
			}

		}
		System.out.print(taiseki);
		sc.close();

	}

}
