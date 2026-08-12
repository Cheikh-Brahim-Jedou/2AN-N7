> source("/Users/chico/Desktop/2AN-N7/Statistique/DataTP.txt")
Error in source("/Users/chico/Desktop/2AN-N7/Statistique/DataTP.txt") : 
  /Users/chico/Desktop/2AN-N7/Statistique/DataTP.txt:1:4: unexpected symbol
1: JJ O3o
       ^
> getwd()
[1] "/Users/chico"
> setwd("/Users/chico/Desktop/2AN-N7/Statistique")
> getwd()
[1] "/Users/chico/Desktop/2AN-N7/Statistique"
> data = read.table(file="DataTP.txt",header=TRUE)
> summary(data)
      JJ                 O3o             O3p            TEMPE      
 Length:1041        Min.   : 19.0   Min.   : 46.4   Min.   :10.40  
 Class :character   1st Qu.: 87.0   1st Qu.: 97.5   1st Qu.:20.20  
 Mode  :character   Median :109.0   Median :125.6   Median :23.80  
                    Mean   :115.4   Mean   :127.2   Mean   :23.88  
                    3rd Qu.:135.0   3rd Qu.:153.6   3rd Qu.:27.60  
                    Max.   :319.0   Max.   :284.7   Max.   :38.00  
     RMH2O              NO2           STATION                FF         
 Min.   :0.00285   Min.   : 0.258   Length:1041        Min.   : 0.1414  
 1st Qu.:0.00763   1st Qu.: 1.248   Class :character   1st Qu.: 3.9623  
 Median :0.00985   Median : 2.109   Mode  :character   Median : 5.5973  
 Mean   :0.01025   Mean   : 3.505                      Mean   : 5.9072  
 3rd Qu.:0.01244   3rd Qu.: 4.062                      3rd Qu.: 7.1063  
 Max.   :0.02753   Max.   :44.396                      Max.   :19.8910  
> modele_complet = lm(O3o~ ., data=data)
> summary(modele_complet)

Call:
lm(formula = O3o ~ ., data = data)

Residuals:
     Min       1Q   Median       3Q      Max 
-103.512  -18.886   -0.888   17.491  152.904 

Coefficients:
             Estimate Std. Error t value Pr(>|t|)    
(Intercept) -21.85174    6.57065  -3.326 0.000913 ***
JJS          -0.91775    1.91297  -0.480 0.631506    
O3p           0.30399    0.03307   9.191  < 2e-16 ***
TEMPE         3.90188    0.22401  17.418  < 2e-16 ***
RMH2O       665.11066  256.61697   2.592 0.009681 ** 
NO2           0.41155    0.25599   1.608 0.108220    
STATIONAls    0.80212    3.36489   0.238 0.811635    
STATIONCad    7.73458    3.02009   2.561 0.010577 *  
STATIONPla   18.11839    3.50722   5.166 2.87e-07 ***
STATIONRam    1.90856    3.11566   0.613 0.540296    
FF           -1.33899    0.36490  -3.669 0.000256 ***
---
Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

Residual standard error: 28.27 on 1030 degrees of freedom
Multiple R-squared:  0.5293,	Adjusted R-squared:  0.5247 
F-statistic: 115.8 on 10 and 1030 DF,  p-value: < 2.2e-16

> library(MASS)
> modele_aic = stepAIC(modele_complet, direction="backward")
Start:  AIC=6968.29
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF

          Df Sum of Sq     RSS    AIC
- JJ       1       184  823130 6966.5
<none>                  822946 6968.3
- NO2      1      2065  825011 6968.9
- RMH2O    1      5367  828313 6973.1
- FF       1     10758  833704 6979.8
- STATION  4     24881  847827 6991.3
- O3p      1     67493  890439 7048.3
- TEMPE    1    242405 1065351 7235.0

Step:  AIC=6966.52
O3o ~ O3p + TEMPE + RMH2O + NO2 + STATION + FF

          Df Sum of Sq     RSS    AIC
<none>                  823130 6966.5
- NO2      1      2034  825165 6967.1
- RMH2O    1      5259  828390 6971.2
- FF       1     11006  834136 6978.3
- STATION  4     25033  848163 6989.7
- O3p      1     67314  890444 7046.4
- TEMPE    1    243173 1066303 7234.0
> summary(modele_aic)

Call:
lm(formula = O3o ~ O3p + TEMPE + RMH2O + NO2 + STATION + FF, 
    data = data)

Residuals:
     Min       1Q   Median       3Q      Max 
-102.800  -19.069   -0.986   17.601  152.641 

Coefficients:
             Estimate Std. Error t value Pr(>|t|)    
(Intercept) -22.31640    6.49644  -3.435 0.000616 ***
O3p           0.30330    0.03303   9.182  < 2e-16 ***
TEMPE         3.90565    0.22379  17.452  < 2e-16 ***
RMH2O       656.95171  255.95721   2.567 0.010409 *  
NO2           0.40836    0.25581   1.596 0.110725    
STATIONAls    0.75918    3.36244   0.226 0.821417    
STATIONCad    7.72459    3.01889   2.559 0.010647 *  
STATIONPla   18.15113    3.50525   5.178 2.69e-07 ***
STATIONRam    1.88239    3.11402   0.604 0.545652    
FF           -1.35108    0.36390  -3.713 0.000216 ***
---
Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

Residual standard error: 28.26 on 1031 degrees of freedom
Multiple R-squared:  0.5291,	Adjusted R-squared:  0.525 
F-statistic: 128.7 on 9 and 1031 DF,  p-value: < 2.2e-16

> modele_bic = stepAIC(modele_complet, direction="backward", k=log(nrow(data)))
Start:  AIC=7022.72
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF

          Df Sum of Sq     RSS    AIC
