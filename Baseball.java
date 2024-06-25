package main;

// ȣ��
import java.util.*;
import java.io.*;

public class Baseball {
	// playGame�̶�� �̸��� �żҵ� ����
    public static int playGame() throws IOException {
    	
    	// ������ ������ ���� ����
    	int x,y,z;
    	// ���� �Լ� ����
    	Random r = new Random();
    	
    	// x�� 1���� 9������ ����
    	x = Math.abs(r.nextInt()%9)+1;
    	// y�� x�� ���� ������ ���� �޾��� ��� �ٽ� ���� ����
    	do {
    		y = Math.abs(r.nextInt()%9)+1;
		} while (x==y);
    	
    	// z�� x�� ���� ������ ���� �޾��� ��� �Ǵ� z�� y�� ���� ������ ���� �޾��� ��� �ٽ� ���� ����
    	do {
    		z = Math.abs(r.nextInt()%9)+1;
		} while (y==z || z==x);
    	
    	// ��ġ�� �ʴ� ������ ������ x, y, z�� ��ȯ
    	return playGame(x, y, z);
    }
        
    

    // PlayGame�̶�� �̸��� x, y, z ������ ���ڸ� �Ķ���� ������ ������ �żҵ� ����
    public static int playGame(int x, int y, int z) throws IOException {
    	
    	// �õ� Ƚ���� ��Ÿ���� ���� ����
    	int count;
        // ��Ʈ����ũ�� �� �� ���� ������� �˷��ִ� ���� ����
    	int strike, ball;
        // �÷��̾ �Է��� ���ڰ� �� �迭 ����
    	int usr[] = new int[3];
        // �� ���� ������ �� �迭 ����
    	int com[] = {x, y, z};
        
        // ���� �߱� ���� ����
        System.out.println("���� �߱� ���� ����");
        
        // count�� 0���� �ʱ�ȭ
        count = 0;

        // ��Ʈ����ũ �� ���� ��� ���߰ų� �õ� Ƚ���� 11 �̻��̵ɶ����� �ݺ�
        do {
        	// �� �� �õ��Ҷ����� �õ� Ƚ�� +1
        	count++;
            // �ùٸ� ���� �Է¹��� ������ �ݺ�
        	do {
            	// ������ �õ� Ƚ�� ���
        		System.out.println("ī��Ʈ: " + count);
                
                // ���� �Է¹޴� �κ�
        		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        		String user;
                
                System.out.print("1��° ����: ");
                user = in.readLine();
                usr[0] = new Integer(user).intValue();
                
                System.out.print("2��° ����: ");
                user = in.readLine();
                usr[1] = new Integer(user).intValue();

                System.out.print("3��° ����: ");
                user = in.readLine();
                usr[2] = new Integer(user).intValue();

                // ����ڰ� �Է��ؾ� �ϴ� ������ ������ �ο�
                if (usr[0] == 0 || usr[1] == 0 || usr[2] == 0) { 
                    System.out.println("0�� �Է����� ������. �ٽ� �Է����ּ���.");
                } else if (usr[0] > 9 || usr[1] > 9 || usr[2] > 9) {
                    System.out.println("1���� 9������ ���� �� �ϳ��� �Է����ּ���. �ٽ� �Է����ּ���.");
                } else if (usr[0] == usr[1] || usr[0] == usr[2] || usr[1] == usr[2]) {
                    System.out.println("��� �ٸ� ���ڸ� �Է����ּ���. �ٽ� �Է����ּ���.");
                }
                
        	} while (usr[0] == 0 || usr[1] == 0 || usr[2] == 0 || usr[0] > 9 || usr[1] > 9 || usr[2] > 9 || usr[0] == usr[1] || usr[0] == usr[2] || usr[1] == usr[2]);

            // ��ī��Ʈ 0���� �ʱ�ȭ
            strike = ball = 0;

            // �Է��� �ڸ����� �Է��� ���� ��� ��ġ�Ѵٸ� ��Ʈ����ũ +1
            if (usr[0] == com[0]) strike++;
            if (usr[1] == com[1]) strike++;
            if (usr[2] == com[2]) strike++;
            // �Է��� �ڸ����� ��ġ���� ������ ���ڴ� ��ġ�Ѵٸ� �� +1
            if (usr[0] == com[1]) ball++;
            if (usr[0] == com[2]) ball++;
            if (usr[1] == com[0]) ball++;
            if (usr[1] == com[2]) ball++;
            if (usr[2] == com[0]) ball++;
            if (usr[2] == com[1]) ball++;

            // ��ī��Ʈ ���
            System.out.println("strike: " + strike + " ball: " + ball);
        } while(strike < 3 && count < 11);
        // ���������� �ɸ� �õ� Ƚ�� ��ȯ
        return count;
    }
        
    public static void main(String[] args) throws IOException {
    	// �õ�Ƚ���� ���� ��� ����� ���� ����
        int result;
        if (args.length == 3) {
            int x = Integer.valueOf(args[0]).intValue();
            int y = Integer.valueOf(args[1]).intValue();
            int z = Integer.valueOf(args[2]).intValue();
            // result�� ���� playGame�� �õ�Ƚ���� ����
            result = playGame(x, y, z); // result = count
        } else {
            result = playGame();
        }
        
        System.out.println();
        // �õ�Ƚ���� ���� ��� ���
        if (result <= 2) {
            System.out.println("�� ���߾��!");
        } else if (result <= 5) {
            System.out.println("���߾��!");
        } else if (result <= 9) {
            System.out.println("�����̳׿�!");
        } else {
            System.out.println("�й��ϼ���!");
        }
    }
}
