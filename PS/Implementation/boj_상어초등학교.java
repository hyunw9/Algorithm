package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_상어초등학교 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[][] graph;
  private static HashMap<Integer, Set<Integer>> map;
  private static PriorityQueue<int[]> lv2;
  private static PriorityQueue<int[]> lv3;
  private static int n;

  static class Node {
    int y;
    int x;
    int empty;
    int like;

    public Node(int y, int x, int like, int empty) {
      this.y = y;
      this.x = x;
      this.empty = empty;
      this.like = like;
    }
  }

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 배열 반복돌면서 인접한 칸에 좋아하는 학생이 가장 많은거 구하기
    // 만약 그게 여러개이거나 0일 경우에는 인접 칸중 가장 빈게 많은 칸으로 정하기
    // 그것도 여러개일 경우 행 번호가 가장 작은칸, 그것도 아닐경우 열번호 갖아 작은 칸으로 정하기

    // Hashmap에 Set 붙여서 학생 + 좋아하는 번호 저장하기
    // 빈 칸 저장하는 자료구조 but 개수가 판별 가능해야함. pq에 칸 많은 순으로 저장, 그래서 poll과 peek 이 같으면 3번으로
    // 그래서 그걸 행, 열 오름차순 정렬된 pq에 넣고 뽑아서 값 저장.
    n = Integer.parseInt(st.nextToken());
    graph = new int[n][n];
    // init
    map = new HashMap<>();
    for (int i = 1; i <= n * n; i++) {
      map.put(i, new HashSet<>());
    }

    // 각 칸별로 인접하게 좋아하는 학생 수 구하기?
    // 인접한 칸에 좋아하는 학생이 가장 많은거 구하기
    // 만약 그게 여러개이거나 0일 경우에는 인접 칸중 가장 빈게 많은 칸으로 정하기

    PriorityQueue<Node> likeq =
        new PriorityQueue<>(
            (o1, o2) -> {
              // 좋아 카운트가 같으면 빈칸 카운트
              // 빈칸 카운트가 같으면 행작은거
              // 행이 같으면 열 작은거
              if (o1.like == o2.like) {
                if (o1.empty == o2.empty) {
                  if (o1.y == o2.y) {
                    return o1.x - o2.x;
                  } else {
                    return o1.y - o2.y;
                  }
                } else {
                  return o2.empty - o1.empty;
                }
              } else {
                return o2.like - o1.like;
              }
            });

    for (int p = 1; p <= n * n; p++) {
      likeq.clear();
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());

      for (int j = 0; j < 4; j++) {
        map.get(k).add(Integer.parseInt(st.nextToken()));
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {

          if (graph[i][j] > 0) continue;
          int[] count = getCount(i, j, k);
          // System.out.println(count);
          likeq.offer(new Node(i, j, count[0], count[1]));
        }
      }
      Node info = likeq.poll();
      graph[info.y][info.x] = k;
    //   System.out.println("info.y: " + info.y + " info.x: " + info.x);
    }
    // print();
    int sum = 0;
    // System.out.println("------------------");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int[] count = getCount(i, j, graph[i][j]);

        int like = count[0];
        if (like == 0) {
            sum +=0;
        }if (like == 1) {
          sum += 1;
        } else if (like == 2) {
          sum += 10;
        } else if (like == 3) {
          sum += 100;
        } else if(like == 4){
          sum += 1000;
        }
      }
    }
    print();
    System.out.println(sum);
    close();
  }

  private static void print(){
    for(int i = 0; i < n ; i++){
        System.out.println(Arrays.toString(graph[i]));
    }
  }

  private static int[] getCount(int y, int x, int k) {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int count = 0;
    int emptycount = 0;
    for (int i = 0; i < 4; i++) {
      int ny = dy[i] + y;
      int nx = dx[i] + x;

      if (nx < 0 || ny < 0 || ny >= n || nx >= n) continue;

      if (map.get(k).contains(graph[ny][nx])) count += 1;
      if (graph[ny][nx] == 0) emptycount += 1;
    }
    // System.out.println(" k : "+ k + " count : "+ count + " empty : " + emptycount);
    return new int[] {count, emptycount};
  }

  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}

/*
 ** 간략한 풀이 :
 */