- JJ       1       184  823130 7016.0
- NO2      1      2065  825011 7018.4
- RMH2O    1      5367  828313 7022.5
<none>                  822946 7022.7
- STATION  4     24881  847827 7025.9
- FF       1     10758  833704 7029.3
- O3p      1     67493  890439 7097.8
- TEMPE    1    242405 1065351 7284.5

Step:  AIC=7016
O3o ~ O3p + TEMPE + RMH2O + NO2 + STATION + FF

          Df Sum of Sq     RSS    AIC
- NO2      1      2034  825165 7011.6
- RMH2O    1      5259  828390 7015.7
<none>                  823130 7016.0
- STATION  4     25033  848163 7019.4
- FF       1     11006  834136 7022.9
- O3p      1     67314  890444 7090.9
- TEMPE    1    243173 1066303 7278.5

Step:  AIC=7011.62
O3o ~ O3p + TEMPE + RMH2O + STATION + FF

          Df Sum of Sq     RSS    AIC
- RMH2O    1      4914  830079 7010.9
<none>                  825165 7011.6
- STATION  4     23162  848327 7012.7
- FF       1     12250  837415 7020.0
- O3p      1     78717  903882 7099.5
- TEMPE    1    241575 1066740 7272.0

Step:  AIC=7010.86
O3o ~ O3p + TEMPE + STATION + FF

          Df Sum of Sq     RSS    AIC
<none>                  830079 7010.9
- STATION  4     24358  854437 7013.2
- FF       1     16112  846191 7023.9
- O3p      1     83925  914004 7104.2
- TEMPE    1    264355 1094434 7291.7
> summary(modele_bic)

Call:
lm(formula = O3o ~ O3p + TEMPE + STATION + FF, data = data)

Residuals:
    Min      1Q  Median      3Q     Max 
-98.526 -18.606  -0.858  17.840 153.262 

Coefficients:
             Estimate Std. Error t value Pr(>|t|)    
(Intercept) -15.82795    6.09487  -2.597  0.00954 ** 
O3p           0.32534    0.03183  10.220  < 2e-16 ***
TEMPE         3.96241    0.21846  18.138  < 2e-16 ***
STATIONAls   -0.31788    3.18811  -0.100  0.92060    
STATIONCad    5.89587    2.83971   2.076  0.03812 *  
STATIONPla   16.48771    3.18833   5.171 2.79e-07 ***
STATIONRam    1.19463    3.06210   0.390  0.69652    
FF           -1.59270    0.35569  -4.478 8.38e-06 ***
---
Signif. codes:  
0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

Residual standard error: 28.35 on 1033 degrees of freedom
Multiple R-squared:  0.5252,	Adjusted R-squared:  0.522 
F-statistic: 163.2 on 7 and 1033 DF,  p-value: < 2.2e-16

> modele_complet_inter = lm(O3o ~ .^2, data=data)
> modele_bic_inter = stepAIC(modele_complet_inter, direction="backward", k=log(nrow(data)))
Start:  AIC=7032.3
O3o ~ (JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF)^2

                Df Sum of Sq    RSS    AIC
- JJ:STATION     4       662 640873 7005.6
- STATION:FF     4      5275 645486 7013.0
- NO2:STATION    4      6382 646592 7014.8
- O3p:STATION    4      8878 649089 7018.8
- O3p:NO2        1        44 640254 7025.4
- TEMPE:FF       1       142 640352 7025.6
- JJ:RMH2O       1       144 640355 7025.6
- JJ:TEMPE       1       285 640495 7025.8
- RMH2O:NO2      1       355 640566 7025.9
- TEMPE:NO2      1       401 640611 7026.0
- JJ:O3p         1       409 640620 7026.0
- JJ:NO2         1       639 640849 7026.4
- O3p:RMH2O      1       650 640860 7026.4
- NO2:FF         1       661 640871 7026.4
- RMH2O:FF       1       994 641204 7027.0
- JJ:FF          1      2009 642220 7028.6
<none>                       640210 7032.3
- O3p:FF         1      5022 645232 7033.5
- RMH2O:STATION  4     20530 660740 7037.4
- TEMPE:STATION  4     22435 662645 7040.4
- O3p:TEMPE      1     13132 653343 7046.5
- TEMPE:RMH2O    1     33136 673346 7077.9

Step:  AIC=7005.58
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:TEMPE + JJ:RMH2O + JJ:NO2 + JJ:FF + O3p:TEMPE + O3p:RMH2O + 
    O3p:NO2 + O3p:STATION + O3p:FF + TEMPE:RMH2O + TEMPE:NO2 + 
    TEMPE:STATION + TEMPE:FF + RMH2O:NO2 + RMH2O:STATION + RMH2O:FF + 
    NO2:STATION + NO2:FF + STATION:FF

                Df Sum of Sq    RSS    AIC
- STATION:FF     4      5282 646155 6986.3
- NO2:STATION    4      6356 647229 6988.1
- O3p:STATION    4      8812 649685 6992.0
- O3p:NO2        1        63 640936 6998.7
- JJ:RMH2O       1       126 640999 6998.8
- TEMPE:FF       1       181 641054 6998.9
- RMH2O:NO2      1       373 641246 6999.2
- TEMPE:NO2      1       401 641273 6999.3
- JJ:TEMPE       1       499 641371 6999.4
- NO2:FF         1       685 641557 6999.7
- O3p:RMH2O      1       704 641577 6999.8
- JJ:NO2         1       729 641601 6999.8
- RMH2O:FF       1      1034 641906 7000.3
- JJ:FF          1      1433 642306 7001.0
- JJ:O3p         1      1705 642578 7001.4
<none>                       640873 7005.6
- O3p:FF         1      4903 645776 7006.6
- RMH2O:STATION  4     20535 661407 7010.6
- TEMPE:STATION  4     22308 663180 7013.4
- O3p:TEMPE      1     12959 653832 7019.5
- TEMPE:RMH2O    1     33585 674457 7051.8

