package main;

// 호출
import java.util.*;
import java.io.*;

public class Baseball {
	// playGame이라는 이름의 매소드 생성
    public static int playGame() throws IOException {
    	
    	// 세개의 숫자의 변수 선언
    	int x,y,z;
    	// 랜덤 함수 선언
    	Random r = new Random();
    	
    	// x는 1부터 9까지의 난수
    	x = Math.abs(r.nextInt()%9)+1;
    	// y와 x가 같은 난수를 지정 받았을 경우 다시 난수 지정
    	do {
    		y = Math.abs(r.nextInt()%9)+1;
		} while (x==y);
    	
    	// z와 x가 같은 난수를 지정 받았을 경우 또는 z와 y가 같은 난수를 지정 받았을 경우 다시 난수 지정
    	do {
    		z = Math.abs(r.nextInt()%9)+1;
		} while (y==z || z==x);
    	
    	// 겹치지 않는 난수가 지정된 x, y, z를 반환
    	return playGame(x, y, z);
    }
        
    

    // PlayGame이라는 이름의 x, y, z 세가지 숫자를 파라미터 값으로 가지는 매소드 생성
    public static int playGame(int x, int y, int z) throws IOException {
    	
    	// 시도 횟수를 나타내는 변수 선언
    	int count;
        // 스트라이크와 볼 몇 개를 맞췄는지 알려주는 변수 선언
    	int strike, ball;
        // 플레이어가 입력한 숫자가 들어갈 배열 생성
    	int usr[] = new int[3];
        // 세 개의 난수가 들어갈 배열 생성
    	int com[] = {x, y, z};
        
        // 숫자 야구 게임 시작
        System.out.println("숫자 야구 게임 시작");
        
        // count를 0으로 초기화
        count = 0;

        // 스트라이크 세 개를 모두 맞추거나 시도 횟수가 11 이상이될때까지 반복
        do {
        	// 한 번 시도할때마다 시도 횟수 +1
        	count++;
            // 올바른 값을 입력받을 때까지 반복
        	do {
            	// 현재의 시도 횟수 출력
        		System.out.println("카운트: " + count);
                
                // 숫자 입력받는 부분
        		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        		String user;
                
                System.out.print("1번째 숫자: ");
                user = in.readLine();
                usr[0] = new Integer(user).intValue();
                
                System.out.print("2번째 숫자: ");
                user = in.readLine();
                usr[1] = new Integer(user).intValue();

                System.out.print("3번째 숫자: ");
                user = in.readLine();
                usr[2] = new Integer(user).intValue();

                // 사용자가 입력해야 하는 숫자의 조건을 부여
                if (usr[0] == 0 || usr[1] == 0 || usr[2] == 0) { 
                    System.out.println("0은 입력하지 마세요. 다시 입력해주세요.");
                } else if (usr[0] > 9 || usr[1] > 9 || usr[2] > 9) {
                    System.out.println("1부터 9까지의 숫자 중 하나를 입력해주세요. 다시 입력해주세요.");
                } else if (usr[0] == usr[1] || usr[0] == usr[2] || usr[1] == usr[2]) {
                    System.out.println("모두 다른 숫자를 입력해주세요. 다시 입력해주세요.");
                }
                
        	} while (usr[0] == 0 || usr[1] == 0 || usr[2] == 0 || usr[0] > 9 || usr[1] > 9 || usr[2] > 9 || usr[0] == usr[1] || usr[0] == usr[2] || usr[1] == usr[2]);

            // 볼카운트 0으로 초기화
            strike = ball = 0;

            // 입력한 자릿수와 입력한 숫자 모두 일치한다면 스트라이크 +1
            if (usr[0] == com[0]) strike++;
            if (usr[1] == com[1]) strike++;
            if (usr[2] == com[2]) strike++;
            // 입력한 자릿수는 일치하지 않지만 숫자는 일치한다면 볼 +1
            if (usr[0] == com[1]) ball++;
            if (usr[0] == com[2]) ball++;
            if (usr[1] == com[0]) ball++;
            if (usr[1] == com[2]) ball++;
            if (usr[2] == com[0]) ball++;
            if (usr[2] == com[1]) ball++;

            // 볼카운트 출력
            System.out.println("strike: " + strike + " ball: " + ball);
        } while(strike < 3 && count < 11);
        // 최종적으로 걸린 시도 횟수 반환
        return count;
    }
        
    public static void main(String[] args) throws IOException {
    	// 시도횟수에 따른 결과 출력을 위한 변수
        int result;
        if (args.length == 3) {
            int x = Integer.valueOf(args[0]).intValue();
            int y = Integer.valueOf(args[1]).intValue();
            int z = Integer.valueOf(args[2]).intValue();
            // result의 값을 playGame의 시도횟수로 지정
            result = playGame(x, y, z); // result = count
        } else {
            result = playGame();
        }
        
        System.out.println();
        // 시도횟수에 따라 결과 출력
        if (result <= 2) {
            System.out.println("참 잘했어요!");
        } else if (result <= 5) {
            System.out.println("잘했어요!");
        } else if (result <= 9) {
            System.out.println("보통이네요!");
        } else {
            System.out.println("분발하세요!");
        }
    }
}
