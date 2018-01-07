# Operators in R

# arithmetic operator
v1 <- c(1, 2, 3)
v2 <- c(4, 5, 6)

print(v1 + v2)
print(v1 - v2)
print(v1 * v2)
print(v1 / v2)
print(v2 %% v1)
print(v2 %/% v1)
print(v1 ^ v2)

# relation operator
print (v1 < v1) # "every < "  => " < "

# logic operator 
# & | !

# assignment operator
# <- <<- =
# -> ->>

# others
v <- 1:9
print(v)

print(-1 %in% v)

M <- matrix( c(2, 6, 5, 1, 10, 4), nrow = 2, ncol = 3, byrow = TRUE)
t <- M %*% t(M)
print(t)