Step:  AIC=6986.34
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:TEMPE + JJ:RMH2O + JJ:NO2 + JJ:FF + O3p:TEMPE + O3p:RMH2O + 
    O3p:NO2 + O3p:STATION + O3p:FF + TEMPE:RMH2O + TEMPE:NO2 + 
    TEMPE:STATION + TEMPE:FF + RMH2O:NO2 + RMH2O:STATION + RMH2O:FF + 
    NO2:STATION + NO2:FF

                Df Sum of Sq    RSS    AIC
- NO2:STATION    4      5922 652076 6968.0
- O3p:STATION    4      5929 652084 6968.1
- JJ:RMH2O       1        21 646176 6979.4
- JJ:TEMPE       1       255 646410 6979.8
- O3p:NO2        1       266 646421 6979.8
- TEMPE:NO2      1       369 646524 6980.0
- TEMPE:FF       1       427 646582 6980.1
- RMH2O:NO2      1       451 646606 6980.1
- RMH2O:FF       1       475 646629 6980.2
- JJ:NO2         1      1019 647174 6981.0
- O3p:RMH2O      1      1041 647196 6981.1
- NO2:FF         1      1202 647356 6981.3
- JJ:O3p         1      1987 648142 6982.6
- JJ:FF          1      2539 648694 6983.5
- O3p:FF         1      3633 649788 6985.2
<none>                       646155 6986.3
- RMH2O:STATION  4     21475 667630 6992.6
- TEMPE:STATION  4     21905 668060 6993.2
- O3p:TEMPE      1     15444 661598 7004.0
- TEMPE:RMH2O    1     33204 679359 7031.6

Step:  AIC=6968.04
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:TEMPE + JJ:RMH2O + JJ:NO2 + JJ:FF + O3p:TEMPE + O3p:RMH2O + 
    O3p:NO2 + O3p:STATION + O3p:FF + TEMPE:RMH2O + TEMPE:NO2 + 
    TEMPE:STATION + TEMPE:FF + RMH2O:NO2 + RMH2O:STATION + RMH2O:FF + 
    NO2:FF

                Df Sum of Sq    RSS    AIC
- O3p:STATION    4     10140 662217 6956.3
- JJ:RMH2O       1         6 652083 6961.1
- JJ:TEMPE       1       176 652252 6961.4
- TEMPE:FF       1       243 652319 6961.5
- RMH2O:NO2      1       370 652447 6961.7
- RMH2O:FF       1       403 652479 6961.7
- O3p:NO2        1       757 652834 6962.3
- TEMPE:NO2      1       795 652871 6962.4
- JJ:NO2         1       950 653027 6962.6
- NO2:FF         1      1041 653118 6962.8
- O3p:RMH2O      1      1226 653303 6963.0
- JJ:O3p         1      1895 653972 6964.1
- JJ:FF          1      2453 654529 6965.0
- O3p:FF         1      3728 655804 6967.0
<none>                       652076 6968.0
- RMH2O:STATION  4     22033 674109 6974.8
- TEMPE:STATION  4     24714 676790 6979.0
- O3p:TEMPE      1     16194 668271 6986.6
- TEMPE:RMH2O    1     32756 684833 7012.1

Step:  AIC=6956.31
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:TEMPE + JJ:RMH2O + JJ:NO2 + JJ:FF + O3p:TEMPE + O3p:RMH2O + 
    O3p:NO2 + O3p:FF + TEMPE:RMH2O + TEMPE:NO2 + TEMPE:STATION + 
    TEMPE:FF + RMH2O:NO2 + RMH2O:STATION + RMH2O:FF + NO2:FF

                Df Sum of Sq    RSS    AIC
- JJ:RMH2O       1        28 662245 6949.4
- TEMPE:FF       1       172 662389 6949.6
- JJ:TEMPE       1       212 662428 6949.7
- RMH2O:NO2      1       388 662605 6950.0
- RMH2O:FF       1       467 662684 6950.1
- NO2:FF         1       608 662825 6950.3
- JJ:NO2         1      1132 663348 6951.1
- O3p:RMH2O      1      1399 663616 6951.6
- TEMPE:NO2      1      1417 663634 6951.6
- JJ:O3p         1      1960 664176 6952.4
- O3p:NO2        1      2241 664457 6952.9
- JJ:FF          1      2628 664845 6953.5
- O3p:FF         1      3178 665395 6954.3
<none>                       662217 6956.3
- RMH2O:STATION  4     21228 683444 6961.4
- TEMPE:STATION  4     25964 688181 6968.6
- O3p:TEMPE      1     22141 684357 6983.6
- TEMPE:RMH2O    1     32269 694485 6998.9

Step:  AIC=6949.41
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:TEMPE + JJ:NO2 + JJ:FF + O3p:TEMPE + O3p:RMH2O + O3p:NO2 + 
    O3p:FF + TEMPE:RMH2O + TEMPE:NO2 + TEMPE:STATION + TEMPE:FF + 
    RMH2O:NO2 + RMH2O:STATION + RMH2O:FF + NO2:FF

                Df Sum of Sq    RSS    AIC
- TEMPE:FF       1       167 662411 6942.7
- JJ:TEMPE       1       267 662512 6942.9
- RMH2O:NO2      1       376 662621 6943.1
- RMH2O:FF       1       508 662753 6943.3
- NO2:FF         1       618 662863 6943.4
- JJ:NO2         1      1111 663356 6944.2
- TEMPE:NO2      1      1416 663660 6944.7
- O3p:RMH2O      1      1469 663714 6944.8
- JJ:O3p         1      1932 664177 6945.5
- O3p:NO2        1      2219 664464 6945.9
- JJ:FF          1      2781 665026 6946.8
- O3p:FF         1      3175 665420 6947.4
<none>                       662245 6949.4
- RMH2O:STATION  4     21726 683971 6955.2
- TEMPE:STATION  4     26146 688391 6961.9
- O3p:TEMPE      1     22156 684401 6976.7
- TEMPE:RMH2O    1     33306 695551 6993.5

