package oneHit4Get;

import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class BUK04_KIMDONGWOO_KIMSOOJIN_2 {

    // 닉네임을 사용자에 맞게 변경해 주세요.
    static final String NICKNAME = "2BUK04_KIMDONGWOO_KIMSOOJIN";

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

    //   static final float[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
//   double a = Math.pow(2, 0.5f);
    //static float[][] HOLES = { { 2.32f, 3.16f }, { 127, 3.16f }, { 251.68f, 3.16f }, {2.32f, 123.84f }, { 127, 123.84f }, { 251.68f, 123.84f } };
    //   static float R=5.73f;
    static float R=5.2f;
    // hole 위치 조절1
    static float mediate = R/2;
    static float[][] HOLES = { { mediate, mediate }, { 127, mediate }, { 254-mediate, mediate }, {mediate, 127-mediate}, { 127, 127 - mediate}, { 254-mediate, 127 - mediate } };

    // *(벡터 생성)
    static boolean[] goal = new boolean[6];
    static float[][] balls;

    //   static float R=5.5;


    static class Vector{

        float x, y;
        Vector(float x, float y){
            this.x=x;
            this.y=y;
        }

        Vector add(Vector o){
            return new Vector(o.x-this.x,o.y-this.y);
        }
        Vector multi(float a){
            return new Vector(a*this.x,a*this.y);
        }
        float mag() {
            return (float) Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2));
        }

        float dot(Vector o) {
            return o.x*this.x+o.y*this.y;
        }
        float cross(Vector o) {
            return Math.abs(this.x*o.y-o.x*this.y);
        }
        Vector unit() {
            return new Vector(this.x/this.mag(), this.y/this.mag());
        }
        float angle() {
            System.out.println(this.y+" "+this.x);
            return (float) ((450-Math.toDegrees(Math.atan2(this.y, this.x)))%360);
        }
    }

    // *(포인트 생성)
    static class Point implements Comparable<Point>{
        float power, angle,between;
        Point(float power, float angle,float between){
            this.power=power;
            this.angle=angle;
            this.between=between;
        }
        @Override
        public int compareTo(Point o) {
            return Double.compare(this.between, o.between);
        }
    }

    public static void main(String[] args) {
        Socket socket = null;
        String recv_data = null;
        byte[] bytes = new byte[1024];
        // 전역 변수로 변경
        balls = new float[NUMBER_OF_BALLS][2];
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
                    //goal 초기화
                    goal = new boolean[6];

                    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                        for (int j = 0; j < 2; j++) {
                            if(balls[i][0]==-1) goal[i]=true;

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
                    order = (int)balls[0][1];
                    System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
                    continue;
                } else if (balls[0][0] == SIGNAL_CLOSE) {
                    break;
                }

                if (order==1) {
                    R=5.2f;
                    goal[2] = true;
                    goal[4] = true;
                } else {
                    R=5.2f;
                    goal[1]=true;
                    goal[3]=true;
                }

                // Show Balls' Position
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

                float angle = 0.0f;
                float power = 0.0f;

                // 넣을 수 있는 리스트
                ArrayList<Point> hitList = new ArrayList<>();


                // 각 공에 대해 포켓에 들어가기 위해 수구가 가야할 위치를 계산
                for (int i = 1; i < NUMBER_OF_BALLS; i++) {
                    for (int j = 0; j < HOLES.length; j++) {

                        if (goal[i]) continue;
                        if (i==5&&!(goal[1]&&goal[3]&&goal[2]&&goal[4])) continue;

                        Vector ball = new Vector(balls[i][0], balls[i][1]);
                        Vector pocket= new Vector(HOLES[j][0], HOLES[j][1]);
                        Vector white = new Vector(balls[0][0], balls[0][1]);


                        // 목적공과 포켓 사이에 공 존재 여부 확인
                        if (!checkPath(ball, pocket)) continue;

                        //접점 찾기
                        Vector btp = ball.add(pocket);
                        Vector unitbtp = btp.unit();
                        Vector unitbtpM = unitbtp.multi(-R);

                        Vector contact = new Vector(ball.x+unitbtpM.x,ball.y+unitbtpM.y);
                        // 수구와 접점 사이에 공 존재 여부 확인
                        if (!checkPath(white, contact)) continue;

                        Vector ctw = contact.add(white);
                        Vector ctb = contact.add(ball);

                        // 목적구 침 여부 확인
                        if (ctw.dot(ctb)>0) continue;


                        System.out.println("공"+i+"포켓"+j);

                        // 힘과 각도 계산
                        Vector wtc = white.add(contact);
//                  System.out.println();
                        System.out.println("수구와 접점 사이 거리"+wtc.mag());
                        System.out.println("목적구와 포켓 사이 거리"+btp.dot(wtc.unit()));
                        hitList.add(new Point(wtc.mag()+btp.dot(wtc.unit()), wtc.angle(),ctw.dot(ctb)/(ctw.mag()*ctb.mag())));
                    }
                }

                Collections.sort(hitList);
                System.out.println("*****************");
                System.out.println(hitList.size());
                System.out.println("*****************");

                if (hitList.isEmpty()) {
                    for (int i = 1; i < NUMBER_OF_BALLS; i++) {
                        if (goal[i]) continue;
                        Vector ball = new Vector(balls[i][0], balls[i][1]);
//                  Vector pocket= new Vector(HOLES[j][0], HOLES[j][1]);
                        Vector white = new Vector(balls[0][0], balls[0][1]);
                        Vector wtb = white.add(ball);
                        power = 40f;
                        angle = (float) wtb.angle()-1f;
                        break;
                    }
                } else {
                    // power: 거리 distance에 따른 힘의 세기를 계산
//               power = Math.max(1f,(float) (hitList.get(0).power+)/6.12f);
                    power = 40f;
//               power = (float) (hitList.get(0).power+1.27)*1.4f/6.62f;
                    angle = (float) hitList.get(0).angle;


                }

                String merged_data = angle + "/" + power + "/";
                bytes = merged_data.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Data Sent: " + merged_data);
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

            }
            os.close();
            is.close();
            socket.close();
            System.out.println("Connection Closed.\n--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkPath(Vector start, Vector end) {
        int cnt=0;
        Vector path = start.add(end);
        for (int i = 1; i < NUMBER_OF_BALLS; i++) {
            if (goal[i]) continue;

            Vector target = new Vector(balls[i][0],balls[i][1]);
            Vector ste = start.add(target);

//         System.out.println(i+"와의 거리"+path.cross(ste)/(path.mag()));

            // 외적 한 것이 D보다 커야함
            if(path.cross(ste)/(path.mag())>R) {
//            System.out.println("1");
                continue;
            }
            //내적한것이 양수이면서
            if (path.dot(ste)/(path.mag()*ste.mag())>(path.mag()+R)) {
//            System.out.println("2");
                continue;
            }
            if((path.dot(ste)<0)) {
//            System.out.println("3");
                continue;
            }
            cnt++;
        }
//      System.out.println("부딪힐 갯수"+cnt);
        if(cnt<=1) return true;
        else return false;
    }
}