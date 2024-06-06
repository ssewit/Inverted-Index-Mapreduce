# Inverted-Index-Mapreduce
Partial and Full Inverted Index on MapReduce

<img width="649" alt="image" src="https://github.com/ssewit/Inverted-Index-Mapreduce/assets/105317921/c6425614-0fcd-4bd4-a5dc-8a5cd1c6e17b">

We are considering three files for this project

    file0's content "it is what it is"
    
    file1's content "what is it"

    file2's content "it is a banana"

## Partially Inveted Index

<img width="395" alt="image" src="https://github.com/ssewit/Inverted-Index-Mapreduce/assets/105317921/76d73fec-b2d8-4ea0-b408-1a2ebbb05f96">

## Fully Inverted Index

<img width="503" alt="image" src="https://github.com/ssewit/Inverted-Index-Mapreduce/assets/105317921/2729663d-29fb-4513-ac42-b164df9274b7">

## Word Count with Combiner (Partially Inverted)

<img width="602" alt="image" src="https://github.com/ssewit/Inverted-Index-Mapreduce/assets/105317921/e74c684d-7902-456d-9a85-ced8c00310f8">

## Word Count with Combiner (Fully Inverted)

<img width="411" alt="image" src="https://github.com/ssewit/Inverted-Index-Mapreduce/assets/105317921/b95d036f-c2fc-4f02-9cdc-9b4e57d820a8">


# Design
Create the text files with the corresponding content:

    file0's content "it is what it is"
    
    file1's content "what is it"

    file2's content "it is a banana"
    
Create the java file to take the input file, reducde and map

# Implementation

```
  $ mkdir inverte_index
  $ cd inverte_index
  $ vi file0.txt
  $ vi file1.txt
  $ vi file2.txt
```
Create Java files 
```
  $ vi DocSumWritable.java
  $ vi IndexReducer.java
  $ vi IndexMapper.java
```

Compile the files

Create Java files 
```
  $ cd InvertedIndexProject
  $ mkdir classes
  $ javac -classpath $(hadoop classpath) -d classes TokenizerMapper.java InvertedIndexReducer.java InvertedIndex.java

```
Create the JAR File

```
  $ jar -cvf invertedindex.jar -C classes/ .

```

Start Hadoop and yarn

```
  $ start-dfs.sh
  $ start-yarn.sh

```
Input and output directories for HDFS 

```
  $ hdfs dfs -mkdir /input
  $ hdfs dfs -mkdir /output
  $ hdfs dfs -put input/* /input

```

Run the Map Job

```
  $ hadoop jar invertedindex.jar InvertedIndex /input /output
  $ hdfs dfs -ls /output
  $ hdfs dfs -cat /output/part-r-00000

```


# Partially Inverted Index Result

<img width="356" alt="image" src="https://github.com/ssewit/Inverted-Index-Mapreduce/assets/105317921/b745e5e4-faf3-4336-9f30-bf949373374f">

# Fully Inverted Index Result

<img width="424" alt="image" src="https://github.com/ssewit/Inverted-Index-Mapreduce/assets/105317921/58339d00-e524-4e75-ac91-16cfb7392c0a">