Step:  AIC=6942.72
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:TEMPE + JJ:NO2 + JJ:FF + O3p:TEMPE + O3p:RMH2O + O3p:NO2 + 
    O3p:FF + TEMPE:RMH2O + TEMPE:NO2 + TEMPE:STATION + RMH2O:NO2 + 
    RMH2O:STATION + RMH2O:FF + NO2:FF

                Df Sum of Sq    RSS    AIC
- JJ:TEMPE       1       289 662700 6936.2
- RMH2O:NO2      1       388 662800 6936.4
- RMH2O:FF       1       603 663015 6936.7
- NO2:FF         1       651 663063 6936.8
- JJ:NO2         1      1120 663531 6937.5
- TEMPE:NO2      1      1546 663957 6938.2
- O3p:RMH2O      1      1759 664171 6938.5
- JJ:O3p         1      1968 664380 6938.9
- O3p:NO2        1      2335 664747 6939.4
- JJ:FF          1      2809 665221 6940.2
- O3p:FF         1      3024 665435 6940.5
<none>                       662411 6942.7
- RMH2O:STATION  4     22567 684978 6949.8
- TEMPE:STATION  4     33874 696285 6966.8
- O3p:TEMPE      1     23593 686004 6972.2
- TEMPE:RMH2O    1     35467 697878 6990.1

Step:  AIC=6936.23
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:NO2 + JJ:FF + O3p:TEMPE + O3p:RMH2O + O3p:NO2 + O3p:FF + 
    TEMPE:RMH2O + TEMPE:NO2 + TEMPE:STATION + RMH2O:NO2 + RMH2O:STATION + 
    RMH2O:FF + NO2:FF

                Df Sum of Sq    RSS    AIC
- RMH2O:NO2      1       367 663067 6929.9
- RMH2O:FF       1       603 663303 6930.2
- NO2:FF         1       663 663364 6930.3
- JJ:NO2         1      1106 663806 6931.0
- TEMPE:NO2      1      1535 664236 6931.7
- O3p:RMH2O      1      1673 664374 6931.9
- JJ:O3p         1      1688 664388 6931.9
- O3p:NO2        1      2316 665016 6932.9
- JJ:FF          1      2857 665557 6933.8
- O3p:FF         1      3013 665714 6934.0
<none>                       662700 6936.2
- RMH2O:STATION  4     22468 685168 6943.1
- TEMPE:STATION  4     33749 696449 6960.1
- O3p:TEMPE      1     23412 686113 6965.4
- TEMPE:RMH2O    1     35306 698006 6983.3

Step:  AIC=6929.86
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:NO2 + JJ:FF + O3p:TEMPE + O3p:RMH2O + O3p:NO2 + O3p:FF + 
    TEMPE:RMH2O + TEMPE:NO2 + TEMPE:STATION + RMH2O:STATION + 
    RMH2O:FF + NO2:FF

                Df Sum of Sq    RSS    AIC
- RMH2O:FF       1       689 663756 6924.0
- NO2:FF         1       782 663849 6924.1
- JJ:NO2         1      1123 664190 6924.7
- O3p:RMH2O      1      1327 664394 6925.0
- JJ:O3p         1      1621 664688 6925.5
- O3p:NO2        1      2170 665237 6926.3
- TEMPE:NO2      1      2187 665254 6926.3
- JJ:FF          1      2836 665903 6927.4
- O3p:FF         1      3034 666100 6927.7
<none>                       663067 6929.9
- RMH2O:STATION  4     22423 685490 6936.7
- TEMPE:STATION  4     34849 697916 6955.4
- O3p:TEMPE      1     23186 686253 6958.7
- TEMPE:RMH2O    1     35079 698146 6976.6

Step:  AIC=6923.99
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:NO2 + JJ:FF + O3p:TEMPE + O3p:RMH2O + O3p:NO2 + O3p:FF + 
    TEMPE:RMH2O + TEMPE:NO2 + TEMPE:STATION + RMH2O:STATION + 
    NO2:FF

                Df Sum of Sq    RSS    AIC
- NO2:FF         1       673 664429 6918.1
- O3p:RMH2O      1       934 664690 6918.5
- JJ:NO2         1      1119 664875 6918.8
- JJ:O3p         1      1694 665450 6919.7
- O3p:NO2        1      2225 665981 6920.5
- TEMPE:NO2      1      2445 666201 6920.9
- O3p:FF         1      2861 666618 6921.5
- JJ:FF          1      3027 666783 6921.8
<none>                       663756 6924.0
- RMH2O:STATION  4     26332 690088 6936.7
- TEMPE:STATION  4     34911 698667 6949.6
- O3p:TEMPE      1     22725 686482 6952.1
- TEMPE:RMH2O    1     34502 698259 6969.8

Step:  AIC=6918.1
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:NO2 + JJ:FF + O3p:TEMPE + O3p:RMH2O + O3p:NO2 + O3p:FF + 
    TEMPE:RMH2O + TEMPE:NO2 + TEMPE:STATION + RMH2O:STATION

                Df Sum of Sq    RSS    AIC
- O3p:RMH2O      1       960 665389 6912.7
- JJ:NO2         1      1153 665582 6913.0
- JJ:O3p         1      1690 666119 6913.8
- O3p:NO2        1      2220 666649 6914.6
- JJ:FF          1      3059 667488 6915.9
- TEMPE:NO2      1      3250 667679 6916.2
- O3p:FF         1      3679 668108 6916.9
<none>                       664429 6918.1
- RMH2O:STATION  4     26410 690839 6930.9
- TEMPE:STATION  4     35079 699508 6943.9
- O3p:TEMPE      1     22783 687212 6946.2
- TEMPE:RMH2O    1     34350 698779 6963.6

