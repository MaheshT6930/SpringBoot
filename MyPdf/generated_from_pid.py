# Auto-generated template from PDF (original text below as comments)
# Review and implement the TODOs.

# SSRREEEENNII  VVEENNIIGGAALLLLAA  BBIIGGDDAATTAA  TTRRAAIINNEERR  CCOONNSSUULLTTAANNTT                                    ++9911--99991166771199999911  SSRRIINNUUVVEENNIIGGAALLLLAA@@OOUUTTLLOOOOKK..CCOOMM    PIG Documentation:  
#  Introduction to Apache Pig  
#  Building Blocks ( Bag, Tuple & Field)  
#  Installing Pig  
#  Different modes of execution of PIG  
#  Pig Latin   
#  Data types  
#  Working with various PIG Commands covering all the functions in PIG  
#  Developing PIG scripts  
#  Parameter Substitution  
#  Passing parameters though a param file  
#  Joins ( Left Outer, Right Outer, Full Outer)  
#  Nested queries  
#  Specialized joins in PIG (Replicated, Skewed & Merge Join)  
#  HCatalog(Getting data from hive to pig & vice versa)  
#  Working with un -structured data  
#  Working with Semi -structured data like XML, JSON  
#  Hands -On Exercise  
#  Assignment on PIG  
# Introduction to Apache Pig : 
# Apache Pig is a tool used to analyze large amounts of data by represeting them as data flows. Using 
# the PigLatin scripting language operations like ETL (Extract, Transform and Load), adhoc data anlaysis 
# and iterative processing can be easily achieved.  
# Pig is an abstraction over MapReduce. In other words, all Pig scripts internally are converted into 
# Map and Reduce tasks to get the task done. Pig was built to make programming MapReduce 
# applications easier. Before Pig, Java was the only way to process the  data stored on HDFS.  
# Pig was first built in Yahoo! and later became a top level Apache project. In this series of we will walk 
# through the different features of pig using a sample dataset.  
# Bag, Tuple & Field : 
# • A relation is a bag (more specifically, an outer bag).  
# • Bag {(12. 5,hello world, -2),(2.87,bye world,10)}  
# A bag is a collection of tuples.  A bag is an unordered collection of tuples. A relation is a special kind 
# of bag, sometimes called an outer bag. An inner bag is a bag that is a field within some A bag is 
# repres ented by tuples separated by commas, all enclosed by curly  
#  
# Installing Pig : 
#  
# SSRREEEENNII  VVEENNIIGGAALLLLAA  BBIIGGDDAATTAA  TTRRAAIINNEERR  CCOONNSSUULLTTAANNTT                                    ++9911--99991166771199999911  SSRRIINNUUVVEENNIIGGAALLLLAA@@OOUUTTLLOOOOKK..CCOOMM    Download Pig  
# $ wget http ://mirror.symnds.com/software/Apache/pig/pig -0.12.0/pig -0.12.0.tar.gz  
# Untar  
# $ tar xvzf pig -0.12 .0.tar .gz 
# Rename to folder for easier access:  
# $ mv pig -0.12 .0 pig 
# Update .bashrc to add the following:  
# export  PATH =$PATH :/home/ hduser /pig/bin 
# Different modes of execution of PIG : 
# Pig can be started in one of the following two modes:  
# Local Mode  
# Cluster Mode  
# Using the  ’-x local’  options starts pig in the local mode whereas executing the pig command without 
# any options starts in Pig in the cluster mode. When in local mode, pig can access files on the local file 
# system. In cluster mode, pig can access files on HDFS.  
# Restart your ter minal and execute the pig command as follows:  
# To start in Local Mode:  
# $ pig -x local  
# 2013 -12-25 20:16:26,258 [main ] INFO org .apache .pig.Main  - Apache  Pig version 0.12 .0 (r1529718 ) 
# compiled Oct 07 2013 , 12:20:14 
# 2013 -12-25 20:16:26,259 [main ] INFO org .apache .pig.Main  - Logging  error messages to : 
# /home/ hduser /pig/myscripts /pig_1388027786256 .log 
# 2013 -12-25 20:16:26,281 [main ] INFO org .apache .pig.impl .util.Utils  - Default  bootup file 
# /home /hduser /.pigbootup not found  
# 2013 -12-25 20:16:26,381 [main ] INFO 
# org.apache .pig.backend .hadoop .executionengine .HExecutionEngine  - Connecting  to hadoop file 
# system at : file:/// 
# grunt > 
# To start in Cluster Mode:  
# $ pig  
#  
# SSRREEEENNII  VVEENNIIGGAALLLLAA  BBIIGGDDAATTAA  TTRRAAIINNEERR  CCOONNSSUULLTTAANNTT                                    ++9911--99991166771199999911  SSRRIINNUUVVEENNIIGGAALLLLAA@@OOUUTTLLOOOOKK..CCOOMM    2013 -12-25 20:19:42,274 [main ] INFO org .apache .pig.Main  - Apache  Pig version 0.12 .0 (r1529718 ) 
# compiled O


# --- Inferred skeletons ---

"""Auto-generated skeletons from PDF instructions.

Fill in the implementations where marked."""

def main():
    """Entry point. Implement program logic here."""
    pass

if __name__ == '__main__':
    main()
