import java.util.List;

public class PascalsTriangle {
    // 杨辉三角
    // 杨辉三角有很多数学特性，需要牢记。

    int level;
    long[][] list;

    public PascalsTriangle(int level) {
        if (level < 3) throw new IllegalArgumentException();
        this.level = level;
        list = new long[level + 1][level + 1];
        build();
    }

    private void build() {
        // level 1
        list[1][1] = 1;

        // level 2
        list[2][1] = 1;
        list[2][2] = 1;

        for (int i = 3; i <= level; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    list[i][j] = 1;
                } else {
                    list[i][j] = list[i - 1][j - 1] + list[i - 1][j];
                }
            }
        }
    }

    public void print() {
        for (int i = 1; i <= level; i++) {
            for (int j = 1; j <= level; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int levelSum(int level) {
        // 每一个level的和有以下的特点
        // levelSum(level) = 2 ^ (level-1);

        return (int) Math.pow(2, (double) level - 1);
    }

    // 杨辉三角还有一个特性是，可以表示二项分布，
    // 比如有5个硬币，求有三个是正面是的概率，我们求可以直接返回list[5][3]即可。
    public double possibility(int total, int positive) {
        if (total > level || total <= 0 || positive > total) throw new IllegalArgumentException();

        return (double) list[total][positive] / (double) levelSum(total);
    }
}
