# wordcloud2
# from https://github.com/Lchiffon/wordcloud2

library(wordcloud2)

# so column name is not valueable ?
words_frame <- data.frame(
  v2 = c(1:5),
  v3 = c(5:1)
)

# print(class(demoFreqC))

wordcloud2(words_frame, size = 2, 
           minRotation = - pi / 6, maxRotation = - pi / 6,
           rotateRatio = 1)