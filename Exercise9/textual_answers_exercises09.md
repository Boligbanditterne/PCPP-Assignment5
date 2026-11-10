## 9.1

### 9.1.1

***Measure the performance of parallel prime counting using platform threads, on your own hardware, as a function of the number of threads that share the work of counting primes. Record system information as well as the measurement results for 1, 2, 3, . . . , 8, 16, 32, 64, . . . , 2048 platform threads in a text file.***

| Benchmark          | Threads |  Mean (us) | Std. dev. | Count |
|--------------------|--------:|-----------:|----------:|------:|
| countSequential    |         |    12413.7 |     15.26 |    32 |
| countParallelPlatf |       1 |    12888.0 |    135.14 |    32 |
| countParallelPlatf |       2 |     8616.1 |    122.43 |    32 |
| countParallelPlatf |       3 |     6225.1 |    133.09 |    64 |
| countParallelPlatf |       4 |     4828.6 |    116.93 |    64 |
| countParallelPlatf |       5 |     4537.3 |    129.43 |    64 |
| countParallelPlatf |       6 |     3922.6 |    240.09 |    64 |
| countParallelPlatf |       7 |     4157.5 |    116.20 |    64 |
| countParallelPlatf |       8 |     4038.7 |     54.28 |    64 |
| countParallelPlatf |       9 |     3747.0 |     66.52 |   128 |
| countParallelPlatf |      10 |     3308.0 |     54.19 |   128 |
| countParallelPlatf |      11 |     3231.4 |     64.60 |   128 |
| countParallelPlatf |      12 |     3114.4 |     91.58 |   128 |
| countParallelPlatf |      24 |     3249.6 |    108.98 |   128 |
| countParallelPlatf |      48 |     3730.0 |    117.79 |   128 |
| countParallelPlatf |      96 |     5494.3 |    297.75 |    64 |
| countParallelPlatf |     192 |    10356.8 |    358.68 |    32 |
| countParallelPlatf |     384 |    20886.0 |    473.80 |    16 |
| countParallelPlatf |     768 |    38300.1 |   1061.00 |     8 |
| countParallelPlatf |    1536 |    77477.9 |   2369.60 |     4 |

### 9.1.2

***Make the same measurements for virtual threads.***

| Benchmark          | Threads |  Mean (us) | Std. dev. | Count |
|--------------------|--------:|-----------:|----------:|------:|
| countSequential    |         |    12439.1 |     29.47 |    32 |
| countParallelVirtu |       1 |    12606.1 |     34.80 |    32 |
| countParallelVirtu |       2 |     8742.4 |    371.95 |    32 |
| countParallelVirtu |       3 |     6476.2 |    258.74 |    64 |
| countParallelVirtu |       4 |     5257.9 |    183.31 |    64 |
| countParallelVirtu |       5 |     4897.0 |    309.75 |    64 |
| countParallelVirtu |       6 |     4940.8 |    252.97 |    64 |
| countParallelVirtu |       7 |     5000.3 |    187.51 |    64 |
| countParallelVirtu |       8 |     4843.6 |    182.96 |    64 |
| countParallelVirtu |       9 |     4339.3 |    132.89 |    64 |
| countParallelVirtu |      10 |     4001.9 |     64.23 |    64 |
| countParallelVirtu |      11 |     3725.5 |     74.46 |   128 |
| countParallelVirtu |      12 |     3342.5 |    101.21 |   128 |
| countParallelVirtu |      24 |     2703.2 |     60.65 |   128 |
| countParallelVirtu |      48 |     2390.4 |     32.86 |   128 |
| countParallelVirtu |      96 |     2233.6 |     32.08 |   128 |
| countParallelVirtu |     192 |     2185.6 |     24.47 |   128 |
| countParallelVirtu |     384 |     2149.8 |     20.18 |   128 |
| countParallelVirtu |     768 |     2146.0 |     17.94 |   128 |
| countParallelVirtu |    1536 |     2215.6 |    102.11 |   128 |


### 9.1.3

***Make the same measurement for the executor-and-task version, still for 1, 2, 3, . . . , 8, 16, 32, 64, . . . , 2048 parallel tasks.***

