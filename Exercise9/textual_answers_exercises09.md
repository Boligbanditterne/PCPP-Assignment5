## 9.1

### 9.1.1

***Measure the performance of parallel prime counting using platform threads, on your own hardware, as a function of the number of threads that share the work of counting primes. Record system information as well as the measurement results for 1, 2, 3, . . . , 8, 16, 32, 64, . . . , 2048 platform threads in a text file.***

countSequential                   12413.7 us      15.26         32
countParallelPlatf      1         12888.0 us     135.14         32
countParallelPlatf      2          8616.1 us     122.43         32
countParallelPlatf      3          6225.1 us     133.09         64
countParallelPlatf      4          4828.6 us     116.93         64
countParallelPlatf      5          4537.3 us     129.43         64
countParallelPlatf      6          3922.6 us     240.09         64
countParallelPlatf      7          4157.5 us     116.20         64
countParallelPlatf      8          4038.7 us      54.28         64
countParallelPlatf      9          3747.0 us      66.52        128
countParallelPlatf     10          3308.0 us      54.19        128
countParallelPlatf     11          3231.4 us      64.60        128
countParallelPlatf     12          3114.4 us      91.58        128
countParallelPlatf     24          3249.6 us     108.98        128
countParallelPlatf     48          3730.0 us     117.79        128
countParallelPlatf     96          5494.3 us     297.75         64
countParallelPlatf    192         10356.8 us     358.68         32
countParallelPlatf    384         20886.0 us     473.80         16
countParallelPlatf    768         38300.1 us    1061.00          8
countParallelPlatf   1536         77477.9 us    2369.60          4

### 9.1.2

***Make the same measurements for virtual threads.***

countSequential                   12439.1 us      29.47         32
countParallelVirtu      1         12606.1 us      34.80         32
countParallelVirtu      2          8742.4 us     371.95         32
countParallelVirtu      3          6476.2 us     258.74         64
countParallelVirtu      4          5257.9 us     183.31         64
countParallelVirtu      5          4897.0 us     309.75         64
countParallelVirtu      6          4940.8 us     252.97         64
countParallelVirtu      7          5000.3 us     187.51         64
countParallelVirtu      8          4843.6 us     182.96         64
countParallelVirtu      9          4339.3 us     132.89         64
countParallelVirtu     10          4001.9 us      64.23         64
countParallelVirtu     11          3725.5 us      74.46        128
countParallelVirtu     12          3342.5 us     101.21        128
countParallelVirtu     24          2703.2 us      60.65        128
countParallelVirtu     48          2390.4 us      32.86        128
countParallelVirtu     96          2233.6 us      32.08        128
countParallelVirtu    192          2185.6 us      24.47        128
countParallelVirtu    384          2149.8 us      20.18        128
countParallelVirtu    768          2146.0 us      17.94        128
countParallelVirtu   1536          2215.6 us     102.11        128


### 9.1.3

***Make the same measurement for the executor-and-task version, still for 1, 2, 3, . . . , 8, 16, 32, 64, . . . , 2048 parallel tasks.***

### 9.1.4

***Reflect and comment on the results; are they plausible?***

Our machine has 12 cores.

1. Platform threads do not improve past the amount of cores that the cpu has - the overhead is greater than the gains past this.

2. Virtual threads keep improving past 12, due to the very little overhead.

3. Virtual threads and the executor-and-task version perform similarly on this non-blocking task.

## 9.2

### 9.1.1 - 9.1.4

Ran with 5.000.000

class exercises09.SynchronizedHistogram     1734.8 ms
class exercises09.CasHistogram     1577.9 ms
class exercises09.AtomicHistogram     1564.0 ms
class exercises09.StripedHistogram     1549.0 ms

1. The results shows that the simple lock version performs the worst.

2. The Cas and AtomicHistogram versions perform better than synchronized for 5.000.000 range. However this is not consistent with higher numbers.

3. The striped Histogram does not perform significantly better as expected - even with strictly using increments and no reads.

### 9.1.5

Striped histogram resembles LA7 the most. It uses a stripecount implementation without any padding.

## 9.3

### 9.3.1

OS:   Linux; 7.0.0-38-generic; amd64
JVM:  Ubuntu; 25.0.4.1
CPU:  null; 12 "cores"
Date: 2026-10-26T12:19:07+0100

SyncLongAdder              20        893191.8 us   44314.98          2
SyncLongArrayAdder         20        182707.3 us   40184.42          2
SyncLongArrayAdderPadded   20         19856.4 us    1019.76         16
WrappedAtomicLong          20        145739.6 us   19249.84          2
MyAtomicLong               20        393249.3 us    8298.85          2
ThreadLocalAtomicLong      20         13478.7 us     719.26         32
LongAdderArray             20         69346.6 us    7581.40          4
LongAdderArrayPadded       20         13476.4 us     955.17         32
WrappedLongAdder           20         11107.7 us     443.10         32

These results resemble the expected results from the lecture.

### 9.3.2

When using the padded version, it tries to ensure that the locks are spread out on seperate cache lines and therefore gets it own line. 

### 9.3.3

***See LongAdderPerformance.java***

SyncLongAdder              20        699332.9 us   51771.69          2
SyncLongArrayAdder         20        173564.0 us   33642.90          2
SyncLongArrayAdderPadded   20         23345.9 us     856.15         16
SyncLongArrayAdderLessPad  20         69721.9 us    7947.52          4

Unsuprisingly the new variant performs worse. Because the lock elements are now null, and never initiated they are not present in heap. This means that the padding is essentially removed and the effect of padding removed. 

### 9.4

memory cover        8192 B        167406.9 us     840.96          2
memory cover       11584 B        167819.1 us     547.88          2
memory cover       16384 B        167164.6 us     290.12          2
memory cover       23172 B        169875.6 us    1527.29          2
memory cover       32772 B        172002.4 us    2100.03          2
memory cover       46348 B        254225.1 us    2310.13          2
memory cover       65544 B        316222.8 us    1492.57          2
memory cover       92692 B        358835.8 us    3230.10          2
memory cover      131088 B        389350.8 us    8911.21          2
memory cover      185388 B        408143.3 us    7023.08          2
memory cover      262180 B        430056.1 us    9699.73          2
memory cover      370780 B        530138.1 us   15677.01          2
memory cover      524364 B        619290.1 us   10816.78          2
memory cover      741564 B        863415.7 us    4373.24          2
memory cover     1048728 B       1064155.0 us   10593.49          2
memory cover     1483124 B       1218676.1 us    4690.51          2
memory cover     2097456 B       1366323.2 us   34641.94          2
memory cover     2966252 B       1841236.9 us  524428.13          2
memory cover     4194912 B       3014037.4 us   73211.02          2
memory cover     5932500 B       5922524.4 us   87131.54          2

The cpu has 32KB cache which can be seen by the increased time at > 32772. The results here are slightly worse than the i9 and m3 processors.
