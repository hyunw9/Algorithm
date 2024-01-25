package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_16113_시그널 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    String line = br.readLine();
    int offset = line.length() / 5;
    char[][] arr = new char[5][offset];
    int idx = 0;

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = line.charAt(j + idx);
        System.out.print(line.charAt(j + idx));
      }
      idx += offset;

    }

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        bw.write(arr[i][j] + " ");
      }
      bw.write("\n");

    }
    int x = 0;

    for (int i = 0; i < offset; i++) {

      int num = check(arr, x);
      if (num == 1) {
        x = x + 2;
      } else {
        x = x + 3;
      }
      System.out.println("num: "+num);
      bw.write(num+"");
    }
    close();
  }

  public static int check(char[][] arr, int x) {
    if (checkOne(arr, 0, x)) {
      return 1;
    } else if (
        check1(arr, 0, x) && check2(arr, 0, x) && check3(arr, 0, x) && check5(arr, 0, x) && check6(
            arr, 0, x) && check7(arr, 0, x)
    ) return 0;
    else if(check1(arr, 0, x) &&check3(arr, 0, x)&&check4(arr, 0, x)&& check5(arr, 0, x)&& check7(arr, 0, x))
      return 2;
    else if(check1(arr, 0, x) &&check3(arr, 0, x)&&check4(arr, 0, x)&& check6(arr, 0, x)&& check7(arr, 0, x))
      return 3;
    else if(check2(arr, 0, x) &&check3(arr, 0, x)&&check4(arr, 0, x)&& check6(arr, 0, x))
      return 4;
    else if(check1(arr, 0, x) &&check2(arr, 0, x)&&check4(arr, 0, x)&& check6(arr, 0, x)&& check7(arr, 0, x))
      return 5;
    else if(check1(arr, 0, x) &&check2(arr, 0, x)&&check4(arr, 0, x)&& check5(arr, 0, x)&& check6(arr, 0, x)&& check7(arr, 0, x))
      return 6;
    else if(check1(arr, 0, x) &&check3(arr, 0, x)&&check6(arr, 0, x))
      return 7;
    else if(check1(arr, 0, x) &&check2(arr, 0, x)&&check3(arr, 0, x)&&check4(arr, 0, x)&& check5(arr, 0, x)&& check6(arr, 0, x)&& check7(arr, 0, x))
      return 8;
    else if(check1(arr, 0, x) &&check2(arr, 0, x)&&check3(arr, 0, x)&&check4(arr, 0, x)&& check6(arr, 0, x)&& check7(arr, 0, x))
      return 9;
    return 0;
  }

  public static boolean checkOne(char[][] arr, int startY, int startX) {
    System.out.println("startX: "+startX);
    for (int i = 0; i < 5; i++) {
      if (arr[startY+i][startX ] == '.') {
        return false;
      }
    }
    return true;
  }

  public static boolean check2(char[][] arr, int startY, int startX) {
    for (int i = 0; i < 3; i++) {
      if (arr[startY + i][startX] == '.') {
        return false;
      }
    }
    return true;
  }

  public static boolean check1(char[][] arr, int startY, int startX) {
    for (int i = 0; i < 3; i++) {
      if (arr[startY][startX + i] == '.') {
        return false;
      }
    }
    return true;
  }

  public static boolean check3(char[][] arr, int startY, int startX) {
    startX = startX + 2;
    for (int i = 0; i < 3; i++) {
      if (arr[startY + i][startX] == '.') {
        return false;
      }
    }
    return true;
  }

  public static boolean check4(char[][] arr, int startY, int startX) {
    startY = startY + 2;
    for (int i = 0; i < 3; i++) {
      if (arr[startY][startX + i] == '.') {
        return false;
      }
    }
    return true;
  }

  public static boolean check5(char[][] arr, int startY, int startX) {
    startY = startY + 2;
    for (int i = 0; i < 3; i++) {
      if (arr[startY + i][startX] == '.') {
        return false;
      }
    }
    return true;
  }

  public static boolean check6(char[][] arr, int startY, int startX) {
    startY = startY + 2;
    startX = startX + 2;
    for (int i = 0; i < 3; i++) {
      if (arr[startY + i][startX] == '.') {
        return false;
      }
    }
    return true;
  }

  public static boolean check7(char[][] arr, int startY, int startX) {
    startY = startY + 4;
    for (int i = 0; i < 3; i++) {
      if (arr[startY][startX + i] == '.') {
        return false;
      }
    }
    return true;
  }


  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
