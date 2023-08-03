package com.ssafy.j_fileio.lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FunctionalApiTest {
    private Map<String, Integer> grades;

    private void setup() {
        grades = new HashMap<>();
        grades.put("hong", 100);
        grades.put("jang", 80);
        grades.put("lim", 95);
        grades.put("kim", 90);
    }

    public static void main(String[] args) {
        FunctionalApiTest fpt = new FunctionalApiTest();
        fpt.setup();
        fpt.consumerTest();
        fpt.supplierTest();
        fpt.functionTest();
        fpt.predicateTest();
    }

    public void consumerTest() {
        // TODO: map의 각 요소를 이름:점수의 형태로 출력해보자.

        // END
    }

    public void supplierTest() {
        Integer score = grades.get("steve");
        // TODO: 만약 score가 null이면 0~100 사이의 값을 설정해보자.

        // END
        System.out.println(score);

    }

    public void functionTest() {

        List<String> result = null;
        // TODO: grades의 각 Entry를 이름(점수)형태의 문자열로 만들어 result에 담은 후 출력해보자.

        // END
        System.out.println(result);
    }

    public void predicateTest() {
        Set<Entry<String, Integer>> set = null;
        // TODO: grades의 Entry 중 name이 3자 넘고 score가 90점 이상인 것들만 set에 담은 후 출력해보자.

        // END
        System.out.println(set);
    }

}
