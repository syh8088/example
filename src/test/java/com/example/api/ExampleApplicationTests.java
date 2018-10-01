package com.example.api;

import com.example.api.model.entities.appnotice.AppNotice;
import com.example.api.model.entities.appnotice.AppNoticeDevice;
import com.example.api.util.security.PasswordEncoding;
import com.example.api.util.security.SHAPasswordEncoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ExampleApplicationTests {

    @Test
    public void Thread() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.printf("efefef");
            }
        };
        //Thread thread = new Thread(task);
        //thread.start();
        Future future = executorService.submit(task);
        System.out.printf(Thread.currentThread().getName());

        System.out.println(future);
    }

    @Test
    public void ExecuteExam() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;

                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println  ("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);

                    int value = Integer.parseInt("숫자");
                }
            };

            //executorService.execute(runnable);
             executorService.submit(runnable);

            Thread.sleep(10);
        }
        executorService.shutdown();
    }


    @Test
    public void kako() {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] result = new String[n];

        for(int i = 0; i < n; i++) {
            int arr = arr1[i] | arr2[i];
            //System.out.println(arr);
            int targetBit = 1;
            String resultString = "";
            System.out.println("" + Integer.toBinaryString(arr));
                for(int j = 0; j < n; j++) {
                    resultString = ((arr & targetBit) > 0 ? "#" : " ") + resultString;
                    targetBit = targetBit << 1;
                }
            result[i] = resultString;
                System.out.println(result[i]);




        }
    }

    @Test
    public void doubleArray() {

        int array1[] = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        System.out.println(array1[0]);
        System.out.println(array2[0]);

        String[] team1 = {"이상해씨", "이상해풀", "이상해꽃"};
        String[] team2 = {"꼬부기", "어니부기", "거북왕"};
        String[] team3 = {"파이리", "리자드", "리자몽"};
        String[] team4 = {"피츄", "피카츄", "라이츄"};

        Map<String, Object> map1 = new HashMap<>();
        map1.put("팀", "team1");
        map1.put("선수", team1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("팀", "team2");
        map2.put("선수", team2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("팀", "team3");
        map3.put("선수", team3);

        Map<String, Object> map4 = new HashMap<>();
        map4.put("팀", "team4");
        map4.put("선수", team4);

        Map[] main = {map1, map2, map3, map4};

        System.out.println(main);
        for(Map temp : main) {
            System.out.printf("%s\n", temp.get("팀"));
            String[] person = (String[]) temp.get("선수");
            for(String player : person) {
                System.out.printf("\t%s\n", player);
            }
        }

    }


    @Test
    public void array2() {
String pw = "as";

        String password = "1234";
        SHAPasswordEncoder shaPasswordEncoder = new SHAPasswordEncoder(512);
        shaPasswordEncoder.setEncodeHashAsBase64(true);
        PasswordEncoding passwordEncoding = new PasswordEncoding(shaPasswordEncoder);
        System.out.println("SHA 암호화: " + passwordEncoding.encode(password));


      // PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      //  String hashedPassword = passwordEncoder.encode(pw);

        int[][] array4 = new int[3][4];
        array4[0][1] = 10;

        int[][] array5 = new int[3][];
        array5[0] = new int[1];
        array5[0][0] = 10;

        int[][] array6 = {{1}, {1,2}, {1,2,3}};
     //   System.out.println(array6[0][0]);

    }

    @Test
    public void contextLoads() {
        HashSet<Integer> A = new HashSet<>();
        A.add(1);
        A.add(2);
        A.add(3);

        Iterator hi = A.iterator();
      /*  while(hi.hasNext()) {
            System.out.println(hi.next());
        }*/


        HashMap<String, Integer> a = new HashMap<>();
        a.put("one", 1);
        a.put("two", 2);
        a.put("three", 3);
        a.put("four", 4);
        System.out.println(a.get("one"));

        iteratorUsingForEach(a);
    }

    static void iteratorUsingForEach(HashMap map) {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    @Test
    public void enumTest() {

        //System.out.println(AppNotice.Category.EVENT.name());
        //System.out.println(AppNotice.Category.valueOf("EVENT"));

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18);
        List<String> noticeName = Arrays.asList("mobile_web", "sport_android", "sport_ios", "game_android", "game_ios");


        list.forEach(e -> {
            //System.out.println(e);
        });


        IntStream.range(0, 5).forEach(i -> {
        });



        // System.out.println(i);
        /*
            IntStream.range(0, i).forEach(j -> {
                //System.out.println(i);
                //System.out.println(j);
            });*/

        int e = 0;
        for (Integer integer : list) {

            if(e % 7 == 0) {
               // System.out.println(e);

            }

            e++;

        }


        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list1.stream().forEach((i) -> {
            //System.out.println(i);
        });


    }

}
