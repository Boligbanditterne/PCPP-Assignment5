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

1. The results shows that the simple lock version performs the worst.

2. The Cas and AtomicHistogram versions perform better than synchronized for 5.000.000 range. However this is not consistent with higher numbers.

3. The striped Histogram does not perform significantly better as expected - even with strictly using increments and no reads.

### 9.1.5

Striped histogram resembles LA7 the most. It uses a stripecount implementation without any padding.

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
| memory cover |     8192 |   167406.9 |    840.96 |     2 |
| memory cover |    11584 |   167819.1 |    547.88 |     2 |
| memory cover |    16384 |   167164.6 |    290.12 |     2 |
| memory cover |    23172 |   169875.6 |   1527.29 |     2 |
| memory cover |    32772 |   172002.4 |   2100.03 |     2 |
| memory cover |    46348 |   254225.1 |   2310.13 |     2 |
| memory cover |    65544 |   316222.8 |   1492.57 |     2 |
| memory cover |    92692 |   358835.8 |   3230.10 |     2 |
| memory cover |   131088 |   389350.8 |   8911.21 |     2 |
| memory cover |   185388 |   408143.3 |   7023.08 |     2 |
| memory cover |   262180 |   430056.1 |   9699.73 |     2 |
| memory cover |   370780 |   530138.1 |  15677.01 |     2 |
| memory cover |   524364 |   619290.1 |  10816.78 |     2 |
| memory cover |   741564 |   863415.7 |   4373.24 |     2 |
| memory cover |  1048728 |  1064155.0 |  10593.49 |     2 |
| memory cover |  1483124 |  1218676.1 |   4690.51 |     2 |
| memory cover |  2097456 |  1366323.2 |  34641.94 |     2 |
| memory cover |  2966252 |  1841236.9 | 524428.13 |     2 |
| memory cover |  4194912 |  3014037.4 |  73211.02 |     2 |
| memory cover |  5932500 |  5922524.4 |  87131.54 |     2 |

The cpu has 32KB cache which can be seen by the increased time at > 32772. The results here are slightly worse than the i9 and m3 processors.