Step:  AIC=6912.65
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:NO2 + JJ:FF + O3p:TEMPE + O3p:NO2 + O3p:FF + TEMPE:RMH2O + 
    TEMPE:NO2 + TEMPE:STATION + RMH2O:STATION

                Df Sum of Sq    RSS    AIC
- JJ:NO2         1      1111 666500 6907.4
- JJ:O3p         1      1325 666714 6907.8
- O3p:NO2        1      2387 667776 6909.4
- JJ:FF          1      2822 668211 6910.1
- TEMPE:NO2      1      3438 668826 6911.1
<none>                       665389 6912.7
- O3p:FF         1      4714 670103 6913.1
- RMH2O:STATION  4     27544 692933 6927.1
- TEMPE:STATION  4     35417 700806 6938.8
- O3p:TEMPE      1     22434 687823 6940.2
- TEMPE:RMH2O    1     35706 701095 6960.1

Step:  AIC=6907.44
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:O3p + 
    JJ:FF + O3p:TEMPE + O3p:NO2 + O3p:FF + TEMPE:RMH2O + TEMPE:NO2 + 
    TEMPE:STATION + RMH2O:STATION

                Df Sum of Sq    RSS    AIC
- JJ:O3p         1       873 667373 6901.9
- JJ:FF          1      2417 668916 6904.3
- O3p:NO2        1      2442 668942 6904.3
- TEMPE:NO2      1      3535 670034 6906.0
<none>                       666500 6907.4
- O3p:FF         1      4739 671238 6907.9
- RMH2O:STATION  4     27826 694326 6922.2
- TEMPE:STATION  4     35316 701816 6933.4
- O3p:TEMPE      1     21992 688491 6934.3
- TEMPE:RMH2O    1     35532 702031 6954.6

Step:  AIC=6901.86
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:FF + 
    O3p:TEMPE + O3p:NO2 + O3p:FF + TEMPE:RMH2O + TEMPE:NO2 + 
    TEMPE:STATION + RMH2O:STATION

                Df Sum of Sq    RSS    AIC
- O3p:NO2        1      2187 669560 6898.3
- JJ:FF          1      2481 669854 6898.8
- TEMPE:NO2      1      3542 670915 6900.4
<none>                       667373 6901.9
- O3p:FF         1      4735 672108 6902.3
- RMH2O:STATION  4     28465 695838 6917.5
- TEMPE:STATION  4     35431 702804 6927.9
- O3p:TEMPE      1     21781 689154 6928.3
- TEMPE:RMH2O    1     36151 703524 6949.8

Step:  AIC=6898.31
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:FF + 
    O3p:TEMPE + O3p:FF + TEMPE:RMH2O + TEMPE:NO2 + TEMPE:STATION + 
    RMH2O:STATION

                Df Sum of Sq    RSS    AIC
- TEMPE:NO2      1      2096 671657 6894.6
- JJ:FF          1      2499 672060 6895.2
<none>                       669560 6898.3
- O3p:FF         1      5618 675179 6900.1
- RMH2O:STATION  4     28340 697900 6913.7
- O3p:TEMPE      1     22002 691562 6925.0
- TEMPE:STATION  4     36050 705611 6925.1
- TEMPE:RMH2O    1     37014 706574 6947.4

Step:  AIC=6894.62
O3o ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + JJ:FF + 
    O3p:TEMPE + O3p:FF + TEMPE:RMH2O + TEMPE:STATION + RMH2O:STATION

                Df Sum of Sq    RSS    AIC
- NO2            1       170 671827 6887.9
- JJ:FF          1      2621 674278 6891.7
<none>                       671657 6894.6
- O3p:FF         1      5919 677576 6896.8
- RMH2O:STATION  4     28265 699922 6909.7
- TEMPE:STATION  4     34410 706066 6918.8
- O3p:TEMPE      1     27899 699555 6930.0
- TEMPE:RMH2O    1     35756 707413 6941.7

Step:  AIC=6887.94
O3o ~ JJ + O3p + TEMPE + RMH2O + STATION + FF + JJ:FF + O3p:TEMPE + 
    O3p:FF + TEMPE:RMH2O + TEMPE:STATION + RMH2O:STATION

                Df Sum of Sq    RSS    AIC
- JJ:FF          1      2642 674468 6885.1
<none>                       671827 6887.9
- O3p:FF         1      6159 677985 6890.5
- RMH2O:STATION  4     28253 700079 6903.0
- TEMPE:STATION  4     34668 706494 6912.5
- O3p:TEMPE      1     28179 700006 6923.8
- TEMPE:RMH2O    1     35783 707610 6935.0

Step:  AIC=6885.07
O3o ~ JJ + O3p + TEMPE + RMH2O + STATION + FF + O3p:TEMPE + O3p:FF + 
    TEMPE:RMH2O + TEMPE:STATION + RMH2O:STATION

                Df Sum of Sq    RSS    AIC
- JJ             1         2 674470 6878.1
<none>                       674468 6885.1
- O3p:FF         1      5597 680065 6886.7
- RMH2O:STATION  4     27504 701973 6898.9
- TEMPE:STATION  4     34446 708914 6909.1
- O3p:TEMPE      1     27655 702123 6920.0
- TEMPE:RMH2O    1     36470 710938 6932.9

Step:  AIC=6878.13
O3o ~ O3p + TEMPE + RMH2O + STATION + FF + O3p:TEMPE + O3p:FF + 
    TEMPE:RMH2O + TEMPE:STATION + RMH2O:STATION

                Df Sum of Sq    RSS    AIC