| Benchmark          | Threads | Mean (µs) | Std. dev. | Count|
|--------------------|------:|----------:|---------:|---------:|
| countSequential    |     – | 12424.3   |    13.15 |       32 |
| countParallelTask  |     1 | 12547.3   |    31.73 |       32 |
| countParallelTask  |     2 |  8808.1   |   228.34 |       32 |
| countParallelTask  |     3 |  6481.8   |   148.25 |       64 |
| countParallelTask  |     4 |  5112.2   |   236.29 |       64 |
| countParallelTask  |     5 |  4666.0   |   236.11 |       64 |
| countParallelTask  |     6 |  4983.2   |   331.21 |       64 |
| countParallelTask  |     7 |  5151.1   |   268.66 |       64 |
| countParallelTask  |     8 |  4867.5   |   152.18 |       64 |
| countParallelTask  |     9 |  4334.2   |   152.92 |       64 |
| countParallelTask  |    10 |  4022.8   |   116.02 |       64 |
| countParallelTask  |    11 |  3750.2   |    66.78 |      128 |
| countParallelTask  |    12 |  3425.6   |    88.62 |      128 |
| countParallelTask  |    24 |  2678.5   |    34.47 |      128 |
| countParallelTask  |    48 |  2382.6   |    20.31 |      128 |
| countParallelTask  |    96 |  2239.8   |    31.30 |      128 |
| countParallelTask  |   192 |  2229.9   |    94.22 |      128 |
| countParallelTask  |   384 |  2144.7   |    18.81 |      128 |
| countParallelTask  |   768 |  2141.5   |    29.92 |      128 |
| countParallelTask  |  1536 |  2135.7   |    21.34 |      128 |

### 9.1.4

***Reflect and comment on the results; are they plausible?***

Our machine has 12 cores.

1. Platform threads do not improve past the amount of cores that the cpu has - the overhead is greater than the gains past this.

2. Virtual threads keep improving past 12, due to the very little overhead.

3. Virtual threads and the executor-and-task version perform similarly on this non-blocking task.

## 9.2

### 9.1.1 - 9.1.4

Ran with 5.000.000

| Class                                | Time (ms) |
|--------------------------------------|----------:|
| class exercises09.SynchronizedHistogram |    1734.8 |
| class exercises09.CasHistogram       |    1577.9 |
| class exercises09.AtomicHistogram    |    1564.0 |
| class exercises09.StripedHistogram   |    1549.0 |
| class exercises09.LongAdderHistogram   |    1532.0 |

1. The results shows that the simple lock version performs the worst.

2. The Cas and AtomicHistogram versions perform better than synchronized for 5.000.000 range. However this is not consistent with higher numbers.

3. The striped Histogram does not perform significantly better as expected - even with strictly using increments and no reads.

### 9.1.5

Striped histogram resembles LA7 the most. It uses a stripecount implementation without any padding.

### 9.1.6

Surpisingly does not improve.  Maybe slightly better than own striped implementation. Does not have any reads.

## 9.3

### 9.3.1

|      |                           |
|------|---------------------------|
| OS   | Linux; 7.0.0-38-generic; amd64 |
| JVM  | Ubuntu; 25.0.4.1          |
| CPU  | null; 12 "cores"          |
| Date | 2026-10-26T12:19:07+0100  |

| Benchmark                | Threads |  Mean (us) | Std. dev. | Count |
|--------------------------|--------:|-----------:|----------:|------:|
| SyncLongAdder            |      20 |   893191.8 |  44314.98 |     2 |
| SyncLongArrayAdder       |      20 |   182707.3 |  40184.42 |     2 |
| SyncLongArrayAdderPadded |      20 |    19856.4 |   1019.76 |    16 |
| WrappedAtomicLong        |      20 |   145739.6 |  19249.84 |     2 |
| MyAtomicLong             |      20 |   393249.3 |   8298.85 |     2 |
| ThreadLocalAtomicLong    |      20 |    13478.7 |    719.26 |    32 |
| LongAdderArray           |      20 |    69346.6 |   7581.40 |     4 |
| LongAdderArrayPadded     |      20 |    13476.4 |    955.17 |    32 |
| WrappedLongAdder         |      20 |    11107.7 |    443.10 |    32 |

