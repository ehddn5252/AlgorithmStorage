package oneHit4Get;

import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

public class BUK04_KONGJIHUN_PARKCHANHO {

    // 닉네임을 사용자에 맞게 변경해 주세요.
    static final String NICKNAME = "BUK04_KONGJIHUN_PARKCHANHO";

    // 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
    static final String HOST = "127.0.0.1";

    // 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
    static final int PORT = 1447;
    static final int CODE_SEND = 9901;
    static final int CODE_REQUEST = 9902;
    static final int SIGNAL_ORDER = 9908;
    static final int SIGNAL_CLOSE = 9909;

    // 게임 환경에 대한 상수입니다.
    static final int TABLE_WIDTH = 254;
    static final int TABLE_HEIGHT = 127;
    static final int NUMBER_OF_BALLS = 6;
    static final double diameter = 5.2;
    static final double realdiameter = 5.73; //타격 각도 조정
    static final double[][] HOLES = {{ 0 + diameter / 2, 0 + diameter / 2 }, { 127, 0 }, // 쿠션 굴절을 예방하기 위해서 목표 위치 수정
            { 254 - diameter / 2, 0 + diameter / 2 }, { 0 + diameter / 2, 127 - diameter / 2 }, { 127, 127 },
            { 254 - diameter / 2, 127 - diameter / 2 }};
    static int intercept = 35;// 중단 홀에 도달할 수 있는 최대 절편값
    static double[][] upIntercept = new double[][] { { 0, intercept }, { TABLE_WIDTH / 2, TABLE_HEIGHT },
            { TABLE_WIDTH, intercept } };// 상단홀 도달 절편
    static double[][] downIntercept = new double[][] { { 0, TABLE_HEIGHT - intercept }, { TABLE_WIDTH / 2, 0 },
            { TABLE_WIDTH, TABLE_HEIGHT - intercept } };// 하단홀 도달 절편

    static boolean areaCheck(double[][] intercept, float[] ballPos){ // 중단 홀 도달 각 여부를 판단하기 위한 메서드
        double a1 = (intercept[0][1] - intercept[1][1]) / (intercept[0][0] - intercept[1][0]);
        double b = -1;
        double c1 = intercept[0][1] - a1 * intercept[0][0];
        double a2 = (intercept[2][1] - intercept[1][1]) / (intercept[2][0] - intercept[1][0]);
        double c2 = intercept[2][1] - a2 * intercept[2][0];
        double res = (a1 * ballPos[0] + b * ballPos[1] + c1) * (a2 * ballPos[0] + b * ballPos[1] + c2); // 두개의 절편과
        // 일차방정식을 사용해서
        // 도달 가능한 영역에 있을
        // 시 양수값
        if (res >= 0) {
            return true;
        }
        return false;
    }

