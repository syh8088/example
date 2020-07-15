package com.example.api.blogCode.hash_code_test;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;

@RunWith(JUnit4.class)
public class HashCodeTest {

    @Test
    public void hashcode_재정의() {
        HashMap<ExtendedPhoneNumber, String> map = new HashMap<>();
        map.put(new ExtendedPhoneNumber(707, 867, 5307), "제니");
        System.out.println("Instance 1 hashcode : " + new ExtendedPhoneNumber(707, 867, 5307).hashCode());
        System.out.println("Instance 2 hashcode : " + new ExtendedPhoneNumber(707, 867, 5307).hashCode());
        Assert.assertEquals(map.get(new ExtendedPhoneNumber(707, 867, 5307)), "제니");
    }

    @Test
    public void hashcode_재정의안함() {
        HashMap<PhoneNumber, String> map = new HashMap<>();
        map.put(new PhoneNumber(707, 867, 5307), "제니");
        System.out.println("Instance 1 hashcode : " + new PhoneNumber(707, 867, 5307).hashCode());
        System.out.println("Instance 2 hashcode : " + new PhoneNumber(707, 867, 5307).hashCode());
        Assert.assertNotEquals(map.get(new PhoneNumber(707, 867, 5307)), "제니");
    }

    @NoArgsConstructor
    @AllArgsConstructor
    public static class PhoneNumber {
        protected int firstNumber;
        protected int secondNumber;
        protected int thirdNumber;

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof PhoneNumber)) {
                return false;
            }

            PhoneNumber p = (PhoneNumber) o;
            return this.firstNumber == p.firstNumber &&
                    this.secondNumber == p.secondNumber &&
                    this.thirdNumber == p.thirdNumber;
        }
    }

    @NoArgsConstructor
    public static class ExtendedPhoneNumber extends PhoneNumber {

        public ExtendedPhoneNumber(int firstNumber, int secondNumber, int thirdNumber) {
            super(firstNumber, secondNumber, thirdNumber);
        }

        @Override
        public int hashCode() {
            int c = 31;
            int hashcode = Integer.hashCode(firstNumber);
            hashcode = c * hashcode + Integer.hashCode(secondNumber);
            hashcode = c * hashcode + Integer.hashCode(thirdNumber);
            return hashcode;
        }
    }
}