These results resemble the expected results from the lecture.

### 9.3.2

When using the padded version, it tries to ensure that the locks are spread out on seperate cache lines and therefore gets it own line. 

### 9.3.3

***See LongAdderPerformance.java***

| Benchmark                 | Threads |  Mean (us) | Std. dev. | Count |
|---------------------------|--------:|-----------:|----------:|------:|
| SyncLongAdder             |      20 |   699332.9 |  51771.69 |     2 |
| SyncLongArrayAdder        |      20 |   173564.0 |  33642.90 |     2 |
| SyncLongArrayAdderPadded  |      20 |    23345.9 |    856.15 |    16 |
| SyncLongArrayAdderLessPad |      20 |    69721.9 |   7947.52 |     4 |

Unsuprisingly the new variant performs worse. Because the lock elements are now null, and never initiated they are not present in heap. This means that the padding is essentially removed and the effect of padding removed. 

### 9.4

| Benchmark    | Size (B) |  Mean (us) | Std. dev. | Count |
|--------------|---------:|-----------:|----------:|------:|
| memory cover |     8192 |   168353.0 |   1425.17 |     2 |
| memory cover |    11584 |   168358.0 |   1037.72 |     2 |
| memory cover |    16384 |   168674.7 |   1883.80 |     2 |
| memory cover |    23172 |   170074.6 |   2092.71 |     2 |
| memory cover |    32772 |   175059.4 |   5118.59 |     2 |
| memory cover |    46348 |   259958.7 |   4896.96 |     2 |
| memory cover |    65544 |   319010.2 |   5446.49 |     2 |
| memory cover |    92692 |   361273.9 |  10320.79 |     2 |
| memory cover |   131088 |   378421.0 |   2638.81 |     2 |
| memory cover |   185388 |   396057.8 |   2652.23 |     2 |
| memory cover |   262180 |   424147.5 |   2363.33 |     2 |
| memory cover |   370780 |   546129.1 |   1422.48 |     2 |
| memory cover |   524364 |   673850.7 |    832.64 |     2 |
| memory cover |   741564 |   870918.5 |   2014.23 |     2 |
| memory cover |  1048728 |  1064921.4 |   2096.65 |     2 |
| memory cover |  1483124 |  1213006.0 |   3603.36 |     2 |
| memory cover |  2097456 |  1321167.6 |   9313.87 |     2 |
| memory cover |  2966252 |  1567721.3 |  12829.20 |     2 |
| memory cover |  4194912 |  2724619.9 |  42891.26 |     2 |
| memory cover |  5932500 |  5291390.1 |  37316.18 |     2 |
| memory cover |  8389820 |  7786469.2 |  53718.20 |     2 |
| memory cover | 11864996 |  9765263.8 |  25568.77 |     2 |
| memory cover | 16779640 | 11143189.4 |  27924.86 |     2 |
| memory cover | 23729996 | 12071283.5 |  27312.28 |     2 |
| memory cover | 33559284 | 12665702.4 |  30157.44 |     2 |
| memory cover | 47459996 | 13203175.4 |  72569.92 |     2 |
| memory cover | 67118572 | 13688421.3 |   7123.64 |     2 |
| memory cover | 94919996 | 14036612.5 |   6541.46 |     2 |
| memory cover | 134237144 | 14350949.1 |  34852.09 |     2 |
| memory cover | 189839988 | 14592856.6 |  41935.23 |     2 |
| memory cover | 268474284 | 15018693.3 |  34989.43 |     2 |
| memory cover | 379679972 | 15231337.2 |  43038.65 |     2 |

The CPU appears to have a 32 KB L1 cache, as the time increases above 32772 B. The results here are slightly worse than the i9 and m3 processors.

At larger sizes we see the RAM latency. For the 379679972 B array size, (15231337.2 us × 1000(get nanoseconds)) / 134217728(the  total repititions of k=arr[k]) = 113.5 ns per access. This suggests an effective RAM access latency of approximately 110 ns, in line with the book's estimate.
