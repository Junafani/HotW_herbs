# HotW_herbs

HotW_herbs is program for calculating phial drop rates in LOTRO. It accepts CSV file with logged drops
and outputs some information on console and also Test.csv-file that contains drop rates in CSV file.

## Input CSV file

Format of input CSV file is following:

-Name of file needs to be "data.csv".
-First line is header "Herb,Crimson Extract,Umber Extract,Verdant Extract,Amber Extract,Sapphire Extract,Violet Extract,Golden Extract"-
-Following lines are pickups. Empty cells can be left empty or marked with 0.

Example:

```Herb,Crimson Extract,Umber Extract,Verdant Extract,Amber Extract,Sapphire Extract,Violet Extract,Golden Extract
Horsetail,,2,,,,,  
Vetchling,2,,,,,,  
Vetchling,2,,,,,,  
Rock-rose,3,1,,,,,  
Buckthorn,2,,2,,,,  
```

## Output file

Program outputs file "Test.csv" which has average pickup rates for each phial per herb.

## TODO  
-Calculate percentage of different amount of phial drops.