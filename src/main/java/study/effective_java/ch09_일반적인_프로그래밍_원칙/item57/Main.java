package study.effective_java.ch09_일반적인_프로그래밍_원칙.item57;

import java.util.Iterator;
import java.util.List;

public class Main {

    private static int[] arr = {1, 2, 3, 4};
    private static List<Integer> a = List.of(1, 2, 3, 4);
    private static List<Integer> b = List.of(5, 6, 7, 8);

    public void variable() {
        // 나쁨: 위에 모아서 선언하면 실제 의미가 흐려짐
        int count;
        count = a.size();

        // 좋음
        int count2 = a.size();
    }

    public void rangeBad() {
        // i가 루프 밖에서 살아남음
        int i = 0;
        int n = arr.length;
        while (i < n) {
            int i1 = arr[i++];
        }
    }

    public void rangeGood() {
        // for가 범위를 루프 내부로 제한
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i++];
        }
    }

    public void anti() {
        // 외부 상태 변경
        int[] sum = {0};
        a.forEach(i -> sum[0] += i);

        // 범위가 루프 안으로 갇힌 리듀스
        int sum2 = a.stream().mapToInt(Integer::intValue).sum();
    }
}