    static boolean crashCheck(float[] start, double[] end, float[] otherball){// start와 end사이에 otherball이 충돌하는지 여부를 반환
        double a = (start[1] - end[1]) / (start[0] - end[0]);
        double b = -1;
        double c = start[1] - a * start[0]; // 출발지와 목적지 사이의 일차방정식 계수 구함
        double res = Math.abs(a * otherball[0] + b * otherball[1] + c) / Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));// 직선과
        // 점의
        // 거리
        if (res < realdiameter && (end[0] - otherball[0]) * (start[0] - otherball[0]) < 0) { // 직선과 점의 거리가 직경보다 작고,
            // otherball이 중간에 있을 때
            // 충돌
            System.out.println("경로에서 충돌");
            return true;
        } else {
            double dx = otherball[0] - end[0];
            double dy = otherball[1] - end[1];
            double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));// 경로에 겹치는 공이 아니더라도 도착지 주위에 있는 공도 충돌할 수 있음
            if (distance <= diameter) {
                System.out.println("목적지 주변에서 충돌");
                return true;
            }
            return false;
        }
    }

    static double getDistance(float[] pos1, double[] pos2) {// 두 점사이 거리를 구하는 메서드
        return Math.sqrt(Math.pow(pos1[0] - pos2[0], 2) + Math.pow(pos1[1] - pos2[1], 2));
    }

    static ArrayList<Double[]> getCandidate(float[] myPos, float[] ballPos, int ballIdx, float[][] balls) {// myPos가
        // ballIdx에 해당하는 공을 칠때, 6가지 모든 HOLES에 대한 경우를 구하고 가능한 경우
        // 굴절각, 타구 각도, 수구에서 타격지점까지 거리, 타격지점에서 HOLE까지 거리를 후보에 저장
        ArrayList<Double[]> candidate = new ArrayList<>();
        if (ballIdx == 5) {
            System.out.println("8번구");
        } else {
            System.out.println(ballIdx + "번구");
        }
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    System.out.println("좌하단");
                    break;
                case 1:
                    System.out.println("중하단");
                    break;
                case 2:
                    System.out.println("우하단");
                    break;
                case 3:
                    System.out.println("좌상단");
                    break;
                case 4:
                    System.out.println("중상단");
                    break;
                case 5:
                    System.out.println("우상단");
                    break;

                default:
                    break;
            }
            if (i == 1) {// 중하단 HOLE 도달 가능 여부
                if (!areaCheck(downIntercept, ballPos)) {
                    System.out.println("도달각 없음");
                    continue;
                }
            }
            if (i == 4) {// 중상단 HOLE 도달 가능 여부
                if (!areaCheck(upIntercept, ballPos)) {
                    System.out.println("도달각 없음");
                    continue;
                }
            }
            double ball2holeRad = Math.atan2(HOLES[i][1] - ballPos[1], HOLES[i][0] - ballPos[0]);// 목적구에서 홀까지의 라디안
            double[] target = new double[] { ballPos[0] - diameter * Math.cos(ball2holeRad),
                    ballPos[1] - diameter * Math.sin(ball2holeRad) };// 타격 위치
            double my2targetRad = Math.atan2(target[1] - myPos[1], target[0] - myPos[0]);// 수구에서 타격 위치까지의 라디안
            double reflect = 90 - Math.toDegrees(my2targetRad) + Math.toDegrees(ball2holeRad); // 수구의 타격 후 굴절 각도
            boolean crash = false;
            boolean possible = true;
            if (80 < Math.abs(90 - reflect)) { // 굴절한계각도 71
                System.out.println("굴절각 불가능");
                possible = false;
            } else {
                System.out.println("굴절 가능");
                for (int j = 1; j < 6; j++) { // 다른 모든 공에 대해 충돌여부 판단
                    if (j == ballIdx || balls[j][0] == -1)
                        continue;
                    if (crashCheck(myPos, target, balls[j]) || crashCheck(ballPos, HOLES[i], balls[j])) {
                        crash = true;
                    }
                }
            }
            if (!crash && possible) { // 굴절 가능하고, 충돌 하지 않을 때
                double angle = 90 - Math.toDegrees(my2targetRad);
                double refract = Math.abs(90 - reflect);
                double targetDist = getDistance(myPos, target);
                double holeDist = getDistance(ballPos, HOLES[i]);
                candidate.add(new Double[] { refract, angle, targetDist, holeDist });// 후보에 추가
            }
        }
        return candidate;// 후보리스트 리턴
    }

    static double getPower(double ball2hole, double reflect, double my2target) {
        double m = 3.1; // 마찰계수
        double angle = Math.toRadians(reflect);// 굴절각도
        double v0 = Math.sqrt(2 * m * ball2hole);// 목적구가 hole에 0의 속도로 도달하기 위한 초기 속도
        double v1 = 0;
        if (reflect == 0) {// 굴절각이 0인 경우 수구의 도착속도가 목적구의 출발 속도와 같다.
            v1 = v0;
        } else {// 굴절각이 있는 경우 속도 전달량만큼 수구 도착속도 계산
            v1 = v0 / Math.cos(angle);
        }
        double power = Math.sqrt(Math.pow(v1, 2) + 2 * m * my2target);// 타격지점에 v1의 속도로 도달하기 위한 수구의 초기 속도
        return power;
    }

    public static double[] getBest(float[][] inputballs, boolean[] hitlist) {
        float[][] balls = inputballs;
        double[] ans = new double[] { 90, 50 };
        float[] myPos = balls[0];
        ArrayList<Double[]> candidate = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if (!hitlist[i])// 목적구인 공에 대해서만 후보 추출
                continue;
            ArrayList<Double[]> temp = getCandidate(myPos, balls[i], i, balls);
            for (Double[] a : temp) {
                candidate.add(a);
            }
        }
        Comparator<Double[]> comparator = new Comparator<Double[]>() {

            @Override
            public int compare(Double[] o1, Double[] o2) {
                // TODO Auto-generated method stub
                return (int) (o1[0] - o2[0]);
            }
        };
        Collections.sort(candidate, comparator);// 모든 후보를 수구의 굴절각도 기준으로 정렬
        for (Double[] c : candidate) {
            System.out.println(Arrays.toString(c));
        }
        if (candidate.size() != 0) {
            ans = new double[] { candidate.get(0)[1],
                    getPower(candidate.get(0)[3], candidate.get(0)[0], candidate.get(0)[2]) };
            //각도와 힘 계산해서 리턴
        } else {
            for (int i = 1; i < 6; i++) {//칠수 있는 공이 없을 경우
                if (hitlist[i]) {//아무공 중앙을 때림
                    double[] target = new double[] { inputballs[i][0], inputballs[i][1] };
                    double my2targetRad = Math.atan2(target[1] - myPos[1], target[0] - myPos[0]);
                    double reflect = 90 - Math.toDegrees(my2targetRad);
                    ans = new double[] { reflect, 50 };
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Socket socket = null;
        String recv_data = null;
        byte[] bytes = new byte[1024];
        float[][] balls = new float[NUMBER_OF_BALLS][2];
        int order = 0;

        try {
            socket = new Socket();
            System.out.println("Trying Connect: " + HOST + ":" + PORT);
            socket.connect(new InetSocketAddress(HOST, PORT));
            System.out.println("Connected: " + HOST + ":" + PORT);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            String send_data = CODE_SEND + "/" + NICKNAME + "/";
            bytes = send_data.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("Ready to play!\n--------------------");

            while (socket != null) {

                // Receive Data
                bytes = new byte[1024];
                int count_byte = is.read(bytes);
                recv_data = new String(bytes, 0, count_byte, "UTF-8");
                System.out.println("Data Received: " + recv_data);

                // Read Game Data
                String[] split_data = recv_data.split("/");
                int idx = 0;
                try {
                    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                        for (int j = 0; j < 2; j++) {
                            balls[i][j] = Float.parseFloat(split_data[idx++]);
                        }
                    }
                } catch (Exception e) {
                    bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
                    os.write(bytes);
                    os.flush();
                    System.out.println("Received Data has been currupted, Resend Requested.");
                    continue;
                }

                // Check Signal for Player Order or Close Connection
                if (balls[0][0] == SIGNAL_ORDER) {
                    order = (int) balls[0][1];
                    System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
                    continue;
                } else if (balls[0][0] == SIGNAL_CLOSE) {
                    break;
                }

                // Show Balls' Position
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

                float angle = 0.0f;
                float power = 0.0f;

                //////////////////////////////
                // 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
                //
                // 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
                // - order: 1인 경우 선공, 2인 경우 후공을 의미
                // - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
                // 예) balls[0][0]: 흰 공의 X좌표
                // balls[0][1]: 흰 공의 Y좌표
                // balls[1][0]: 1번 공의 X좌표
                // balls[4][0]: 4번 공의 X좌표
                // balls[5][0]: 마지막 번호(8번) 공의 X좌표

                // 여기서부터 코드를 작성하세요.
                // 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

                boolean[] hitlist = new boolean[6];
                if (order == 1) {// 선공
                    if (balls[1][0] == -1 && balls[3][0] == -1) {
                        hitlist[5] = true;
                    } else if (balls[1][0] == -1 && balls[3][0] != -1) {
                        hitlist[3] = true;
                    } else if (balls[1][0] != -1 && balls[3][0] == -1) {
                        hitlist[1] = true;
                    } else {
                        hitlist[1] = true;
                        hitlist[3] = true;
                    }
                } else {// 후공
                    if (balls[2][0] == -1 && balls[4][0] == -1) {
                        hitlist[5] = true;
                    } else if (balls[2][0] == -1 && balls[4][0] != -1) {
                        hitlist[4] = true;
                    } else if (balls[2][0] != -1 && balls[4][0] == -1) {
                        hitlist[2] = true;
                    } else {
                        hitlist[2] = true;
                        hitlist[4] = true;
                    }
                }

                angle = (float) getBest(balls, hitlist)[0];
                power = (float) getBest(balls, hitlist)[1];

                String merged_data = angle + "/" + power + "/";
                bytes = merged_data.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Data Sent: " + merged_data);
            }

            os.close();
            is.close();
            socket.close();
            System.out.println("Connection Closed.\n--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
