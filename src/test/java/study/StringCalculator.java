package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Calculator{
    public Calculator() {
    }
}

public class StringCalculator {


    @BeforeEach
    void setUp(){

    }

    /**
     * 덧셈
     * 뺄셈
     * 곱셈
     * 나눗셈
     * 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
     * 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
     * 사칙 연산을 모두 포함하는 기능 구현
     */
    @Test
    void stringCalculator(){
        //Scanner scanner = new Scanner(System.in);
        //String value = scanner.nextLine();
        String value = "2 + 3 * 4 / 2";
        String[] strArr = value.split(" ");

        Queue<Character> que = new LinkedList<>();
        for(String s : strArr){
            que.add(s.charAt(0));
        }

        int firstVal = 0;
        int secondVal = 0;
        char operation;
        int sum = 0;
        while (!que.isEmpty()){
            if(Character.isDigit(que.peek())){
                firstVal = (int)(que.poll()-'0');
            }else {
                operation = que.poll();
                secondVal = (int)(que.poll()-'0');
                if(operation == '+'){
                    sum=firstVal+secondVal;
                    firstVal=sum;
                }else if(operation == '-'){
                    sum=firstVal-secondVal;
                    firstVal=sum;
                }else if(operation == '*'){
                    sum=firstVal*secondVal;
                    firstVal=sum;
                }else if(operation == '/'){
                    sum=firstVal/secondVal;
                    firstVal=sum;
                }
            }
        }

        assertEquals(sum, 10);
    }
}