<none>                       674470 6878.1
- O3p:FF         1      5598 680068 6879.8
- RMH2O:STATION  4     27512 701982 6892.0
- TEMPE:STATION  4     34445 708915 6902.2
- O3p:TEMPE      1     27703 702173 6913.1
- TEMPE:RMH2O    1     36505 710975 6926.1
> summary(modele_bic_inter)

Call:
lm(formula = O3o ~ O3p + TEMPE + RMH2O + STATION + FF + O3p:TEMPE + 
    O3p:FF + TEMPE:RMH2O + TEMPE:STATION + RMH2O:STATION, data = data)

Residuals:
    Min      1Q  Median      3Q     Max 
-89.037 -17.613  -0.417  15.491 145.465 

Coefficients:
                   Estimate Std. Error t value Pr(>|t|)    
(Intercept)       1.988e+02  2.238e+01   8.880  < 2e-16 ***
O3p              -6.627e-01  1.354e-01  -4.895 1.14e-06 ***
TEMPE            -4.488e+00  8.285e-01  -5.417 7.58e-08 ***
RMH2O            -6.994e+03  1.289e+03  -5.428 7.12e-08 ***
STATIONAls       -5.098e+01  1.534e+01  -3.323 0.000923 ***
STATIONCad        1.066e+01  1.669e+01   0.639 0.523272    
STATIONPla        1.546e+01  1.676e+01   0.923 0.356374    
STATIONRam       -6.524e+00  1.476e+01  -0.442 0.658674    
FF               -4.566e+00  1.115e+00  -4.096 4.54e-05 ***
O3p:TEMPE         3.236e-02  4.997e-03   6.476 1.46e-10 ***
O3p:FF            2.638e-02  9.061e-03   2.911 0.003681 ** 
TEMPE:RMH2O       3.431e+02  4.616e+01   7.434 2.23e-13 ***
TEMPE:STATIONAls  3.167e+00  5.973e-01   5.302 1.41e-07 ***
TEMPE:STATIONCad  1.601e-01  6.075e-01   0.264 0.792142    
TEMPE:STATIONPla -6.161e-01  6.703e-01  -0.919 0.358210    
TEMPE:STATIONRam  6.339e-01  5.955e-01   1.064 0.287378    
RMH2O:STATIONAls -3.072e+03  7.218e+02  -4.256 2.27e-05 ***
RMH2O:STATIONCad -9.354e+02  6.805e+02  -1.375 0.169517    
RMH2O:STATIONPla  1.359e+03  7.551e+02   1.800 0.072194 .  
RMH2O:STATIONRam -1.660e+03  7.755e+02  -2.141 0.032526 *  
---
Signif. codes:  
0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

Residual standard error: 25.7 on 1021 degrees of freedom
Multiple R-squared:  0.6142,	Adjusted R-squared:  0.607 
F-statistic: 85.54 on 19 and 1021 DF,  p-value: < 2.2e-16

> getwd()
[1] "/Users/chico/Desktop/2AN-N7/Statistique"
> source("CV.R")
> summary(data)
 JJ           O3o             O3p            TEMPE      
 F:317   Min.   : 19.0   Min.   : 46.4   Min.   :10.40  
 S:724   1st Qu.: 87.0   1st Qu.: 97.5   1st Qu.:20.20  
         Median :109.0   Median :125.6   Median :23.80  
         Mean   :115.4   Mean   :127.2   Mean   :23.88  
         3rd Qu.:135.0   3rd Qu.:153.6   3rd Qu.:27.60  
         Max.   :319.0   Max.   :284.7   Max.   :38.00  
     RMH2O              NO2         STATION  
 Min.   :0.00285   Min.   : 0.258   Aix:199  
 1st Qu.:0.00763   1st Qu.: 1.248   Als:222  
 Median :0.00985   Median : 2.109   Cad:202  
 Mean   :0.01025   Mean   : 3.505   Pla:208  
 3rd Qu.:0.01244   3rd Qu.: 4.062   Ram:210  
 Max.   :0.02753   Max.   :44.396            
       FF         
 Min.   : 0.1414  
 1st Qu.: 3.9623  
 Median : 5.5973  
 Mean   : 5.9072  
 3rd Qu.: 7.1063  
 Max.   :19.8910  
> rm(list=ls())
> data=read.table("DataTP.txt",header=TRUE
+ )
> data$STATION=as.factor(data$STATION)
> summary(data)
      JJ                 O3o             O3p       
 Length:1041        Min.   : 19.0   Min.   : 46.4  
 Class :character   1st Qu.: 87.0   1st Qu.: 97.5  
 Mode  :character   Median :109.0   Median :125.6  
                    Mean   :115.4   Mean   :127.2  
                    3rd Qu.:135.0   3rd Qu.:153.6  
                    Max.   :319.0   Max.   :284.7  
     TEMPE           RMH2O              NO2        
 Min.   :10.40   Min.   :0.00285   Min.   : 0.258  
 1st Qu.:20.20   1st Qu.:0.00763   1st Qu.: 1.248  
 Median :23.80   Median :0.00985   Median : 2.109  
 Mean   :23.88   Mean   :0.01025   Mean   : 3.505  
 3rd Qu.:27.60   3rd Qu.:0.01244   3rd Qu.: 4.062  
 Max.   :38.00   Max.   :0.02753   Max.   :44.396  
 STATION         FF         
 Aix:199   Min.   : 0.1414  
 Als:222   1st Qu.: 3.9623  
 Cad:202   Median : 5.5973  
 Pla:208   Mean   : 5.9072  
 Ram:210   3rd Qu.: 7.1063  
           Max.   :19.8910  
