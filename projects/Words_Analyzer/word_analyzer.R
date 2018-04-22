# install.packages("jiebaR")
# install.packages("sqldf")
# install.palckages("wordcloud2")
library(jiebaR)
library(sqldf)
library(wordcloud2)

f<-scan('D:/Desktop/test.txt',sep='\n',what='',encoding="UTF-8")
seg<-qseg[f]
seg<-seg[nchar(seg)>2]
seg<-seg[nchar(seg)<17]
# seg
m1<-data.frame(seg)
m2<-sqldf("select seg,count(1) as freg from m1 group by seg")
wordcloud2(m2, size = 0.5, minSize = 0, gridSize =  3,color = "random-light", backgroundColor = "grey")