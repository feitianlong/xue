package ArrayQuestion;

/**
 * @author l.wang(516066490@qq.com)
 */
public class SuduSolution {
    /**
     * �ų���������( �ո�ֿ���81������ 0 ��ʾ����,)
     */
    static String source = "0 4 8 0 9 3 0 0 2" +
                           "0 3 7 1 2 0 8 4 5" + 
                           "0 0 1 8 0 0 7 0 0" + 
                           "7 9 3 6 1 2 0 5 8" +
                           "8 5 4 3 0 9 0 2 1" + 
                           "6 1 2 5 4 8 0 0 3" + 
                           "1 2 6 4 8 5 3 9 7" +
                           "4 8 5 9 3 0 2 0 6" +
                           "3 7 9 2 0 1 5 8 4";
    static long start;
    static int i;

    public static void main(String[] args) {
        start = System.nanoTime();
        int[][] data = init(source);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (data[i][j] == 0) {
                    data[i][j] = 0x1ff;
                }
            }
        }
        print(data);
        solve(data);
        System.out.println("����ʱ��" + (System.nanoTime() - start) / 1000000.0 + "ms");
    }

    private static void solve(int[][] data) {
        analyse(data);
        int result = check(data);
        if (result == 1) {
            int[] position = smallPosition(data);
            int pv = data[position[0]][position[1]];
            int pvcount = Integer.bitCount(pv);
            for (int i = 0; i < pvcount; i++) {
                int testV = 1 << ((int) (Math.log(Integer.highestOneBit(pv)) / Math.log(2)));
                pv ^= testV;
//               System.out.println("����["+position[0]+","+position[1]+"]"+((int)
//               (Math.log(Integer.highestOneBit(testV)) / Math.log(2))+1));
                int[][] copy = copyData(data);
                copy[position[0]][position[1]] = testV;
                solve(copy);
            }
        } else if (result == 0) {
            System.out.println("------------------------------------��"+(++i)+"����---------------------"
                    + (System.nanoTime() - start) / 1000000.0 + "ms---");
            print(data);
        }
    }

    /**
     * ������������
     * @param data
     * @return
     */
    private static int[][] copyData(int[][] data) {
        int[][] copy = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                copy[i][j] = data[i][j];
            }
        }
        return copy;
    }

    /**
     * �ҵ���ѡ�����ٵ�λ�ÿ�ʼ����<br>
     * <b>****����������Ч��*****<b>
     * @param data
     * @return int[2] ����λ��
     */
    public static int[] smallPosition(int[][] data) {
        int[] res = null;
        int smallCount = 10;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int bitcount = Integer.bitCount(data[i][j]);
                if (bitcount == 2) {
                    return new int[] { i, j };
                } else if (bitcount != 1) {
                    if (smallCount > bitcount) {
                        smallCount = bitcount;
                        res = new int[] { i, j };
                    }
                }
            }
        }
        return res;
    }

    /**
     * �����
     * @param data
     * @return <b>0</b>   ��ȷ<br>
     *                  <b>1</b>    ����λ��δ��<br>
     *                  <b>-1</b>    ����<br>
     */
    private static int check(int[][] data) {
        for (int i = 0; i < 9; i++) {
            int row = 0;
            int col = 0;
            int block = 0;
            for (int j = 0; j < 9; j++) {
                if (Integer.bitCount(data[i][j]) > 1) {
                    return 1;
                }
                row |= data[i][j];
                col |= data[j][i];
            }

            for (int h = i / 3 * 3; h < i / 3 * 3 + 3; h++) {
                for (int l = i % 3 * 3; l < i % 3 * 3 + 3; l++) {
                    block |= data[h][l];
                }
            }
            if (row != 0x1ff || col != 0x1ff || block != 0x1ff) {
                return -1;
            }
        }
        return 0;
    }

    private static void analyse(int[][] data) {
        boolean changed = false;
        changed = reduce(data);
        //TODO �����Լ�������ɾ����ѡ���㷨��������һ������������
        if (changed) {
            analyse(data);
        }
    }

    /**
     * �������й�����ֵ���м򵥵ĺ�ѡ��ɾ��
     * @param data
     * @return
     */
    private static boolean reduce(int[][] data) {
        boolean changed = false;
        for (int m = 0; m < 9; m++) {
            for (int n = 0; n < 9; n++) {
                if (Integer.bitCount(data[m][n]) != 1) {
                    if (setMaybe(data, m, n)) {
                        changed = true;
                    }
                }
            }
        }
        return changed;
    }

    /**
     * ����m��n��λ�õĿ���ֵ
     * 
     * @param m
     *            �У�0-8��
     * @param n
     *            �У�0-8��
     * @return �Ƿ�����˺�ѡ��
     */
    private static boolean setMaybe(int[][] data, int m, int n) {
        if (Integer.bitCount(data[m][n]) == 1) {
            return false;
        }
        int row = 0;// ����ȷ��ֵ����
        int col = 0;// ����ȷ��ֵ����
        int block = 0; // ������ȷ��ֵ����

        for (int i = 0; i < 9; i++) {
            if (Integer.bitCount(data[m][i]) == 1) {
                row += data[m][i];
            }
            if (Integer.bitCount(data[i][n]) == 1) {
                col += data[i][n];
            }
        }

        for (int i = m / 3 * 3; i < m / 3 * 3 + 3; i++) {
            for (int j = n / 3 * 3; j < n / 3 * 3 + 3; j++) {
                if (Integer.bitCount(data[i][j]) == 1) {
                    block += data[i][j];
                }
            }
        }

        int have = row | col | block;// �����ܵ�ֵ
        int left = 0x1ff ^ have;// ��ѡ��
        // System.out.println("["+m+","+n+"]"+Integer.toBinaryString(left));
        return tryReduce(data, m, n, left);
    }

    /**
     * �µĺ�ѡ�����ϵĺ�ѡ���Ƚϣ����Լ��ٺ�ѡ��
     * 
     * @param data
     * @param m
     *            �У�0-8��
     * @param n
     *            �У�0-8��
     * @param v
     *            ��ѡ������0x1F9(������1 1111 1001)��ʾ��ѡ��Ϊ1 4 5 6 7 8 9
     * @return �Ƿ�ı���m��n�еĺ�ѡ��,<br/>
     *         <b>true</b> �����˺�ѡ��<br/>
     *         <b>false</b> û�м���
     */
    private static boolean tryReduce(int[][] data, int m, int n, int v) {
        int old = data[m][n];
        data[m][n] = old & v;
        return data[m][n] != old;
    }

    /**
     * ��ʼ������
     * 
     * @param source
     *            �ո�ֿ���81������ 0 ��ʾ����
     * @return
     */
    private static int[][] init(String source) {
        source = source.replace(" ", "");
        int[][] data = new int[9][9];
        for (int i = 0; i < source.length(); i++) {
            //Ӧ����source.charAt(i) - '0'
            int v = Integer.parseInt(source.charAt(i) + "");
            if (v != 0) {
                data[i / 9][i % 9] = 1 << (v - 1);
            }
        }
        return data;
    }

    /**
     * ��ӡ����
     * 
     * @param data
     */
    private static void print(int[][] data) {
        for (int m = 0; m < 9; m++) {
            for (int n = 0; n < 9; n++) {
                int v = getV9(data[m][n]);
                if (v != -1) {
                    System.out.print(v + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    /**
     * ��ʹ��1��λ�Ʊ�ʾ������ת��Ϊ����;
     * 
     * @param v
     *            ��1��λ�Ʊ�ʾ����ֵ
     * @return
     */
    public static int getV9(int v) {
        // ʹ��switch��ʹ��Math.logʱ��Ч�ʲ��
        switch (v) {
        case 1:
            return 1;
        case 2:
            return 2;
        case 4:
            return 3;
        case 8:
            return 4;
        case 16:
            return 5;
        case 32:
            return 6;
        case 64:
            return 7;
        case 128:
            return 8;
        case 256:
            return 9;
        default:
            break;
        }
        return -1;
    }

}