> data$JJ=as.factor(data$JJ)
> summary(data)
 JJ           O3o             O3p            TEMPE      
 F:317   Min.   : 19.0   Min.   : 46.4   Min.   :10.40  
 S:724   1st Qu.: 87.0   1st Qu.: 97.5   1st Qu.:20.20  
         Median :109.0   Median :125.6   Median :23.80  
         Mean   :115.4   Mean   :127.2   Mean   :23.88  
         3rd Qu.:135.0   3rd Qu.:153.6   3rd Qu.:27.60  
         Max.   :319.0   Max.   :284.7   Max.   :38.00  
     RMH2O              NO2         STATION  
 Min.   :0.00285   Min.   : 0.258   Aix:199  
 1st Qu.:0.00763   1st Qu.: 1.248   Als:222  
 Median :0.00985   Median : 2.109   Cad:202  
 Mean   :0.01025   Mean   : 3.505   Pla:208  
 3rd Qu.:0.01244   3rd Qu.: 4.062   Ram:210  
 Max.   :0.02753   Max.   :44.396            
       FF         
 Min.   : 0.1414  
 1st Qu.: 3.9623  
 Median : 5.5973  
 Mean   : 5.9072  
 3rd Qu.: 7.1063  
 Max.   :19.8910  
> library(MASS)
> library(verification)
Error in library(verification) : 
  there is no package called ‘verification’
> install.packages("verification")
--- Please select a CRAN mirror for use in this session ---
also installing the dependencies ‘dotCall64’, ‘Rcpp’, ‘spam’, ‘viridisLite’, ‘RColorBrewer’, ‘maps’, ‘proxy’, ‘fields’, ‘CircStats’, ‘dtw’

trying URL 'https://mirror.ibcp.fr/pub/CRAN/bin/macosx/big-sur-arm64/contrib/4.5/dotCall64_1.2.tgz'
trying URL 'https://mirror.ibcp.fr/pub/CRAN/bin/macosx/big-sur-arm64/contrib/4.5/Rcpp_1.1.1-1.1.tgz'
trying URL 'https://mirror.ibcp.fr/pub/CRAN/bin/macosx/big-sur-arm64/contrib/4.5/spam_2.11-3.tgz'
trying URL 'https://mirror.ibcp.fr/pub/CRAN/bin/macosx/big-sur-arm64/contrib/4.5/viridisLite_0.4.3.tgz'
trying URL 'https://mirror.ibcp.fr/pub/CRAN/bin/macosx/big-sur-arm64/contrib/4.5/RColorBrewer_1.1-3.tgz'
trying URL 'https://mirror.ibcp.fr/pub/CRAN/bin/macosx/big-sur-arm64/contrib/4.5/maps_3.4.3.tgz'
trying URL 'https://mirror.ibcp.fr/pub/CRAN/bin/macosx/big-sur-arm64/contrib/4.5/proxy_0.4-29.tgz'
trying URL 'https://mirror.ibcp.fr/pub/CRAN/bin/macosx/big-sur-arm64/contrib/4.5/fields_17.3.tgz'
trying URL 'https://mirror.ibcp.fr/pub/CRAN/bin/macosx/big-sur-arm64/contrib/4.5/CircStats_0.2-7.tgz'
trying URL 'https://mirror.ibcp.fr/pub/CRAN/bin/macosx/big-sur-arm64/contrib/4.5/dtw_1.23-2.tgz'
trying URL 'https://mirror.ibcp.fr/pub/CRAN/bin/macosx/big-sur-arm64/contrib/4.5/verification_1.45.tgz'

The downloaded binary packages are in
	/var/folders/pb/bg3dyhjs05qglz23ky7057_c0000gn/T//RtmprRH0Ep/downloaded_packages
> library(verfication)
Error in library(verfication) : there is no package called ‘verfication’
> i
Error: object 'i' not found
> library(verification)
Loading required package: fields
Loading required package: spam
Spam version 2.11-3 (2026-01-05) is loaded.
Type 'help( Spam)' or 'demo( spam)' for a short introduction 
and overview of this package.
Help for individual functions is also obtained by adding the
suffix '.spam' to the function name, e.g. 'help( chol.spam)'.

Attaching package: ‘spam’

The following objects are masked from ‘package:base’:

    backsolve, forwardsolve

Loading required package: viridisLite
Loading required package: RColorBrewer

Try help(fields) to get started.
Loading required package: boot
Loading required package: CircStats
Loading required package: dtw
Loading required package: proxy

Attaching package: ‘proxy’

The following object is masked from ‘package:spam’:

    as.matrix

The following objects are masked from ‘package:stats’:

    as.dist, dist

The following object is masked from ‘package:base’:

    as.matrix

Loaded dtw v1.23-2. See ?dtw for help, citation("dtw") for use in publication.

> data$OCC=as.factor(as.numeric(data$O3o>180))
> data$OCCp=as.factor(as.numeric(data$O3p>180))
> summary(data)
 JJ           O3o             O3p            TEMPE      
 F:317   Min.   : 19.0   Min.   : 46.4   Min.   :10.40  
 S:724   1st Qu.: 87.0   1st Qu.: 97.5   1st Qu.:20.20  
         Median :109.0   Median :125.6   Median :23.80  
         Mean   :115.4   Mean   :127.2   Mean   :23.88  
         3rd Qu.:135.0   3rd Qu.:153.6   3rd Qu.:27.60  
         Max.   :319.0   Max.   :284.7   Max.   :38.00  
     RMH2O              NO2         STATION  
 Min.   :0.00285   Min.   : 0.258   Aix:199  
 1st Qu.:0.00763   1st Qu.: 1.248   Als:222  
 Median :0.00985   Median : 2.109   Cad:202  
 Mean   :0.01025   Mean   : 3.505   Pla:208  
 3rd Qu.:0.01244   3rd Qu.: 4.062   Ram:210  
 Max.   :0.02753   Max.   :44.396            
       FF          OCC     OCCp   
 Min.   : 0.1414   0:960   0:934  
 1st Qu.: 3.9623   1: 81   1:107  
 Median : 5.5973                  
 Mean   : 5.9072                  
 3rd Qu.: 7.1063                  
 Max.   :19.8910                  
