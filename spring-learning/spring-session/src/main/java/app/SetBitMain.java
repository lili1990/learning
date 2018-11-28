package app;

import redis.clients.jedis.BitOP;
import redis.clients.jedis.Jedis;

import java.util.BitSet;

/**
 * @author lili
 * @date 2018/9/10
 * @description
 */
public class SetBitMain {



    public static void main(String[] args) {

        Jedis jedis = null;

        try {

            jedis = new Jedis("127.0.0.1", 6379);

            //setbit 参数说明
            //setbit key/用户ID/1 or 0 (1表示用户登入过 0表示没有登入 默认为0)
            // 2016-12-3 login operation user
            //设置2016-12-3登入的用户ID

//            for(int i=0;i<1000000;i++) {
//                jedis.setbit("login:2016-12-3", i, true);
//            }
//
//            for(int i=900000;i<1990000;i++) {
//                jedis.setbit("login:2016-12-4", i, true);
//            }
//
//            for(int i=1000000;i<1099900;i++) {
//                jedis.setbit("login:2016-12-5", i, true);
//            }
//
//            for(int i=1000000;i<1099990;i++) {
//                jedis.setbit("login:2016-12-6", i, true);
//            }
//
//            for(int i=1000000;i<1099999;i++) {
//                jedis.setbit("login:2016-12-7", i, true);
//            }


            System.out.println( jedis.bitcount("5_day_onlin",8000000,8000024));

//            jedis.bitop(BitOP.AND,"5_day_onlin","login:2016-12-3","login:2016-12-4","login:2016-12-5","login:2016-12-6","login:2016-12-7");





        } catch(Exception e) {

            e.printStackTrace();

        }

        finally {

            if (jedis != null) {

                jedis.disconnect();

            }

        }
    }




    public static byte[] bitSet2ByteArray(BitSet bitSet) {
        byte[] bytes = new byte[bitSet.size() / 8];
        for (int i = 0; i < bitSet.size(); i++) {
            int index = i / 8;
            int offset = 7 - i % 8;
            bytes[index] |= (bitSet.get(i) ? 1 : 0) << offset;
        }
        return bytes;
    }

    public static BitSet byteArray2BitSet(byte[] bytes) {
        BitSet bitSet = new BitSet(bytes.length * 8);
        int index = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 7; j >= 0; j--) {
                bitSet.set(index++, (bytes[i] & (1 << j)) >> j == 1 ? true: false);
            }
        }
        return bitSet;
    }
}
