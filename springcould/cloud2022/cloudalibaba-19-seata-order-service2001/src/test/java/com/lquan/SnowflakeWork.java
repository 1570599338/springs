package com.lquan;
/**
 * @description:
 * @author: lquan
 * @create: 2023-01-18 15:46
 **/
public class SnowflakeWork {

    // 工作机器号（0~31）
    private long workerId;

    /** 数据中心ID（0~31）**/
    private long datacenterId;

    /**  毫秒内序列号（0~4095） **/
    private long sequence=0l;

    /** 上次生成ID的时间戳**/
    private long  lastTimestamp=-1l;

    /** 开始时间戳(2019-01-01) **/
    private final long twepoch=1420041600000L ;

    /**  机器id所占的位数 **/
    private final long workerIdBits =5L;

    /** 数据表示id所占的位数**/
    private final long datacenterIdBits =5L;

    /**支持的最大机器的id 结果是31（这个移位算法可以很快的计算出几位二进制数所能标示的最大十进制数）**/
    private final long maxWorkerId = -1L^(-1L<<workerIdBits);

    /**支持的最大数据标识的id 结果是31**/
    private final long maxDatacenterId =-1L^(-1L<<datacenterIdBits);

    /**  序列在id中占的位数 **/
    private  final long sequenceBits =12L;

    /**  机器ID向左移动12位 **/
    private  final long  workerIdShift = sequenceBits;

    /**  数据标识id向左移动17位（12+5） **/
    private  final long  datacenterIdShift = sequenceBits + workerIdBits;

    /**  时间戳向左移动22位（17+5）  **/
    private  final long  timestampLeftShift = sequenceBits + workerIdBits +datacenterIdBits;

    /**生成序列的掩码，这里位4095（0b111111111111111=0xfff=4095）**/
    private final long sequenceMask =-1L^(-1L<<sequenceBits);


    public SnowflakeWork(long workerId, long sequenceId) {
        if(workerId>maxWorkerId || workerId<0){
            //throw  new IllegalAccessException("");
        }

        if(sequenceId>maxDatacenterId || sequenceId<0){
            //throw  new IllegalAccessException("");
        }

        this.workerId = workerId;
        this.datacenterId = sequenceId;
    }


    /**
     * 获取下一个ID（该方法线程安全的）
     * @return
     */
    public synchronized long nextId() {
        long timestamp = timeGen();
        //如果当前时间小于上一次ID 生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            // throw new RuntimeException(String.format("clock moved backwards. Refusing to generate id for %d milliseconi);
        }
        //如果是同一时间生产的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            //毫砂内序列监出
            if (sequence == 0) {
                //阻塞到下一个毫秒，获得新的时问戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {// 时间戳改变，毫秒内序列重置
            sequence = 0l;
        }

        //上次生成的ID的时间戳
        lastTimestamp = timestamp;

        // 移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - twepoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }


    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp  上次生成ID的时间戳
     * @return 当前时间戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }


    /**
     *
     * 返回毫秒位单位的当前时间
     * @return 当前时间（毫秒）
     *
     */
    protected long timeGen(){
        return System.currentTimeMillis();
    }


    public static void main(String[] args) {

        SnowflakeWork snowflakeWork = new SnowflakeWork(1, 1);
        for (int i = 0; i <10 ; i++) {
            long id = snowflakeWork.nextId();
            System.out.println(id+"\t"+String.valueOf(id).length());
            System.out.println("---------------------------");
        }
    }

}