> source("scores.R")
> 
> ?glm
starting httpd help server ... done
> ?family
> ?glm
> glm.out=glm(OCC~.,data[,-2],family=binomial)
> summary(glm.out)

Call:
glm(formula = OCC ~ ., family = binomial, data = data[, -2])

Coefficients:
              Estimate Std. Error z value Pr(>|z|)    
(Intercept) -16.891453   1.765987  -9.565  < 2e-16 ***
JJS          -0.443841   0.314875  -1.410 0.158664    
O3p           0.020059   0.007612   2.635 0.008404 ** 
TEMPE         0.380194   0.050572   7.518 5.57e-14 ***
RMH2O       145.545377  39.858608   3.652 0.000261 ***
NO2          -0.016155   0.059846  -0.270 0.787202    
STATIONAls   -0.446005   0.620826  -0.718 0.472506    
STATIONCad    0.383273   0.467294   0.820 0.412104    
STATIONPla    0.832554   0.642743   1.295 0.195212    
STATIONRam   -1.324943   0.649946  -2.039 0.041496 *  
FF           -0.087804   0.095016  -0.924 0.355436    
OCCp1         0.116125   0.529621   0.219 0.826447    
---
Signif. codes:  
0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

(Dispersion parameter for binomial family taken to be 1)

    Null deviance: 569.19  on 1040  degrees of freedom
Residual deviance: 319.49  on 1029  degrees of freedom
AIC: 343.49

Number of Fisher Scoring iterations: 8

> glm.outBIC=stepAIC(glm.out,k=log(nrow(data))) 
Start:  AIC=402.87
OCC ~ JJ + O3p + TEMPE + RMH2O + NO2 + STATION + FF + OCCp

          Df Deviance    AIC
- STATION  4   328.76 384.34
- OCCp     1   319.54 395.97
- NO2      1   319.57 396.00
- FF       1   320.37 396.80
- JJ       1   321.45 397.88
<none>         319.49 402.87
- O3p      1   326.94 403.37
- RMH2O    1   332.42 408.85
- TEMPE    1   399.73 476.16

Step:  AIC=384.34
OCC ~ JJ + O3p + TEMPE + RMH2O + NO2 + FF + OCCp

        Df Deviance    AIC
- OCCp   1   328.77 377.41
- FF     1   329.57 378.21
- NO2    1   330.67 379.31
- JJ     1   330.91 379.55
<none>       328.76 384.34
- RMH2O  1   341.66 390.30
- O3p    1   345.61 394.25
- TEMPE  1   428.62 477.25

Step:  AIC=377.41
OCC ~ JJ + O3p + TEMPE + RMH2O + NO2 + FF

        Df Deviance    AIC
- FF     1   329.60 371.28
- NO2    1   330.69 372.38
- JJ     1   330.95 372.64
<none>       328.77 377.41
- RMH2O  1   341.66 383.35
- O3p    1   363.98 405.67
- TEMPE  1   431.07 472.75

Step:  AIC=371.28
OCC ~ JJ + O3p + TEMPE + RMH2O + NO2

        Df Deviance    AIC
- NO2    1   331.53 366.27
- JJ     1   331.71 366.45
<none>       329.60 371.28
- RMH2O  1   341.67 376.41
- O3p    1   364.34 399.08
- TEMPE  1   432.69 467.43

Step:  AIC=366.27
OCC ~ JJ + O3p + TEMPE + RMH2O

        Df Deviance    AIC
- JJ     1   333.68 361.47
<none>       331.53 366.27
- RMH2O  1   343.84 371.63
- O3p    1   365.03 392.82
- TEMPE  1   433.31 461.10

Step:  AIC=361.47
OCC ~ O3p + TEMPE + RMH2O

        Df Deviance    AIC
<none>       333.68 361.47
- RMH2O  1   345.75 366.59
- O3p    1   366.87 387.71
- TEMPE  1   438.24 459.09
> formula(glm.outBIC)
OCC ~ O3p + TEMPE + RMH2O
> scores(data$OCCp,data$OCC)
    OBS
PREV   0   1
   0 883  51
   1  77  30
[1] " "
[1] "Taux global    H         F         PSS"
[1] 0.87704131 0.37037037 0.08020833 0.29016204
> scores(predict(glm.outBIC,type="response")>0.5,data$OCC)
       OBS
PREV      0   1
  FALSE 942  51
  TRUE   18  30
[1] " "
[1] "Taux global    H         F         PSS"
[1] 0.9337176 0.3703704 0.0187500 0.3516204
> roc.plot(as.numeric(data$OCC)-1,fitted(glm.outBIC))
Warning message:
In roc.plot.default(as.numeric(data$OCC) - 1, fitted(glm.outBIC)) :
  Large amount of unique predictions used as thresholds. Consider specifying thresholds.
> scores(predict(glm.outBIC,type="response")>0.1,data$OCC)
       OBS
PREV      0   1
  FALSE 833  17
  TRUE  127  64
[1] " "
[1] "Taux global    H         F         PSS"
[1] 0.8616715 0.7901235 0.1322917 0.6578318
> summary(lm)
Error in object[[i]] : object of type 'closure' is not subsettable
> lm.out=lm(O3o~.,data[,-9])
> scores(predict(lm.out)>180,data$OCC)
       OBS
PREV      0   1
  FALSE 956  72
  TRUE    4   9
[1] " "
[1] "Taux global    H         F         PSS"
[1] 0.926993276 0.111111111 0.004166667 0.106944444
> (Multiple R-squared = 0.2286 (22.86%) : Cela signifie que l'ozone prévu par MOCAGE seul ne parvient à expliquer que $22.86\%$ de la variance (la fluctuation) de l'ozone réel mesuré à Aix.
)
