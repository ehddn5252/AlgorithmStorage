package oneHit4Get;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class BUK04_KIMDONGWOO_3 {

    // 닉네임을 사용자에 맞게 변경해 주세요.
    static final String NICKNAME = "BUK04_KIMDONGWOO_3";

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
    static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

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
                    order = (int)balls[0][1];
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
                //   - order: 1인 경우 선공, 2인 경우 후공을 의미
                //   - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
                //     예) balls[0][0]: 흰 공의 X좌표
                //         balls[0][1]: 흰 공의 Y좌표
                //         balls[1][0]: 1번 공의 X좌표
                //         balls[4][0]: 4번 공의 X좌표
                //         balls[5][0]: 마지막 번호(8번) 공의 X좌표

                // 여기서부터 코드를 작성하세요.
                // 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

                // whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
                float whiteBall_x = balls[0][0];
                float whiteBall_y = balls[0][1];

                // targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
                int targetNumber = findBalls(balls,order);
                System.out.println("targetNumber: "+ targetNumber);
                float targetBall_x = balls[targetNumber][0];
                float targetBall_y = balls[targetNumber][1];
                // 가까운 위치의
                int holeNum = findNearHole2(targetBall_x,targetBall_y);
                System.out.println("===================");
                System.out.println("holeNum" + holeNum);
                float holeTargetWidth = Math.abs(targetBall_x - HOLES[holeNum][0]);
                float holeTargetHeight = Math.abs(targetBall_y - HOLES[holeNum][1]);

                double radian2 = holeTargetHeight>0?Math.atan(holeTargetWidth/holeTargetHeight):0;
                float add_sin = (float)Math.sin(radian2) * (float)5.72; // 5.72;
                float add_cos = (float)Math.cos(radian2) * (float)5.72;///2;

                // case1
                if(HOLES[holeNum][0]>=targetBall_x &&HOLES[holeNum][1]>=targetBall_y ){
                    targetBall_x= Math.abs(targetBall_x-add_sin);
                    targetBall_y= Math.abs(targetBall_y-add_cos);
                }
                // case2
                else if(HOLES[holeNum][0]<targetBall_x &&HOLES[holeNum][1]<targetBall_y ){
                    targetBall_x= Math.abs(targetBall_x+add_sin);
                    targetBall_y= Math.abs(targetBall_y+add_cos);
                }

                //case3
                else if(HOLES[holeNum][0]>=targetBall_x &&HOLES[holeNum][1]<targetBall_y ){
                    targetBall_x= Math.abs((targetBall_x-add_sin));
                    targetBall_y= Math.abs((targetBall_y+add_cos));
                }

                // case4
                else if(HOLES[holeNum][0]<targetBall_x && HOLES[holeNum][1]>=targetBall_y ){
                    targetBall_x= Math.abs(targetBall_x+add_sin);
                    targetBall_y= Math.abs(targetBall_y-add_cos);
                }

                // width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리
                float width = Math.abs(targetBall_x - whiteBall_x);
                float height = Math.abs(targetBall_y - whiteBall_y);

                // radian: width와 height를 두 변으로 하는 직각삼각형의 각도를 구한 결과
                //   - 1radian = 180 / PI (도)
                //   - 1도 = PI / 180 (radian)
                // angle : 아크탄젠트로 얻은 각도 radian을 degree로 환산한 결과

                // hole 과 target 사이 거리: angle2
                double angle2 = (float) ((180.0 / Math.PI) * radian2);
                double radian = height > 0? Math.atan(width / height): 0;
                angle = (float) ((180.0 / Math.PI) * radian);

                // 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
                if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y)
                {
                    radian = Math.atan(width / height);
                    angle = (float) (((180.0 / Math.PI) * radian) + 180);
                }

                // 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
                else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y)
                {
                    radian = Math.atan(height / width);
                    angle = (float) (((180.0 / Math.PI) * radian) + 90);
                }
                // distance: 두 점(좌표) 사이의 거리를 계산
                double distance = Math.sqrt((width * width) + (height * height));

                // power: 거리 distance에 따른 힘의 세기를 계산
                power = (float) distance * (float) 0.6;
                power= 40f;
                // 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
                // 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
                //   - angle: 흰 공을 때려서 보낼 방향(각도)
                //   - power: 흰 공을 때릴 힘의 세기
                //
                // 이 때 주의할 점은 power는 100을 초과할 수 없으며,
                // power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
                //
                // 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
                //////////////////////////////

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

    static int findBalls(float[][] balls, int order){
        for(int i=1;i<balls.length;++i){
            if(order==1){
                if(i==2 || i==4 )continue;
            }
            else if (order==2){
                if(i==1 || i==3 )continue;
            }
            if(balls[i][0]!=-1.0 && balls[i][1]!=-1.0){
                return i;
            }
        }
        return 0;
    }

    static int findNearHole(float x, float y){
        double distance=99999;
        int saveNum=0;
        for(int i=0;i<HOLES.length;++i){
            if(Math.pow(x-HOLES[i][0],2) + Math.pow(y-HOLES[i][1],2) < distance){
                distance = Math.pow(x-HOLES[i][0],2) + Math.pow(y-HOLES[i][1],2);
                saveNum=i;
            }
        }
        return saveNum;
    }

    static int findNearHole2(float x, float y){
        int ret=0;
        if(x<=63 && y<=127){
            ret=0;
        }
        else if (x<=190 && y<=127){
            ret = 1;
        }
        else if(x<=254 && y<=127){
            ret=2;
        }
        else if(x<=63 && y>=127){
            ret = 3;
        }
        else if (x<=190 && y>=127){
            ret = 4;
        }
        else if (x<=254 && y >=127){
            ret = 5;
        }
        return ret;
    }
}
