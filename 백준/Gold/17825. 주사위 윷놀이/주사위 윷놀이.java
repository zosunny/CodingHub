import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int[] arr = new int[10];
    static int[][] board = new int[42][2];
    static int maxScore = Integer.MIN_VALUE;
    static Map<Integer, int[]> mals = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        for(int i=0; i<10; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        for(int i=1; i<=4; i++) {
            mals.put(i, new int[]{1, 0});
        }
        dfs(0, 0);
        System.out.println(maxScore);
    }

    public static void dfs(int turn, int totalScore) {
        if(turn == 10) {
            maxScore = Math.max(totalScore, maxScore);
            return;
        }

        int[][] tmp = new int[42][2];
        for(int i=1; i<=41; i++) {
            tmp[i][0] = board[i][0];
            tmp[i][1] = board[i][1];
        }

        for(int mal=1; mal<=4; mal++) {
            int[] curPos = mals.get(mal);
            int cur = curPos[0];
            int blue = curPos[1];

            if (cur != 41) {
                int score = move(mal, arr[turn]);
                if(score > 0) {
                    if(score == 41) {
                        score = 0;
                    }
                    dfs(turn+1, totalScore + score);
                    mals.put(mal, new int[]{cur, blue});
                    for (int i=1; i<=41; i++) {
                        board[i][0] = tmp[i][0];
                        board[i][1] = tmp[i][1];
                    }
                }
            }
        }
    }

    public static int move(int mal, int step) {
        int[] curPos = mals.get(mal);
        int pos = curPos[0];
        int blue = curPos[1];

        if(blue == 0 && (pos % 10 == 0 && pos < 40)) {
            if(pos == 10) {
                pos += 3;
            } else if(pos == 20) {
                pos += 2;
            } else if(pos == 30) {
                pos -= 2;
            }
            step--;
            blue = 1;
        }

        for(int i=0; i<step; i++) {
            if(pos == 40) {
                pos = 41;
                break;

            } else if(pos == 1) {
                pos = 2;
                continue;
            }

            if(blue == 1) {
                if(pos % 5 == 0) {
                    pos += 5;
                } else if(pos == 19 || pos == 26 || pos == 24) {
                    pos = 25;
                } else if(pos > 25){
                    pos -= 1;
                } else if(pos > 20) {
                    pos += 2;
                } else {
                    pos += 3;
                }

            } else {
                pos += 2;
            }
        }
        if(pos == 40) {
            if(board[pos][0] == 0 && board[pos][1] == 0) {
                board[curPos[0]][curPos[1]] = 0;
                board[pos][blue] = mal;
                mals.put(mal, new int[]{pos, blue});
                return pos;
            }

        } else if(pos == 41 || board[pos][blue] == 0) {
            board[curPos[0]][curPos[1]] = 0;
            board[pos][blue] = mal;
            mals.put(mal, new int[]{pos, blue});
            return pos;

        }
        return 0;
    }
}